/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Agendamento;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public interface IAgendamentoDAO {

    public void cadastrarNovoAgendamento(Agendamento a) throws SQLException;

    public void atualizarAgendamento(Agendamento a) throws SQLException;

    public List<Agendamento> listar() throws SQLException, ClassNotFoundException;

    public Agendamento buscarAgendamento(int agendamentoID) throws SQLException;

    public void excluirAgendamento(int idAgendamento) throws SQLException;

    public int selectID(Agendamento a) throws SQLException;

    public boolean setAtivo(Agendamento a) throws SQLException;
}
