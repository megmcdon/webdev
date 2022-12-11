<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jh" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${cat} ~ Products</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>
            <div class="">
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp" />
                </header>

                <!--begin menu-hero-section -->
                <section id="hero-section" class="menu-hero-section">

                    <!--begin image-overlay -->
                    <div class="image-overlay"></div>
                    <!--end image-overlay -->

                    <!--begin container-->
                    <div class="container image-section-inside">

                        <!--begin row-->
                        <div class="row">

                            <!--begin col-md-10-->
                            <div class="col-md-10 col-md-offset-1 text-center">

                                <span class="comic-text white wow fadeIn" data-wow-delay="0.5s">Our Products</span>

                                <p class="hero-text wow fadeInUp" data-wow-delay="2s">
                                We would love for you to stop by our flagship cafe at the JHU campus, but understand this cannot be a reality for everyone.
                                For those who cannot make it but want to experience our coffee, we have started to sell our products online! <br> <br>
                                
                                Our beans -- that are freshly roasted to maximize freshness, and merchandise can be shipped nationwide while 
                                our brew can be delivered if you live on campus. <br> <br>
                                 
                                Just a reminder that all our products are fair trade and organic. 
                                </p>

                            </div>
                            <!--end col-md-10-->

                        </div>
                        <!--end row-->

                    </div>
                    <!--end container-->    

                </section>
                <!--end menu-hero-section -->

                <!--begin menu-section-->
                <section class="section-white">

                    <!--begin container-->
                    <div class="container">
                        <div class="row">
                            <jh:loop type="Beans" products="${beans}"></jh:loop>
                            <jh:loop type="Brewing Equipment" products="${brew}"></jh:loop>
                            <jh:loop type="Merchandise" products="${merch}"></jh:loop>
                            </div>
                        </div>
                        <!--end container-->
                    </section>
                    <!--end menu-section-->

                    <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                </footer>
            </div>
        </main>
    </body>
</html>