// DataAtual.java
package com.example.contadorpessoas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataAtual {
    public static void main(String[] args) {
        //System.out.println(obterDataAtual());
    }

    public static String obterDataAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return agora.format(formato);
    }
}
