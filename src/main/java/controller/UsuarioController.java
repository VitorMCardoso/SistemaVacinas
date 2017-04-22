/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

    /* public boolean inserirUsuario(Usuario u) throws SQLException {

        final JPanel panel = new JPanel();
        if (u.getNome() != null && u.getSobrenome() != null && u.getLogin() != null
                && u.getEmail() != null && u.getSenha() != null
                && u.getCargo() != null && u.getRg() != null && u.getCpf() != null
                && u.getEndereco() != null && u.getPerfil() != null) {
            u.setNome(u.getNome());
            u.setSobrenome(u.getSobrenome());
            u.setLogin(u.getLogin());
            u.setEmail(u.getEmail());
            u.setSenha(u.getSenha());
            u.setCargo(u.getCargo());
            u.setRg(u.getRg());
            u.setCpf(u.getCpf());
            u.setEndereco(u.getEndereco());
            u.setPerfil(u.getPerfil());
            dao.cadastrarNovoUsuario(u);
            JOptionPane.showMessageDialog(panel, "Usuario Cadastrado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        //('Vitor','d','d','f',1,2,'r',true,true);
        return true;
    }*/
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
        usuario.setRg((request.getParameter("rg")));
        usuario.setCpf((request.getParameter("cpf")));
        usuario.setEndereco((request.getParameter("endereco")));
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
        } else {
            usuario.setPerfil(PerfilAcesso.COMUM);
        }
        dao.cadastrarNovoUsuario(usuario);
        response.sendRedirect("list");
    }

    public boolean atualizarUsuario(Usuario u) throws SQLException {

        final JPanel panel = new JPanel();
        if (u.getId() == dao.selectID(u) && u.isAtivo() != dao.setAtivo(u)) {
            u.getId();
            u.setNome(u.getNome());
            u.setSobrenome(u.getSobrenome());
            u.setRg(u.getRg());
            u.setCpf(u.getCpf());
            u.setEndereco(u.getEndereco());
            u.setEmail(u.getEmail());
            dao.atualizarUsuario(u);
            JOptionPane.showMessageDialog(panel, "Paciente Atualizado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
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

    /*public boolean excluirUsuario(Usuario u, int usuarioID) throws SQLException {

        final JPanel panel = new JPanel();
        if (u.getId() == dao.selectID(u) && u.isAtivo() != dao.setAtivo(u)) {
            u.setId(u.getId());
            dao.excluirUsuario(usuarioID);
            JOptionPane.showMessageDialog(panel, "Paciente Apagado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean mostrarUsuario(Usuario u) throws SQLException {

        final JPanel panel = new JPanel();
        if (u.getId() == dao.selectID(u) && u.isAtivo() != dao.setAtivo(u)) {
            u.setId(u.getId());
            dao.buscarUsuario(u);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean resetarSenha(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.resetarSenha(p);
            JOptionPane.showMessageDialog(panel, "Senha Resatada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
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
        /*try {
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                usuario = new Usuario();
                usuario.setNome(request.getParameter("txtNome"));
                usuario.setSobrenome(request.getParameter("txtNome"));
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setEmail(request.getParameter("txtEmail"));
                usuario.setSenha(request.getParameter("txtSenha"));
                String cargo = request.getParameter("optCargo");
                if (cargo.equalsIgnoreCase("gerente")) {
                    usuario.setCargo(Cargo.GERENTE);
                } else if (cargo.equalsIgnoreCase("secretaria")) {
                    usuario.setCargo(Cargo.SECRETARIA);
                } else {
                    usuario.setCargo(Cargo.ESTOQUISTA);
                }
                usuario.setRg((request.getParameter("txtRg")));
                usuario.setCpf((request.getParameter("txtCpf")));
                usuario.setEndereco((request.getParameter("txtEndereco")));
                String perfil = request.getParameter("optPerfil");
                if (perfil.equalsIgnoreCase("administrador")) {
                    usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
                } else {
                    usuario.setPerfil(PerfilAcesso.COMUM);
                }
                //Chamada do metodo de inserçao de usuario
                inserirUsuario(usuario);
                request.setAttribute("msg", "cadastrado com sucesso");
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("../admin/cadastro_usuario.jsp");
                rd.forward(request, response);
            } else if (acao.equals("Listar")) {
                RequestDispatcher view = request.getRequestDispatcher("listarUsuario.jsp");
                request.setAttribute("usuarios", dao.listar());
                view.forward(request, response);
            } else {

            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }*/
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
                    //showEditForm(request, response);
                    break;
                case "/update":
                    //updateBook(request, response);
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
