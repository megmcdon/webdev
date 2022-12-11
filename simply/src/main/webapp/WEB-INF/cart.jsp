<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cart</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>
            <div class="">
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp" />
                </header>

                <!--begin about-hero-section -->
                <section id="hero-section" class="about-hero-section">

                    <!--begin image-overlay -->
                    <div class="image-overlay"></div>
                    <!--end image-overlay -->

                    <!--begin container-->
                    <div class="container image-section-inside">

                        <!--begin row-->
                        <div class="row">

                            <!--begin col-md-10-->
                            <div class="col-md-10 col-md-offset-1 text-center">

                                <span class="comic-text white wow fadeIn" data-wow-delay="0.5s">Organic & Fair Trade</span>

                                <h2 class="section-title white wow bounceIn" data-wow-delay="1s"></h2>

                                <p class="hero-text wow fadeInUp" data-wow-delay="2s">Please use the below buttons to update your cart and checkout when you are ready!</p>

                            </div>
                            <!--end col-md-10-->

                        </div>
                        <!--end row-->

                    </div>
                    <!--end container-->    

                </section>
                <!--end about-hero-section -->

                <!-- Shop Cart
                ============================================= -->
                <section id="shopcart" class="shop shop-cart bg-gray section-white">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12">
                                <div class="cart-table table-responsive">
                                    <c:if test="${not empty msg}">
                                        <div class="alert alert-info">
                                            
                                        ${msg}
                                        </div>
                                    </c:if>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr class="cart-product">
                                                <th class="cart-product-item" style="width: 60%;">Product</th>
                                                <th class="cart-product-price">Price</th>
                                                <th class="cart-product-quantity">Quantity</th>
                                                <th class="cart-product-total">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:choose>
                                                <c:when test="${not empty cart }">
                                                    <c:forEach items="${cart}" var="p">
                                                        <tr class="cart-product">
                                                            <td class="cart-product-item flex items-center justify-between">
                                                                <button data-ctx="${pageContext.request.contextPath}" data-id="${p.product.id}" class="cart-product-remove delete flex items-center justify-center">
                                                                    <i class="fa fa-close"></i>
                                                                </button>
                                                                <div class="cart-product-img menu-img">
                                                                    <img src="${pageContext.request.contextPath}/images/products/products${p.id}.webp" alt="product"/>
                                                                </div>
                                                                <div class="cart-product-name">
                                                                    <h6>${p.product.name}</h6>
                                                                </div>
                                                            </td>
                                                            <td class="cart-product-price">$<fmt:formatNumber type="number" minFractionDigits="2" value="${p.product.price}"/></td>
                                                            <td class="cart-product-quantity">
                                                                <div class="product-quantity">
                                                                    <input required data-ctx="${pageContext.request.contextPath}"
                                                                           data-id="${p.product.id }" type="number" class="form-control qty"
                                                                           value="${p.quantity}" />
                                                                </div>
                                                            </td>
                                                            <td class="cart-product-total">$<fmt:formatNumber type="number" minFractionDigits="2" value="${p.quantity * p.product.price}"/></td>

                                                        </tr>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                <div class="alert alert-info">Your Cart is Empty</div>
                                            </c:otherwise>
                                        </c:choose>
                                        <tr class="cart-product-action">
                                            <td colspan="4">
                                            	<div class="row">
                                            	 <div class="col-xs-12 col-sm-6 col-md-6">
                                                       
                                                    </div>
                                                    <!-- .col-md-6 end -->
                                                    <div class="col-xs-12 col-sm-6 col-md-6 text-right ">
                                                        <h5>Total: <span> $<fmt:formatNumber type="number" minFractionDigits="2" value="${totalPrice}"/></span></h5>
                                                    </div>
                                                    <!-- .col-md-6 end -->
                                            	</div>
                                                <div class="row clearfix">
                                                    <div class="col-xs-12 col-sm-6 col-md-6">
                                                       
                                                    </div>
                                                    <!-- .col-md-6 end -->
                                                    <div class="col-xs-12 col-sm-6 col-md-6 text-right">
                                                        <a class="btn btn-lg btn-yellow-small scrool" href="">update cart</a>
                                                        <a class="btn btn-lg btn-yellow-small scrool" href="<c:url value="/cart/checkout" />">Checkout</a>
                                                    </div>
                                                    <!-- .col-md-6 end -->
                                                    
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- .cart-table end -->
                            </div>

                            
                        </div>
                        <!-- .row end -->
                    </div>
                    <!-- .container end -->
                </section>
                
                
                
                <!-- #shopcart end -->


                <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                    <script src="${pageContext.request.contextPath}/js/cart.js"></script>
                </footer>

            </div>
        </main>
    </body>
</html>
