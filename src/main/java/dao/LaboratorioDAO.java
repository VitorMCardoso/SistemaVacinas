/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Laboratorio;

/**
 *
 * @author vitor
 */
public class LaboratorioDAO implements ILaboratorioDAO {

    private Connection conexao;
    Laboratorio laboratorio = new Laboratorio();

    public LaboratorioDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    @Override
    public void cadastrarNovoLaboratorio(Laboratorio l) throws SQLException {
        String sql = "Insert Into laboratorio (razaoSocial,cnpj,registroEstadual,nomeFantasia,telefone,site,"
                + "cep,logradouro,numero,bairro,cidade,estado,ativo)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?,true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, l.getRazaoSocial());
            stmt.setString(2, l.getCnpj());
            stmt.setString(3, l.getRegistroEstadual());
            stmt.setString(4, l.getNomeFantasia());
            stmt.setString(5, l.getTelefone());
            stmt.setString(6, l.getSite());
            stmt.setString(7, l.getCep());
            stmt.setString(8, l.getLogradouro());
            stmt.setString(9, l.getNumero());
            stmt.setString(10, l.getBairro());
            stmt.setString(11, l.getCidade());
            stmt.setString(12, l.getEstado());
            //executa o código
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public void atualizarLaboratorio(Laboratorio l) throws SQLException {
        String sql = "Update laboratorio set razaoSocial = ? , cnpj = ?, registroEstadual = ?, nomeFantasia = ?, "
                + "telefone = ?, site = ?, cep = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, l.getRazaoSocial());
            stmt.setString(2, l.getCnpj());
            stmt.setString(3, l.getRegistroEstadual());
            stmt.setString(4, l.getNomeFantasia());
            stmt.setString(5, l.getTelefone());
            stmt.setString(6, l.getSite());
            stmt.setString(7, l.getCep());
            stmt.setString(8, l.getLogradouro());
            stmt.setString(9, l.getNumero());
            stmt.setString(10, l.getBairro());
            stmt.setString(11, l.getCidade());
            stmt.setString(12, l.getEstado());
            stmt.setInt(12, l.getId());
            // executa o código sql
            stmt.executeUpdate();
            stmt.close();
        }
    }

    @Override
    public List<Laboratorio> listar() throws SQLException, ClassNotFoundException {
        List<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
        String query = "SELECT * FROM laboratorio";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(rs.getInt("id"));
                laboratorio.setRazaoSocial(rs.getString("razaoSocial"));
                laboratorio.setCnpj(rs.getString("cnpj"));
                laboratorio.setRegistroEstadual(rs.getString("registroEstadual"));
                laboratorio.setNomeFantasia(rs.getString("nomeFantasia"));
                laboratorio.setTelefone(rs.getString("telefone"));
                laboratorio.setSite(rs.getString("site"));
                laboratorio.setCep(rs.getString("cep"));
                laboratorio.setLogradouro(rs.getString("logradouro"));
                laboratorio.setNumero(rs.getString("numero"));
                laboratorio.setBairro(rs.getString("bairro"));
                laboratorio.setCidade(rs.getString("cidade"));
                laboratorio.setEstado(rs.getString("estado"));
                laboratorio.setAtivo(rs.getBoolean("ativo"));
                laboratorios.add(laboratorio);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorios;
    }

    @Override
    public Laboratorio buscarLaboratorio(int laboratorioID) throws SQLException {
        String query = "SELECT * FROM laboratorio where id=" + laboratorioID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                laboratorio.setId(rs.getInt("id"));
                laboratorio.setRazaoSocial(rs.getString("razaoSocial"));
                laboratorio.setCnpj(rs.getString("cnpj"));
                laboratorio.setRegistroEstadual(rs.getString("registroEstadual"));
                laboratorio.setNomeFantasia(rs.getString("nomeFantasia"));
                laboratorio.setTelefone(rs.getString("telefone"));
                laboratorio.setSite(rs.getString("site"));
                laboratorio.setCep(rs.getString("cep"));
                laboratorio.setLogradouro(rs.getString("logradouro"));
                laboratorio.setNumero(rs.getString("numero"));
                laboratorio.setBairro(rs.getString("bairro"));
                laboratorio.setCidade(rs.getString("cidade"));
                laboratorio.setEstado(rs.getString("estado"));
                laboratorio.setAtivo(rs.getBoolean("ativo"));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorio;
    }

    @Override
    public void excluirLaboratorio(int laboratorioID) throws SQLException {
        String sql = "update laboratorio set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, laboratorioID);
        stmt.execute();
        stmt.close();
    }

    @Override
    public int selectID(Laboratorio l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setAtivo(Laboratorio l) throws SQLException {
        String query = "SELECT ativo FROM laboratorio where id=" + l.getId();
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
