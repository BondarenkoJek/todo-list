
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="/styles/sign_in.css"/>
</head>
<body>

    <form class="form" action="/sign_in" method="post">
        <h2>Sign in</h2>

        <label for="userName">Your name</label>
        <input id="userName" name="userName" type="text"/>

        <label for="password">Password</label>
        <input id="password" name="password" type="password"/>


        <input value="Sign in" type="submit"/>

        <div class="div_a"><a href="/registration">Create your account</a></div>
    </form>

</body>
</html>
