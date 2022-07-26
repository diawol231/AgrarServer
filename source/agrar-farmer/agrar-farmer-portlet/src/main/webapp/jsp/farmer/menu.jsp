<%@ page import="agrar.farmer.sbuilder.model.Farmer" %>
<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.constants.TabKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Farmer farmer = (Farmer) row.getObject();
%>

<%-- Редирект для добавления/изменения фермера --%>
<portlet:renderURL var="editModeUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER_CARD %>"/>
	<portlet:param name="<%= WebKeys.JSP_TAB %>" value="<%= TabKeys.FARMER.getName() %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmer.getId()) %>"/>
	<portlet:param name="editMode" value="true"/>
</portlet:renderURL>

<%-- Действие для добавления в архив фермера --%>
<portlet:actionURL name="archiveFarmer" var="archiveUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmer.getId()) %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu showWhenSingleIcon="true" icon="">
	<%-- Пункт меню для редактирования --%>
	<liferay-ui:icon iconCssClass="icon-edit-sign" message="edit" url="<%= editModeUrl %>"/>
	<%-- Пункт меню для архивирования --%>
	<liferay-ui:icon iconCssClass="icon-off" message='<%= !farmer.isArchive() ? "deactivate" : "activate" %>' url="<%= archiveUrl %>"/>
</liferay-ui:icon-menu>
