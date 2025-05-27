package hust.soict.hesdpi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hesdpi.aims.media.DigitalVideoDisc;
import hust.soict.hesdpi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemsToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(8, 4 , 10, 10));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(); 

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();

        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            float cost = Float.parseFloat(costField.getText());
            int id = Integer.parseInt(idField.getText());
            DigitalVideoDisc dvd = new DigitalVideoDisc(id , title, category, cost, director, length);
            store.addMedia(dvd);

            dispose();
            new StoreManagerScreen(store);
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.add(idLabel);     panel.add(idField);
        panel.add(titleLabel);     panel.add(titleField);
        panel.add(categoryLabel);  panel.add(categoryField);
        panel.add(directorLabel);  panel.add(directorField);
        panel.add(lengthLabel);    panel.add(lengthField);
        panel.add(costLabel);      panel.add(costField);
        panel.add(new JLabel());   panel.add(addButton);

        return panel;
    }
}