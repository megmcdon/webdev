<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>About</title>
        <jsp:include page="/WEB-INF/common/header.jsp" />
    </head>
    <body>
        <main>
            <div class="container py-4">
                <header class="pb-3 mb-4 border-bottom">
                    <jsp:include page="/WEB-INF/common/nav.jsp">
                        <jsp:param name="isAuth" value="${isAuth}"/>
                        <jsp:param name="isAdminAuth" value="${isAdminAuth}"/>
                    </jsp:include>
                </header>

                <div>Add Content</div>

                <footer class="pt-3 mt-4 text-muted border-top">
                    <jsp:include page="/WEB-INF/common/footer.jsp">
                        <jsp:param name="isAdminAuth" value="${isAdminAuth}"/>
                        <jsp:param name="isAuth" value="${isAuth}"/>
                    </jsp:include>
                </footer>
            </div>
        </main>
    </body>
</html>
