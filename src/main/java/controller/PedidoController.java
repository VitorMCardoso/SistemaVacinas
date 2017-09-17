/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PedidoCompraDAO;
import dao.VacinasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PedidoCompra;

/**
 *
 * @author vitor
 */
public class PedidoController implements IController {

    private final PedidoCompraDAO dao;
    private final VacinasDAO daoVacinas;
    private PedidoCompra pedidoCompra;

    public PedidoController() throws SQLException, IOException {
        this.dao = new PedidoCompraDAO();
        this.daoVacinas = new VacinasDAO();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        pedidoCompra = new PedidoCompra();
        pedidoCompra.setData(java.sql.Date.valueOf(request.getParameter("data")));
        pedidoCompra.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        pedidoCompra.setIdLaboratorio(Integer.valueOf(request.getParameter("idLaboratorio")));
        pedidoCompra.setIdVacinas(Integer.valueOf(request.getParameter("idVacinas")));

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
        int id = Integer.parseInt(request.getParameter("id"));
        int quantidade = Integer.parseInt(request.getParameter("quantidadeVac"));
        daoVacinas.cresVacina(quantidade, id);
        response.sendRedirect("listar");
    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        pedidoCompra = new PedidoCompra();
        pedidoCompra.setId(Integer.valueOf(request.getParameter("id")));
        pedidoCompra.setData(java.sql.Date.valueOf(request.getParameter("data")));
        pedidoCompra.setQuantidadeVac(Integer.valueOf(request.getParameter("quantidadeVac")));
        pedidoCompra.setIdLaboratorio(Integer.valueOf(request.getParameter("idLaboratorio")));
        pedidoCompra.setIdVacinas(Integer.valueOf(request.getParameter("idVacinas")));

        dao.atualizar(pedidoCompra);

        response.sendRedirect("listar");
    }

}
