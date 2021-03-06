<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup" %>


<template:page pageTitle="${pageTitle}">

	<div class="row">
		<div class="col-xs-3">
			<cms:pageSlot position="ProductLeftRefinements" var="feature">
				<cms:component component="${feature}"/>
			</cms:pageSlot>
		</div>
		<div class="col-sm-12 col-md-9">
            <div class="row">
                <cms:pageSlot position="SearchResultsGridSlot" var="feature">
                    <cms:component component="${feature}"/>
                </cms:pageSlot>
            </div>
		</div>
	</div>

	<storepickup:pickupStorePopup />

</template:page>
