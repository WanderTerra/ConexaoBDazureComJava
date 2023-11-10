module com.example.contadorpessoas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.contadorpessoas to javafx.fxml;
    exports com.example.contadorpessoas;
}