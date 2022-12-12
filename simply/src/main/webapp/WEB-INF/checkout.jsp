<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                    <!--begin container-->
                    <div class="container"> 
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                                <h2 class="section-title wow bounceIn" data-wow-delay="1s">Confirm Order</h2>
                            </div>
                        </div>
                        <!--begin row-->
                        <div class="row">
                            <h3>Cart Total $<fmt:formatNumber type="number" minFractionDigits="2" value="${totalPrice}"/></h3>
                            <c:choose>
                                <c:when test="${not empty cart }">
                                    <form method="post" action="<c:url value="/cart/confirm"/>">
                                        <div class="row mb-4">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>First Name</label> <input type="text"
                                                                                     class="form-control" value="${user.firstName }" />
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Last Name</label> <input type="text"
                                                                                    class="form-control" value="${user.lastName }" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row mb-4">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Credit Card</label> <input type="text"
                                                                                      class="form-control" value="${user.ccnum }" />
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Expire</label> <input type="text" class="form-control"
                                                                                  value="${user.ccexp }" />
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Cvv</label> <input type="text" class="form-control"
                                                                              value="${user.cccvv }" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row mb-4">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Billing Address</label> <input type="text"
                                                                                          class="form-control" value="${user.billingAddr }" />
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Shipping Address</label> <input type="text" class="form-control"
                                                                                           value="${user.shippingAddr }" />
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Confirm</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <div class="alert alert-info">Your Cart is Empty</div>
                                </c:otherwise>
                            </c:choose>


                            <!--end contact form -->

                        </div>
                        <!--end row-->
                    </div>
                    <!--end container-->

                </section>
                <!--end section-white-->

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
