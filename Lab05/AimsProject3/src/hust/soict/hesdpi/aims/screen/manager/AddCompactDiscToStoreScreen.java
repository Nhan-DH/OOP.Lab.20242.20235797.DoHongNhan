package hust.soict.hesdpi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hesdpi.aims.media.CompactDisc;
import hust.soict.hesdpi.aims.media.Track;
import hust.soict.hesdpi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemsToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String artist = artistField.getText();
            float cost = Float.parseFloat(costField.getText());
            ArrayList<Track> banghi = new ArrayList<Track>();
    		banghi.add(new Track("lao tam kho tu", 3)); 
    		banghi.add(new Track("dung nguoi dung thoi diem", 4));
    		banghi.add(new Track("tung yeu ca 1 thanh pho", 5));
            CompactDisc cd = new CompactDisc(WIDTH, title, category, cost, artist, banghi);
            store.addMedia(cd);

            dispose();
            new StoreManagerScreen(store);
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.add(titleLabel);    panel.add(titleField);
        panel.add(categoryLabel); panel.add(categoryField);
        panel.add(artistLabel);   panel.add(artistField);
        panel.add(costLabel);     panel.add(costField);
        panel.add(new JLabel());  panel.add(addButton);

        return panel;
    }
}
