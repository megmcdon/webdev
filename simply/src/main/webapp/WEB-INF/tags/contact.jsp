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
				<jsp:include page="/WEB-INF/common/nav.jsp" />
			</header>

			<div class="row">

				<iframe class="map"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30153.788252261566!2d72.82321484621745!3d19.141690214227783!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7b63aceef0c69%3A0x2aa80cf2287dfa3b!2sJogeshwari%20West%2C%20Mumbai%2C%20Maharashtra%20400047!5e0!3m2!1sen!2sin!4v1629452077891!5m2!1sen!2sin"
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
				<jsp:include page="/WEB-INF/common/footer.jsp" />
			</footer>
		</div>
	</main>
</body>
</html>