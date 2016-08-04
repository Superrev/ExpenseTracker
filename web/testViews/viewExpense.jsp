<%--
  Created by IntelliJ IDEA.
  User: Superduo
  Date: 8/4/16
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Expense</title>
</head>
<body>
view expense
<br><br>
<table>

    <%--private String expenseID;--%>
    <%--private String expenseName;--%>
    <%--private String expenseAmount;--%>
    <%--private String expenseDate;--%>
    <%--private CategoryType categoryType;--%>


    <tr>
        <td>Expense ID:</td>
        <td><c:out value="${expenses.expensesID}" /></td>
    </tr>
    <tr>
        <td> Expense Name:</td>
        <td><c:out value="${expenses.expenseName}" /></td>
    </tr>
    <tr>
        <td>Expense Amount:</td>
        <td><c:out value="${expenses.expenseAmount}" /></td>
    </tr>
    <tr>
        <td>Expense Date:</td>
        <td><c:out value="${expenses.expenseDate}" /></td>
    </tr>

    <tr>
        <td>Category Type:</td>
        <td><c:out value="${expenses.categoryType}" /></td>
    </tr>


</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/mvc_cust/viewAllExpenses">All Pets</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/mvc_cust/editExpenses?expensesID=<c:out value="${expenses.expensesID}" />">Edit Expenses</a>
</body>
</html>
</body>
</html>
