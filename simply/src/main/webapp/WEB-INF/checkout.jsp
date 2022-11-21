<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<jsp:include page="/WEB-INF/common/header.jsp" />
</head>
<body>
	<main>
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<jsp:include page="/WEB-INF/common/nav.jsp" />
			</header>

			<div class="container">
				<h3>Cart Total $${cart.total }</h3>
				<c:choose>
					<c:when test="${not empty cart.products }">
						<form method="post" action="${pageContext.request.contextPath}/checkout">
							<div class="row mb-4">
								<div class="col-md-6">
									<div class="form-group">
										<label>First Name</label> <input type="text"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Last Name</label> <input type="text"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-md-3">
									<div class="form-group">
										<label>Credit Card</label> <input type="text"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Expriry</label> <input type="text" class="form-control" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Cvv</label> <input type="text" class="form-control" />
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Confirm</button>
						</form>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">Your Cart is Empty</div>
					</c:otherwise>
				</c:choose>

			</div>


			<footer class="pt-3 mt-4 text-muted border-top">
				<jsp:include page="/WEB-INF/common/footer.jsp" />
			</footer>
		</div>
	</main>
</body>
</html>