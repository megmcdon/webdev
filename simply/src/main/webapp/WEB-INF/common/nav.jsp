<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default navbar-fixed-top">

    <!--begin container -->
    <div class="container flex items-center justify-between">

        <!--begin navbar -->
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/cart" class="navbar-toggle"><i class="fa fa-cart-shopping"></i></a>
            <a class="navbar-toggle" href="javascript:void(0);" onclick="myFunction()"><i class="fa fa-bars"></i></a>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand brand scrool"><img src="${pageContext.request.contextPath }/images/lg1.png" alt="logo" class="width-100"></a>
        </div>

        <div id="navbar-collapse-02" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">			      
                <li class="selected"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                <li>
                    <a class="dropdown" href="${pageContext.request.contextPath}/products">
                        Products
                        <!-- <i class="fa fa-caret-down"></i> -->
                    </a> 
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/products?category=beans">Beans</a>
                        <a href="${pageContext.request.contextPath}/products?category=brew">Coffee</a>
                        <a href="${pageContext.request.contextPath}/products?category=merch">Merchandise</a>
                    </div>
                </li>
                <li><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
                <li><a href="${pageContext.request.contextPath}/account">Account</a></li>
                <li><a href="${pageContext.request.contextPath}/cart" class="purchase"><i class="fa fa-cart-shopping"></i> Cart</a></li>
                <c:if test="${isAuth || isAdminAuth}">
                    <li><a href="${pageContext.request.contextPath}/logout" class="purchase">Logout</a></li>
                </c:if>
                <c:if test="${!isAuth && !isAdminAuth}">
                    <li><a href="${pageContext.request.contextPath}/login" class="purchase">Login</a></li>
                </c:if>
            </ul>
        </div>
        <!--end navbar -->

    </div>
    <!--end container -->

</nav>
