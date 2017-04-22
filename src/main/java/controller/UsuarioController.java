/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;
import model.PerfilAcesso;
import model.Usuario;

/**
 *
 * @author vitor
 */
public class UsuarioController extends HttpServlet {

    private UsuarioDAO dao;
    private Usuario usuario;

    public UsuarioController() throws SQLException, IOException {
        this.dao = new UsuarioDAO();
    }

    public void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        String cargo = request.getParameter("optCargo");
        if (cargo.equalsIgnoreCase("gerente")) {
            usuario.setCargo(Cargo.GERENTE);
        } else if (cargo.equalsIgnoreCase("secretaria")) {
            usuario.setCargo(Cargo.SECRETARIA);
        } else {
            usuario.setCargo(Cargo.ESTOQUISTA);
        }
        usuario.setRg(request.getParameter("rg"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEndereco(request.getParameter("endereco"));
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
        } else {
            usuario.setPerfil(PerfilAcesso.COMUM);
        }
        dao.cadastrarNovoUsuario(usuario);
        response.sendRedirect("list");
    }

    public void listarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Usuario> listUsuario = dao.listar();
        request.setAttribute("listarUsuario", listUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/usuarioForm.jsp");
        dispatcher.forward(request, response);
    }

    public void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        dao.excluirUsuario(id);
        response.sendRedirect("list");

    }

    public void editUsuarioForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Usuario usuarioLocalizado = dao.buscarUsuario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/usuarioForm.jsp");
        request.setAttribute("usuario", dao.buscarUsuario(id));
        dispatcher.forward(request, response);

    }

    public void updateUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        usuario = new Usuario();
        usuario.setId(Integer.parseInt(request.getParameter("id")));
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        String cargo = request.getParameter("optCargo");
        if (cargo.equalsIgnoreCase("gerente")) {
            usuario.setCargo(Cargo.GERENTE);
        } else if (cargo.equalsIgnoreCase("secretaria")) {
            usuario.setCargo(Cargo.SECRETARIA);
        } else {
            usuario.setCargo(Cargo.ESTOQUISTA);
        }
        usuario.setRg(request.getParameter("rg"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEndereco(request.getParameter("endereco"));
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
        } else {
            usuario.setPerfil(PerfilAcesso.COMUM);
        }

        dao.atualizarUsuario(usuario);
        response.sendRedirect("list");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    inserirUsuario(request, response);
                    break;
                case "/delete":
                    deletarUsuario(request, response);
                    break;
                case "/edit":
                    editUsuarioForm(request, response);
                    break;
                case "/update":
                    updateUsuario(request, response);
                    break;
                default:
                    listarUsuario(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
