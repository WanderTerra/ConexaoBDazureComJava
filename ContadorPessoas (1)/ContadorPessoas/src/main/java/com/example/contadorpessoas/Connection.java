
package com.example.contadorpessoas;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.contadorpessoas.DataAtual.obterDataAtual;


public class Connection {
    private static final String URL = "jdbc:mysql://bdcontador-pessoas.mysql.database.azure.com:3306/contadorpessoas";
    private static final String USERNAME = "wanderley";
    private static final String PASSWORD = "Java&claudio";

    public static int getQuantidadePessoasSemanaAtual() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) AS Quantidade FROM registropython WHERE YEARWEEK(data_hora, 1) = YEARWEEK(NOW(), 1)";

        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("Quantidade");
            } else {
                return 0; // Retorna 0 se não houver dados para a semana atual
            }
        }
    }

    public static String getDiaComMaiorContagem() throws SQLException, ClassNotFoundException {
        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            ResultSet rs = conexao.createStatement().executeQuery("SELECT DATE_FORMAT(data_hora, '%d/%m/%y') AS DiaComMaiorContagem, COUNT(*) AS Contagem FROM registropython GROUP BY DiaComMaiorContagem ORDER BY Contagem DESC LIMIT 1");
            if (rs.next()) {
                return rs.getString("DiaComMaiorContagem");
            } else {
                return "N/A";
            }
        }
    }

    public static int getQuantidadePessoasDiaAtual() throws SQLException, ClassNotFoundException {
        String dataAtual = obterDataAtual();

        String sql = "SELECT COUNT(*) AS Quantidade FROM registropython WHERE DATE(data_hora) = ?";

        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, dataAtual);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Quantidade");
                } else {
                    return 0; // Retorna 0 se não houver dados para o dia atual
                }
            }
        }
    }


    public static String getMesComMaiorContagem() throws SQLException, ClassNotFoundException {
        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            ResultSet rs = conexao.createStatement().executeQuery("SELECT DATE_FORMAT(data_hora, '%m/%Y') AS MesComMaiorContagem, COUNT(*) AS Contagem FROM registropython GROUP BY MesComMaiorContagem ORDER BY Contagem DESC LIMIT 1");
            if (rs.next()) {
                return rs.getString("MesComMaiorContagem");
            } else {
                return "N/A";
            }
        }
    }

    public static String getAnoComMaiorContagem() throws SQLException, ClassNotFoundException {
        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            ResultSet rs = conexao.createStatement().executeQuery("SELECT DATE_FORMAT(data_hora, '%Y') AS AnoComMaiorContagem, COUNT(*) AS Contagem FROM registropython GROUP BY AnoComMaiorContagem ORDER BY Contagem DESC LIMIT 1");
            if (rs.next()) {
                return rs.getString("AnoComMaiorContagem");
            } else {
                return "N/A";
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String dataInicio = "2023-11-01"; // Defina a data de início do intervalo
        String dataFim = "2023-11-09"; // Defina a data de fim do intervalo

        int quantidadeNoIntervalo = getQuantidadePessoasNoIntervalo(dataInicio, dataFim);

        System.out.println("Quantidade de pessoas no intervalo: " + quantidadeNoIntervalo);
    }


    public static int getQuantidadePessoasNoIntervalo(String dataInicio, String dataFim) throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) AS Quantidade FROM registropython WHERE DATE(data_hora) BETWEEN ? AND ?";

        try (java.sql.Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, dataInicio);
            statement.setString(2, dataFim);

            //System.out.println("SQL: " + statement.toString()); // Adicione esta linha para depurar a consulta SQL

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Quantidade");
                } else {
                    return 0; // Retorna 0 se não houver dados no intervalo de tempo
                }
            }
        }
    }
}








