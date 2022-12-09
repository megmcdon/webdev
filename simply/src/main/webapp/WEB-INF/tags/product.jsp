<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${product.name }</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>
            <div >
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp" />
                </header>



                <div>
                    <h5>${product.name }</h5>
                    ${product.description }
                    <h5>Todo Add Images</h5>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <form method="post" action="<c:url value="/cart"/>">
                            <input type="hidden" name="p_id" value="${product.id}" />
                            <div class="row mb-2">
                                <div class="col-sm-12">
                                    <input name="quantity" class="form-control" type="number"
                                           required="required">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <button type="submit" class="btn btn-primary">Add to
                                        cart2</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp" />
                </footer>
            </div>
        </main>
    </body>
</html>