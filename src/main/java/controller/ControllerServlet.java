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
import javax.servlet.RequestDispatcher;
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
    private final LaboratorioController controllerLaboratorio;
    private final VacinasController controllerVacina;

    public ControllerServlet() throws SQLException, IOException {
        this.controllerUsuario = new UsuarioController();
        this.controllerPaciente = new PacientesController();
        this.controllerLaboratorio = new LaboratorioController();
        this.controllerVacina = new VacinasController();
    }

    public void showPrincipalForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/principal.jsp");
        dispatcher.forward(request, response);
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
                // Usuario Controller
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
                case "/list":
                    controllerUsuario.listarUsuario(request, response);
                    break;
                // Paciente Controller
                case "/newPaciente":
                    controllerPaciente.showNewForm(request, response);
                    break;
                case "/insertPaciente":
                    controllerPaciente.inserirPaciente(request, response);
                    break;
                case "/deletePaciente":
                    controllerPaciente.deletarPaciente(request, response);
                    break;
                case "/editPaciente":
                    controllerPaciente.editPacienteForm(request, response);
                    break;
                case "/listPaciente":
                    controllerPaciente.listarPaciente(request, response);
                    break;
                case "/updatePaciente":
                    controllerPaciente.updatePaciente(request, response);
                    break;
                // Laboratorio Controller
                case "/newLaboratorio":
                    controllerLaboratorio.showNewForm(request, response);
                    break;
                case "/insertLaboratorio":
                    controllerLaboratorio.inserirLaboratorio(request, response);
                    break;
                case "/deleteLaboratorio":
                    controllerLaboratorio.deletarLaboratorio(request, response);
                    break;
                case "/editLaboratorio":
                    controllerLaboratorio.editLaboratorioForm(request, response);
                    break;
                case "/listLaboratorio":
                    controllerLaboratorio.listarLaboratorio(request, response);
                    break;
                case "/updateLaboratorio":
                    controllerLaboratorio.updateLaboratorio(request, response);
                    break;
                // Vacinas Controller
                case "/newVacina":
                    controllerVacina.showNewForm(request, response);
                    break;
                case "/insertVacina":
                    controllerVacina.inserirVacina(request, response);
                    break;
                case "/deleteVacina":
                    controllerVacina.descVacina(request, response);
                    break;
                case "/editVacina":
                    controllerVacina.editVacinaForm(request, response);
                    break;
                case "/listVacina":
                    controllerVacina.listarVacina(request, response);
                    break;
                case "/updateVacina":
                    controllerVacina.updateVacina(request, response);
                    break;
                default:
                    showPrincipalForm(request, response);
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
