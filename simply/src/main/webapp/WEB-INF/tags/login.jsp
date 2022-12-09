<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>

            <div class="">
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp" />
                </header>

                <section class="section-white" style="padding: 200px 0px;">

                    <!--begin container-->
                    <div class="container"> 
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                                <h2 class="section-title wow bounceIn" data-wow-delay="1s">Login</h2>
                            </div>
                        </div>
                        <!--begin row-->
                        <div class="row">

                            <!--begin contact form -->
                            <form id="login-form" class="contact" method="post" action="<c:url value="/login"/>">

                                <!--begin col-md-6-->
                                <div class="col-md-12 wow slideInLeft" data-wow-delay="0.2s">
                                    <input class="contact-input white-input" required name="email" placeholder="Email Address" type="email">
                                    <input class="contact-input white-input" required name="password" placeholder="Password" type="password">
                                </div>
                                <!--end col-md-6-->

                                <input value="Login" id="submit-button" class="btn btn-lg btn-reverse-yellow-small scrool wow fadeInUp" type="submit">

                            </form>
                            <!--end contact form -->

                        </div>
                        <!--end row-->

                        <div class="row" id="contact-form" style="text-align:left; padding:0px 15px;">
                            <a class="ms-2" href="<c:url value="/user"/>">Don't Have an Account? Sign Up.</a>
                        </div>

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