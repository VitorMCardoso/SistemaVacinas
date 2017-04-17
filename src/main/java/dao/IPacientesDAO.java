/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Paciente;

/**
 *
 * @author vitor
 */
public interface IPacientesDAO {
    public void cadastrarNovoPaciente(Paciente p) throws SQLException;

    public void atualizarPaciente(Paciente p) throws SQLException;

    public List<Paciente> listar() throws SQLException, ClassNotFoundException;

    public Paciente buscarPaciente(int pacienteID) throws SQLException;

    public void excluirPaciente(int pacienteID) throws SQLException;

    public void resetarSenha(Paciente p) throws SQLException;

    public int selectID(Paciente p) throws SQLException;

    public boolean setAtivo(Paciente p) throws SQLException;

    public Paciente autenticaUsuario(Paciente p) throws SQLException;
}
