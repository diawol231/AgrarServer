<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.constants.TabKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>

<% PortletURL thisUrl1 = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse); %>

<%
	// Получаем из БД объект фермера и добавляем навигационную метку
	long farmId = ParamUtil.getLong(request, WebKeys.PARAM_ID);
	Farmer farmer = FarmerLocalServiceUtil.fetchFarmer(farmId);
	PortalUtil.addPortletBreadcrumbEntry(request, farmer.getName(), null);
%>

<% List<DictArea> areaList = DictAreaLocalServiceUtil.getAreas(); %>

<%
	String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
%>

<h3><liferay-ui:message key="<%= TabKeys.AREA.getLabel() %>"/></h3>

<%-- Действие для добавления/изменения района фермера --%>
<portlet:actionURL name="editFarmerArea" var="createUrl1">
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmId) %>"/>
</portlet:actionURL>

<div style="margin: 5px;">
	<aui:a cssClass="btn" href="#" id="create_area">
		<%-- Кнопка для добавления района фермера --%>
		<aui:icon cssClass="icon-plus-sign"/><liferay-ui:message key="add"/>
	</aui:a>
</div>

<%-- Верстка модального окна для добавления района фермера --%>
<div hidden="true">

	<div id="dialogHeader1">
		<h4><liferay-ui:message key="farm_area_create"/></h4>
	</div>

	<div id="dialogBody1">
		<%-- Форма с полями ввода --%>
		<aui:form name="create_area_0" action="<%= createUrl1 %>" method="post">
			<aui:row>
				<aui:col span="6">
					<%-- Поле для названия посевного района --%>
					<aui:select
							label="<%= WebKeys.FARM_AREA_NAME %>"
							name="<%= WebKeys.FARM_AREA_NAME + Integer.toString(0) %>"
					>

						<% for(DictArea item : areaList) { %>
						<aui:option
								label='<%= item.getName() %>'
								value="<%= Long.toString(item.getId()) %>"
						/>
						<% } %>

					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<%-- Поле для описания посевного района --%>
					<aui:input
							label="<%= WebKeys.FARM_AREA_DESCRIPTION %>"
							name="<%= WebKeys.FARM_AREA_DESCRIPTION + Integer.toString(0) %>"
							type="textarea"
							rows="5"
							showRequiredLabel="false"
					/>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<%-- Кнопка для отправки формы --%>
					<aui:button type="submit"  value="save"/>
				</aui:col>
				<aui:col span="6">
					<%-- Кнопка для закрытия модального окна --%>
					<aui:button name="closeDialog1"  value="cancel"/>
				</aui:col>
			</aui:row>

		</aui:form>

	</div>

</div>

<%-- Скрипт для открытия модального окна по нажатию на кнопку --%>
<aui:script>

AUI().use('aui-modal', function(A) {
	A.one('#<portlet:namespace/>create_area').on('click', function(event) {
		var modal = new A.Modal({
			headerContent: AUI().one('#dialogHeader1'),
			bodyContent: AUI().one('#dialogBody1'),
			centered: true,
			modal: true,
			width: 300,
			height: 450,
			zIndex: 10
		}).render();

		A.one('#<portlet:namespace/>closeDialog1').on('click', function() {
			modal.hide();
		});
	});
});

</aui:script>

<%-- Верстка таблицы с выводом посевных районов фермера --%>
<div class="noPaginationTop">
<% FarmerAreaSearcher searchHelper1 = new FarmerAreaSearcher(request, farmId); %>
<%! SearchContainer<FarmerArea> searchContainer1 = null; %>
<liferay-ui:search-container emptyResultsMessage="no_entries" var="searchContainer1" iteratorURL="<%= thisUrl1 %>" delta="100"
							 orderByCol="<%= orderByCol %>"
							 orderByType="<%= orderByType %>">

	<%-- Заполнение таблицы сеарч контейнера --%>
	<liferay-ui:search-container-results>
		<%
		List<FarmerArea> farmerAreaList = searchHelper1.getList(0, searchHelper1.getTotal());
		List<FarmerArea> sortableFarmerArea = new ArrayList<FarmerArea>(farmerAreaList);

		sortableFarmerArea = FarmerAreaComparator.sortFarmerArea(sortableFarmerArea, orderByCol, orderByType);
		pageContext.setAttribute("results", ListUtil.subList(sortableFarmerArea, searchContainer1.getStart(), searchContainer1.getEnd()));
		pageContext.setAttribute("total", farmerAreaList.size());
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="agrar.farmer.sbuilder.model.FarmerArea" modelVar="entry">

		<%-- Колонка с названием района --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_AREA_NAME %>"
												 value="<%= entry.showArea() %>"
												 orderable="true"
												 orderableProperty="name"
												 />

		<%-- Колонка с описанием района --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_AREA_DESCRIPTION %>"
												 value="<%= entry.getDescription() %>"
												 />

		<%-- Колонка с меню действий --%>
		<liferay-ui:search-container-column-jsp cssClass="actionsWidth" name="actions" path="/jsp/farmer/area/menu.jsp"/>
	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator/>

</liferay-ui:search-container>
</div>