<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<jsp:include page="/WEB-INF/common/header.jsp" />
</head>
<body>
	<main>
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<jsp:include page="/WEB-INF/common/nav.jsp" />
			</header>

			<form method="post" action="<c:url value="/SignupServlet"/>">
				<div class="row mb-4">
					<div class="col-md-6">

						<label for="fname" class="form-label">First Name</label> <input
							required="required" class="form-control" name="fname" id="fname"
							type="text" />

					</div>
					<div class="col-md-6">

						<label for="lname" class="form-label">Last Name</label> <input
							class="form-control" name="lname" id="lname" type="text"
							required="required" />

					</div>
				</div>
				<div class="row mb-4">
					<div class="col-md-12">

						<label for="email" class="form-label">Email Address</label> <input
							type="email" class="form-control" name="email" id="email"
							type="text" required="required" />

					</div>
				</div>
				<div class="row mb-4">
					<div class="col-md-12">

						<label for="ba" class="form-label">Billing Address</label> <input
							class="form-control" name="ba" id="ba" type="text"
							required="required" />

					</div>
				</div>
				<div class="row mb-4">
					<div class="col-md-12">

						<label for="sa" class="form-label">Shipping Address</label> <input
							class="form-control" name="sa" id="sa" type="text" />

					</div>
				</div>
				<div class="row mb-4">
					<div class="col-md-4">

						<label for="cc" class="form-label">Credit Card</label> <input
							class="form-control" name="cc" id="cc" type="text"
							required="required" />

					</div>
					<div class="col-md-4">

						<label for="expiry" class="form-label">Expiry</label> <input
							class="form-control" name="expiry" id="expiry" type="text"
							required="required" />

					</div>
					<div class="col-md-4">

						<label for="cvv" class="form-label">Cvv</label> <input
							class="form-control" name="cvv" id="cvv" type="text"
							required="required" />

					</div>
				</div>
				<div class="row mb-4">
					<div class="col-md-6">

						<label for="cc" class="form-label">Password</label> <input
							class="form-control" name="password" id="password" type="text"
							required="required" />

					</div>
					<div class="col-md-6">

						<label for="expiry" class="form-label">Confirm Password</label> <input
							class="form-control" name="confirmPassword" id="confirmPassword"
							type="text" required="required" />

					</div>
				</div>
				<button class="btn btn-primary" type="submit">Sign Up</button>
			</form>

			<footer class="pt-3 mt-4 text-muted border-top">
				<jsp:include page="/WEB-INF/common/footer.jsp" />
			</footer>
		</div>
	</main>
</body>
</html>