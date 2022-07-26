<%@ page import="agrar.dict.sbuilder.model.DictArea" %>
<%@ page import="agrar.dict.constants.WebKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>

<%
	// Получение текущего объекта
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	DictArea entry = (DictArea) row.getObject();
%>

<%-- Действие для добавления/изменения района --%>
<portlet:actionURL name="editArea" var="editUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.DICTIONARIES %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(entry.getId()) %>"/>
</portlet:actionURL>

<%-- Действие для архивирования района --%>
<portlet:actionURL name="archiveArea" var="archiveUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.DICTIONARIES %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(entry.getId()) %>"/>
</portlet:actionURL>

<%-- Действие для удаления района --%>
<portlet:actionURL name="deleteArea" var="deleteUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.DICTIONARIES %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(entry.getId()) %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu icon="">
	<%-- Пункт меню для редактирования --%>
	<liferay-ui:icon iconCssClass="icon-edit-sign" message="edit" url="#"
					 id='<%= "edit_region_" + Long.toString(entry.getId()) %>'/>

	<%-- Пункт меню для архивирования --%>
	<liferay-ui:icon iconCssClass="icon-off" message='<%= !entry.isArchive() ? "deactivate" : "activate" %>'
					 url="<%= archiveUrl%>"/>

	<%-- Пункт меню для удаления --%>
	<liferay-ui:icon iconCssClass="icon-remove" message="delete" url="<%= deleteUrl %>"/>

</liferay-ui:icon-menu>

<%-- Верстка модального окна для редактирования района --%>
<div hidden="true">

	<% String paramId = Long.toString(entry.getId()); %>

	<div id='<%= "dialogHeader" + paramId %>'>
		<h4><liferay-ui:message key="region_edit"/></h4>
	</div>

	<div id='<%= "dialogBody" + paramId %>'>

		<%-- Форма с полями ввода --%>
		<aui:form name='<%= "edit_region_" + paramId %>' action="<%= editUrl %>" method="post">
			<aui:row>
				<aui:col span="12">
					<%-- Поле для названия района --%>
					<aui:input
							label="<%= WebKeys.REGION_NAME %>"
							name="<%= WebKeys.REGION_NAME + paramId %>"
							value="<%= entry.getName() %>"
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
							name="<%= WebKeys.REGION_CODE + paramId %>"
							value="<%= entry.getCode() %>"
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
					<aui:button name='<%= "closeDialog" + paramId %>' value="cancel"/>
				</aui:col>
			</aui:row>
		
		</aui:form>
		
	</div>

</div>

<%-- Скрипт для открытия модального окна по нажатию на кнопку --%>
<aui:script>
	
AUI().use('aui-modal', function(A) {
	A.one('#<portlet:namespace/>edit_region_<%= Long.toString(entry.getId()) %>').on('click', function(event) {
		var modal = new A.Modal({
			headerContent: AUI().one('#dialogHeader<%= paramId %>'),
			bodyContent: AUI().one('#dialogBody<%= paramId %>'),
			centered: true,
			modal: true,
			width: 300,
			height: 350,
			zIndex: 10
		}).render();
		
		A.one('#<portlet:namespace/>closeDialog<%= paramId %>').on('click', function() {
			modal.hide();
		});
	});
});

</aui:script>
