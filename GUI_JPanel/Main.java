package GUI_JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("JFrame with JPanel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Click any below");
        topPanel.add(label);
        topPanel.setBackground(Color.lightGray);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(Color.DARK_GRAY);

        ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(
                new JButton ("Save"),
                new JButton("Delete"),
                new JButton("Cancel")
        )
        );


        for (JButton button : buttons){
            bottomPanel.add(button);
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println(button.getText());

                    JWindow window = new JWindow();
                    window.setLayout(null);
                    //JLabel label = new JLabel(button.getText(), SwingConstants.CENTER);
                    String text = button.getText();
                    label.setText("<html><center><h4><style = 'font-weight:bold';>User Action</font></h4>" + text + "</center></html>");

                    int windowWidth = 300;
                    int windowHeight = 100;
                    int labelWidth = 80;
                    int labelHeight = 60;

                    // Center the label
                    int labelX = (windowWidth - labelWidth) / 2;
                    int labelY = (windowHeight - labelHeight) / 2;
                    label.setBounds(labelX, labelY, labelWidth, labelHeight);

                    window.add(label);
                    window.setSize(300, 100);
                    window.setLocationRelativeTo(null);
                    window.setBackground(new Color(255,255, 255, 200));

                    JButton closeButton = new JButton("X");
                    closeButton.setSize(30, 30);
                    closeButton.setBounds(10, 10, 20, 20);
                    closeButton.addActionListener(e2 -> window.dispose());

                    window.add(closeButton);
                    window.setVisible(true);

                }
            });
        }
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}
