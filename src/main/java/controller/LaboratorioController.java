/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LaboratorioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Laboratorio;

/**
 *
 * @author vitor
 */
public class LaboratorioController {
    
    private LaboratorioDAO dao;
    private Laboratorio laboratorio;

    public LaboratorioController() throws SQLException, IOException {
        this.dao = new LaboratorioDAO();
    }
    
    public void inserirLaboratorio(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        laboratorio = new Laboratorio();
        laboratorio.setRazaoSocial(request.getParameter("razaoSocial"));
        laboratorio.setCnpj(request.getParameter("cnpj"));
        laboratorio.setRegistroEstadual(request.getParameter("registroEstadual"));
        laboratorio.setNomeFantasia(request.getParameter("nomeFantasia"));
        laboratorio.setTelefone(request.getParameter("telefone"));
        laboratorio.setSite(request.getParameter("site"));
        laboratorio.setCep(request.getParameter("cep"));
        laboratorio.setLogradouro(request.getParameter("logradouro"));
        laboratorio.setNumero(request.getParameter("numero"));
        laboratorio.setBairro(request.getParameter("bairro"));
        laboratorio.setCidade(request.getParameter("cidade"));
        laboratorio.setEstado(request.getParameter("estado"));

        dao.cadastrarNovoLaboratorio(laboratorio);
        response.sendRedirect("listLaboratorio");
    }
    
    public void listarLaboratorio(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Laboratorio> listLaboratorio = dao.listar();
        request.setAttribute("listarLaboratorio", listLaboratorio);
        RequestDispatcher dispatcher = request.getRequestDispatcher("laboratorio/listarLaboratorio.jsp");
        dispatcher.forward(request, response);
    }
    
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("laboratorio/laboratorioForm.jsp");
        dispatcher.forward(request, response);
    }
    
    public void deletarLaboratorio(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.excluirLaboratorio(id);
        response.sendRedirect("listLaboratorio");

    }

    public void editLaboratorioForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("laboratorio/laboratorioForm.jsp");
        request.setAttribute("laboratorio", dao.buscarLaboratorio(id));
        dispatcher.forward(request, response);

    }

    public void updateLaboratorio(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        laboratorio = new Laboratorio();
        laboratorio.setId(Integer.parseInt(request.getParameter("id")));
        laboratorio.setRazaoSocial(request.getParameter("razaoSocial"));
        laboratorio.setCnpj(request.getParameter("cnpj"));
        laboratorio.setRegistroEstadual(request.getParameter("registroEstadual"));
        laboratorio.setNomeFantasia(request.getParameter("nomeFantasia"));
        laboratorio.setTelefone(request.getParameter("telefone"));
        laboratorio.setSite(request.getParameter("site"));
        laboratorio.setCep(request.getParameter("cep"));
        laboratorio.setLogradouro(request.getParameter("logradouro"));
        laboratorio.setNumero(request.getParameter("numero"));
        laboratorio.setBairro(request.getParameter("bairro"));
        laboratorio.setCidade(request.getParameter("cidade"));
        laboratorio.setEstado(request.getParameter("estado"));
        
        dao.atualizarLaboratorio(laboratorio);
        response.sendRedirect("listLaboratorio");
    }
}
