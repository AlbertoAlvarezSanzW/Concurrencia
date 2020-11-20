package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller implements Hilo.Callback {

    @FXML
    private TextField idTextField;

    @FXML
    private Label idLabel;

    @FXML
    private void onBotonClicked(){
        idLabel.setText("");
        Hilo s = new Hilo(idTextField.getText(), this);
        s.start();
    }


    @Override
    public void updateText(Character character) {
        Platform.runLater(new ThreadUi(character));
    }


    public class ThreadUi extends Thread {
        private final Character character;
        public ThreadUi (Character character){
            this.character = character;
        }
        @Override
        public void run() {
            idLabel.setText(idLabel.getText() + character);
        }
    }
}
