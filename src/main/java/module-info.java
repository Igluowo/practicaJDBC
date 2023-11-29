module com.mycompany.practicajdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.practicajdbc to javafx.fxml;
    exports com.mycompany.practicajdbc;
    exports com.mycompany.practicajdbc.vistas;
}
