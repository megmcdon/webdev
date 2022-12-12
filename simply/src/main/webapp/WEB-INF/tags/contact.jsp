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
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<jsp:include page="/WEB-INF/common/nav.jsp">
                    <jsp:param name="isAuth" value="${isAuth}"/>
                    <jsp:param name="isAdminAuth" value="${isAdminAuth}"/>
                </jsp:include>
			</header>

			<div class="row">

				<iframe class="map"
					src="https://www.google.com/maps/place/Johns+Hopkins+University/@39.3299054,-76.6227064,17z/data=!3m1!4b1!4m5!3m4!1s0x89c804df8502f88d:0x303d58494fa04c66!8m2!3d39.3299013!4d-76.6205177?coh=164777&entry=tt&shorturl=1"
					allowfullscreen="" loading="lazy"></iframe>

				<form action="">
					<h3>get in touch</h3>
					<div class="row mb-2">
						<div class="form-group">
							<span class="fas fa-user"></span> <input class="form-control"
								type="text" placeholder="name">
						</div>
					</div>
					<div class="row mb-2">
						<div class="form-group">
							<span class="fas fa-envelope"></span> <input class="form-control"
								type="email" placeholder="email">
						</div>
					</div>
					<div class="row mb-2">
						<div class="form-group">

							<span class="fas fa-phone"></span> <input class="form-control"
								type="number" placeholder="number">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Contact Now</button>
				</form>

			</div>

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
