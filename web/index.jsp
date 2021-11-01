<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deng
  Date: 2020/3/16
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--    @elvariable id="per" type="com.test"--%>
<%--    @elvariable id="per" type=""--%>
    <form:form action="FormDemo/testpara">
<%--      <form:input naem="name" /><br/>--%>
        name:<input name="name" TYPE="text"><br/>
        age:<input name="age" type="text">
      <input type="submit" value="提交"/>
    </form:form>
    <form:form action="FormDemo/testmethod" method="post">
        <input type="submit" value="增加">
    </form:form>
    <form:form action="FormDemo/testmethod" method="put">
        <input type="submit" value="修改">
    </form:form>
    <form:form action="FormDemo/testmethod" method="get">
        <input type="submit" value="查询">
    </form:form>
    <form:form action="FormDemo/testmethod" method="delete">
        <input type="submit" value="删除">
    </form:form>
    <form:form action="FormDemo/testupload" enctype="multipart/form-data" method="get">
        <input type="file" name="file"/>
        desc:<input name="desc" type="text"/>
        <input type="submit" value="upload">
    </form:form>

    <a href="${pageContext.request.contextPath}/FormDemo/test">hello</a>


  $END$
  </body>
</html>
