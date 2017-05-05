/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import java.io.IOException;
import model.PerfilAcesso;
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cargo;

/**
 *
 * @author vitor
 */
public class UsuarioDAO implements IUsuarioDAO {

    private Connection conexao;
    Usuario usuario = new Usuario();

    public UsuarioDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    @Override
    public void cadastrarNovoUsuario(Usuario u) throws SQLException {
        String sql = "Insert Into usuario (nome,sobrenome,login,email,senha,cargo,rg,cpf,endereco,bairro,cidade,estado,ativo,perfil)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?,true,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());
            stmt.setString(6, u.getCargo().toString());
            stmt.setString(7, u.getRg());
            stmt.setString(8, u.getCpf());
            stmt.setString(9, u.getEndereco());
            stmt.setString(10, u.getBairro());
            stmt.setString(11, u.getCidade());
            stmt.setString(12, u.getEstado());
            stmt.setString(13, u.getPerfil().toString());
            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    @Override
    public void atualizarUsuario(Usuario u) throws SQLException {
        String sql = "Update usuario set nome = ? , sobrenome = ?, login = ?, email = ?, "
                + "senha = ?, cargo = ?, rg = ?, cpf = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, perfil = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());
            stmt.setString(6, u.getCargo().toString());
            stmt.setString(7, u.getRg());
            stmt.setString(8, u.getCpf());
            stmt.setString(9, u.getEndereco());
            stmt.setString(10, u.getBairro());
            stmt.setString(11, u.getCidade());
            stmt.setString(12, u.getEstado());
            stmt.setString(13, u.getPerfil().toString());
            stmt.setInt(14, u.getId());
            // executa o código sql
            stmt.executeUpdate();
            stmt.close();
        }
    }

    @Override
    public List<Usuario> listar() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String query = "SELECT * FROM usuario";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCargo(Cargo.valueOf(rs.getString("cargo")));
                usuario.setRg(rs.getString("rg"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuario.setPerfil(PerfilAcesso.valueOf(rs.getString("perfil")));
                usuarios.add(usuario);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario buscarUsuario(int usuarioID) throws SQLException {
       
        String query = "SELECT * FROM usuario where id=" + usuarioID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rsUsuario = st.executeQuery(query);

            // iterate through the java resultset
            if (rsUsuario.next()) {

                usuario.setId(rsUsuario.getInt("id"));
                usuario.setNome(rsUsuario.getString("nome"));
                usuario.setSobrenome(rsUsuario.getString("sobrenome"));
                usuario.setLogin(rsUsuario.getString("login"));
                usuario.setEmail(rsUsuario.getString("email"));
                usuario.setSenha(rsUsuario.getString("senha"));
                usuario.setCargo(Cargo.valueOf(rsUsuario.getString("cargo")));
                usuario.setRg(rsUsuario.getString("rg"));
                usuario.setCpf(rsUsuario.getString("cpf"));
                usuario.setEndereco(rsUsuario.getString("endereco"));
                usuario.setBairro(rsUsuario.getString("bairro"));
                usuario.setCidade(rsUsuario.getString("cidade"));
                usuario.setEstado(rsUsuario.getString("estado"));
                usuario.setAtivo(rsUsuario.getBoolean("ativo"));
                usuario.setPerfil(PerfilAcesso.valueOf(rsUsuario.getString("perfil")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void excluirUsuario(int usuarioID) throws SQLException { // implementação do método -remove-
        String sql = "update usuario set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, usuarioID);
        stmt.execute();
        stmt.close();

    }

    @Override
    public void resetarSenha(Usuario u) throws SQLException {
        String sql = "Update usuario set senha = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setInt(1, 123);
            stmt.setInt(2, u.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public int selectID(Usuario u) throws SQLException {
        String query = "SELECT id FROM usuario where id=" + u.getId();
        Statement st = conexao.createStatement();
        int id = 0;
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        st.close();
        return id;
    }

    @Override
    public boolean setAtivo(Usuario u) throws SQLException {
        String query = "SELECT ativo FROM usuario where id=" + u.getId();
        Statement st = conexao.createStatement();
        boolean ativo = true;
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ativo = rs.getBoolean("ativo");
        }
        st.close();
        return ativo;
    }

    @Override
    public Usuario autenticaUsuario(Usuario u) throws SQLException {
        Usuario usuarioAutenticado = null;

        String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
        ResultSet rsUsuario = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            //executa o código
            rsUsuario = stmt.executeQuery();

            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setId(rsUsuario.getInt("id"));
                usuarioAutenticado.setNome(rsUsuario.getString("nome"));
                usuarioAutenticado.setSobrenome(rsUsuario.getString("sobrenome"));
                usuarioAutenticado.setLogin(rsUsuario.getString("login"));
                usuarioAutenticado.setEmail(rsUsuario.getString("email"));
                usuarioAutenticado.setSenha(rsUsuario.getString("senha"));
                usuarioAutenticado.setCargo(Cargo.valueOf(rsUsuario.getString("cargo")));
                usuarioAutenticado.setRg(rsUsuario.getString("rg"));
                usuarioAutenticado.setCpf(rsUsuario.getString("cpf"));
                usuarioAutenticado.setEndereco(rsUsuario.getString("endereco"));
                usuarioAutenticado.setBairro(rsUsuario.getString("bairro"));
                usuarioAutenticado.setCidade(rsUsuario.getString("cidade"));
                usuarioAutenticado.setEstado(rsUsuario.getString("estado"));
                usuarioAutenticado.setAtivo(rsUsuario.getBoolean("ativo"));
                usuarioAutenticado.setPerfil(PerfilAcesso.valueOf(rsUsuario.getString("perfil")));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }
}
