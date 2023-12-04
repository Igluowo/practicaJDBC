module com.mycompany.practicajdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.practicajdbc.vistas to javafx.fxml;
    exports com.mycompany.practicajdbc;
    exports com.mycompany.practicajdbc.vistas;
}
