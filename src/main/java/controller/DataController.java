/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataValFabDAO;
import dao.LoteVacinasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataValFab;
import model.LoteVacinas;

/**
 *
 * @author vitor
 */
public class DataController implements IController {

    private final DataValFabDAO dao;
    private final LoteVacinasDAO loteVacinasDAO;
    private final DataValFab dataValFab;

    public DataController() throws SQLException, IOException {
        this.dao = new DataValFabDAO();
        this.loteVacinasDAO = new LoteVacinasDAO();
        this.dataValFab = new DataValFab();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        dataValFab.setDataValidade(java.sql.Date.valueOf(request.getParameter("dataValidade")));
        dataValFab.setDataFabricacao(java.sql.Date.valueOf(request.getParameter("dataFabricacao")));

        // OBJECT LOTE SET
        dataValFab.setLote(new LoteVacinas(Integer.valueOf(request.getParameter("lote"))));
        loteVacinasDAO.buscar(this.dataValFab.getLote().getId());
        dataValFab.setLote(loteVacinasDAO.loteVacinas);

        dao.cadastrar(dataValFab);
        response.sendRedirect("listar");

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<DataValFab> listDatas = dao.listar();
        request.setAttribute("listarDatas", listDatas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarData.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dataForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("dataForm.jsp");
        request.setAttribute("data", dao.buscar(id));
        dispatcher.forward(request, response);
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        dataValFab.setDataValidade(java.sql.Date.valueOf(request.getParameter("dataValidade")));
        dataValFab.setDataFabricacao(java.sql.Date.valueOf(request.getParameter("dataFabricacao")));

        // OBJECT LOTE SET
        dataValFab.setLote(new LoteVacinas(Integer.valueOf(request.getParameter("lote"))));
        loteVacinasDAO.buscar(this.dataValFab.getLote().getId());
        dataValFab.setLote(loteVacinasDAO.loteVacinas);

        dao.atualizar(dataValFab);
        response.sendRedirect("listar");
    }

}
