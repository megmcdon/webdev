<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jh" tagdir="/WEB-INF/tags"%>

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
			
			<!-- begin section white -->
            <section class="section-white" style="padding: 200px 0px;">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        ${error}
                    </div>
                </c:if>

                <!-- begin container -->                
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <span class="comic-text wow fadeIn" data-wow-delay="0.5s">Simply Coffee</span>
                            <h2 class="section-title wow bounceIn" data-wow-delay="1s">Stock Management</h2>
                        </div>
                    </div>
                </div>
				<!-- end container -->                
                
                <!-- begin container -->
                <div class="container">
                    <div class="row">
                        <jh:stock type="Beans" products="${beans}"></jh:stock>
                        <jh:stock type="Brewing Equipment" products="${brew}"></jh:stock>
                        <jh:stock type="Merchandise" products="${merch}"></jh:stock>
                    </div>
                </div>
				<!-- end container -->                
                
            </section>
			<!-- end section-white -->                

            <footer class="pt-3 mt-4 text-muted border-top">
                <jsp:include page="/WEB-INF/common/footer.jsp" />
            </footer>
        </div>
    </main>
</body>

</html>