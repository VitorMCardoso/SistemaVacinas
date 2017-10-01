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
public class VacinasController implements IController{

    private final VacinasDAO dao;
    private Vacinas vacina;

    public VacinasController() throws SQLException, IOException {
        this.dao = new VacinasDAO();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        vacina = new Vacinas();
        vacina.setNome(request.getParameter("nome"));
        vacina.setTipo(request.getParameter("tipo"));
        dao.cadastrar(vacina);
        response.sendRedirect("listar");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Vacinas> listVacina = dao.listar();
        request.setAttribute("listarVacinas", listVacina);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarVacinas.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacinasForm.jsp");
        dispatcher.forward(request, response);
    }

    public void descVacina(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        vacina = new Vacinas();
        vacina.setId(Integer.parseInt(request.getParameter("id")));
        //dao.descVacina(5, vacina.getId());
        response.sendRedirect("listar");

    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacinasForm.jsp");
        request.setAttribute("vacina", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        vacina = new Vacinas();
        vacina.setId(Integer.parseInt(request.getParameter("id")));
        vacina.setNome(request.getParameter("nome"));
        vacina.setTipo(request.getParameter("tipo"));
        dao.atualizar(vacina);
        response.sendRedirect("listar");
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
