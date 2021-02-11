<%-- 
    Document   : mensajes
    Created on : Feb 11, 2021, 8:14:57 PM
    Author     : salaz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mensaje a Alumnos</h1>
        <%
            String grupo = (String) request.getAttribute("grupo");
            ArrayList<Alumno> alumnos = (ArrayList) request.getAttribute("alumnos");
        %>
        <div>
            <form action="servletAlumnos" method="POST">
                Grupo seleccionado: <%=grupo%>
                <table class="table table-dark">
                    <% for (Alumno a : alumnos) {%>
                    <tr>
                        <td><%=a.getNombre()%></td>
                        <td><%=a.getApellido()%></td>
                        <td><%=a.getEmail()%></td>
                    </tr>
                    <%}%>
                </table>
                Mensaje: <textarea name="mensaje"></textarea>
                <input type="submit" value="Enviar">
            </form>
        </div>
    </body>
</html>
