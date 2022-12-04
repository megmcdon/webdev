<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}">
			Simply Coffee </a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/products">Menu</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/products?category=beans">Bean</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/products?category=brewing">Brewing
						Equipment</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/products?category=merch">Merchandise
				</a></li>

				<c:if test="${empty pageContext.request.remoteUser}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/LoginServlet">Account</a></li>
				</c:if>




				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/About">About</a></li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cart">Cart</a></li>



				<c:if test="${not empty pageContext.request.remoteUser}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/Logout">Logout</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>