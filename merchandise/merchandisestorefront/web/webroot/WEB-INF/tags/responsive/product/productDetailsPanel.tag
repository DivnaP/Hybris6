<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



<div class="product-details">
	<ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
		<div class="name">${product.name} <span class="sku">ID</span><span class="code">${product.code}</span></div>
	</ycommerce:testId>
	<product:productReviewSummary product="${product}" showLinks="true"/>

</div>


<div class="row">
	<div class="col-xs-10 col-xs-push-1 col-sm-6 col-sm-push-0 col-lg-4">
		<product:productImagePanel galleryImages="${galleryImages}"
			product="${product}" />
	</div>
	<div class="clearfix hidden-sm hidden-md hidden-lg"></div>
	<div class="col-sm-5 col-lg-8">
		<div class="row">
			<div class="col-lg-6">
				<div class="product-details">
					<product:productPromotionSection product="${product}"/>

					<ycommerce:testId
						code="productDetails_productNamePrice_label_${product.code}">
						<product:productPricePanel product="${product}" />
					</ycommerce:testId>

					<div class="description">${product.summary}</div>
				</div>
			</div>

			<div class="col-sm-12 col-md-9 col-lg-6">
				<div class="row">
					<div class="col-xs-12">
						<cms:pageSlot position="VariantSelector" var="component">
							<cms:component component="${component}" element="div" class="yComponentWrapper"/>
						</cms:pageSlot>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<cms:pageSlot position="AddToCart" var="component">
							<cms:component component="${component}" element="div" class="yComponentWrapper"/>
						</cms:pageSlot>
					</div>
				</div>
				
				<div class="row">
					<div class="col-xs-12">
						<%-- <cms:pageSlot position="AddToCart" var="component">
							<cms:component component="${component}" element="div" class="yComponentWrapper"/> --%>
							</br>
							</br>
							<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
							
							 <c:if test="${not product.inWishlist}">
							<button id="wishlistBtn" onclick="wishClick(${product.code})" > Add to wishlist</button>
						
							</c:if>
							 <c:if test="${product.inWishlist}">
								<button id="wishlistRemoveBtn" style="" onclick="wishRemoveClick(${product.code})" >Remove from wishlist</button>
							</c:if>
							
							</sec:authorize>
							
					<%-- 	</cms:pageSlot> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

