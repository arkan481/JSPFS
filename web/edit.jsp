<%-- 
    Document   : create
    Created on : Jul 9, 2020, 7:46:34 AM
    Author     : arkan481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/views/layouts/head.jsp">
            <jsp:param name="title" value="Create"/>
        </jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container pt-4">
            <jsp:include page="/views/layouts/navbar.jsp"></jsp:include>
                <div class="row">
                    <div class="col-4">
                        <form action="edit" method="POST">
                            <input type="hidden" value="${product.id}" name ="id" />
                            <div class="form-group">
                                <label for="productName">Product Name</label>
                                <input class="form-control" type="text" name="productName" value="${product.productName}"/>
                            </div>
                            <div class="form-group">
                                <label for="category">Product Category</label>
                                <select name="category" class="form-control" type="text">
                                    <option ${product.category == 'Alat Mandi' ? 'selected' : ''} value="Alat Mandi">Alat Mandi</option>
                                    <option ${product.category == 'Makanan & Minuman' ? 'selected' : ''} value="Makanan & Minuman">Makanan & Minuman</option>
                                    <option ${product.category == 'Pakaian' ? 'selected' : ''} value="pakaian">Pakaian</option>
                                    <option ${product.category == 'Elektronik' ? 'selected' : ''} value="Elektronik">Elektronik</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="qty">Product Quantity</label>
                                <input class="form-control" type="number" min="0" name="qty" value="${product.qty}"/>
                            </div>
                            <div class="form-group">
                                <label for="expired_at">Product Expired</label>
                                <input name="expired_at" type="text" id="datepicker" value="${product.expired_at}"/>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-sm btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            <jsp:include page="/views/layouts/footer.jsp"></jsp:include>
            </div>
        <jsp:include page="/views/layouts/scripts.jsp"></jsp:include>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
            $('#datepicker').datepicker({
                weekStart: 1,
                autoclose: true,
                todayHighlight: true,
                format: 'yyyy-mm-dd'
            });
            $('#datepicker').datepicker("setDate", new Date());
        </script>
    </body>
</html>
