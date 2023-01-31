module csci205_final_project{
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports org.bankscanner.Application;
    opens org.bankscanner.Application to javafx.fxml;

    exports org.bankscanner.Quarter;
    opens org.bankscanner.Quarter to javafx.fxml;
}