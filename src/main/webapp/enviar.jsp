<%-- 
    Document   : enviar
    Created on : 11 feb. 2021, 20:53:47
    Author     : manue
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <% 
            ArrayList<Alumno> grupo = ( ArrayList<Alumno> ) request.getAttribute("mensajes");
            
            %>
        <h1>Enviar mensaje</h1>
         <% 
                 for ( Alumno alumn: grupo ) { 

                 
                 %>
                 <%=alumn.getId()%>.&nbspNombre:&nbsp;<%=alumn.getNombre()%> Apellidos:&nbsp;<%=alumn.getApellidos()%> Correo:&nbsp;<%=alumn.getCorreo()%>&nbsp;&nbsp; <br>
             <%} %><br>
             <input type="textarea"  id="exampleFormControlTextarea1" rows="3" ></input><br>
             <input type="submit" value="enviar">
    </body>
</html>
