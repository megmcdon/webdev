<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="type" required="true"%>
<%@attribute name="products" required="true" type="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty products }">
	<h1>${type}</h1>
	<div class="row">
		<c:forEach items="${products }" var="p" varStatus="status">
			<div class="col-sm-4">
				<div class="card mb-2">
					<img
						src="<c:url value="https://via.placeholder.com/1024x200.png?text=Simply Coffee Placeholder" />"
						class="card-img-top" alt="Simply Coffee">
					<div class="card-body">
						<h5 class="card-title">
							<a href="<c:url value="/products/${p.id}"/>"> ${p.name} </a>
						</h5>
						<p class="card-text">${p.description }</p>
						<c:choose>
							<c:when test="${p.outOfStock }">
								<div class="alert alert-danger">Out of stock</div>
							</c:when>
							<c:otherwise>


								<form method="post" action="<c:url value="/cart"/>">
									<input type="hidden" name="pid" value="${p.id}" />
									<div class="row mb-2">
										<div class="col-sm-12">
											<input name="quantity" class="form-control" type="number"
												required="required">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<button type="submit" class="btn btn-primary">Add to
												cart</button>
										</div>
									</div>
								</form>

							</c:otherwise>

						</c:choose>


					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>
