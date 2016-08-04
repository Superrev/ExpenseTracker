<%--
  Created by IntelliJ IDEA.
  User: Superduo
  Date: 8/4/16
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Expense</title>
</head>
<body>
    <select>
         <option>
            <form name="addNewExpense" method="POST" action="/mvc_cust/saveNewExpense">
    Expense Name: <input type="text" name="expensename" /><br>
    Expense Amount: <input type="text" name="expenseamount" /><br>
    Expense Date: <input type="text" name="expensedate" /><br>
    CategoryType: <input type="text" name="categorytype" /><br>
    <input type="submit">
        </form>
         </option>
    </select>

</body>
</html>
