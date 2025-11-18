package GUI_JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("My JFrame");

        frame.setSize(400, 200);
        frame.setTitle("JFrame Sample");
       // frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(
                new JButton ("Save"),
                new JButton("Delete"),
                new JButton("Cancel")
        )
        );



        for (JButton button : buttons){
            frame.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(button.getText());
                    JOptionPane.showMessageDialog(frame, button.getText());
                }
            });
        }
        frame.setVisible(true);
    }

}

