package com.example.contadorpessoas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;



public class HelloController {

    @FXML
    private Button btnConsultar;

    @FXML
    private Label lbAnoMaior;

    @FXML
    private Label lbDia;

    @FXML
    private Label lbDiaMaior;

    @FXML
    private Label lbMesMaior;

    @FXML
    private Label lbSemana;

    @FXML
    public void initialize() {
        try {
            // Obtém a quantidade de pessoas do dia atual
            int quantidadePessoasDiaAtual = Connection.getQuantidadePessoasDiaAtual();

            // Obtém a quantidade de pessoas da semana atual
            int quantidadePessoasSemanaAtual = Connection.getQuantidadePessoasSemanaAtual();

            // Define os valores nas labels
            lbDia.setText(String.valueOf(quantidadePessoasDiaAtual));
            lbSemana.setText(String.valueOf(quantidadePessoasSemanaAtual));

            // Obtém os valores do banco de dados
            String diaComMaiorContagem = Connection.getDiaComMaiorContagem();
            String mesComMaiorContagem = Connection.getMesComMaiorContagem();
            String anoComMaiorContagem = Connection.getAnoComMaiorContagem();

            // Define os valores nas outras labels
            lbDiaMaior.setText(diaComMaiorContagem);
            lbMesMaior.setText(mesComMaiorContagem);
            lbAnoMaior.setText(anoComMaiorContagem);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Trate as exceções conforme necessário
        }

    }
}
