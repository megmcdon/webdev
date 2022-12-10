<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                <jsp:include page="/WEB-INF/common/nav.jsp" />
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
                            <h2 class="section-title wow bounceIn" data-wow-delay="1s">Confirm Order</h2>
                        </div>
                    </div>
                    <div class="row">
                        <h4>Hi ${user.firstName}, your order has been confirmed!</h4>
                        <p>An email has been sent to the "${user.email}"...</P>
                    </div>
                    <div class="row">
                        <div class="col-md-2 text-left"><h5>Item</h5></div>
                        <div class="col-md-1 text-center"><h5>Quantity</h5></div>
                        <div class="col-md-1 text-center"><h5>Price</h5></div>
                        <div class="col-md-8"></div>
                    </div>
                    <c:forEach items="${cart}" var="item">
                        <div class="row">
                            <div class="col-md-2 text-left">${item.product.name}</div>
                            <div class="col-md-1 text-center">${item.quantity}</div>
                            <div class="col-md-1 text-left">$${item.quantity * item.product.price}</div>
                            <div class="col-md-8"></div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <div class="col-md-2 text-left"><h5>TOTAL</h5></div>
                        <div class="col-md-1"></div>
                        <div class="col-md-1 text-left"><h5>$${totalPrice}</h5></div>
                        <div class="col-md-8"></div>
                    </div>
                </div>
            </section>

            <footer class="pt-3 mt-4 text-muted border-top">
                <jsp:include page="/WEB-INF/common/footer.jsp" />
            </footer>
        </div>
    </main>
</body>

</html>