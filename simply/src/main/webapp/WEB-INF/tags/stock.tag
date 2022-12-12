<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="type" required="true"%>
<%@attribute name="products" required="true" type="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty products}">
    <div class="col-md-6">
		<h2 class="menu-section-title">${type}</h2>
		<c:forEach items="${products}" var="p" varStatus="status">
            <div class="menu-wrapper" style="width:100%;">
                <div class="menu-image">
                    <div class="popup-wrapper">
                        <div class="popup-gallery">
                            <a href="/images/products/products${p.id}.webp" class="popup3 blog-item-pic" style="width:75%;">
                                <img src="<c:url value="/images/products/products${p.id}.webp"/>" ><span class="eye-wrapper"><i class="fa fa-expand eye-icon"></i></span>
                            </a>
                        </div>
                     </div>
                </div>
                <div class="menu-description">
                    <div class="menu-list">
                        <h5>${p.name}</h5>
                        <span class="menu-dot-line"></span>
                    </div>
                    <br/>
                    <form method="put" action="<c:url value="/cart/stock"/>">
                        <input type="hidden" name="pid" value="${p.id}" />
                        <div class="row mb-2">
                            <div class="col-sm-4 col-4">
                                <input name="stock" class="form-control" type="number" step="1" value="${p.stock}" min="0" required="required">
                            </div>
                            <div class="col-sm-4 col-4">
                                <button type="submit" class="btn-cart"> <i class="fa-solid fa-rotate-right"></i> </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
		</c:forEach>
	</div>
</c:if>
