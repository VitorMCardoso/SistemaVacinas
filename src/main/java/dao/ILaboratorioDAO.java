/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Laboratorio;

/**
 *
 * @author vitor
 */
public interface ILaboratorioDAO {

    public void cadastrarNovoLaboratorio(Laboratorio l) throws SQLException;

    public void atualizarLaboratorio(Laboratorio l) throws SQLException;

    public List<Laboratorio> listar() throws SQLException, ClassNotFoundException;

    public Laboratorio buscarLaboratorio(int laboratorioID) throws SQLException;

    public void excluirLaboratorio(int laboratorioID) throws SQLException;

    public int selectID(Laboratorio l) throws SQLException;

    public boolean setAtivo(Laboratorio l) throws SQLException;

}
