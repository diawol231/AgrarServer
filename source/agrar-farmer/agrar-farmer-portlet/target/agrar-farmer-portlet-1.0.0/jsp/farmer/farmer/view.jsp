<%@ page import="agrar.farmer.constants.WebKeys" %>
<%@ page import="agrar.farmer.constants.TabKeys" %>
<%@ page import="agrar.farmer.type.OrgForm" %>
<%@page pageEncoding="utf-8" language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/init.jsp"%>
<%@include file="/jsp/farmer/init.jsp"%>


<% SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); %>

<% String jspPage = ParamUtil.getString(request, WebKeys.JSP_PAGE, WebKeys.FARMER_CARD); %>

<%
	// Получаем из БД объект фермера или создаем новый
	long farmId = ParamUtil.getLong(request, WebKeys.PARAM_ID);
	Farmer farmer;
	if(farmId > 0) {
		farmer = FarmerLocalServiceUtil.fetchFarmer(farmId);
		PortalUtil.addPortletBreadcrumbEntry(request, farmer.getName(), null);
	} else {
		farmer = FarmerLocalServiceUtil.createFarmer(0L);
	}
%>

<%-- Если не в режиме редактирования карточки --%>
<% if(!ParamUtil.getBoolean(request, "editMode")) { %>

	<%-- Редирект для добавления/изменения фермера --%>
	<portlet:renderURL var="editModeUrl">
		<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= jspPage %>"/>
		<portlet:param name="<%= WebKeys.JSP_TAB %>" value="<%= TabKeys.FARMER.getName() %>"/>
		<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= Long.toString(farmId) %>"/>
		<portlet:param name="editMode" value="true"/>
	</portlet:renderURL>

	<%-- Кнопка для изменения фермера --%>
	<aui:a cssClass="btn" href='<%= editModeUrl%>'>
		<aui:icon cssClass="icon-edit-sign"/><liferay-ui:message key="edit"/>
	</aui:a>


	<h3><liferay-ui:message key="<%= TabKeys.FARMER.getLabel() %>"/></h3>


	<%-- Верстка таблица с полями из карточки фермера --%>
	<table class="table table-bordered table-hover table-striped responsive-table-horizontal">
		<tr>
			<td width="300px"><liferay-ui:message key="<%= WebKeys.FARM_NAME %>"></liferay-ui:message></td>
			<td><%= farmer.getName() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_FORM %>"></liferay-ui:message></td>
			<td><%= farmer.showForm() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_INN %>"></liferay-ui:message></td>
			<td><%= farmer.getInn() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_KPP %>"></liferay-ui:message></td>
			<td><%= farmer.getKpp() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_OGRN %>"></liferay-ui:message></td>
			<td><%= farmer.getOgrn() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_REG_AREA %>"></liferay-ui:message></td>
			<td><%= farmer.showRegArea() %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_REG_DATE %>"></liferay-ui:message></td>
			<td><%= sdf.format(farmer.getRegistrationDate()) %></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="<%= WebKeys.FARM_ARCHIVE %>"></liferay-ui:message></td>
			<td><%= farmer.getArchive()? "В архиве" : "Не в архиве" %></td>
		</tr>

	</table>


<%-- Если в режиме редактирования карточки --%>
<% } else { %>

	<% List <DictArea> areas = DictAreaLocalServiceUtil.getAreas(); %>

	<%-- Действие для добавления/изменения фермера --%>
	<portlet:actionURL name="editFarmer" var="editUrl">
		<portlet:param name="<%= WebKeys.JSP_PAGE %>" value="<%= jspPage %>"/>
		<portlet:param name="<%= WebKeys.JSP_TAB %>" value="<%= TabKeys.FARMER.getName() %>"/>
		<portlet:param name="<%= WebKeys.PARAM_ID %>" value="<%= farmId != 0 ? Long.toString(farmId) : StringPool.BLANK %>"/>
		<portlet:param name="editMode" value="true"/>
	</portlet:actionURL>

	<%-- Форма с полями ввода --%>
	<aui:form name="farmerForm" action="<%= editUrl %>" method="post">
	
		<h3><liferay-ui:message key="<%= TabKeys.FARMER.getLabel() %>"/></h3>
		
		<aui:row>
			<aui:col span="3">
				<%-- Поле для названия --%>
				<aui:input
						label="<%= WebKeys.FARM_NAME %>"
						name="<%= WebKeys.FARM_NAME %>"
						value="<%= farmer.getName() %>"
						showRequiredLabel="true"
				>
					<aui:validator name="required" errorMessage="required"/>
				</aui:input>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для ОПФ --%>
				<aui:select
						label="<%= WebKeys.FARM_FORM %>"
						name="<%= WebKeys.FARM_FORM %>"
						showEmptyOption="true"
				>
					<% for(OrgForm item: OrgForm.values()) { %>
					<aui:option
							label="<%= item.getLabel() %>"
							value="<%= Long.toString(item.getId()) %>"
							selected="<%= farmer.getForm() == item.getId() %>"
					/>
					<% } %>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="3">
				<%-- Поле для ИНН --%>
				<aui:input
						label="<%=  WebKeys.FARM_INN %>"
						name="<%= WebKeys.FARM_INN %>"
						value="<%= farmer.getInn() %>"
						showRequiredLabel="true"
				>
					<aui:validator name="required" errorMessage="required"/>
				</aui:input>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для КПП --%>
				<aui:input
						label="<%=  WebKeys.FARM_KPP %>"
						name="<%= WebKeys.FARM_KPP %>"
						value="<%= farmer.getKpp() %>"
						showRequiredLabel="false"
				>
				</aui:input>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для ОГРН --%>
				<aui:input
						label="<%=  WebKeys.FARM_OGRN %>"
						name="<%= WebKeys.FARM_OGRN %>"
						value="<%= farmer.getOgrn() %>"
						showRequiredLabel="false"
				>
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="3">
				<%-- Поле для района регистрации --%>
				<aui:select
						label="<%= WebKeys.FARM_REG_AREA %>"
						name="<%= WebKeys.FARM_REG_AREA %>"
						showEmptyOption="true"
				>
					<% for(DictArea item: areas) { %>
					<aui:option
							label="<%= item.getName() %>"
							value="<%= Long.toString(item.getId()) %>"
							selected="<%= farmer.getRegistrationArea() == item.getId() %>"
					/>
					<% } %>
				</aui:select>
			</aui:col>
			<aui:col span="3">
				<%-- Поле для даты регистрации --%>
				<aui:input
						label="<%= WebKeys.FARM_REG_DATE %>"
						name="<%= WebKeys.FARM_REG_DATE %>"
						value="<%= Validator.isNotNull(farmer.getRegistrationDate())? sdf.format(farmer.getRegistrationDate()): StringPool.BLANK %>"
						showRequiredLabel="false"
				>
				</aui:input>
			</aui:col>
			<%-- Скрипт для выпадающего календаря --%>
			<script>
				jQuery(function ($) {
					$('#<portlet:namespace/><%= WebKeys.FARM_REG_DATE %>').mask('99.99.9999');
					$('#<portlet:namespace/><%= WebKeys.FARM_REG_DATE %>').datepicker();
				});
			</script>
		</aui:row>

	
		<aui:button-row>
			<%-- Кнопка для отправки формы --%>
			<aui:button type="submit" value="save" disabled="false"/>
		</aui:button-row>		
		
	</aui:form>

<% } %>
	


