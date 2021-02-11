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
    private ArrayList<Alumno> alumnos;
    private String rutaFicheros;
    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        
        grupos = new ArrayList<String>();
        grupos.add("2daw_a");
        grupos.add("2daw_b");
        rutaFicheros = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
        
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
       alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupoSeleccionado.replace(" ", "")).concat(".txt"));
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
        String grupoSeleccionado = "2daw_a";
        if (request.getParameter("grupo")!=null) {
            
            grupoSeleccionado = request.getParameter("grupo");
        }
        
        int ultimoId = alumnos.get(alumnos.size()-1).getId();
        ArrayList<Alumno> seleccionados = new ArrayList<Alumno>();
        
        for (int i = 0; i <= ultimoId; i++) {
            if(request.getParameter(String.valueOf(i)) != null) {
                for (Alumno alu : alumnos) {
                    if (alu.getId() == i) {
                        Alumno a = new Alumno(alu.getId(), alu.getNombre(), alu.getApellido(), alu.getEmail());
                        seleccionados.add(a);
                    }
                }
            }
        }
        
        request.setAttribute("grupo", grupoSeleccionado);
        request.setAttribute("alumnos", seleccionados);
        request.getRequestDispatcher("mensajes.jsp").forward(request,response);
        
        
        
    }

    

}
