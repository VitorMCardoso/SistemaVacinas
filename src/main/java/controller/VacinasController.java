/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VacinasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;
import model.PerfilAcesso;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public class VacinasController {

    private final VacinasDAO dao;
    private Vacinas vacina;

    public VacinasController() throws SQLException, IOException {
        this.dao = new VacinasDAO();
    }

    public void inserirVacina(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        vacina = new Vacinas();
        vacina.setDataValidade(java.sql.Date.valueOf(request.getParameter("dataValidade")));
        vacina.setDataFabricacao(java.sql.Date.valueOf(request.getParameter("dataFabricacao")));
        vacina.setNome(request.getParameter("nome"));
        vacina.setTipo(request.getParameter("tipo"));
        vacina.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        vacina.setLote(request.getParameter("lote"));
        vacina.setIdLaboratorio(Integer.parseInt(request.getParameter("idLaboratorio")));

        dao.cadastrar(vacina);
        response.sendRedirect("listVacina");
    }

    public void listarVacina(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Vacinas> listVacina = dao.listar();
        request.setAttribute("listarVacinas", listVacina);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacinas/listarVacinas.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacinas/vacinasForm.jsp");
        dispatcher.forward(request, response);
    }

    public void descVacina(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        vacina = new Vacinas();
        vacina.setId(Integer.parseInt(request.getParameter("id")));
        dao.descVacina(5, vacina.getId());
        response.sendRedirect("listVacina");

    }

    public void editVacinaForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacinas/vacinasForm.jsp");
        request.setAttribute("vacina", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    public void updateVacina(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        vacina = new Vacinas();
        vacina.setId(Integer.parseInt(request.getParameter("id")));
        vacina.setDataValidade(java.sql.Date.valueOf(request.getParameter("dataValidade")));
        vacina.setDataFabricacao(java.sql.Date.valueOf(request.getParameter("dataFabricacao")));
        vacina.setNome(request.getParameter("nome"));
        vacina.setTipo(request.getParameter("tipo"));
        vacina.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        vacina.setLote(request.getParameter("lote"));
        vacina.setIdLaboratorio(Integer.parseInt(request.getParameter("idLaboratorio")));

        dao.atualizar(vacina);
        response.sendRedirect("listVacina");
    }
}
