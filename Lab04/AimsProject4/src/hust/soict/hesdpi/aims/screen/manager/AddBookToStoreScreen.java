package hust.soict.hesdpi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hesdpi.aims.media.Book;
import hust.soict.hesdpi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemsToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText(); 
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());

            List<String> tacgia = new ArrayList<String>();
    		tacgia.add("higashino keigo");
    		Book book = new Book(5, title, category, cost, tacgia);
            store.addMedia(book);

            dispose();
            new StoreManagerScreen(store);
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.add(titleLabel);    panel.add(titleField);
        panel.add(categoryLabel); panel.add(categoryField);
        panel.add(costLabel);     panel.add(costField);
        panel.add(new JLabel());  panel.add(addButton);

        return panel;
    }
}