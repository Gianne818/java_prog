package org.example.cruz_la6_gui.item_9;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GeographyQuizController {
    public Button backButton;
    public Button nextButton;

    public Label scoreLabel;

    public TextField question1TextField;
    public TextField question2TextField;
    public TextField question3TextField;
    public ArrayList<TextField> textFields = new ArrayList<>();

    public VBox panel1;
    public VBox panel2;
    public VBox panel3;
    public VBox panel4;
    public ArrayList<VBox> panels = new ArrayList<>();

    private int curScore = 0;
    private int curPanel = 0;

    public void initialize(){
        panels.add(panel1);
        panels.add(panel2);
        panels.add(panel3);
        panels.add(panel4);

        textFields.add(question1TextField);
        textFields.add(question2TextField);
        textFields.add(question3TextField);
    }

    private void scorer(){
        curScore = 0;
        String[] answers = {"Paris", "Tokyo", "Berlin"};
        for(int i = 0; i<3; i++){
            String ans = textFields.get(i).getText();
            if(ans.equalsIgnoreCase(answers[i])){
                curScore++;
            }
        }
    }

    public void onNextBtnClick(ActionEvent event){
       scorer();

        if(curPanel < panels.size()-1){
            panels.get(curPanel).setVisible(false);
            panels.get(curPanel).setManaged(false);
            curPanel++;
            panels.get(curPanel).setVisible(true);
            panels.get(curPanel).setManaged(true);
        }

        if(curPanel==panels.size()-1) {
            nextButton.setVisible(false);
        }

        if(curPanel!=0){
            backButton.setVisible(true);
        }
        scoreLabel.setText(curScore + "/3");

    }

    public void onBackBtnClick(ActionEvent event){
        scorer();

        if(curPanel > 0){
            panels.get(curPanel).setVisible(false);
            panels.get(curPanel).setManaged(false);
            curPanel--;
            panels.get(curPanel).setVisible(true);
            panels.get(curPanel).setManaged(true);
        }

        if(curPanel!=panels.size()-1){
            nextButton.setVisible(true);
        }
        if(curPanel==0){
            backButton.setVisible(false);
        }

        scoreLabel.setText(curScore + "/3");
    }

}
