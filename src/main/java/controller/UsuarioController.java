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
public class UsuarioController extends RelatorioController {

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
        usuario.setBairro(request.getParameter("bairro"));
        usuario.setCidade(request.getParameter("cidade"));
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            usuario.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            usuario.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            usuario.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            usuario.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            usuario.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            usuario.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            usuario.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            usuario.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            usuario.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            usuario.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            usuario.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            usuario.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            usuario.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            usuario.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            usuario.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            usuario.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            usuario.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            usuario.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            usuario.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            usuario.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            usuario.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            usuario.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            usuario.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            usuario.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            usuario.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("sp")) {
            usuario.setEstado(Estado.SP);
        } else {
            usuario.setEstado(Estado.TO);
        }
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
        } else {
            usuario.setPerfil(PerfilAcesso.COMUM);
        }
        dao.cadastrar(usuario);
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

        dao.excluir(id);
        response.sendRedirect("list");

    }

    public void editUsuarioForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Usuario usuarioLocalizado = dao.buscarUsuario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/usuarioForm.jsp");
        request.setAttribute("usuario", dao.buscar(id));
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
        usuario.setBairro(request.getParameter("bairro"));
        usuario.setCidade(request.getParameter("cidade"));
        String estado = request.getParameter("optEstado");
        if (estado.equalsIgnoreCase("AC")) {
            usuario.setEstado(Estado.AC);
        } else if (estado.equalsIgnoreCase("AL")) {
            usuario.setEstado(Estado.AL);
        } else if (estado.equalsIgnoreCase("AM")) {
            usuario.setEstado(Estado.AM);
        } else if (estado.equalsIgnoreCase("AP")) {
            usuario.setEstado(Estado.AP);
        } else if (estado.equalsIgnoreCase("BA")) {
            usuario.setEstado(Estado.BA);
        } else if (estado.equalsIgnoreCase("CE")) {
            usuario.setEstado(Estado.CE);
        } else if (estado.equalsIgnoreCase("DF")) {
            usuario.setEstado(Estado.DF);
        } else if (estado.equalsIgnoreCase("ES")) {
            usuario.setEstado(Estado.ES);
        } else if (estado.equalsIgnoreCase("GO")) {
            usuario.setEstado(Estado.GO);
        } else if (estado.equalsIgnoreCase("MA")) {
            usuario.setEstado(Estado.MA);
        } else if (estado.equalsIgnoreCase("MG")) {
            usuario.setEstado(Estado.MG);
        } else if (estado.equalsIgnoreCase("MS")) {
            usuario.setEstado(Estado.MS);
        } else if (estado.equalsIgnoreCase("MT")) {
            usuario.setEstado(Estado.MT);
        } else if (estado.equalsIgnoreCase("PA")) {
            usuario.setEstado(Estado.PA);
        } else if (estado.equalsIgnoreCase("PB")) {
            usuario.setEstado(Estado.PB);
        } else if (estado.equalsIgnoreCase("PE")) {
            usuario.setEstado(Estado.PE);
        } else if (estado.equalsIgnoreCase("PI")) {
            usuario.setEstado(Estado.PI);
        } else if (estado.equalsIgnoreCase("PR")) {
            usuario.setEstado(Estado.PR);
        } else if (estado.equalsIgnoreCase("RJ")) {
            usuario.setEstado(Estado.RJ);
        } else if (estado.equalsIgnoreCase("RN")) {
            usuario.setEstado(Estado.RN);
        } else if (estado.equalsIgnoreCase("RO")) {
            usuario.setEstado(Estado.RO);
        } else if (estado.equalsIgnoreCase("RR")) {
            usuario.setEstado(Estado.RR);
        } else if (estado.equalsIgnoreCase("RS")) {
            usuario.setEstado(Estado.RS);
        } else if (estado.equalsIgnoreCase("SC")) {
            usuario.setEstado(Estado.SC);
        } else if (estado.equalsIgnoreCase("SE")) {
            usuario.setEstado(Estado.SE);
        } else if (estado.equalsIgnoreCase("SP")) {
            usuario.setEstado(Estado.SP);
        } else {
            usuario.setEstado(Estado.TO);
        }
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
        } else {
            usuario.setPerfil(PerfilAcesso.COMUM);
        }

        dao.atualizar(usuario);
        response.sendRedirect("list");
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
