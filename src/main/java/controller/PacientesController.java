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
import javax.servlet.jsp.jstl.core.Config;
import model.Estado;
import model.Paciente;

/**
 *
 * @author vitor
 */
public class PacientesController implements IController {

    private PacientesDAO dao;
    private Paciente paciente;

    public PacientesController() throws SQLException, IOException {
        this.dao = new PacientesDAO();
    }

    PacientesController(Config config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response)
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
        String estado = request.getParameter("optEstado");
        paciente.setEstado(Estado.valueOf(estado));
        dao.cadastrar(paciente);
        response.sendRedirect("listar");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Paciente> listPaciente = dao.listar();
        request.setAttribute("listarPaciente", listPaciente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarPaciente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pacienteForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.excluir(id);
        response.sendRedirect("listar");

    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("pacienteForm.jsp");
        request.setAttribute("paciente", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
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
        String estado = request.getParameter("optEstado");
        paciente.setEstado(Estado.valueOf(estado));
        dao.atualizar(paciente);
        response.sendRedirect("listar");
    }
}
