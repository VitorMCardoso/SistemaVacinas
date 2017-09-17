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
import java.util.Date;
import java.util.List;
import model.Agendamento;
import model.Paciente;
import model.Vacinas;

/**
 *
 * @author Kanec
 */
public class AgendamentoDAO implements IDao<Agendamento> {

    private Connection conexao;
    private Agendamento agendamento = new Agendamento();
    private VacinasDAO vacinasDAO = new VacinasDAO();

    public AgendamentoDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    @Override
    public void cadastrar(Agendamento a) throws SQLException {
        String sql = "Insert Into agendamento (dataDose, quantidadeVac, idPaciente, idVacinas, ativo) Values (?, ?, ?, ?, true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(a.getDataDose().getTime()));
            stmt.setInt(2, a.getQuantidadeVac());
            stmt.setInt(3, a.getIdPaciente());
            stmt.setInt(4, a.getIdVacinas());
            vacinasDAO.descVacina(a.getQuantidadeVac(), a.getIdVacinas());
            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    @Override
    public void atualizar(Agendamento a) throws SQLException {
        String sql = "Update agendamento set dataDose = ?, quantidadeVac = ?, "
                + "idPaciente = ?, idVacinas = ? where id=?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(a.getDataDose().getTime()));
            stmt.setInt(2, a.getQuantidadeVac());
            stmt.setInt(3, a.getIdPaciente());
            stmt.setInt(4, a.getIdVacinas());
            stmt.setInt(5, a.getId());
            vacinasDAO.descVacina(a.getQuantidadeVac(), a.getIdVacinas());
            //executa o código
            stmt.executeUpdate();
            stmt.close();
        }
    }

    @Override
    public List<Agendamento> listar() throws SQLException, ClassNotFoundException {
        List<Agendamento> agendamentos = new ArrayList<Agendamento>();
        String query = "SELECT * FROM agendamento";
        try {

            // execute the query, and get a java resultset
            try (Statement st = conexao.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                
                // iterate through the java resultset
                while (rs.next()) {
                    Agendamento agendamento = new Agendamento();
                    agendamento.setId(rs.getInt("id"));
                    agendamento.setDataDose(java.sql.Date.valueOf(rs.getString("dataDose")));
                    agendamento.setQuantidadeVac(rs.getInt("quantidadeVac"));
                    agendamento.setIdPaciente(rs.getInt("idPaciente"));
                    agendamento.setIdVacinas(rs.getInt("idVacinas"));
                    agendamento.setAtivo(rs.getBoolean("ativo"));
                    agendamentos.add(agendamento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(agendamento);
        return agendamentos;
    }

    @Override
    public Agendamento buscar(int agendamentoID) throws SQLException {

        String query = "SELECT * FROM agendamento where id=" + agendamentoID;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                agendamento.setId(Integer.valueOf(rs.getString("id")));
                agendamento.setDataDose(java.sql.Date.valueOf(rs.getString("dataDose")));
                agendamento.setQuantidadeVac(Integer.valueOf(rs.getString("quantidadeVac")));
                agendamento.setIdPaciente(Integer.valueOf(rs.getString("idPaciente")));
                agendamento.setIdVacinas(Integer.valueOf(rs.getString("idVacinas")));
                agendamento.setAtivo(Boolean.valueOf(rs.getString("ativo")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamento;
    }

    @Override
    public void excluir(int idAgendamento) throws SQLException { // implementação do método -remove-
        String sql = "update agendamento set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idAgendamento);
        stmt.execute();
        stmt.close();

    }
    
    public void excluirAgendamento(int idAgendamento,int quantidadeVacinas, int idVacina) throws SQLException { // implementação do método -remove-
        String sql = "update agendamento set ativo=false where id=?";
        vacinasDAO.cresVacina(quantidadeVacinas, idVacina);
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idAgendamento);
            stmt.executeUpdate();
        }

    }

    @Override
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

    @Override
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
