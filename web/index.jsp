<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<model.orm.Doctor> doctorList = model.Doctors.getList() ;
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <b>Вибрати лікаря</b>
        <input list="doctors" />
        <datalist id="doctors">
            <% for( model.orm.Doctor doctor : doctorList ) { %>
                <option value="<%= doctor.getId() %>"><%= doctor.getName() %>(<%= doctor.getSpeciality() %>)</option>
             <% } %>
        </datalist>
        
        <form action="add_doctor">
            ПІБ <input name='name' />
            <br/>
            Спеціальність <input name='spec' />
            <br/>
            <button>Додати</button>
                
        </form>
        
             <% if(request.getAttribute( "message" ) != null ) { %>
                 <script> alert('<%= request.getAttribute( "message" ) %>') </script>
             <% } %>
    </body>
</html>
