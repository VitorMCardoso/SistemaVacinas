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
public class VacinasDAO implements IDao<Vacinas> {

    private Connection conexao;
    private Vacinas vacina = new Vacinas();

    public VacinasDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    public void cadastrar(Vacinas v) throws SQLException {
        String sql = "Insert Into vacinas (datavalidade, datafabricacao, nome, tipo, quantidade, idLote)"
                + "Values(?,?,?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(v.getDataValidade().getTime()));
            stmt.setDate(2, new java.sql.Date(v.getDataFabricacao().getTime()));
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setInt(6, v.getIdLote());

            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    public void atualizar(Vacinas v) throws SQLException {
        String sql = "Update vacinas set datavalidade = ? , datafabricacao=?, nome = ?, tipo = ?, "
                + "quantidade=?, idlote = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, (java.sql.Date) v.getDataValidade());
            stmt.setDate(2, (java.sql.Date) v.getDataFabricacao());
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setInt(6, v.getIdLote());
            stmt.setInt(7, v.getId());
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
                vacina.setIdLote(Integer.valueOf(rs.getString("idLote")));
                vacinas.add(vacina);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacinas;
    }

    @Override
    public Vacinas buscar(int usuarioID) throws SQLException {

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
                vacina.setIdLote(Integer.valueOf(rs.getString("idLote")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacina;
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

    public void descVacina(int quantidadeAgendamento, int idVacina) throws SQLException {
        String query = "Update vacinas set quantidade=quantidade-? where id =?";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, quantidadeAgendamento);
        stmt.setInt(2, idVacina);
        stmt.executeUpdate();
        stmt.close();
    }

    public void cresVacina(int quantidadeAgendamento, int idVacina) throws SQLException {
        String query = "Update vacinas set quantidade=quantidade+? where id =?";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, quantidadeAgendamento);
        stmt.setInt(2, idVacina);
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setAtivo(Vacinas t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
