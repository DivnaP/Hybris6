<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<nav:pagination top="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchPageData.currentQuery.url}"  numberPagesShown="${numberPagesShown}"/>

<div class="product-listing product-list row">
    <c:forEach items="${searchPageData.results}" var="product" varStatus="status">
        <product:productListerItem product="${product}"/>
        <button id="wishlistBtn" onclick="wishClick(${product.code})" > Add to wishlist</button>
        <button id="wishlistRemoveBtn" style="" onclick="wishRemoveClick(${product.code})" disabled >Remove from wishlist</button>
    </c:forEach>
</div>

<div id="addToCartTitle" style="display:none">
    <div class="add-to-cart-header">
        <div class="headline">
            <span class="headline-text"><spring:theme code="basket.added.to.basket"/></span>
        </div>
    </div>
</div>

<nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchPageData.currentQuery.url}"  numberPagesShown="${numberPagesShown}"/>

<storepickup:pickupStorePopup/>

