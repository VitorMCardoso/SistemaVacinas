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
import java.util.Date;
import model.Agendamento;
import model.Paciente;
import model.Vacinas;

/**
 *
 * @author Kanec
 */
public class AgendamentoDAO {


    private Connection conexao;

    public AgendamentoDAO() throws SQLException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    public void cadastrarNovosAgendamentos(Agendamento a) throws SQLException {
        String sql = "Insert Into agendamento (datadose, idpaciente, idvacinas, ativo) Values (?, ?, ?, true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(a.getDataDose().getTime()));
            stmt.setInt(2, a.getPaciente().getId());
            stmt.setInt(3, a.getVacinas().getId());

            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    public void atualizarAgendamentoDia(Agendamento a) throws SQLException {
        String sql = "Update agendamento set datadose = ? where id=?";
       
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, (java.sql.Date) a.getDataDose());
            stmt.setInt(2, a.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }
    
     public void atualizarAgendamentoVacina(Vacinas v, Agendamento a) throws SQLException {
        String sql = "Update agendamento set idvacinas = ? where id=?";
       
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setInt(1, v.getId());
            stmt.setInt(2, a.getId());
            // executa o código sql
            stmt.execute();
            stmt.close();
        }
    }

    public void buscarAgendamento(Agendamento a) throws SQLException {
       
        String query = "SELECT * FROM agendamento where id= " + a.getId();
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                Date dataDose = rs.getDate("datadose");
                int idPaciente = rs.getInt("idpaciente");
                int idVacinas = rs.getInt("idvacinas");

                // print the results
                out.format("%s, %s, %s, %s\n", id, dataDose, idPaciente, idVacinas);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirAgendamento(Agendamento a) throws SQLException { // implementação do método -remove-
        String sql = "update agendamento set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        stmt.execute();
        stmt.close();

    }
    
    public int selectID(Agendamento a) throws SQLException {
        String query = "SELECT id FROM agendamento where id=" + a.getId();
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

    public boolean setAtivo(Agendamento a) throws SQLException {
        String query = "SELECT ativo FROM agendamento where id=" + a.getId();
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
