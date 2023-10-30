package org.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                    "SELECT DAY(data_hora) AS DiaComMaiorContagem, COUNT(*) AS Contagem " +
                            "FROM registropython " +
                            "GROUP BY DAY(data_hora) " +
                            "ORDER BY Contagem DESC " +
                            "LIMIT 1"
            );

            if (rs.next()) {
                int dayWithMaxCount = rs.getInt("DiaComMaiorContagem");
                int maxCount = rs.getInt("Contagem");

                System.out.println("Dia com a maior contagem: Dia " + dayWithMaxCount + " com uma contagem de " + maxCount);
            } else {
                System.out.println("Nenhum dado encontrado.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado.");
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




