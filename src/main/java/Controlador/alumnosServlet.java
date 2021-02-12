/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class alumnosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ArrayList<String> grupos = null;
    private String rutaFicheros;
    private ArrayList<Alumno> alumnos = null;
    
    public void init(ServletConfig config) throws ServletException {
    
       grupos = new ArrayList<String>();
       grupos.add("2daw_a");
       grupos.add("2daw_b");
       rutaFicheros = config.getServletContext().getRealPath("").concat(File.separator).concat("grupos");
       
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
            String grupoSeleccionado="2daw_a";
            if (request.getParameter("grupo")!=null) {
                grupoSeleccionado = request.getParameter("grupo");
            }
            ArrayList<Alumno> alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupoSeleccionado.replace(" ", "")).concat(".txt"));
            request.setAttribute("grupos", grupos);
            request.setAttribute("grupo", grupoSeleccionado);
            request.setAttribute("alumnos", alumnos);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
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
         ArrayList mensajes = new ArrayList<Alumno>();
         String grupoSeleccionado="2daw_a";
            if (request.getParameter("grupo")!=null) {
                grupoSeleccionado = request.getParameter("grupo");
            }
         ArrayList<Alumno> alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupoSeleccionado.replace(" ", "")).concat(".txt"));
          int numeroAlumnos = alumnos.size();
          int ultimoID = alumnos.get(numeroAlumnos-1).getId();
          String[] ids= request.getParameterValues("alumnos");
          String numerodeids = ids.length+"";
              for(int x=0;x<ids.length;x++)
               for ( Alumno alum:alumnos ) {
                   String id =alum.getId()+"";
                   if ( id.equalsIgnoreCase(ids[x])) {
                       Alumno alumnoMandarMensaje = new Alumno(alum.getNombre(),alum.getApellidos(),alum.getCorreo(),alum.getId());
                       mensajes.add(alumnoMandarMensaje);
                   }
               
               }
        request.setAttribute("mensajes", mensajes);
        request.setAttribute("ids", numerodeids);
        request.getRequestDispatcher("enviar.jsp").forward(request, response);
        
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
