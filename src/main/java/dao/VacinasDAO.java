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
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Laboratorio;
import model.Paciente;
import model.Vacinas;

/**
 *
 * @author Kanec
 */
public class VacinasDAO implements IVacinasDAO {

    private Connection conexao;
    private Vacinas vacina = new Vacinas();

    public VacinasDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    public void cadastrarNovaVacina(Vacinas v) throws SQLException {
        String sql = "Insert Into vacinas (datavalidade, datafabricacao, nome, tipo, quantidade, lote, idlaboratorio)"
                + "Values(?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(v.getDataValidade().getTime()));
            stmt.setDate(2, new java.sql.Date(v.getDataFabricacao().getTime()));
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setString(6, v.getLote());
            stmt.setInt(7, v.getIdLaboratorio());

            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    public void atualizarVacina(Vacinas v) throws SQLException {
        String sql = "Update vacinas set datavalidade = ? , datafabricacao=?, nome = ?, tipo = ?, "
                + "quantidade=?, lote=?, idlaboratorio = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, (java.sql.Date) v.getDataValidade());
            stmt.setDate(2, (java.sql.Date) v.getDataFabricacao());
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setString(6, v.getLote());
            stmt.setInt(7, v.getIdLaboratorio());
            stmt.setInt(8, v.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public List<Vacinas> listar() throws SQLException, ClassNotFoundException {
        List<Vacinas> vacinas = new ArrayList<Vacinas>();
        String query = "SELECT * FROM vacinas";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                Vacinas vacina = new Vacinas();
                vacina.setId(Integer.valueOf(rs.getString("id")));
                vacina.setDataValidade(java.sql.Date.valueOf(rs.getString("dataValidade")));
                vacina.setDataFabricacao(java.sql.Date.valueOf(rs.getString("dataFabricacao")));
                vacina.setNome(rs.getString("nome"));
                vacina.setTipo(rs.getString("tipo"));
                vacina.setQuantidade(Integer.valueOf(rs.getString("quantidade")));
                vacina.setLote(rs.getString("lote"));
                vacina.setIdLaboratorio(Integer.valueOf(rs.getString("idLaboratorio")));
                vacinas.add(vacina);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacinas;
    }

    @Override
    public Vacinas buscarVacina(int usuarioID) throws SQLException {

        String query = "SELECT * FROM vacinas where id=" + usuarioID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                vacina.setId(Integer.valueOf(rs.getString("id")));
                vacina.setDataValidade(java.sql.Date.valueOf(rs.getString("dataValidade")));
                vacina.setDataFabricacao(java.sql.Date.valueOf(rs.getString("dataFabricacao")));
                vacina.setNome(rs.getString("nome"));
                vacina.setTipo(rs.getString("tipo"));
                vacina.setQuantidade(Integer.valueOf(rs.getString("quantidade")));
                vacina.setLote(rs.getString("lote"));
                vacina.setIdLaboratorio(Integer.valueOf(rs.getString("idLaboratorio")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacina;
    }

    @Override
    public void excluirVacina(int vacinasID) throws SQLException {
        String sql = "update vacinas set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, vacinasID);
        stmt.execute();
        stmt.close();
    }

    public int selectID(Vacinas v) throws SQLException {
        String query = "SELECT id FROM vacinas where id=" + v.getId();
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

    public boolean setAtivo(Vacinas v) throws SQLException {
        String query = "SELECT ativo FROM vacinas where id=" + v.getId();
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
