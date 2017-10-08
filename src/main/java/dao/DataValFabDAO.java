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
import model.DataValFab;
import model.Laboratorio;
import model.LoteVacinas;

/**
 *
 * @author vitor
 */
public class DataValFabDAO implements IDao<DataValFab> {

    private Connection conexao;
    private DataValFab dataValFab = new DataValFab();

    public DataValFabDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    @Override
    public void cadastrar(DataValFab d) throws SQLException {
        String sql = "Insert Into dataValFab (dataValidade, dataFabricacao, idLote)"
                + "Values(?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(d.getDataValidade().getTime()));
            stmt.setDate(2, new java.sql.Date(d.getDataFabricacao().getTime()));
            stmt.setInt(3, d.getLote().getId());

            //executa o código
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public void atualizar(DataValFab d) throws SQLException {
        String sql = "Update dataValFab set dataValidade = ?, dataFabricacao = ?, "
                + "idLote = ? where id=?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(d.getDataValidade().getTime()));
            stmt.setDate(2, new java.sql.Date(d.getDataFabricacao().getTime()));
            stmt.setInt(3, d.getLote().getId());
            stmt.setInt(4, d.getId());

            //executa o código
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public List<DataValFab> listar() throws SQLException, ClassNotFoundException {
        List<DataValFab> dataValFabs = new ArrayList<DataValFab>();
        String query = "SELECT * FROM dataValFab";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                DataValFab dataValFab = new DataValFab();
                dataValFab.setId(rs.getInt("id"));
                dataValFab.setDataValidade(java.sql.Date.valueOf(rs.getString("dataValidade")));
                dataValFab.setDataFabricacao(java.sql.Date.valueOf(rs.getString("dataFabricacao")));
                dataValFab.setLote(new LoteVacinas(rs.getInt("idLote")));
                dataValFabs.add(dataValFab);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataValFabs;
    }

    @Override
    public DataValFab buscar(int dataID) throws SQLException {
        String query = "SELECT * FROM dataValFab where id=" + dataID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                dataValFab.setId(Integer.valueOf(rs.getString("id")));
                dataValFab.setDataValidade(java.sql.Date.valueOf(rs.getString("dataValidade")));
                dataValFab.setDataFabricacao(java.sql.Date.valueOf(rs.getString("dataValidade")));
                dataValFab.setLote(new LoteVacinas(rs.getInt("idLote")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //vacinasDAO.cresVacina(agendamento.getQuantidadeVac(), 1);
        return dataValFab;
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int selectID(DataValFab d) throws SQLException {
        String query = "SELECT id FROM dataValFab where id=" + d.getId();
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
    public void setAtivo(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
