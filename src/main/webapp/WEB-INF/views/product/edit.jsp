<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 蔡林红
  Date: 2017/11/4
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form action="" method="post">
            <div class="form-group">
                <labal>所有类型</labal>
                <select name="typeId" class="form-control">
                    <option value="">请选择类型</option>
                    <c:forEach items="${typeList}" var="type">
                        <option value="${type.id}" ${type.id==product.typeId ? 'selected' : ''}>${type.typeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                    <label>商品名称</label>
                    <input type="text" name="productName" value="${product.productName}" class="form-control">
                     </div>
                    <div class="form-group">
                        <label>产地</label>
                        <input type="text" name="place" value="${product.place}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>市场价</label>
                        <input type="text"  name="marketPrice" value="${product.marketPrice}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>考拉价</label>
                        <input type="text" name="price" value="${product.price}" class="form-control">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-success">保存</button>
                    </div>
        </form>

    </div>


</body>
</html>
