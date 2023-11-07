module com.crud.app.crudjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.crud.app.crudjavafx to javafx.fxml;
    exports com.crud.app.crudjavafx;
}