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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Agendamento;
import model.Laboratorio;
import model.PedidoCompra;
import model.Vacinas;

/**
 *
 * @author vitor
 */
public class PedidoCompraDAO implements IDao<PedidoCompra> {

    private Connection conexao;
    private PedidoCompra pedidoCompra = new PedidoCompra();

    public PedidoCompraDAO() throws SQLException, IOException {
        this.conexao = ConectaBancoDeDados.getConexaoMySQL();
    }

    @Override
    public void cadastrar(PedidoCompra p) throws SQLException {
        String sql = "Insert Into pedidoCompra (data, quantidadeVac, idLaboratorio, idVacinas, ativo) Values (?, ?, ?, ?, true)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setInt(2, p.getQuantidadeVac());
            stmt.setInt(3, p.getLaboratorio().getId());
            stmt.setInt(4, p.getVacinas().getId());
            //executa o código
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public void atualizar(PedidoCompra p) throws SQLException {
        String sql = "Update pedidoCompra set data = ?, quantidadeVac = ?, "
                + "idLaboratorio = ?, idVacinas = ? where id=?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            //seta os valores
            stmt.setDate(1, new java.sql.Date(p.getData().getTime()));
            stmt.setInt(2, p.getQuantidadeVac());
            stmt.setInt(3, p.getLaboratorio().getId());
            stmt.setInt(4, p.getVacinas().getId());
            stmt.setInt(5, p.getId());
            //executa o código
            stmt.executeUpdate();
            stmt.close();
        }
    }

    @Override
    public List<PedidoCompra> listar() throws SQLException, ClassNotFoundException {
        List<PedidoCompra> pedidoCompras = new ArrayList<PedidoCompra>();
        String query = "SELECT * FROM pedidoCompra";
        try {

            // execute the query, and get a java resultset
            try (Statement st = conexao.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    PedidoCompra pedidoCompra = new PedidoCompra();
                    pedidoCompra.setId(rs.getInt("id"));
                    pedidoCompra.setData(java.sql.Date.valueOf(rs.getString("data")));
                    pedidoCompra.setQuantidadeVac(rs.getInt("quantidadeVac"));
                    pedidoCompra.setLaboratorio(new Laboratorio(rs.getInt("idLaboratorio")));
                    pedidoCompra.setVacinas(new Vacinas(rs.getInt("idVacinas")));
                    pedidoCompra.setAtivo(rs.getBoolean("ativo"));
                    pedidoCompras.add(pedidoCompra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoCompras;
    }

    @Override
    public PedidoCompra buscar(int pedidoId) throws SQLException {
        String query = "SELECT * FROM pedidoCompra where id=" + pedidoId;
        try {

            Statement st = conexao.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()) {

                pedidoCompra.setId(Integer.valueOf(rs.getString("id")));
                pedidoCompra.setData(java.sql.Date.valueOf(rs.getString("data")));
                pedidoCompra.setQuantidadeVac(Integer.valueOf(rs.getString("quantidadeVac")));
                pedidoCompra.setLaboratorio(new Laboratorio(rs.getInt("idLaboratorio")));
                pedidoCompra.setVacinas(new Vacinas(rs.getInt("idVacinas")));
                pedidoCompra.setAtivo(Boolean.valueOf(rs.getString("ativo")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoCompra;
    }

    @Override
    public void excluir(int idPedido) throws SQLException {
        String sql = "update pedidoCompra set ativo=false where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idPedido);
        stmt.execute();
        stmt.close();
    }

    @Override
    public int selectID(PedidoCompra p) throws SQLException {
        String query = "SELECT id FROM pedidoCompra where id=" + p.getId();
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
    public void setAtivo(int idPedido) throws SQLException {
        String sql = "update pedidoCompra set ativo=true where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idPedido);
        stmt.execute();
        stmt.close();
    }

}
