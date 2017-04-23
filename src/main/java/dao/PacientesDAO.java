/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;
import model.PerfilAcesso;

/**
 *
 * @author Kanec
 */
public class PacientesDAO implements IPacientesDAO{
    
    private Connection conexao;
    Paciente paciente = new Paciente();
    
    public PacientesDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }
    
    @Override
    public void cadastrarNovoPaciente(Paciente p) throws SQLException {
        String sql = "Insert Into paciente (nome,sobrenome,email,senha,rg,cpf,endereco,ativo,perfil)"
                + "Values(?,?,?,?,?,?,?,true,COMUM)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSobrenome());
            stmt.setString(3, p.getLogin());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getSenha());
            stmt.setString(6, p.getRg());
            stmt.setString(7, p.getCpf());
            stmt.setString(8, p.getEndereco());
            stmt.setString(9, p.getPerfil().toString());
            //executa o código
            stmt.execute();
            stmt.close();
        }
        
    }
    
    @Override
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
    
    @Override
    public Paciente buscarPaciente(int pacienteID) throws SQLException {
        
        String query = "SELECT * FROM paciente where id=" + pacienteID;
        try {
            
            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rsPaciente = st.executeQuery(query);

            // iterate through the java resultset
            while (rsPaciente.next()) {
                paciente.setId(rsPaciente.getInt("id"));
                paciente.setNome(rsPaciente.getString("nome"));
                paciente.setSobrenome(rsPaciente.getString("sobrenome"));
                paciente.setLogin(rsPaciente.getString("login"));
                paciente.setEmail(rsPaciente.getString("email"));
                paciente.setSenha(rsPaciente.getString("senha"));
                paciente.setRg(rsPaciente.getString("rg"));
                paciente.setCpf(rsPaciente.getString("cpf"));
                paciente.setEndereco(rsPaciente.getString("endereco"));
                paciente.setAtivo(rsPaciente.getBoolean("ativo"));
                paciente.setPerfil(PerfilAcesso.valueOf(rsPaciente.getString("perfil")));

            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
    
    @Override
    public void excluirPaciente(int pacienteID) throws SQLException { // implementação do método -remove-
        String sql = "update paciente set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, pacienteID);
        stmt.execute();
        stmt.close();
        
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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

    @Override
    public List<Paciente> listar() throws SQLException, ClassNotFoundException {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        String query = "SELECT * FROM paciente";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSobrenome(rs.getString("sobrenome"));
                paciente.setLogin(rs.getString("login"));
                paciente.setEmail(rs.getString("email"));
                paciente.setRg(rs.getString("rg"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setAtivo(rs.getBoolean("ativo"));
                pacientes.add(paciente);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public Paciente autenticaUsuario(Paciente p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
