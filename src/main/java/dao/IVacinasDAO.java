/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public interface IVacinasDAO {

    public void cadastrarNovaVacina(Vacinas v) throws SQLException;

    public void atualizarVacina(Vacinas v) throws SQLException;

    public List<Vacinas> listar() throws SQLException, ClassNotFoundException;

    public Vacinas buscarVacina(int vacinasID) throws SQLException;

    public int selectID(Vacinas v) throws SQLException;
    
    public void descVacina(int quantidadeAgendamento, int vacinasId) throws SQLException;
    
    public void cresVacina(int quantidadeAgendamento, int idVacina) throws SQLException;

}
