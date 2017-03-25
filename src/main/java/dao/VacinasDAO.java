/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBanco.ConectaBancoDeDados;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Paciente;
import model.Vacinas;

/**
 *
 * @author Kanec
 */

//teste
//testeftftft
        
public class VacinasDAO {

    private Connection conexao;

    public VacinasDAO() throws SQLException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    public void cadastrarNovasVacinas(Vacinas v) throws SQLException {
        String sql = "Insert Into vacinas (datavalidade, datafabricacao, nome, tipo, quantidade, lote, idlaboratorio, ativo)"
                + "Values(?,?,?,?,?,?,1,true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(v.getDataValidade().getTime()));
            stmt.setDate(2, new java.sql.Date(v.getDataFabricacao().getTime()));
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setString(6, v.getLote());

            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    public void atualizarVacinas(Vacinas v) throws SQLException {
        String sql = "Update vacinas set datavalidade = ? , datafabricacao=?, nome = ?, tipo = ?, quantidade=?, lote=?, idlaboratorio = ? where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, (java.sql.Date) v.getDataValidade());
            stmt.setDate(2, (java.sql.Date) v.getDataFabricacao());
            stmt.setString(3, v.getNome());
            stmt.setString(4, v.getTipo());
            stmt.setInt(5, v.getQuantidade());
            stmt.setString(6, v.getLote());
            stmt.setInt(7, 1);
            stmt.setInt(8, v.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }

    public void buscarVacinas(Vacinas v) throws SQLException {
        int z = 0;
        z = v.getId();
        String query = "SELECT * FROM vacinas where id=" + z;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                Date dataValid = rs.getDate("datavalidade");
                Date dataFabric = rs.getDate("datafabricacao");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                int quantidade = rs.getInt("quantidade");
                String lote = rs.getString("lote");
                int idlab = rs.getInt("idlaboratorio");

                // print the results
                out.format("%s, %s, %s, %s, %s, %s, %s, %s\n", id, dataValid, dataFabric, nome, tipo, quantidade, lote, idlab);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirVacinas(Vacinas v) throws SQLException { // implementação do método -remove-
        String sql = "update vacinas set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, v.getId());
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
