<%-- 
    Document   : Index
    Created on : Jul 1, 2020, 2:39:15 PM
    Author     : arkan481
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/views/layouts/head.jsp">
            <jsp:param name="title" value="Index"/>
        </jsp:include>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
    </head>
    <body>

        <div class="container pt-4">
            <jsp:include page="/views/layouts/navbar.jsp"></jsp:include>
                <div class="row">
                    <div class="col-4 pb-4">
                        <a href="${pageContext.request.contextPath}/create" class="btn btn-sm btn-primary">Create</a>
                    </div>
                    <div class="col-12">
                        <table class="table table-responsive table-hover">
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>Product Name</td>
                                    <td>Category</td>
                                    <td>Qty</td>
                                    <td>Expired At</td>
                                    <td>Action</td>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${data}">
                                <tr>
                                    <td><p>${item.id}</p></td>
                                    <td><p>${item.productName}</p></td>
                                    <td><p>${item.category}</p></td>
                                    <td><p>${item.qty}</p></td>
                                    <td><p>${item.expired_at}</p></td>
                                    <td>
                                        <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/edit?id=${item.id}" name="id" value="${item.id}">
                                            Edit
                                        </a>
                                            <form action="" method="POST">
                                                <button class="btn btn-sm btn-danger" value="${item.id}" name="del">Delete</button>
                                            </form>
<!--                                        <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/" onclick="">
                                            Delete
                                        </a>-->
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <jsp:include page="/views/layouts/footer.jsp"></jsp:include>
            </div>
        <jsp:include page="/views/layouts/scripts.jsp"></jsp:include>
    </body>
</html>
