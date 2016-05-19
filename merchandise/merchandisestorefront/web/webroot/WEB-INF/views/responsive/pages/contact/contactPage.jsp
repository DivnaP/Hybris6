<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/responsive/formElement"%>
	<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<template:page pageTitle="${pageTitle}">

<%-- <div class="headline">
	<spring:theme code="contact.title" />
</div> --%>
<form:form method="get" commandName="contactForm" action="/merchandisestorefront/merchandise/en/contactus/sendEmail">
	<br>
	<formElement:formInputBox idKey="contact.firstName"
		labelKey="contact.firstName" path="firstName" inputCSS="form-control"
		mandatory="true" />
	 
	<formElement:formInputBox idKey="contact.lastName"
		labelKey="contact.lastName" path="lastName" inputCSS="form-control"
		mandatory="true" />
			<formElement:formInputBox idKey="contact.email"
		labelKey="contact.email" path="email" inputCSS="form-control"
		mandatory="true" />
	
		<formElement:formInputBox idKey="contact.subject"
		labelKey="contact.subject" path="subject" inputCSS="form-control"
		mandatory="true" />
		
	<formElement:formInputTextarea idKey="contact.message"
		labelKey="contact.message" path="message" inputCSS="form-control"
		mandatory="true" />

	<div class="form-actions clearfix">
		
			<button type="submit" class="btn btn-default btn-block">
				Send
			</button>
		
	</div>
</form:form>


</template:page>