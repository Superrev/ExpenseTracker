<%--
  Created by IntelliJ IDEA.
  User: Superduo
  Date: 8/4/16
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All expenses</title>
</head>
<body>
<h1>View All expenses</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view All Expenses</title>
</head>
<body>
<br><br>
<table>

    <%--private String expenseID;--%>
    <%--private String expenseName;--%>
    <%--private String expenseAmount;--%>
    <%--private String expenseDate;--%>
    <%--private CategoryType categoryType;--%>


    <c:forEach items="${expenses}" var="expenses">
        <tr>
                <%--<td><a href="/mvc_cust/viewOwner?ownerid=${owner.ownerId}"><c:out value="${owner.ownerId}" /></a></td>--%>

            <td><a href="/mvc_cust/viewExpense?expenseID=${expenses.expenseID}"><c:out value="${expenses.expensesID}" /></a></td>
            <td><c:out value="${expenses.expenseID}" /></td>
            <td><c:out value="${expenses.expenseName}" /></td>
            <td><c:out value="${expenses.expenseAmount}" /></td>
            <td><c:out value="${expenses.expenseDate}" /></td>
            <td><c:out value="${expenses.categoryType}" /></td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>
</body>
</html>