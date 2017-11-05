<%--
  Created by IntelliJ IDEA.
  User: 蔡林红
  Date: 2017/11/4
  Time: 11:29
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
        <c:if test="${not empty message}">
            <div class="alert alert-info">
                    ${message}
            </div>
        </c:if>

        <h3 class="page-header">
            ${kaola.productName}
                <a href="/product/${kaola.id}/edit" class="btn btn-info pull-right">编辑</a>
                <a href="javascript:;" id="delLink" rel="${kaola.id}" class="btn btn-danger pull-right">删除</a>
        </h3>
        <ul>
            <li>产地 : ${kaola.place}</li>
            <li>市场价: ${kaola.marketPrice}</li>
            <li>考拉价: ${kaola.price}</li>
            <li>评论数量: ${kaola.commentNum}</li>
        </ul>
        <a href="/product">返回列表</a>
    </div>

    <script src="/static/js/jquery.min.js"></script>
    <script>
        $(function(){
            $("#delLink").click(function(){
                var id=$(this).attr("rel");
                if(confirm("你确定要删除吗？")){
                    window.location.href="/product/"+id+"/delete";
                }
            });

        });

    </script>
</body>
</html>
