module com.example.segumiento1programacion3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.segumiento1programacion3 to javafx.fxml;
    exports com.example.segumiento1programacion3;
}