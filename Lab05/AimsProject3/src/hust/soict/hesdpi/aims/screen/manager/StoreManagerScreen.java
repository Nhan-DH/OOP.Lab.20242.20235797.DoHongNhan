package hust.soict.hesdpi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hesdpi.aims.cart.Cart;
import hust.soict.hesdpi.aims.media.Book;
import hust.soict.hesdpi.aims.media.CompactDisc;
import hust.soict.hesdpi.aims.media.DigitalVideoDisc;
import hust.soict.hesdpi.aims.media.Media;
import hust.soict.hesdpi.aims.media.Track;
import hust.soict.hesdpi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;

	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout()); 

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
 
		setTitle("Store cua Nhan");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;

	}

	JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(viewStoreItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		title.setForeground(Color.BLUE);
		title.setLayout(new FlowLayout(FlowLayout.CENTER));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());

		return header;
	}

 JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3));

		LinkedList<Media> mediaInStore = store.getItemsInStore();
		for (Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media);
			center.add(cell);
		}

		return center;
	}

	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "bach tuyet va 7 chu lun", "hoat hinh", 100.0f, "an danh", 90);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "natra", "hoat hinh", 100.0f, "an danh", 90);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		ArrayList<Track> banghi = new ArrayList<Track>();
		banghi.add(new Track("lao tam kho tu", 3));
		banghi.add(new Track("dung nguoi dung thoi diem", 4));
		banghi.add(new Track("tung yeu ca 1 thanh pho", 5));
		CompactDisc cd = new CompactDisc(3, "tinh yeu", "nhac tre", 50.0f, "Thanh Hung", banghi);
		store.addMedia(cd);
		List<String> tacgia = new ArrayList<String>();
		tacgia.add("nguyen nhat anh");
		tacgia.add("higashino keigo");
		Book book = new Book(4, "mat biec", "tinh cam", 100.f, tacgia);
		store.addMedia(book);
		Cart cart = new Cart();
		cart.addMedia(book);
		cart.addMedia(dvd1);
		new StoreManagerScreen(store);
	}
}
