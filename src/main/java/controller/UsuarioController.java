/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacientesDAO;
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
import model.Paciente;
import model.PerfilAcesso;
import model.Usuario;

/**
 *
 * @author vitor
 */
public class UsuarioController {

    private final UsuarioDAO dao;
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

}
