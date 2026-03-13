package hust.soict.hesdpi.test.screen.customer.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hesdpi.aims.cart.Cart;
import hust.soict.hesdpi.aims.media.Book;
import hust.soict.hesdpi.aims.media.CompactDisc;
import hust.soict.hesdpi.aims.media.DigitalVideoDisc;
import hust.soict.hesdpi.aims.media.Track;
import hust.soict.hesdpi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hesdpi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/hust/soict/hesdpi/aims/screen/customer/view/Store.fxml"));
			ViewStoreController controller = new ViewStoreController(store, cart);
			loader.setController(controller);
			Parent root = loader.load();
			primaryStage.setTitle("Store");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		store = new Store();
		cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "bach tuyet va 7 chu lun", "hoat hinh", 100.0f, "an danh", 90);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "natra", "hoat hinh", 100.0f, "an danh", 90);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(5, "conan", "hoat hinh", 150.0f, "an danh", 90);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(6, "doraemon", "hoat hinh", 123.0f, "an danh", 90);

		store.addMedia(dvd1);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
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
		cart.addMedia(book);
		cart.addMedia(dvd1);
		launch(args);
	}
}
