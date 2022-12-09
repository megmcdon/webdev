<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sign Up</title>
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
                    <!--begin container-->
                    <div class="container"> 
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                                <h2 class="section-title wow bounceIn" data-wow-delay="1s">Sign up</h2>
                            </div>
                        </div>
                        <!--begin row-->
                        <div class="row">

                            <!--begin contact form -->
                            <form:form modelAttribute="user" id="signup-form" class="contact" method="post" action="${pageContext.request.contextPath}/user">

                                <!--begin col-md-6-->
                                <div class="col-md-12 wow slideInLeft" data-wow-delay="0.2s">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <form:input class="contact-input white-input" path="firstName" placeholder="First Name" type="text" required="required"/>
                                        </div>
                                        <div class="col-md-6">
                                            <form:input class="contact-input white-input" path="lastName" placeholder="Last Name" type="text" required="required"/>
                                        </div>
                                    </div>
                                    <form:input class="contact-input white-input"  path="email" placeholder="Email" type="email" required="required"/>
                                     <input class="contact-input white-input" required name="password" placeholder="Password" type="password" required="required">
                                    <form:input class="contact-input white-input"  path="billingAddr" placeholder="Billing Address" type="text" required="required"/>
                                    <form:input class="contact-input white-input"  path="shippingAddr" placeholder="Shipping Address" type="text"/>
                                </div>
                                <div class="col-md-12 wow slideInLeft" data-wow-delay="0.2s">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <form:input class="contact-input white-input" path="ccnum" placeholder="Credit Card" type="text" required="required"/>
                                        </div>
                                        <div class="col-md-4">
                                            <form:input class="contact-input white-input" path="ccexp" placeholder="Expriry MM/YY" type="text" required="required" />
                                        </div>
                                        <div class="col-md-4">
                                            <form:input class="contact-input white-input" path="cccvv" placeholder="cvv" type="text" required="required" max='5' min='3'/>
                                        </div>
                                    </div>



                                   
                                </div>
                                <!--end col-md-6-->

                                <input value="Sign Up" id="submit-button" class="btn btn-lg btn-reverse-yellow-small scrool wow fadeInUp" type="submit">

                            </form:form>
                            <!--end contact form -->

                        </div>
                        <!--end row-->
                    </div>
                    <!--end container-->

                </section>
                <!--end section-white-->

                <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                </footer>
            </div>
        </main>
    </body>
</html>