// HelloApplication.java
package com.example.contadorpessoas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("telaInicialUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 421, 372);
        stage.setTitle("Consulta de Dados");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("DataBase não encontrado!");
        }

        String dataInicio = "2023-11-01"; // Defina a data de início do intervalo
        String dataFim = "2023-11-09"; // Defina a data de fim do intervalo

        try {
            int quantidadeNoIntervalo = Connection.getQuantidadePessoasNoIntervalo(dataInicio, dataFim);
            System.out.println("Quantidade de pessoas no intervalo: " + quantidadeNoIntervalo);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        launch();
    }
}
