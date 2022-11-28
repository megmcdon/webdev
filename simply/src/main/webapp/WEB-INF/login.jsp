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
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<jsp:include page="/WEB-INF/common/nav.jsp" />
			</header>

			<form method="post" action="<c:url value="/j_security_check"/>">
				<div class="row mb-4">
					<div class="col-md-6">

						<label for="un" class="form-label">Email Address</label> <input
							required="required" class="form-control" name="j_username" id="un"
							type="text" />

					</div>
					<div class="col-md-6">

						<label for="pw" class="form-label">Password</label> <input
							class="form-control" name="j_password" id="pw" type="text"
							required="required" />

					</div>
				</div>
				<button class="btn btn-primary" type="submit">Login</button>
				<a class="ms-2" href="<c:url value="/SignupServlet"/>">Don't Have an Account. Sign Up.</a>
			</form>

			<footer class="pt-3 mt-4 text-muted border-top">
				<jsp:include page="/WEB-INF/common/footer.jsp" />
			</footer>
		</div>
	</main>
</body>
</html>