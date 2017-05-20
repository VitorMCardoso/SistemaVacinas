/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacientesDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

/**
 *
 * @author vitor
 */
public class PacientesController {

    private PacientesDAO dao;
    private Paciente paciente;

    public PacientesController() throws SQLException, IOException {
        this.dao = new PacientesDAO();
    }

    public void inserirPaciente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        paciente = new Paciente();
        paciente.setNome(request.getParameter("nome"));
        paciente.setSobrenome(request.getParameter("sobrenome"));
        paciente.setLogin(request.getParameter("login"));
        paciente.setEmail(request.getParameter("email"));
        paciente.setSenha(request.getParameter("senha"));
        paciente.setRg(request.getParameter("rg"));
        paciente.setCpf(request.getParameter("cpf"));
        paciente.setEndereco(request.getParameter("endereco"));
        paciente.setBairro(request.getParameter("bairro"));
        paciente.setCidade(request.getParameter("cidade"));
        paciente.setEstado(request.getParameter("estado"));

        dao.cadastrar(paciente);
        response.sendRedirect("listPaciente");
    }

    public void listarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Paciente> listPaciente = dao.listar();
        request.setAttribute("listarPaciente", listPaciente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paciente/listarPaciente.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paciente/pacienteForm.jsp");
        dispatcher.forward(request, response);
    }

    public void deletarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.excluir(id);
        response.sendRedirect("listPaciente");

    }

    public void editPacienteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("paciente/pacienteForm.jsp");
        request.setAttribute("paciente", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    public void updatePaciente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        paciente = new Paciente();
        paciente.setId(Integer.parseInt(request.getParameter("id")));
        paciente.setNome(request.getParameter("nome"));
        paciente.setSobrenome(request.getParameter("sobrenome"));
        paciente.setLogin(request.getParameter("login"));
        paciente.setEmail(request.getParameter("email"));
        paciente.setSenha(request.getParameter("senha"));
        paciente.setRg(request.getParameter("rg"));
        paciente.setCpf(request.getParameter("cpf"));
        paciente.setEndereco(request.getParameter("endereco"));
        paciente.setBairro(request.getParameter("bairro"));
        paciente.setCidade(request.getParameter("cidade"));
        paciente.setEstado(request.getParameter("estado"));
        
        dao.atualizar(paciente);
        response.sendRedirect("listPaciente");
    }
}
