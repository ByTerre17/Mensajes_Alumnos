<%-- 
    Document   : inicio.jsp
    Created on : 5 feb. 2021, 19:25:55
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
        <div class="container">
        <h1>Mensajes a Alumnos</h1>
        
        <% 
            String grupoActivo = ( String ) request.getAttribute("grupo");
            ArrayList<String> grupos = ( ArrayList<String> ) request.getAttribute("grupos");
            ArrayList<Alumno> alumnos = ( ArrayList<Alumno> ) request.getAttribute("alumnos");
            %>
        <h2>Grupo Seleccionado: <%=grupoActivo%></h2> <br>
        
            <form action="alumnosServlet" method="get">
                Grupo:<select class="form-control"  name="grupo">
             
             <% 
                 
                 for ( String grup: grupos ) { 
                 String textoSelected="";
                 if ( grup.equals(grupoActivo)) {
                     textoSelected = " selected";
                 }
                 %>
                     <option <%=textoSelected%> value="<%=grup%>"><%=grup%></option>
                    
             <% } %>
         </select>
         <input type="submit" value="Elegir grupo"></input>
         </form>
         
         <br>
         <form action="mensajesServlet" method="get">
             Alumnos:<br>
             
             <% 
                 int i =0;
                 for ( Alumno alumn: alumnos ) { 
                 alumn.setId(i);
                 
                 %>
                 Nombre:&nbsp;<%=alumn.getNombre()%> Apellidos:&nbsp;<%=alumn.getApellidos()%> Correo:&nbsp;<%=alumn.getCorreo()%>&nbsp;&nbsp;<input type="checkbox"  value="<%=alumn.getId()%>"></input> <br>
             <% i++;} %>
         </select>
         <input type="submit" value="Elegir alumnos para mandar mensaje"></input>
            </form>
        </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
