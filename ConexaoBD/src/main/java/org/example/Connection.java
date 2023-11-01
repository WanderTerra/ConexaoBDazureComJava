package org.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Connection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        java.sql.Connection conexao = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://bdcontador-pessoas.mysql.database.azure.com:3306/contadorpessoas", "wanderley", "Java&claudio");
            // Consulta SQL para encontrar o dia com a maior contagem
            ResultSet rs = conexao.createStatement().executeQuery(
                    "SELECT DATE_FORMAT(data_hora, '%d/%m/%y') AS DiaComMaiorContagem, COUNT(*) AS Contagem " +
                            "FROM registropython " +
                            "GROUP BY DiaComMaiorContagem " +
                            "ORDER BY Contagem DESC " +
                            "LIMIT 1"
            );

            if (rs.next()) {
                String dayWithMaxCount = rs.getString("DiaComMaiorContagem");
                int maxCount = rs.getInt("Contagem");

                System.out.println("Dia com a maior contagem: " + dayWithMaxCount + " com uma contagem de " + maxCount);
            } else {
                System.out.println("Nenhum dado encontrado.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://bdcontador-pessoas.mysql.database.azure.com:3306/contadorpessoas", "wanderley", "Java&claudio");
            // Consulta SQL para encontrar o dia com a maior contagem
            ResultSet rs = conexao.createStatement().executeQuery(
                    "SELECT DATE_FORMAT(data_hora, '%m/%Y') AS MesComMaiorContagem, COUNT(*) AS Contagem " +
                            "FROM registropython " +
                            "GROUP BY MesComMaiorContagem " +
                            "ORDER BY Contagem DESC " +
                            "LIMIT 1"
            );

            if (rs.next()) {
                String MonthWithMaxCount = rs.getString("MesComMaiorContagem");
                int maxCount = rs.getInt("Contagem");

                System.out.println("Mês com a maior contagem: " + MonthWithMaxCount + " com uma contagem de " + maxCount);
            } else {
                System.out.println("Nenhum dado encontrado.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://bdcontador-pessoas.mysql.database.azure.com:3306/contadorpessoas", "wanderley", "Java&claudio");
            // Consulta SQL para encontrar o dia com a maior contagem
            ResultSet rs = conexao.createStatement().executeQuery(
                    "SELECT DATE_FORMAT(data_hora, '%Y') AS AnoComMaiorContagem, COUNT(*) AS Contagem " +
                            "FROM registropython " +
                            "GROUP BY AnoComMaiorContagem " +
                            "ORDER BY Contagem DESC " +
                            "LIMIT 1"
            );

            if (rs.next()) {
                String YearWithMaxCount = rs.getString("AnoComMaiorContagem");
                int maxCount = rs.getInt("Contagem");

                System.out.println("Ano com a maior contagem: " + YearWithMaxCount + " com uma contagem de " + maxCount);
            } else {
                System.out.println("Nenhum dado encontrado.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




