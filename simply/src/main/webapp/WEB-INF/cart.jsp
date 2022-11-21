<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<jsp:include page="/WEB-INF/common/header.jsp" />
</head>
<body>
	<main>
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<jsp:include page="/WEB-INF/common/nav.jsp" />
			</header>

			<div class="container">
				<h3>Cart</h3>
				<c:choose>

					<c:when test="${not empty cart.products }">
						<c:forEach items="${cart.products}" var="p">
							<div class="row mb-4">
								<div class="col-md-4">${p.key.name}</div>
								<div class="col-md-4">
									<input required data-ctx="${pageContext.request.contextPath}"
										data-id="${p.key.id }" type="number" class="form-control qty"
										value="${p.value}" />
								</div>
								<div class="col-md-1 align-middle">
									<c:out value="$${p.key.price}" />
								</div>
								<div class="col-md-1">
									<button data-ctx="${pageContext.request.contextPath}"
										data-id="${p.key.id }" class="btn btn-danger delete">Remove</button>
								</div>
							</div>
						</c:forEach>
						<div><h3>Total: $<span id="totalspan">${cart.total }</span></h3></div>
						<a class="btn btn-primary" href="<c:url value="/checkout" />">Check Out</a>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">Your Cart is Empty</div>
					</c:otherwise>
				</c:choose>



			</div>

			<footer class="pt-3 mt-4 text-muted border-top">
				<jsp:include page="/WEB-INF/common/footer.jsp" />
				<script src="${pageContext.request.contextPath}/js/cart.js"></script>
			</footer>

		</div>
	</main>
</body>
</html>