/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Utilidades;

/**
 *
 * @author salaz
 */
public class servletAlumnos extends HttpServlet {

    
    private ArrayList<String> grupos;
    private String rutaFicheros;
    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        
        grupos = new ArrayList<String>();
        grupos.add("2daw_a");
        grupos.add("2daw_b");
        rutaFicheros = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
        
    }

    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletAlumnos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletAlumnos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grupoSeleccionado = "2daw_a";
        if (request.getParameter("grupo")!=null) {
            grupoSeleccionado = request.getParameter("grupo");
        }
       ArrayList<Alumno> alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupoSeleccionado.replace(" ", "")).concat(".txt"));
       request.setAttribute("grupos", grupos);
       request.setAttribute("grupo", grupoSeleccionado);
       request.setAttribute("alumnos", alumnos);
       request.getRequestDispatcher("alumnos.jsp").forward(request,response);
       
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
