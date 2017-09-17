/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vitor
 */
public interface IDao <T>{
    
    public void cadastrar (T t) throws SQLException;
    
    public void atualizar(T t) throws SQLException;

    public List<T> listar() throws SQLException, ClassNotFoundException;

    public T buscar(int id) throws SQLException;

    public void excluir(int id) throws SQLException;

    public int selectID(T t) throws SQLException;

    public void setAtivo(int id) throws SQLException;

}
