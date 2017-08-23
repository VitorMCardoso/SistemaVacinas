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
public class PacientesController {

    private PacientesDAO dao;
    private Paciente paciente;

    public PacientesController() throws SQLException, IOException {
        this.dao = new PacientesDAO();
    }

    PacientesController(Config config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            paciente.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            paciente.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            paciente.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            paciente.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            paciente.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            paciente.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            paciente.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            paciente.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            paciente.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            paciente.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            paciente.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            paciente.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            paciente.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            paciente.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            paciente.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            paciente.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            paciente.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            paciente.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            paciente.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            paciente.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            paciente.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            paciente.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            paciente.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            paciente.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            paciente.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("sp")) {
            paciente.setEstado(Estado.SP);
        } else {
            paciente.setEstado(Estado.TO);
        }

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
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            paciente.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            paciente.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            paciente.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            paciente.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            paciente.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            paciente.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            paciente.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            paciente.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            paciente.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            paciente.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            paciente.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            paciente.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            paciente.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            paciente.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            paciente.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            paciente.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            paciente.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            paciente.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            paciente.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            paciente.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            paciente.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            paciente.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            paciente.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            paciente.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            paciente.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("sp")) {
            paciente.setEstado(Estado.SP);
        } else {
            paciente.setEstado(Estado.TO);
        }

        dao.atualizar(paciente);
        response.sendRedirect("listPaciente");
    }
}
