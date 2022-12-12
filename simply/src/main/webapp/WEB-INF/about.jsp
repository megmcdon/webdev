<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>About</title>
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

                                <span class="comic-text white wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>

                                <h2 class="section-title white wow bounceIn" data-wow-delay="1s">Organic & Fair Trade</h2>

                                <p class="hero-text wow fadeInUp" data-wow-delay="2s">
                                Here at Simply Coffee we pride ourselves in delivering the 
                                finest coffee, beans and merchandise known to allkind. All Coffee
                                products sold are Fair Trade certified meaning that the coffee
                                has not been audited throughout the supply chain to meet certain
                                sustainability and labor standards. To top that all off, all 
                                merchandise sends money back to the factory workers who make
                                our product. </p>

                            </div>
                            <!--end col-md-10-->

                        </div>
                        <!--end row-->

                    </div>
                    <!--end container-->    

                </section>
                <!--end about-hero-section -->

                <!--begin section-white-->
                <section class="section-white">

                    <!--begin container-->
                    <div class="container"> 

                        <!--begin row-->
                        <div class="row">

                            <!--begin col-md-6-->
                            <div class="col-md-6 wow slideInLeft">

                                <img src="${pageContext.request.contextPath}/images/lg3.gif" alt="picture" class="width-100">

                            </div>
                            <!--end col-md-6-->

                            <!--begin col-md-6-->
                            <div class="col-md-6 text-center padding-top-40 padding-bottom-40 wow slideInRight">

                                <span class="comic-text">Discover</span>

                                <h2 class="section-title">Our Story</h2>

                                <p>We believe that sustainable and equitable trade relationships should
                                be the standard across the globe. When you treat workers and farmers 
                                fairly, everyone benefits. By making all our products fair trade we 
                                help businesses source products that are ethically and sustainably 
                                produced which also gives our consumer confidence that the people behind
                                the products get a fair deal for their hard work.</p>
                                
                                <p>We also ensure that all products sold are of the highest quality. To 
                                ensure freshness, we roast our beans in house which not only lets us 
                                control the roast level but also allows us to add subtle nuances that make
                                our coffee like no other.</p>

                            </div>
                            <!--end col-md-6-->

                        </div>
                        <!--end row-->

                    </div>
                    <!--end container-->

                </section>
                <!--end section-white-->

                <div id="rev_slider_30_1_wrapper" class="rev_slider_wrapper fullwidthbanner-container" data-alias="media-carousel-autoplay30" style="margin:0px auto;background-color:#fff;padding:0px;margin-top:0px;margin-bottom:0px;">

                    <!-- START REVOLUTION SLIDER 5.0.7 fullwidth mode -->
                    <div id="rev_slider_30_1" class="rev_slider fullwidthabanner" style="display:none;" data-version="5.0.7">

                        <ul>	

                            <!-- SLIDE  -->
                            <li data-index="rs-122" data-transition="fade" data-slotamount="7"  data-easein="default" data-easeout="default" data-masterspeed="300"  data-rotate="0"  data-saveperformance="off"  data-title="Real Webdesign" data-param1="Regular Image" data-description="">

                                <!-- MAIN IMAGE -->
                                <img src="${pageContext.request.contextPath}/images/Beans.jpg"  alt=""  data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-no-retina>

                            </li>

                            <!-- SLIDE  -->
                            <li data-index="rs-122" data-transition="fade" data-slotamount="7"  data-easein="default" data-easeout="default" data-masterspeed="300"  data-rotate="0"  data-saveperformance="off"  data-title="Real Webdesign" data-param1="Regular Image" data-description="">

                                <!-- MAIN IMAGE -->
                                <img src="${pageContext.request.contextPath}/images/Brewing.jpg"  alt=""  data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-no-retina>

                            </li>

                            <!-- SLIDE  -->
                            <li data-index="rs-122" data-transition="fade" data-slotamount="7"  data-easein="default" data-easeout="default" data-masterspeed="300"  data-rotate="0"  data-saveperformance="off"  data-title="Real Webdesign" data-param1="Regular Image" data-description="">

                                <!-- MAIN IMAGE -->
                                <img src="${pageContext.request.contextPath}/images/Merchandise.jpg"  alt=""  data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-no-retina>

                            </li>

                        </ul>

                        <div class="tp-bannertimer tp-bottom" style="visibility: hidden !important;"></div>	

                    </div>

                </div><!-- END REVOLUTION SLIDER -->


               

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
