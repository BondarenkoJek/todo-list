<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TodoList</title>
    <link rel="stylesheet" href="/styles/style.css"/>
</head>
<body>
<div class="form-style-8">
    <h2>Todo List for ${user.userName}</h2>

    <form action="/add/${user.id}" method="post">
        <label for="Task">new Task</label>
        <input id="Task" name="taskDescription" type="text" />
        <input value="add"  type="submit"/>
    </form>

    <table class="table_blur">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>State</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="task" items="${list}" >
        <tr>
            <td>${task.date}</td>
            <td>${task.taskDescription}</td>
            <td>${task.state}</td>
            <td>
                <form action="/del/${user.id}" method="get">
                    <button name="id" type="submit" value="${task.id}">del</button>
                </form>
            </td>
        </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>
