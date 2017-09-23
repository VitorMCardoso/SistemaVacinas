/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaoBanco;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author vitor
 */
public class ConectaBancoDeDados {

    //Início da classe de conexão//
    public static String status = "Não conectou...";

//Método Construtor da Classe//
    public ConectaBancoDeDados() {

    }

//Método de Conexão//
    public static java.sql.Connection getConexaoMySQL() throws IOException {

        Connection connection = null;          //atributo do tipo Connection
        try {

            Properties prop = new Properties();
            InputStream inputStream = ConectaBancoDeDados.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(inputStream);
// Carregando o JDBC Driver padrão
            String driverName = prop.getProperty("driverName");
            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");        //nome de um usuário de seu BD      
            String password = prop.getProperty("password");     //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");

            }
            return connection;

        } catch (ClassNotFoundException e) {
            //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
//Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() throws IOException {

        try {
            ConectaBancoDeDados.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {

            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() throws IOException {

        FecharConexao();
        return ConectaBancoDeDados.getConexaoMySQL();
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
