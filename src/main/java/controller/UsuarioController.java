/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;
import model.Estado;
import model.PerfilAcesso;
import model.Usuario;

/**
 *
 * @author vitor
 */
public class UsuarioController extends RelatorioController implements IController{

    private final UsuarioDAO dao;
    private Usuario usuario;

    public UsuarioController() throws SQLException, IOException {
        this.dao = new UsuarioDAO();
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        String cargo = request.getParameter("optCargo");
        usuario.setCargo(Cargo.valueOf(cargo));
        usuario.setRg(request.getParameter("rg"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEndereco(request.getParameter("endereco"));
        usuario.setBairro(request.getParameter("bairro"));
        usuario.setCidade(request.getParameter("cidade"));
        String estado = request.getParameter("optEstado");
        usuario.setEstado(Estado.valueOf(estado));
        String perfil = request.getParameter("optPerfil");
        usuario.setPerfil(PerfilAcesso.valueOf(perfil));
        dao.cadastrar(usuario);
        response.sendRedirect("listarUsuario");
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Usuario> listUsuario = dao.listar();
        request.setAttribute("listarUsuario", listUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void deletar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        dao.excluir(id);
        response.sendRedirect("listarUsuario");

    }

    @Override
    public void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Usuario usuarioLocalizado = dao.buscarUsuario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioForm.jsp");
        request.setAttribute("usuario", dao.buscar(id));
        dispatcher.forward(request, response);

    }

    @Override
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        usuario = new Usuario();
        usuario.setId(Integer.parseInt(request.getParameter("id")));
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        String cargo = request.getParameter("optCargo");
        usuario.setCargo(Cargo.valueOf(cargo));
        usuario.setRg(request.getParameter("rg"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEndereco(request.getParameter("endereco"));
        usuario.setBairro(request.getParameter("bairro"));
        usuario.setCidade(request.getParameter("cidade"));
        String estado = request.getParameter("optEstado");
        usuario.setEstado(Estado.valueOf(estado));
        String perfil = request.getParameter("optPerfil");
        usuario.setPerfil(PerfilAcesso.valueOf(perfil));
        dao.atualizar(usuario);
        response.sendRedirect("listarUsuario");
    }

    public void relatorio() throws Exception {
        try {
            List<Usuario> listagemResultado = dao.listar();

            HashMap paramRel = new HashMap();
            String nomeRelatorio = "relatorioUsuario";
            gerarRelatorio(nomeRelatorio, paramRel, listagemResultado);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
