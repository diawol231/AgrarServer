<%@ page import="agrar.dict.search.DictAreaSearcher" %>
<%@ page import="agrar.dict.sbuilder.model.DictArea" %>
<%@ page import="agrar.dict.constants.WebKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8" %>
<%@include file="/jsp/init.jsp" %>

<% PortletURL thisUrl = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse); %>

<%
    String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
    String orderByType = ParamUtil.getString(request, "orderByType", "asc");
%>

<h3><liferay-ui:message key="Реестр районов"/></h3>

<%-- Действие для добавления/изменения района --%>
<portlet:actionURL name="editArea" var="createUrl">
    <portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.DICTIONARIES %>"/>
</portlet:actionURL>

<%-- Кнопка для добавления --%>
<aui:a cssClass="btn" href="#" id="create_region">
    <aui:icon cssClass="icon-plus-sign"/><liferay-ui:message key="add"/>
</aui:a>

<%-- Верстка модального окна для добавления района --%>
<div hidden="true">

    <div id="dialogHeader">
        <h4><liferay-ui:message key="region_create"/></h4>
    </div>

    <div id="dialogBody">

        <%-- Форма с полями ввода --%>
        <aui:form name="create_region_0" action="<%= createUrl %>" method="post">
            <aui:row>
                <aui:col span="12">
                    <%-- Поле для названия района --%>
                    <aui:input
                            label="<%= WebKeys.REGION_NAME %>"
                            name="<%= WebKeys.REGION_NAME + Integer.toString(0) %>"
                            showRequiredLabel="true"
                    >
                        <aui:validator name="required" errorMessage="required"/>
                    </aui:input>
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col span="12">
                    <%-- Поле для кода района --%>
                    <aui:input
                            type="number"
                            label="<%= WebKeys.REGION_CODE %>"
                            name="<%= WebKeys.REGION_CODE + Integer.toString(0) %>"
                            showRequiredLabel="false"
                    >
                    </aui:input>
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col span="6">
                    <%-- Кнопка для отправки формы --%>
                    <aui:button type="submit" value="save"/>
                </aui:col>
                <aui:col span="6">
                    <%-- Кнопка для закрытия модального окна --%>
                    <aui:button name="closeDialog" value="cancel"/>
                </aui:col>
            </aui:row>

        </aui:form>

    </div>

</div>

<%-- Скрипт для открытия модального окна по нажатию на кнопку --%>
<aui:script>

    AUI().use('aui-modal', function(A) {
        A.one('#<portlet:namespace/>create_region').on('click', function(event) {
            var modal = new A.Modal({
                headerContent: AUI().one('#dialogHeader'),
                bodyContent: AUI().one('#dialogBody'),
                centered: true,
                modal: true,
                width: 300,
                height: 350,
                zIndex: 10
            }).render();

            A.one('#<portlet:namespace/>closeDialog').on('click', function() {
                modal.hide();
            });
        });
    });

</aui:script>

<%
    // Получение параметров фильтров
    String regionName = ParamUtil.getString(request, WebKeys.FILTER_01);
    boolean regionArchive = ParamUtil.getBoolean(request, WebKeys.FILTER_02);
    
	boolean hideFilter = (regionName.isEmpty()
						 && !regionArchive) ? true : false;
	if (hideFilter) {
		SessionClicks.put(request, "region_filter", "none");
	}
%>

<%-- Кнопка для разворачивания фильтров --%>
<aui:a cssClass="btn" href="javascript:wjpyToggle();">
    <aui:icon cssClass="icon-search"/><liferay-ui:message key="filter"/>
</aui:a>

<div style="display: none;">
    <liferay-ui:toggle
            defaultShowContent="false"
            id="region_filter"
    />
</div>

<%-- Действие для применения фильтров --%>
<portlet:renderURL var="filterUrl">
    <portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.DICTIONARIES %>"/>
</portlet:renderURL>


<%-- Верстка полей фильтров --%>
<div id="region_filter" style="display: <liferay-ui:toggle-value id="region_filter" defaultValue="none"/>; margin-top: 5px">
    <%-- Форма с полями ввода --%>
    <aui:form action="<%= filterUrl %>">

        <aui:row>
            <aui:col span="4">
                <%-- Поле для названия района --%>
                <aui:input
                        label="<%= WebKeys.REGION_NAME %>"
                        name="<%= WebKeys.FILTER_01 %>"
                        value="<%= regionName %>"
                />
            </aui:col>
            <aui:col span="4">
                <%-- Поле для архивности района --%>
                <aui:select
                        label="<%= WebKeys.REGION_ARCHIVE %>"
                        name="<%= WebKeys.FILTER_02 %>"
                >
                    <aui:option
                            label="active"
                            value="false"
                            selected="<%= !regionArchive %>"
                    />
                    <aui:option
                            label="non_active"
                            value="true"
                            selected="<%= regionArchive %>"
                    />
                </aui:select>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:button-row style="margin-top: 25px;">
                    <%-- Кнопка для отправки формы --%>
                    <aui:button type="submit" value="submit"/>
                    <%-- Кнопка для очистки фильтров --%>
                    <aui:button value="clear" href="<%= filterUrl %>"/>
                </aui:button-row>
            </aui:col>
        </aui:row>

    </aui:form>
</div>

<%-- Верстка таблицы с выводом справочника районов --%>
<div class="noPaginationTop">
    <% DictAreaSearcher searchHelper = new DictAreaSearcher(request); %>
    <%! SearchContainer<DictArea> searchContainer = null; %>
    <liferay-ui:search-container emptyResultsMessage="no_entries" var="searchContainer" iteratorURL="<%= thisUrl %>"
                                 delta="100"
                                 orderByCol="<%= orderByCol %>"
                                 orderByType="<%= orderByType %>">

        <%-- Заполнение таблицы сеарч контейнера --%>
        <liferay-ui:search-container-results
                results="<%= searchHelper.getList(searchContainer.getStart(), searchContainer.getEnd()) %>"
                total="<%= searchHelper.getTotal() %>"
        />

        <liferay-ui:search-container-row className="agrar.dict.sbuilder.model.DictArea" modelVar="entry">

            <%-- Колонка с названием района --%>
            <liferay-ui:search-container-column-text name="<%= WebKeys.REGION_NAME %>" value="<%= entry.getName() %>"
                                                     orderable="true"
                                                     orderableProperty="name"
            />

            <%-- Колонка с кодом района --%>
            <liferay-ui:search-container-column-text name="<%= WebKeys.REGION_CODE %>" value="<%= Long.toString(entry.getCode()) %>"

            />

            <%-- Колонка с меню действий --%>
            <liferay-ui:search-container-column-jsp cssClass="actionsWidth" name="actions" path="/jsp/menu.jsp"/>

        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator/>

    </liferay-ui:search-container>
</div>