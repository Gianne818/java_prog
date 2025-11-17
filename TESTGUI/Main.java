package TESTGUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JButton button = new JButton("Click Me!");
        button.setBounds(100, 70, 100, 30);

        JLabel label = new JLabel("Hello, Swing!");
        label.setSize(50, 50);
        //label.setVisible(true);
        label.setBounds(100, 100, 100, 20);


        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText("Button Clicked!");
            }
        });

        frame.add(label);
        frame.add(button);

        frame.setLayout(null);

        frame.setVisible(true);
    }
}
