<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Superduo
  Date: 8/4/16
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Expense</title>
</head>
<body>
Edit Expense
<br><br>
<%--private String expenseID;--%>
<%--private String expenseName;--%>
<%--private String expenseAmount;--%>
<%--private String expenseDate;--%>
<%--private CategoryType categoryType;--%>

<form name="updateExpense" method="POST" action="/mvc_cust/updateExpense">
    Expense ID:
    <input type="text" name="expenseID" value="<c:out value="${expense.expenseID}" />" readonly /><br>

    Expense Name:
    <input type="text" name="expenseName" value="<c:out value="${expense.expenseName}" />" /><br>

    Expense Amount:
    <input type="text" name="expenseAmount" value="<c:out value="${expense.expenseAmount}" />" /><br>

    Expense Date:
    <input type="text" name="expenseDate" value="<c:out value="${expense.expenseDate}" />" /><br>


    Category Type:
    <select name="categoryType"> <c:forEach var="ctype" items="{categoryTypes}">
        <option value="<c:out value="${expenses.categoryTypes}" />" /><br></option>
    </c:forEach></select>
    <input type="submit">
</form>
</body></body>
</html>
</body>
</html>
