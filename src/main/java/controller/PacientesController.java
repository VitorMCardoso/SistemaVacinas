/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacientesDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

/**
 *
 * @author vitor
 */
public class PacientesController {

    private PacientesDAO dao;

    public PacientesController() throws SQLException, IOException {
        this.dao = new PacientesDAO();
    }

    
    public void listarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Paciente> listPaciente = dao.listar();
        request.setAttribute("listarPaciente", listPaciente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paciente/listarPaciente.jsp");
        dispatcher.forward(request, response);
    }
    
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paciente/pacienteForm.jsp");
        dispatcher.forward(request, response);
    }

   /* public boolean inserirPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getNome() != null && p.getSobrenome() != null && p.getLogin() != null
                && p.getEmail() != null && p.getSenha()
                != null && p.getRg() != null && p.getCpf() != null
                && p.getEndereco() != null && p.getPerfil() != null) {
            p.setNome(p.getNome());
            p.setSobrenome(p.getSobrenome());
            p.setLogin(p.getLogin());
            p.setEmail(p.getEmail());
            p.setSenha(p.getSenha());
            p.setRg(p.getRg());
            p.setCpf(p.getCpf());
            p.setEndereco(p.getEndereco());
            p.setPerfil(p.getPerfil());
            dao.cadastrarNovoPaciente(p);
            JOptionPane.showMessageDialog(panel, "Usuario Cadastrado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        //('Vitor','d','d','f',1,2,'r',true,true);
        return true;
    }

    public boolean atualizarPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getNome() != null && p.getSobrenome() != null && p.getRg() != null && p.getCpf() != null
                && p.getEndereco() != null && p.getEmail() != null && p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.getId();
            p.setNome(p.getNome());
            p.setSobrenome(p.getSobrenome());
            p.setRg(p.getRg());
            p.setCpf(p.getCpf());
            p.setEndereco(p.getEndereco());
            p.setEmail(p.getEmail());
            dao.atualizarPaciente(p);
            JOptionPane.showMessageDialog(panel, "Paciente Atualizado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean excluirPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.excluirPaciente(p);
            JOptionPane.showMessageDialog(panel, "Paciente Apagado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean mostrarPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.buscarPaciente(p);
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
    }*/
}
