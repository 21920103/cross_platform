<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Лабораторна робота 2. Використання (впровадження) іменованої залежності - ClientCounter -->
        <p>Загалом зареєстровано <b>${clientCounter.getCnt()}</b> пацієнтів:</p>
        <%= request.getAttribute( "clientList") %>
    </body>
</html>
