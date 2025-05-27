package hust.soict.hedspi.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete = new JButton("DEL");
    private JButton btnReset = new JButton("C");
    private JTextField tfDisplay = new JTextField();

    public NumberGrid() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(400, 400);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        panel.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        panel.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String buttonText = evt.getActionCommand();

            if (buttonText.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (buttonText.equals("C")) {
                tfDisplay.setText("");
            } else {
                tfDisplay.setText(tfDisplay.getText() + buttonText);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}