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
import model.Estado;
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
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            laboratorio.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            laboratorio.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            laboratorio.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            laboratorio.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            laboratorio.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            laboratorio.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            laboratorio.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            laboratorio.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            laboratorio.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            laboratorio.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            laboratorio.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            laboratorio.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            laboratorio.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            laboratorio.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            laboratorio.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            laboratorio.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            laboratorio.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            laboratorio.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            laboratorio.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            laboratorio.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            laboratorio.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            laboratorio.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            laboratorio.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            laboratorio.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            laboratorio.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("sp")) {
            laboratorio.setEstado(Estado.SP);
        } else {
            laboratorio.setEstado(Estado.TO);
        }

        dao.cadastrar(laboratorio);
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
        dao.excluir(id);
        response.sendRedirect("listLaboratorio");

    }

    public void editLaboratorioForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("laboratorio/laboratorioForm.jsp");
        request.setAttribute("laboratorio", dao.buscar(id));
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
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            laboratorio.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            laboratorio.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            laboratorio.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            laboratorio.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            laboratorio.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            laboratorio.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            laboratorio.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            laboratorio.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            laboratorio.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            laboratorio.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            laboratorio.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            laboratorio.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            laboratorio.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            laboratorio.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            laboratorio.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            laboratorio.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            laboratorio.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            laboratorio.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            laboratorio.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            laboratorio.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            laboratorio.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            laboratorio.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            laboratorio.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            laboratorio.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            laboratorio.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("sp")) {
            laboratorio.setEstado(Estado.SP);
        } else {
            laboratorio.setEstado(Estado.TO);
        }

        dao.atualizar(laboratorio);
        response.sendRedirect("listLaboratorio");
    }
}
