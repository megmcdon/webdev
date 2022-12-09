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

                                <span class="comic-text white wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>

                                <h2 class="section-title white wow bounceIn" data-wow-delay="1s">--- Slogan here ---</h2>

                                <p class="hero-text wow fadeInUp" data-wow-delay="2s">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis doloribus assumenda quis provident iusto id suscipit ipsum, ut alias repellat quia aut itaque, labore temporibus minus facere ex, nesciunt a.</p>

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

                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quos vitae placeat nulla eveniet quisquam. Cupiditate ipsa alias commodi rerum voluptatum repellat dolor earum. Sint, eligendi nam, et dolor aperiam odit possimus porro eos ullam excepturi nostrum magnam temporibus pariatur, nemo non iste facilis nesciunt aut ut cupiditate error! Illo, ipsum? Nam ad, libero dicta adipisci magni accusamus reiciendis, sunt id fugiat non, atque eum odio nemo. Ipsa quibusdam eligendi necessitatibus sed architecto saepe iste, consequatur vero nisi numquam possimus quis voluptate nostrum nam, natus velit non! Eum voluptas repudiandae laborum recusandae corrupti iste odit, blanditiis minus, cupiditate unde libero amet.</p>

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
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                </footer>
            </div>
        </main>
    </body>
</html>