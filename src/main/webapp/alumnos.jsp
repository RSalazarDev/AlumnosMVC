<%-- 
    Document   : alumnos
    Created on : Feb 5, 2021, 2:21:40 PM
    Author     : salaz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Alumnos de Bosco</h1>
            <%
                String grupoActivo = (String) request.getAttribute("grupo");
                ArrayList<String> grupos = (ArrayList<String>) request.getAttribute("grupos");
                ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("alumnos");
            %>
            Grupo Seleccionado: <%=grupoActivo%> <br>
            <form action="servletAlumnos" method="get">
                Grupo: <select class="form-control" name="grupo">

                    <%
                        for (String grupo : grupos) {
                            String textoSelected = "";
                            if (grupo.equals(grupoActivo)) {
                                textoSelected = " selected";
                            }
                    %>
                    <option <%=textoSelected%> value="<%=grupo%>"><%=grupo%></option>
                    <% } %>
                </select>
                <br>
                <input type="submit" value="Enviar">
            </form>
            <form  action="servletAlumnos" method="post">
                <table style="margin: 10px;" class="table">
                    <% for (Alumno alu : alumnos) {%>
                    <tr>
                        <td>
                            <%=alu.getNombre()%>
                        </td>
                        <td>
                            <%=alu.getApellido()%>
                        </td>
                        <td>
                            <%=alu.getEmail()%>
                        </td>
                        <td>
                            <input type="checkbox" id="enviar" name="enviar" value="">
                        </td>
                    </tr>
                    <%}%>
                </table>

                <input type="submit" value="Enviar">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
