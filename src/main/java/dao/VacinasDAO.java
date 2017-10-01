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
    public Vacinas vacina = new Vacinas();

    public VacinasDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    public void cadastrar(Vacinas v) throws SQLException {
        String sql = "Insert Into vacinas (nome, tipo)"
                + "Values(?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getTipo());

            //executa o código
            stmt.execute();
            stmt.close();
        }

    }

    public void atualizar(Vacinas v) throws SQLException {
        String sql = "Update vacinas set nome = ?, tipo = ? "
                + "where id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getTipo());
            stmt.setInt(3, v.getId());
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
                vacina.setNome(rs.getString("nome"));
                vacina.setTipo(rs.getString("tipo"));
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
                vacina.setNome(rs.getString("nome"));
                vacina.setTipo(rs.getString("tipo"));
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
    
    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtivo(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
