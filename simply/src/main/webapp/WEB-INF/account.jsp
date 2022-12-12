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
                                <table class="table table-bordered">
                                    <tr class="cart-product">
                                        <th>ID</th>
                                        <th>Date</th>
                                        <th>Items</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                    </tr>
                                    <c:choose>
                                        <c:when test="${not empty orders}">
                                            <c:forEach items="${orders}" var="o">
                                                <tr class="cart-product">
                                                    <td>${o.id}</td>
                                                    <td>${o.date}</td>
                                                    <td>name</td>
                                                    <td>$<fmt:formatNumber type="number" minFractionDigits="2" value="0"/></td>
                                                    <td>0</td>
                                                    <td>$<fmt:formatNumber type="number" minFractionDigits="2" value="0"/></td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                    </c:choose>
                                </table>
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