<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <jsp:include page="/WEB-INF/common/header.jsp" />
</head>

<body>
    <main>
        <div class="">
            <header class="pb-3 mb-4 border-bottom">
                <jsp:include page="/WEB-INF/common/nav.jsp">
                    <jsp:param name="isAuth" value="${isAuth}"/>
                    <jsp:param name="isAdminAuth" value="${isAdminAuth}"/>
                </jsp:include>
            </header>

            <section class="section-white" style="padding: 200px 0px;">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        ${error}
                    </div>
                </c:if>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                            <h2 class="section-title wow bounceIn" data-wow-delay="1s">Confirmation</h2>
                        </div>
                    </div>
                    <div class="row">
                        <h4>Hi ${user.firstName}, your order has been confirmed!</h4>
                        <p>An email has been sent to the "${user.email}"...</P>
                    </div>
                    
                    
                    <!-- plan a -->
<%--                   <div class="row">
                        <div class="col-md-2 text-left"><h5>Item</h5></div>
                        <div class="col-md-1 text-center"><h5>Quantity</h5></div>
                        <div class="col-md-1 text-center"><h5>Price</h5></div>
                        <div class="col-md-8"></div>
                    </div>
                    <c:forEach items="${cart}" var="item">
                        <div class="row">
                            <div class="col-md-2 text-left">${item.product.name}</div>
                            <div class="col-md-1 text-center">${item.quantity}</div>
                            <div class="col-md-1 text-left">$<fmt:formatNumber type="number" minFractionDigits="2" value="${item.quantity * item.product.price}"/></div>
                            <div class="col-md-8"></div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <div class="col-md-2 text-left"><h5>TOTAL</h5></div>
                        <div class="col-md-1"></div>
                        <div class="col-md-1 text-left"><h5>$<fmt:formatNumber type="number" minFractionDigits="2" value="${totalPrice}"/></h5></div>
                        <div class="col-md-8"></div>
                    </div>  --%>
                    
                    
                    <!-- plan-b -->
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
                                                                <div class="cart-product-name">
                                                                    <h6>${p.product.name}</h6>
                                                                </div>
                                                            </td>
                                                            <td class="cart-product-price">$<fmt:formatNumber type="number" minFractionDigits="2" value="${p.product.price}"/></td>
                                                            <td class="cart-product-quantity">${p.quantity}</td>
                                                            <td class="cart-product-total"> $<fmt:formatNumber type="number" minFractionDigits="2" value="${p.quantity * p.product.price}"/></td>

                                                        </tr>
                                                    </c:forEach>
                                                </c:when>
                                              
                                           
                                        </c:choose>
                                        
                                        <tr class="cart-product-action">
                                            <td colspan="4">
                                                <div class="row clearfix">
                                                    <div class="col-xs-12 col-sm-6 col-md-6">
                                                       
                                                    </div>
                                                    <div class="col-xs-12 col-sm-6 col-md-6 text-right ">
                                                        <h5>Total: <span> $<fmt:formatNumber type="number" minFractionDigits="2" value="${totalPrice}"/></span></h5>
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
                </div>
            </section>

            <footer class="pt-3 mt-4 text-muted border-top">
                <jsp:include page="/WEB-INF/common/footer.jsp">
                    <jsp:param name="isAdminAuth" value="${isAdminAuth}"/>
                    <jsp:param name="isAuth" value="${isAuth}"/>
                </jsp:include>
            </footer>
        </div>
    </main>
</body>

</html>
