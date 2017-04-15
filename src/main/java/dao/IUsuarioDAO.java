/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Usuario;

/**
 *
 * @author vitor
 */
public interface IUsuarioDAO {

    public void cadastrarNovoUsuario(Usuario u) throws SQLException;

    public void atualizarUsuario(Usuario u) throws SQLException;

    public List<Usuario> listar() throws SQLException, ClassNotFoundException;

    public Usuario buscarUsuario(int usuarioID) throws SQLException;

    public void excluirUsuario(int usuarioID) throws SQLException;

    public void resetarSenha(Usuario u) throws SQLException;

    public int selectID(Usuario u) throws SQLException;

    public boolean setAtivo(Usuario u) throws SQLException;

    public Usuario autenticaUsuario(Usuario u) throws SQLException;

}
