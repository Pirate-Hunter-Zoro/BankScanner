package org.bankscanner.Application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextField bankFieldNumericInput;

    @FXML
    private Label bankFieldNumericInputLabel;

    @FXML
    private Label bankFieldNumericInputLabel1;

    @FXML
    private Label bankFieldNumericInputLabel11;

    @FXML
    private TextField bankNumericRangeInput;

    @FXML
    private TextArea banksOutput;

    @FXML
    private Label banksOutputLabel;

    @FXML
    private TextField categoricalBankFieldInput;

    @FXML
    private TextField categoricalParentFieldInput;

    @FXML
    private Label categoricalParentFieldInputLabel;

    @FXML
    private Button clearButton;

    @FXML
    private TextField endQuarterInput;

    @FXML
    private Label endQuarterLabel;

    @FXML
    private Label nonNumericBankFieldInputLabel;

    @FXML
    private TextField parentFieldNumericInput;

    @FXML
    private Label parentFieldNumericInputLabel;

    @FXML
    private TextField parentNumericRangeInput;

    @FXML
    private TextArea parentsOutput;

    @FXML
    private Label parentsOutputLabel;

    @FXML
    private Button searchButton;

    @FXML
    private TextField startQuarterInput;

    @FXML
    private Label startQuarterLabel;

    @FXML
    void initialize() {
        assert backgroundImage != null : "fx:id=\"backgroundImage\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert bankFieldNumericInput != null : "fx:id=\"bankFieldNumericInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert bankFieldNumericInputLabel != null : "fx:id=\"bankFieldNumericInputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert bankFieldNumericInputLabel1 != null : "fx:id=\"bankFieldNumericInputLabel1\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert bankFieldNumericInputLabel11 != null : "fx:id=\"bankFieldNumericInputLabel11\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert bankNumericRangeInput != null : "fx:id=\"bankNumericRangeInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert banksOutput != null : "fx:id=\"banksOutput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert banksOutputLabel != null : "fx:id=\"banksOutputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert categoricalBankFieldInput != null : "fx:id=\"categoricalBankFieldInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert categoricalParentFieldInput != null : "fx:id=\"categoricalParentFieldInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert categoricalParentFieldInputLabel != null : "fx:id=\"categoricalParentFieldInputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert endQuarterInput != null : "fx:id=\"endQuarterInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert endQuarterLabel != null : "fx:id=\"endQuarterLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert nonNumericBankFieldInputLabel != null : "fx:id=\"nonNumericBankFieldInputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert parentFieldNumericInput != null : "fx:id=\"parentFieldNumericInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert parentFieldNumericInputLabel != null : "fx:id=\"parentFieldNumericInputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert parentNumericRangeInput != null : "fx:id=\"parentNumericRangeInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert parentsOutput != null : "fx:id=\"parentsOutput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert parentsOutputLabel != null : "fx:id=\"parentsOutputLabel\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert startQuarterInput != null : "fx:id=\"startQuarterInput\" was not injected: check your FXML file 'appScreen.fxml'.";
        assert startQuarterLabel != null : "fx:id=\"startQuarterLabel\" was not injected: check your FXML file 'appScreen.fxml'.";

    }

}