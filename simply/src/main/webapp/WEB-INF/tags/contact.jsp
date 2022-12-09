<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Contact Us</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>
            <div class="">
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp" />
                </header>

                <!--begin contact-hero-section -->
                <section id="hero-section" class="contact-hero-section">

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

                                <h2 class="section-title white wow bounceIn" data-wow-delay="1s">Get In Touch</h2>

                                <p class="hero-text wow fadeInUp" data-wow-delay="2s">For any enquiries you can give us a call at <strong>+xx xxx xx xx xxx</strong><br>Alternatively we can get in touch using the form bellow.</p>

                            </div>
                            <!--end col-md-10-->

                        </div>
                        <!--end row-->

                    </div>
                    <!--end container-->    

                </section>
                <!--end contact-hero-section -->

                <!--begin contact2-hero-section-->
                <div class="contact2-hero-section"> 



                    <!--begin image-overlay -->
                    <div class="image-overlay"></div>
                    <!--end image-overlay -->

                    <!--begin container-->
                    <div class="container image-section-inside"> 

                        <!--begin row-->
                        <div class="row">


                            <!--begin col-md-10-->
                            <div class="col-md-10 col-md-offset-1 text-center">

                                <h3 class="section-title small-margin wow fadeIn" data-wow-delay="0.3s">CONTACT FORM</h3>

                                <p class="wow fadeInUp" data-wow-delay="1s">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam odit corrupti ea libero. Praesentium voluptas, provident soluta libero assumenda nostrum. Cum porro at facere repellat.</p>

                                <!--begin contact-wrapper-->
                                <div class="contact-wrapper">

                                    <!--begin success message -->
                                    <p class="contact_success_box" style="display:none;">We received your message and you'll hear from us soon. Thank You!</p>
                                    <!--end success message -->

                                    <!--begin contact form -->
                                    <form id="contact-form" class="contact" action="" method="post">

                                        <!--begin col-md-6-->
                                        <div class="col-md-6 wow slideInLeft" data-wow-delay="0.2s">
                                            <input class="contact-input white-input form-control" required name="contact_names" placeholder="Full Name" type="text">
                                            <input class="contact-input white-input" required name="contact_email" placeholder="Email Address" type="email">
                                            <input class="contact-input white-input" required name="contact_phone" placeholder="Phone Number" type="text">
                                        </div>
                                        <!--end col-md-6-->

                                        <!--begin col-md-6-->
                                        <div class="col-md-6 wow slideInRight" data-wow-delay="0.25s">
                                            <textarea class="contact-commnent white-input" rows="2" cols="20" name="contact_message" placeholder="Your Message..."></textarea>
                                        </div>
                                        <!--end col-md-6-->

                                        <input value="Send Message" id="submit-button" class="btn btn-lg btn-reverse-yellow-small scrool wow fadeInUp" type="submit">

                                    </form>
                                    <!--end contact form -->

                                </div>
                                <!--end contact-wrapper-->

                            </div>
                            <!--end col-md-10-->

                        </div>
                        <!--end row-->

                        <div class="row flex">
                            <iframe class="map"
                                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3086.1626054682006!2d-76.6205177!3d39.329901299999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c804df8502f88d%3A0x303d58494fa04c66!2sJohns%20Hopkins%20University!5e0!3m2!1sen!2sus!4v1670585986415!5m2!1sen!2sus"
                                    allowfullscreen="yes" loading="lazy"></iframe>
                        </div>

                    </div>
                    <!--end container-->

                </div>
                <!--end contact2-hero-section-->


                <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                </footer>
            </div>
        </main>
    </body>
</html>