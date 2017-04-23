/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vitor
 */
public class ControllerServlet extends HttpServlet {

    private final UsuarioController controllerUsuario;
    private final PacientesController controllerPaciente;

    public ControllerServlet() throws SQLException, IOException {
        this.controllerUsuario = new UsuarioController();
        this.controllerPaciente = new PacientesController();
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

        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    controllerUsuario.showNewForm(request, response);
                    break;
                case "/insert":
                    controllerUsuario.inserirUsuario(request, response);
                    break;
                case "/delete":
                    controllerUsuario.deletarUsuario(request, response);
                    break;
                case "/edit":
                    controllerUsuario.editUsuarioForm(request, response);
                    break;
                case "/update":
                    controllerUsuario.updateUsuario(request, response);
                    break;
                case "/listPaciente":
                    controllerPaciente.listarPaciente(request, response);
                    break;
                default:
                    controllerUsuario.listarUsuario(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        doGet(request, response);
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
