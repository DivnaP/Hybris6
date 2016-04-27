<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="pagination"
	tagdir="/WEB-INF/tags/responsive/nav/pagination"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/my-account/wishlist" var="wishlistUrl" />

<template:page pageTitle="${pageTitle}">
<div class="product-listing product-list row">
	<c:forEach items="${searchPageData}" var="product" varStatus="status">
		<product:productListerItem product="${product}" />
		
		<div class="row" align=center>
			<div class="col-sm-12 col-md-9 col-lg-6">
				<div class="row" align="center">
					<div class="col-xs-4">

						<button id="wishlistRemoveBtn" style=""
							onclick="wishRemoveClick(${product.code})">Remove from
							wishlist</button>
					</div>
					<div class="col-xs-2">
						<c:url value="/cart/add" var="addToCartUrl" />
						<form:form id="addToCartForm${product.code}"
							action="${addToCartUrl}" method="post" class="add_to_cart_form">

							<ycommerce:testId code="addToCartButton">
								<input type="hidden" name="productCodePost"
									value="${product.code}" />
								<input type="hidden" name="productNamePost"
									value="${product.name}" />
								<input type="hidden" name="productPostPrice"
									value="${product.price.value}" />

								<button type="submit"
									class="btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn
	          
	            <c:if test="${product.stock.stockLevelStatus.code eq 'outOfStock' }"> out-of-stock</c:if>"
									onclick="wishRemoveClick(${product.code})"
									<c:if test="${product.stock.stockLevelStatus.code eq 'outOfStock' }">aria-disabled="true"</c:if>
									disabled="disabled"></button>
							</ycommerce:testId>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>
</div>
</template:page>
