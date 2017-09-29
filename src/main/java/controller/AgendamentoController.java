/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendamentoDAO;
import dao.VacinasDAO;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agendamento;
import model.Paciente;
import model.Vacinas;


/**
 *
 * @author vitor
 */
public class AgendamentoController implements IController{

    private AgendamentoDAO dao;
    private Agendamento agendamento;
    private Paciente paciente;
    private Vacinas vacinas;

    public AgendamentoController() throws SQLException, IOException {
        this.dao = new AgendamentoDAO();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        agendamento = new Agendamento();
        paciente = new Paciente();
        vacinas = new Vacinas();
        agendamento.setDataDose(java.sql.Date.valueOf(request.getParameter("dataDose")));
        agendamento.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        paciente.setId(Integer.valueOf(request.getParameter("idPaciente")));
        agendamento.setPaciente(paciente);
        vacinas.setId(Integer.valueOf(request.getParameter("idVacinas")));
        agendamento.setVacinas(vacinas);

        dao.cadastrar(agendamento);
        response.sendRedirect("listar");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Agendamento> listAgendamento = dao.listar();
        request.setAttribute("listarAgendamentos", listAgendamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarAgendamento.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamentoForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamentoForm.jsp");
        request.setAttribute("agendamento", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantidade = Integer.valueOf(request.getParameter("quantidadeVac"));
        int idVacinas = Integer.parseInt(request.getParameter("idVacinas"));
        dao.excluirAgendamento(id,quantidade,idVacinas);
        response.sendRedirect("listar");

    }
  
    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        agendamento = new Agendamento();
        paciente = new Paciente();
        vacinas = new Vacinas();
        agendamento.setDataDose(java.sql.Date.valueOf(request.getParameter("dataDose")));
        agendamento.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        paciente.setId(Integer.valueOf(request.getParameter("idPaciente")));
        agendamento.setPaciente(paciente);
        vacinas.setId(Integer.valueOf(request.getParameter("idVacinas")));
        agendamento.setVacinas(vacinas);

        dao.atualizar(agendamento);
        
        response.sendRedirect("listar");
    }
}
