package org.example.calcujavafxmarch28;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class HelloController {

    private Label welcomeText;
    private boolean hasBeenCLicked;
    public TextField tfAnswer;
    private int stored = 0;
    private boolean priorClickedWasAnOperator;
    private char priorOperator = '+';

    public void onBtnNumberClicked(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getSource();
        String num = btn.getText();
        if(tfAnswer.getText().equals("0") || priorClickedWasAnOperator){
            tfAnswer.setText(num);
            priorClickedWasAnOperator = false;
        } else {
            tfAnswer.setText(tfAnswer.getText() + num);
        }
    }

    public void onBtnClearClicked(ActionEvent event){
        tfAnswer.setText("0");
    }

    public void onBtnOperatorClicked(ActionEvent event){
        Button btn = (Button) event.getSource();
        if(priorClickedWasAnOperator){
            priorOperator = btn.getText().charAt(0);
            return;
        }

        priorClickedWasAnOperator = true;
        switch(priorOperator){
            case '+':
                stored += Integer.parseInt(tfAnswer.getText());
                break;
            case '-':
                stored -= Integer.parseInt(tfAnswer.getText());
                break;

            case '*':
                stored *= Integer.parseInt(tfAnswer.getText());
                break;

            case '/':
                try{
                    stored /= Integer.parseInt(tfAnswer.getText());
                } catch(ArithmeticException e){
                    tfAnswer.setText("Math error");
                    priorOperator = btn.getText().charAt(0);
                    return;
                }

                break;

        }
        tfAnswer.setText(stored + "");
        priorOperator = btn.getText().charAt(0);
    }
}
