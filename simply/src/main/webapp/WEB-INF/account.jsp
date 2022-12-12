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
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                            <h2 class="section-title wow bounceIn" data-wow-delay="1s">Order History</h2>
                        </div>
                    </div>
                    <section id="shopcart" class="shop shop-cart bg-gray section-white">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="cart-table table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr class="cart-product">
                                                    <th class="cart-product-date">Date</th>
                                                    <th class="cart-product-item" style="width: 60%;">Product</th>
                                                    <th class="cart-product-price">Price</th>
                                                    <th class="cart-product-quantity">Quantity</th>
                                                    <th class="cart-product-total">Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${orders}" var="o">
                                                    <c:forEach items="${o.carts}" var="c">
                                                        <tr class="cart-product">
                                                            <td class="cart-product-date">${o.date}</td>
                                                            <td class="cart-product-item flex items-center justify-between"><div class="cart-product-name"><h6>${c.product.name}</h6></div></td>
                                                            <td class="cart-product-price">$<fmt:formatNumber type="number" minFractionDigits="2" value="${c.product.price}"/></td>
                                                            <td class="cart-product-quantity">${c.quantity}</td>
                                                            <td class="cart-product-total"> $<fmt:formatNumber type="number" minFractionDigits="2" value="${c.quantity * c.product.price}"/></td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
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
