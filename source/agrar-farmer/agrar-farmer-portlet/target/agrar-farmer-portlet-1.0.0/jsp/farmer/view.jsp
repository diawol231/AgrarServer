<%@ page import="agrar.farmer.search.FarmerSearcher" %>
<%@ page import="agrar.farmer.sbuilder.model.Farmer" %>
<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.comparator.FarmerComparator" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>

<% PortletURL thisUrl = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse); %>
<% List<DictArea> areaList = DictAreaLocalServiceUtil.getAreas(); %>
<% SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); %>

<%
	// Получение параметров фильтров
	String name = ParamUtil.getString(request, WebKeys.FILTER_01);
	String inn = ParamUtil.getString(request, WebKeys.FILTER_02);
	long reg_area = ParamUtil.getLong(request, WebKeys.FILTER_03);
	Date reg_date_start = ParamUtil.getDate(request, WebKeys.FILTER_04, new SimpleDateFormat("dd.MM.yyyy"), null);
	Date reg_date_end = ParamUtil.getDate(request, WebKeys.FILTER_05, new SimpleDateFormat("dd.MM.yyyy"), null);
	boolean archive = ParamUtil.getBoolean(request, WebKeys.FILTER_06);

	boolean hideFilter = (name.isEmpty()
						 && inn.isEmpty()
						 && reg_area == 0
						 && Validator.isNull(reg_date_start)
						 && Validator.isNull(reg_date_end)
						 && !archive) ? true : false;
	if (hideFilter) {
		SessionClicks.put(request, "farm_filter", "none");
	}
%>

<%
	String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
%>

<h3><liferay-ui:message key="Реестр фермеров"/></h3>

<%-- Действие для добавления фермера --%>
<portlet:renderURL var="createUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER_CARD %>"/>
	<portlet:param name="editMode" value="true"/>
</portlet:renderURL>

<%-- Кнопка для добавления фермера --%>
<aui:a cssClass="btn" href='<%= createUrl%>'>
	<aui:icon cssClass="icon-plus-sign"/><liferay-ui:message key="add"/>
</aui:a>

<%-- Кнопка для разворачивания фильтров --%>
<aui:a cssClass="btn" href="javascript:wjpyToggle();">
	<aui:icon cssClass="icon-search"/><liferay-ui:message key="filter"/>
</aui:a>


<div style="display: none;">
	<liferay-ui:toggle
		defaultShowContent="false"
		id="farm_filter"
	/>
</div>

<%-- Действие для применения фильтров --%>
<portlet:renderURL var="filterUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER %>"/>
</portlet:renderURL>


<%-- Верстка полей фильтров --%>
<div id="farm_filter" style="display: <liferay-ui:toggle-value id="farm_filter" defaultValue="none"/>;margin-top: 5px">
	<%-- Форма с полями ввода --%>
	<aui:form action="<%= filterUrl %>">
		<aui:row>
			<aui:col span="3">
				<aui:col span="3">
					<%-- Поле для названия --%>
					<aui:input
							label="<%= WebKeys.FARM_NAME %>"
							name="<%= WebKeys.FILTER_01 %>"
							value="<%= name %>"
					/>
				</aui:col>
			</aui:col>
			<aui:col span="3">
				<aui:col span="3">
					<%-- Поле для ИНН --%>
					<aui:input
							label="<%= WebKeys.FARM_INN %>"
							name="<%= WebKeys.FILTER_02 %>"
							value="<%= inn %>"
					/>
				</aui:col>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для района регистрации --%>
				<aui:select
						label="<%= WebKeys.FARM_REG_AREA %>"
						name="<%= WebKeys.FILTER_03 %>"
				>
					<aui:option
							label="all"
							value="0"
							selected="<%= reg_area == 0 %>"
					/>

					<% for(DictArea item : areaList) { %>
					<aui:option
							label="<%= item.getName() %>"
							value="<%= Long.toString(item.getId()) %>"
							selected="<%= reg_area == item.getId() %>"
					/>
					<% } %>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="3">
				<%-- Поле для даты ОТ --%>
				<aui:input
						label="<%= WebKeys.FILTER_REG_DATE_FROM %>"
						name="<%= WebKeys.FILTER_04 %>"
						value="<%= Validator.isNotNull(reg_date_start) ? sdf.format(reg_date_start) : StringPool.BLANK %>"
				/>
				<%-- Скрипт для выпадающего календаря --%>
				<script>
					jQuery(function($){
						$('#<portlet:namespace/><%= WebKeys.FILTER_04 %>').mask('99.99.9999', {placeholder: "чч.мм.гггг"});
						$('#<portlet:namespace/><%= WebKeys.FILTER_04 %>').datepicker();
					});
				</script>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для даты ДО --%>
				<aui:input
						label="<%= WebKeys.FILTER_REG_DATE_TO %>"
						name="<%= WebKeys.FILTER_05 %>"
						value="<%= Validator.isNotNull(reg_date_end) ? sdf.format(reg_date_end) : StringPool.BLANK %>"
				/>
				<%-- Скрипт для выпадающего календаря --%>
				<script>
					jQuery(function($){
						$('#<portlet:namespace/><%= WebKeys.FILTER_05 %>').mask('99.99.9999', {placeholder: "чч.мм.гггг"});
						$('#<portlet:namespace/><%= WebKeys.FILTER_05 %>').datepicker();
					});
				</script>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="3">
				<%-- Поле для архивности фермера --%>
				<aui:input
						label="<%= WebKeys.FILTER_ARCHIVE %>"
						name="<%= WebKeys.FILTER_06 %>"
						type="checkbox"
						checked="<%= archive %>"
				/>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col>
				<aui:button-row>
					<%-- Кнопка для отправки формы --%>
					<aui:button type="submit" value="submit"/>
					<%-- Кнопка для очистки фильтров --%>
					<aui:button value="clear" href="<%= filterUrl %>"/>
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
</div>

<%-- Верстка таблицы с выводом реестра фермеров --%>
<div class="noPaginationTop">
<% FarmerSearcher searchHelper = new FarmerSearcher(request); %>
<%! SearchContainer<Farmer> searchContainer = null; %>
<liferay-ui:search-container emptyResultsMessage="no_entries" var="searchContainer" iteratorURL="<%= thisUrl %>" delta="100"
							 orderByCol="<%= orderByCol %>"
							 orderByType="<%= orderByType %>">

	<%-- Заполнение таблицы сеарч контейнера --%>
	<liferay-ui:search-container-results>
		<%
		List<Farmer> farmList = searchHelper.getList(0, searchHelper.getTotal());
		List<Farmer> sortableFarm = new ArrayList<Farmer>(farmList);
		
		sortableFarm = FarmerComparator.sortFarmer(sortableFarm, orderByCol, orderByType);
		pageContext.setAttribute("results", ListUtil.subList(sortableFarm, searchContainer.getStart(), searchContainer.getEnd()));
		pageContext.setAttribute("total", farmList.size());
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="agrar.farmer.sbuilder.model.Farmer" modelVar="entry">

		<%-- Колонка с названием фермера со ссылкой в его карточку --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_NAME %>"
												 orderable="true"
												 orderableProperty="name"
												 >
		
			<portlet:renderURL var="viewUrl">
				<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER_CARD %>"/>
				<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(entry.getId()) %>"/>
			</portlet:renderURL>
			
			<aui:a label="<%= entry.getName() %>" href="<%= viewUrl %>"/>
		
		</liferay-ui:search-container-column-text>

		<%-- Колонка с ОПФ фермера --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_FORM %>"
												 value='<%= entry.getForm() != 0 ? entry.showForm() : StringPool.BLANK %>'
												 />

		<%-- Колонка с ИНН фермера --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_INN %>"
												 value='<%= entry.getInn() %>'

		/>

		<%-- Колонка с районом регистрации фермера --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_REG_AREA %>"
												 value='<%= entry.getRegistrationArea() != 0 ? entry.showRegArea() : StringPool.BLANK %>'
												 />

		<%-- Колонка с датой регистрации фермера --%>
		<liferay-ui:search-container-column-text name="<%= WebKeys.FARM_REG_DATE %>"
												 value='<%= Validator.isNotNull(entry.getRegistrationDate()) ? sdf.format(entry.getRegistrationDate()) : StringPool.BLANK %>'
		/>

		<%-- Колонка с меню действий --%>
		<liferay-ui:search-container-column-jsp cssClass="actionsWidth" name="actions" path="/jsp/farmer/menu.jsp"/>
	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator/>

</liferay-ui:search-container>
</div>