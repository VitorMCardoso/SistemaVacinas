/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LaboratorioDAO;
import dao.LoteVacinasDAO;
import dao.PedidoCompraDAO;
import dao.VacinasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Laboratorio;
import model.LoteVacinas;
import model.PedidoCompra;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public class PedidoController implements IController {

    private final PedidoCompraDAO dao;
    private final VacinasDAO vacinasDAO;
    private final LaboratorioDAO laboratorioDAO;
    private final PedidoCompra pedidoCompra;
    private final LoteVacinasDAO loteVacinasDAO;

    public PedidoController() throws SQLException, IOException {
        this.dao = new PedidoCompraDAO();
        this.vacinasDAO = new VacinasDAO();
        this.laboratorioDAO = new LaboratorioDAO();
        this.loteVacinasDAO = new LoteVacinasDAO();
        this.pedidoCompra = new PedidoCompra();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        pedidoCompra.setData(java.sql.Date.valueOf(request.getParameter("data")));
        pedidoCompra.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        this.laboratorioDAO.laboratorio.setId(Integer.valueOf(request.getParameter("idLaboratorio")));
        laboratorioDAO.buscar(this.laboratorioDAO.laboratorio.getId());
        pedidoCompra.setLaboratorio(this.laboratorioDAO.laboratorio);
        this.vacinasDAO.vacina.setId(Integer.valueOf(request.getParameter("idVacinas")));
        vacinasDAO.buscar(this.vacinasDAO.vacina.getId());
        pedidoCompra.setVacinas(vacinasDAO.vacina);

        dao.cadastrar(pedidoCompra);
        response.sendRedirect("listar");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<PedidoCompra> listarPedido = dao.listar();
        request.setAttribute("listarPedido", listarPedido);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarPedido.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pedidoCompraForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("pedidoCompraForm.jsp");
        request.setAttribute("pedido", dao.buscar(id));
        dispatcher.forward(request, response);
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.excluir(id);
        response.sendRedirect("listar");
    }

    public void confirmar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
        loteVacinasDAO.loteVacinas.setQuantidadeVac(Integer.parseInt(request.getParameter("quantidadeVac")));
        
        //OBJECT LABORATORIO SET
        this.loteVacinasDAO.loteVacinas.setLaboratorio(new Laboratorio(Integer.valueOf(request.getParameter("idLaboratorio"))));
        laboratorioDAO.buscar(this.loteVacinasDAO.loteVacinas.getLaboratorio().getId());
        loteVacinasDAO.loteVacinas.setLaboratorio(laboratorioDAO.laboratorio);
        
        //OBJECT VACINAS SET
        this.loteVacinasDAO.loteVacinas.setVacina(new Vacinas(Integer.valueOf(request.getParameter("idVacinas"))));
        vacinasDAO.buscar(this.loteVacinasDAO.loteVacinas.getVacina().getId());
        loteVacinasDAO.loteVacinas.setVacina(vacinasDAO.vacina);
        
        
        loteVacinasDAO.cadastrar(loteVacinasDAO.loteVacinas);
        
        response.sendRedirect("listar");
    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
        pedidoCompra.setId(Integer.valueOf(request.getParameter("id")));
        pedidoCompra.setData(java.sql.Date.valueOf(request.getParameter("data")));
        pedidoCompra.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        this.laboratorioDAO.laboratorio.setId(Integer.valueOf(request.getParameter("idLaboratorio")));
        laboratorioDAO.buscar(this.laboratorioDAO.laboratorio.getId());
        pedidoCompra.setLaboratorio(this.laboratorioDAO.laboratorio);
        this.vacinasDAO.vacina.setId(Integer.valueOf(request.getParameter("idVacinas")));
        vacinasDAO.buscar(this.vacinasDAO.vacina.getId());
        pedidoCompra.setVacinas(vacinasDAO.vacina);

        dao.atualizar(pedidoCompra);

        response.sendRedirect("listar");
    }

}
