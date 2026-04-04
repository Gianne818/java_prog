package org.example.cruz_la6_gui.item_1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NumberCounterController {

    public Button increaseButton;
    public Button decreaseButton;
    public Label countLabel;

    private int curCount = 0;

    public void onBtnClick(ActionEvent event){
        Button btn = (Button)event.getSource();
        if(btn.getText().equals("Increase")){
            curCount++;
        } else {
            curCount--;
        }
        countLabel.setText(curCount + "");
    }
}
