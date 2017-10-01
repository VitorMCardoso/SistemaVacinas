/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LaboratorioDAO;
import dao.LoteVacinasDAO;
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
import model.Vacinas;

/**
 *
 * @author vitor
 */
public class LoteController implements IController {

    private final LoteVacinasDAO dao;
    private final VacinasDAO vacinasDAO;
    private final LaboratorioDAO laboratorioDAO;
    private final LoteVacinas loteVacinas;

    public LoteController() throws SQLException, IOException {
        this.loteVacinas = new LoteVacinas();
        this.dao = new LoteVacinasDAO();
        this.laboratorioDAO = new LaboratorioDAO();
        this.vacinasDAO = new VacinasDAO();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        loteVacinas.setQuantidadeVac(Integer.parseInt(request.getParameter("quantidadeVac")));

        //OBJECT LABORATORIO SET
        loteVacinas.setLaboratorio(new Laboratorio(Integer.valueOf(request.getParameter("idLaboratorio"))));
        laboratorioDAO.buscar(this.loteVacinas.getLaboratorio().getId());
        loteVacinas.setLaboratorio(laboratorioDAO.laboratorio);

        //OBJECT VACINAS SET
        loteVacinas.setVacina(new Vacinas(Integer.valueOf(request.getParameter("idVacinas"))));
        vacinasDAO.buscar(this.loteVacinas.getVacina().getId());
        loteVacinas.setVacina(vacinasDAO.vacina);

        dao.cadastrar(loteVacinas);
        response.sendRedirect("listar");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<LoteVacinas> listLotes = dao.listar();
        request.setAttribute("listarLote", listLotes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarLote.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loteForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("loteForm.jsp");
        request.setAttribute("lote", dao.buscar(id));
        dispatcher.forward(request, response);
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        loteVacinas.setQuantidadeVac(Integer.parseInt(request.getParameter("quantidadeVac")));

        //OBJECT LABORATORIO SET
        loteVacinas.setLaboratorio(new Laboratorio(Integer.valueOf(request.getParameter("idLaboratorio"))));
        laboratorioDAO.buscar(this.loteVacinas.getLaboratorio().getId());
        loteVacinas.setLaboratorio(laboratorioDAO.laboratorio);

        //OBJECT VACINAS SET
        loteVacinas.setVacina(new Vacinas(Integer.valueOf(request.getParameter("idVacinas"))));
        vacinasDAO.buscar(this.loteVacinas.getVacina().getId());
        loteVacinas.setVacina(vacinasDAO.vacina);

        dao.atualizar(loteVacinas);
        response.sendRedirect("listar");
    }

}
