package org.example.cruz_la6_gui.item_2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PizzaOrderController {

    public ChoiceBox<String> pizzaSizeChoice;
    public ChoiceBox<String> pizzaToppingsChoice;
    public ChoiceBox<String> extraCheeseChoice;

    public Label totalLabel;

    private int total = 0;

   public void initialize(){
       pizzaSizeChoice.setItems(FXCollections.observableArrayList("Small", "Medium", "Large"));
       pizzaSizeChoice.setValue("Medium");
       pizzaToppingsChoice.setItems(FXCollections.observableArrayList("Mushroom", "Pepperoni", "Onions"));
       pizzaToppingsChoice.setValue("Mushroom");
       extraCheeseChoice.setItems(FXCollections.observableArrayList("No", "Yes"));
       extraCheeseChoice.setValue("No");
   }

   public void onBtnClick(ActionEvent event){
       total = 0;
       char s = pizzaSizeChoice.getValue().charAt(0);
       switch(s){
           case 'S':
               total+=10;
               break;

           case 'M':
               total+=15;
               break;

           case 'L':
               total+=20;
               break;
       }

       total+=2;

       char cheese = extraCheeseChoice.getValue().charAt(0);
       if(cheese=='Y') total+=3;

       totalLabel.setText(total + "");

   }

}
