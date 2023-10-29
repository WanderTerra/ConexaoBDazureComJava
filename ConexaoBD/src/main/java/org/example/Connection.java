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
            ResultSet rsregistropython = conexao.createStatement().executeQuery("SELECT * FROM registropython");
            while(rsregistropython.next())
            {
                System.out.println("Data: " + rsregistropython.getString("data_hora"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados nao encontrado.");
        } finally {
            if (conexao != null) {
                conexao.close();
            }

        }
    }

  }

