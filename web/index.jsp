<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding( "UTF-8" ) ;
    ArrayList<model.orm.Doctor> doctorList = model.Doctors.getList() ;
    ArrayList<String> spec =  model.Doctors.getSpecList() ;
    String selectedSpec = null ;
    if(request.getParameter( "spec" ) != null ) {
        selectedSpec = request.getParameter( "spec" ) ;
    }
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Лабораторна робота 1</h2>
        <h3>Розробка та використання сервлетів при створенні WEB-додатків</h3>
        <p>У проекті завдання релізоване для сутностей "Лікар" (Doctor) - Таблиця БД, ORM Doctor, модель Doctors, контроллер DoctorController</p>
        <p>Сервлети та редирект ілюстроване на класі (сервлеті) servlets.TestConnection, де перевіряється можливість підключення до БД та перехід у статичний режим за неможливості </p>
        <b>Перелік лікарів</b>
        <input list="doctors" />
        <datalist id="doctors">
            <% for( model.orm.Doctor doctor : doctorList ) { %>
                <option value="<%= doctor.getId() %>"><%= doctor.getName() %>(<%= doctor.getSpeciality() %>)</option>
             <% } %>
        </datalist>
        
        <form action="add_doctor" style="border:2px solid blue;display:block">
            <h4>Додати лікаря</h4>
            ПІБ <input name='name' />
            <br/>
            Спеціальність <input name='spec' />
            <br/>
            <button>Додати</button>
                
        </form>
        <b>Вибрати лікаря за спеціальністю</b>
        <form>
            <% for( String s : spec ) { %>
            <label><input type="radio" name="spec" value="<%= s %>" <%= (s.equals(selectedSpec))?"checked":"" %> /><%= s %></label><br />
            <% } %>
            <button>Вибрати</button>
        </form>
        <% if(selectedSpec != null ) { %>
        <div style="border:2px solid green">
             <% for( model.orm.Doctor d : model.Doctors.getListBySpec( selectedSpec ) ) { %>
             <p><%= d.getName() %></p>
             <% } %>
        </div>
        <% } %>
           
           <!-- Message -->
             <% if(request.getAttribute( "message" ) != null ) { %>
                 <script> alert('<%= request.getAttribute( "message" ) %>') </script>
             <% } %>
             
             
        <h2>Лабораторна робота 2</h2>
        <h3>Використання впровадження залежностей при створенні WEB-додатків</h3>
        <p>У проекті завдання релізоване для сутностей "Пацієнт" (Client) - Таблиця БД "Clients", ORM Client, модель Clients реалізована у пакеті di(dependency injection) у вигляді залежного класу, контроллер ClientController</p>
        <a href="clients">На сторінку з пацієнтами</a>
    </body>
</html>
