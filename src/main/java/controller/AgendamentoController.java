/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendamentoDAO;
import dao.VacinasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agendamento;


/**
 *
 * @author vitor
 */
public class AgendamentoController {

    private final AgendamentoDAO dao;
    private final VacinasDAO daoVac;
    private Agendamento agendamento;

    public AgendamentoController() throws SQLException, IOException {
        this.dao = new AgendamentoDAO();
        this.daoVac = new VacinasDAO();
    }

    public void inserirAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        agendamento = new Agendamento();
        agendamento.setDataDose(java.sql.Date.valueOf(request.getParameter("dataDose")));
        agendamento.setQuantidade(Integer.valueOf(request.getParameter("quantidadeVac")));
        agendamento.setPaciente(Integer.valueOf(request.getParameter("idPaciente")));
        agendamento.setVacinas(Integer.valueOf(request.getParameter("idVacinas")));

        dao.cadastrarNovoAgendamento(agendamento);
        response.sendRedirect("listAgendamento");
    }

    public void listarAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Agendamento> listAgendamento = dao.listar();
        request.setAttribute("listarAgendamentos", listAgendamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento/listarAgendamento.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento/agendamentoForm.jsp");
        dispatcher.forward(request, response);
    }

    public void editAgendamentoForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento/agendamentoForm.jsp");
        request.setAttribute("agendamento", dao.buscarAgendamento(id));
        dispatcher.forward(request, response);

    }

    public void deletarAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        dao.excluirAgendamento(id);
        response.sendRedirect("listAgendamento");

    }

    public void updateAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        agendamento = new Agendamento();
        daoVac.cresVacina(Integer.valueOf(request.getParameter("quantidadeVac")), Integer.valueOf(request.getParameter("idVacinas")));
        agendamento.setId(Integer.valueOf(request.getParameter("id")));
        agendamento.setDataDose(java.sql.Date.valueOf(request.getParameter("dataDose")));
        agendamento.setQuantidade(Integer.valueOf(request.getParameter("quantidadeVac")));
        agendamento.setPaciente(Integer.valueOf(request.getParameter("idPaciente")));
        agendamento.setVacinas(Integer.valueOf(request.getParameter("idVacinas")));

        dao.atualizarAgendamento(agendamento);
        //daoVac.descVacina(Integer.valueOf(request.getParameter("quantidadeVac")), Integer.valueOf(request.getParameter("idVacinas")));
        response.sendRedirect("listAgendamento");
    }
}
