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
import model.LoteVacinas;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public class LoteVacinasDAO implements IDao<LoteVacinas>{
    
    private Connection conexao;
    public LoteVacinas loteVacinas = new LoteVacinas();
    
    public LoteVacinasDAO() throws SQLException, IOException{
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    
    
    @Override
    public void cadastrar(LoteVacinas t) throws SQLException {
        String sql = "Insert Into loteVacinas (quantidadeVac, idLaboratorio, idVacinas, ativo)"
                + "Values(?,?,?,true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setInt(1, t.getQuantidadeVac());
            stmt.setInt(2, t.getLaboratorio().getId());
            stmt.setInt(3, t.getVacina().getId());

            //executa o código
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public void atualizar(LoteVacinas t) throws SQLException {
        String sql = "Update loteVacinas set quantidadeVac = ?, idLaboratorio = ?, idVacinas = ? "
                + "where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setInt(1, t.getQuantidadeVac());
            stmt.setInt(2, t.getLaboratorio().getId());
            stmt.setInt(3, t.getVacina().getId());
            stmt.setInt(4, t.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public List<LoteVacinas> listar() throws SQLException, ClassNotFoundException {
        List<LoteVacinas> loteVacinas = new ArrayList<LoteVacinas>();
        String query = "SELECT * FROM LoteVacinas";
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                LoteVacinas loteVacina = new LoteVacinas();
                loteVacina.setId(Integer.valueOf(rs.getString("id")));
                loteVacina.setQuantidadeVac(rs.getInt("quantidadeVac"));
                loteVacina.setLaboratorio(new Laboratorio(rs.getInt("idLaboratorio")));
                loteVacina.setVacina(new Vacinas(rs.getInt("idVacinas")));
                loteVacina.setAtivo(rs.getBoolean("ativo"));
                loteVacinas.add(loteVacina);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loteVacinas;
    }

    @Override
    public LoteVacinas buscar(int loteID) throws SQLException {
        String query = "SELECT * FROM loteVacinas where id=" + loteID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                loteVacinas.setId(Integer.valueOf(rs.getString("id")));
                loteVacinas.setQuantidadeVac(rs.getInt("quantidadeVac"));
                loteVacinas.setLaboratorio(new Laboratorio(rs.getInt("idLaboratorio")));
                loteVacinas.setVacina(new Vacinas(rs.getInt("idVacinas")));
                loteVacinas.setAtivo(rs.getBoolean("ativo"));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //vacinasDAO.cresVacina(agendamento.getQuantidadeVac(), 1);
        return loteVacinas;
    }

    @Override
    public void excluir(int loteID) throws SQLException {
        String sql = "update loteVacinas set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, loteID);
        stmt.execute();
        stmt.close();
    }

    @Override
    public int selectID(LoteVacinas t) throws SQLException {
        String query = "SELECT id FROM loteVacinas where id=" + t.getId();
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
    public void setAtivo(int loteID) throws SQLException {
        String sql = "update loteVacinas set ativo=true where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, loteID);
        stmt.execute();
        stmt.close();
    }
    
    public void descVacina(int quantidade, int idVacina) throws SQLException {
        String query = "Update loteVacinas set quantidadeVac=quantidadeVac-? where idVacinas =? AND ativo = true";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, quantidade);
        stmt.setInt(2, idVacina);
        stmt.executeUpdate();
        stmt.close();
    }

    public void cresVacina(int quantidade, int idVacina) throws SQLException {
        String query = "Update loteVacinas set quantidadeVac=quantidadeVac+? where id =?";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, quantidade);
        stmt.setInt(2, idVacina);
        stmt.executeUpdate();
        stmt.close();
    }
    
}
