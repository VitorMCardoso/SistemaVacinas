/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Paciente;
import model.PerfilAcesso;

/**
 *
 * @author Kanec
 */
public class PacientesDAO {
    
    private Connection conexao;
    
    public PacientesDAO() throws SQLException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }
    
    public void cadastrarNovoPaciente(Paciente p) throws SQLException {
        String sql = "Insert Into paciente (nome,sobrenome,email,senha,rg,cpf,endereco,ativo,perfil)"
                + "Values(?,?,?,?,?,?,?,true,COMUM)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSobrenome());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, 12345);
            stmt.setString(5, p.getRg());
            stmt.setString(6, p.getCpf());
            stmt.setString(7, p.getEndereco());
            //executa o código
            stmt.execute();
            stmt.close();
        }
        
    }
    
    public void atualizarPaciente(Paciente p) throws SQLException {
        String sql = "Update paciente set nome = ? , sobrenome = ?, email = ?, rg=?, cpf=?, endereco = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSobrenome());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getRg());
            stmt.setString(5, p.getCpf());
            stmt.setString(6, p.getEndereco());
            stmt.setInt(7, p.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }
    
    public void buscarPaciente(Paciente p) throws SQLException {
        
        String query = "SELECT * FROM paciente where id=" + p.getId();
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
    
    public void excluirPaciente(Paciente p) throws SQLException { // implementação do método -remove-
        String sql = "update paciente set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, p.getId());
        stmt.execute();
        stmt.close();
        
    }
    
    public void resetarSenha(Paciente p) throws SQLException {
        String sql = "Update paciente set senha = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setInt(1, 123);
            stmt.setInt(2, p.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }
    
    public int selectID(Paciente p) throws SQLException {
        String query = "SELECT id FROM paciente where id=" + p.getId();
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
    
    public boolean setAtivo(Paciente p) throws SQLException {
        String query = "SELECT ativo FROM paciente where id=" + p.getId();
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
}
