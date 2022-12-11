<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="type" required="true"%>
<%@attribute name="products" required="true" type="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${not empty products }">

	<!--begin col-md-6-->
	<div class="col-md-6">
		<h2 class="menu-section-title">${type}</h2>
	
		<c:forEach items="${products }" var="p" varStatus="status">
			<!--begin menu-wrapper-->
				<div class="menu-wrapper"  style="width:100%;">
					
					<!--begin menu-image-->
					<div class="menu-image">
					
						<div class="popup-wrapper">
                         	<div class="popup-gallery">
                         	   <a href="/images/products/products${p.id}.webp" class="popup3 blog-item-pic" style="width:100%;"><img src="<c:url value="/images/products/products${p.id}.webp"/>" ><span class="eye-wrapper"><i class="fa fa-expand eye-icon"></i></span></a>
                         		
                         	</div>
                         </div>	
                         
					</div>
					<!--end menu-image-->
						
					<!--begin menu-description-->
					<div class="menu-description">
						
						<!--begin menu-list-->
						<div class="menu-list">
						
							<h5>${p.name}</h5>
							
							<p class="price">$<fmt:formatNumber type="number" minFractionDigits="2" value="${p.price}"/></p>

							
							
							<span class="menu-dot-line"></span>
							
						</div>
						<!--end menu-list-->
						
						<p class="menu-ingredients">${p.description }</p>

						<c:choose>
							<c:when test="${p.stock == 0}">
								<div class="alert alert-danger" style="height:34px; padding:6px; text-align:center">Out of stock</div>
							</c:when>
							<c:otherwise>


								<form method="post" action="<c:url value="/cart"/>">
									<input type="hidden" name="pid" value="${p.id}" />
									<input type="hidden" name="uri" value="add-products" />
									<div class="row mb-2">
										<div class="col-sm-4 col-4">
											<input name="quantity" class="form-control" type="number" step="1" value="0" min="1" max="10"
												required="required">
										</div>
										<div class="col-sm-4 col-4">
											<button type="submit" class="btn-cart"> <i class="fa fa-shopping-cart"></i> </button>
										</div>
									</div>
								</form>

							</c:otherwise>

						</c:choose>
							
					</div>
					<!--end menu-description-->
							
				</div>
				<!--end menu-wrapper-->
		</c:forEach>

	</div>
	<!--end col-md-6-->
</c:if>
