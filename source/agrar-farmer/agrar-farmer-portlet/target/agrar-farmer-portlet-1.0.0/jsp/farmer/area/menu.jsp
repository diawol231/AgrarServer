<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.constants.TabKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>

<%
	// Получение текущего объекта
	long farmId = ParamUtil.getLong(request, WebKeys.PARAM_ID);
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	FarmerArea area = (FarmerArea) row.getObject();
%>

<% List<DictArea> areaList = DictAreaLocalServiceUtil.getAreas(); %>

<%-- Действие для добавления/изменения района фермера --%>
<portlet:actionURL name="editFarmerArea" var="editUrl1">
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmId) %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID_2 %>" value="<%= Long.toString(area.getId()) %>"/>
</portlet:actionURL>

<%-- Действие для удаления района фермера --%>
<portlet:actionURL name="deleteFarmerArea" var="deleteUrl1">
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmId) %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID_2 %>" value="<%= Long.toString(area.getId()) %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu icon="" showWhenSingleIcon="true">
	<%-- Пункт меню для редактирования --%>
	<liferay-ui:icon iconCssClass="icon-edit-sign" message="edit" url="#" id='<%= "edit_area_" + Long.toString(area.getId()) %>'/>
	<%-- Пункт меню для удаления --%>
	<liferay-ui:icon iconCssClass="icon-remove-sign" message="delete" url="<%= deleteUrl1%>"/>
</liferay-ui:icon-menu>

<%-- Верстка модального окна для редактирования района фермера --%>
<div hidden="true">

	<% String areaId = Long.toString(area.getId()); %>

	<div id='<%= "dialogHeader1_" + areaId %>'>
		<h4><liferay-ui:message key="farm_area_edit"/></h4>
	</div>

	<div id='<%= "dialogBody1_" + areaId %>'>
		<%-- Форма с полями ввода --%>
		<aui:form name='<%= "edit_area_" + areaId %>' action="<%= editUrl1 %>" method="post">
			<aui:row>
				<aui:col span="6">
					<%-- Поле для названия посевного района --%>
					<aui:select
							label="<%= WebKeys.FARM_AREA_NAME %>"
							name="<%= WebKeys.FARM_AREA_NAME + areaId %>"
					>

						<% for(DictArea item : areaList) { %>
						<aui:option
								label='<%= item.getName() %>'
								value="<%= Long.toString(item.getId()) %>"
								selected="<%= area.getAreaId() == item.getId() %>"
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
							name="<%= WebKeys.FARM_AREA_DESCRIPTION + areaId %>"
							value="<%= area.getDescription() %>"
							type="textarea"
							rows="5"
							showRequiredLabel="false"
					/>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<%-- Кнопка для отправки формы --%>
					<aui:button type="submit" value="save"/>
				</aui:col>
				<aui:col span="6">
					<%-- Кнопка для закрытия модального окна --%>
					<aui:button name='<%= "closeDialog1_" + areaId %>' value="cancel"/>
				</aui:col>
			</aui:row>

		</aui:form>
		
	</div>

</div>

<%-- Скрипт для открытия модального окна по нажатию на кнопку --%>
<aui:script>
	
AUI().use('aui-modal', function(A) {
	A.one('#<portlet:namespace/>edit_area_<%= Long.toString(area.getId()) %>').on('click', function(event) {
		var modal = new A.Modal({
			headerContent: AUI().one('#dialogHeader1_<%= areaId %>'),
			bodyContent: AUI().one('#dialogBody1_<%= areaId %>'),
			centered: true,
			modal: true,
			width: 300,
			height: 430,
			zIndex: 10
		}).render();
		
		A.one('#<portlet:namespace/>closeDialog1_<%= areaId %>').on('click', function() {
			modal.hide();
		});
	});
});

</aui:script>
