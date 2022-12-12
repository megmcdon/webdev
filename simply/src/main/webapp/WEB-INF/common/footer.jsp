<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--begin footer -->
<div class="footer">

    <!--begin container -->
    <div class="container">

        <!--begin row -->
        <div class="row footer-top">

            <!--begin col-md-3 -->
            <div class="col-md-4 padding-bottom-50">

                <h4>ABOUT US</h4>

                <p> Here at Simply Coffee we pride ourselves in delivering the 
                    finest coffee, beans and merchandise known to allkind.</p>

                <a href="${pageContext.request.contextPath}/about" class="btn btn-lg btn-yellow-x-small scrool">About Us</a>

            </div>
            <!--end col-md-3 -->



            <!--begin col-md-3 -->
            <div class="col-md-4 padding-bottom-50">

                <h4>CONTACT DETAILS</h4>

                <p class="contact_info"><i class="fa fa-map-marker"></i>Baltimore, Maryland</p>

                <p class="contact_info"><i class="fa fa-phone"></i>+1 (410) 516-7456</p>

                <p class="contact_info"><i class="fa fa-envelope-square"></i> <a href="mailto:simplycoffee@sc.com">simplycoffee@sc.com</a></p>

                <a href="${pageContext.request.contextPath}/contact" class="btn btn-lg btn-yellow-x-small scrool">Contact Us</a>

            </div>
            <!--end col-md-3 -->

            <!--begin col-md-3 -->
            <div class="col-md-4 padding-bottom-50">
                <h4>ADMIN LOGIN</h4>
                <p> Log into the system as an admin to manage the inventories and others etc.</p>
                <c:if test="${isAdminAuth}">
                    <a href="${pageContext.request.contextPath}/adminPortal" class="btn btn-lg btn-yellow-x-small scrool">Manage Stocks</a>
                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-lg btn-yellow-x-small scrool">Logout</a>
                </c:if>
                <c:if test="${!isAdminAuth}">
                    <c:if test="${isAuth}">
                        <i>Already logged in as a customer. Please logout first to login as an admin.</i>
                    </c:if>
                    <c:if test="${!isAuth}">
                        <a href="${pageContext.request.contextPath}/login?admin=true" class="btn btn-lg btn-yellow-x-small scrool">Login</a>
                    </c:if>
                </c:if>
            </div>
            <!--end col-md-3 -->
        </div>
        <!--end row -->

        <!--begin row -->
        <div class="row">

            <!--begin footer-bottom -->
            <div class="footer-bottom">

                <!--begin col-md-5 -->
                <div class="col-md-5">

                    <!--begin copyright -->
                    <div class="copyright ">
                        <p> &#169; 2022 Simply Coffee. Designed by Simply Coffee</a></p>

                    </div>
                    <!--end copyright -->

                </div>
                <!--end col-md-5 -->

                <!--begin col-md-2 -->
                <div class="col-md-2 text-center">

                    <a href="#hero-section" class="scrool top-scroll"><i class="fa fa-angle-double-up"></i></a>

                </div>
                <!--end col-md-2 -->


            </div>
            <!--end footer-bottom -->

        </div>
        <!--end row -->

    </div>
    <!--end container -->

</div>
<!--end footer -->


<script>
function myFunction() {
var x = document.getElementById("navbar-collapse-02");
if (x.classList.contains("collapse")) {
x.classList.remove("collapse");
x.classList.add("in");
} else {
x.classList.add("collapse");
x.classList.remove("in");
}
}
</script>

<!-- Load JS here for greater good =============================-->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-switch.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.nav.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.js"></script>

<!-- RS5.0 Core JS Files -->
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/jquery.themepunch.revolution.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.carousel.min.js"></script>

<!-- begin custom script-->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>

