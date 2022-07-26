<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.constants.TabKeys" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>

<%
	long farmId = ParamUtil.getLong(request, WebKeys.PARAM_ID);
	String activeTab = ParamUtil.getString(request, WebKeys.JSP_TAB, TabKeys.FARMER.getName());
%>

<portlet:renderURL var="backUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER %>"/>
</portlet:renderURL>

<div style="margin: 5px;">
	<liferay-ui:icon-menu>
		<%-- Ссылка для перехода в реестр фермеров --%>
		<liferay-ui:icon iconCssClass="icon-chevron-left" message="Вернуться к списку фермеров" url="<%= backUrl %>"/>
	</liferay-ui:icon-menu>
</div>

<%-- Редирект на карточку фермера --%>
<portlet:renderURL var="tabsUrl">
	<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= WebKeys.FARMER_CARD %>"/>
	<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmId) %>"/>
</portlet:renderURL>

<%-- Если фермер существует, то отображаем все вкладки --%>
<% if (farmId != 0) { %>
	<div class="tabbable tabs-left">
		<liferay-ui:tabs
			url="<%= tabsUrl %>" 
			param="<%= WebKeys.JSP_TAB %>" 
			value="<%= activeTab %>"
			tabsValues="<%= TabKeys.getTabNames() %>"
			names="<%= TabKeys.getTabLabels() %>"
		>
		
			<div class="tab-content" style="overflow: hidden;">
				<jsp:include page='<%= activeTab + "/view.jsp" %>'/>
			</div>
			
		</liferay-ui:tabs>
	</div>

<%-- Если фермера создаем, то отображаем только основную вкладку --%>
<% } else { %>
<div class="tabbable tabs-left">
	<liferay-ui:tabs
			url="<%= tabsUrl %>"
			param="<%= WebKeys.JSP_TAB %>"
			value="<%= activeTab %>"
			tabsValues="<%= TabKeys.FARMER.getName() %>"
			names="<%= TabKeys.FARMER.getLabel() %>"
	>

		<div class="tab-content" style="overflow: hidden;">
			<jsp:include page='<%= activeTab + "/view.jsp" %>'/>
		</div>

	</liferay-ui:tabs>
</div>

<% }  %>