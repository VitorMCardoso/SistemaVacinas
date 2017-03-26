/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import model.Cargo;
import model.Paciente;
import model.PerfilAcesso;
import model.Usuario;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cargo;

/**
 *
 * @author vitor
 */
public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }
    
        public void cadastrarNovoUsuario(Usuario u) throws SQLException {
        String sql = "Insert Into usuario (nome,sobrenome,login,email,senha,cargo,rg,cpf,endereco,ativo,perfil)"
                + "Values(?,?,?,?,?,?,?,?,?,true,?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, 12345);
            stmt.setString(6, u.getCargo().toString());
            stmt.setString(7, u.getRg());
            stmt.setString(8, u.getCpf());
            stmt.setString(9, u.getEndereco());
            stmt.setString(10, u.getPerfil().toString());
            //executa o código
            stmt.execute();
            stmt.close();
        }
        
    }
    
    public void atualizarUsuario(Usuario u) throws SQLException {
        String sql = "Update usuario set nome = ? , sobrenome = ?, email = ?, rg=?, cpf=?, endereco = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getRg());
            stmt.setString(5, u.getCpf());
            stmt.setString(6, u.getEndereco());
            stmt.setInt(7, u.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }
    
    public void buscarUsuario(Usuario u) throws SQLException {
        
        String query = "SELECT * FROM usuario where id=" + u.getId();
        try {
            
            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                int rg = rs.getInt("rg");
                int cpf = rs.getInt("cpf");
                String endereco = rs.getString("endereco");

                // print the results
                out.format("%s, %s, %s, %s, %s, %s, %s\n", id, nome, sobrenome, email, rg, cpf, endereco);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirUsuario(Usuario u) throws SQLException { // implementação do método -remove-
        String sql = "update usuario set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, u.getId());
        stmt.execute();
        stmt.close();
        
    }
    
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
                usuarioAutenticado.setAtivo(rsUsuario.getBoolean("ativo"));
                usuarioAutenticado.setPerfil(PerfilAcesso.valueOf(rsUsuario.getString("perfil")));
            }
        }catch(SQLException sqlErro){
            throw new RuntimeException(sqlErro);
        }finally{
            if(conexao != null){
                try{
                    conexao.close();
                }catch(SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }
}
