package gui;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button btMyButton;

    @FXML
    private Button btnAlert;

    @FXML
    public void onMyButtonClick() {
        System.out.println("Hello!");
    }


    public void onbtnAlertClickonbtnAlertClick(ActionEvent actionEvent) {
        Alerts.showAlert("Atenção", "Tenho algo a dizer!", "Não era nada", Alert.AlertType.INFORMATION);
    }
}