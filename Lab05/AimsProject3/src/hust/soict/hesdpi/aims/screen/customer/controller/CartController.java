package hust.soict.hesdpi.aims.screen.customer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hesdpi.aims.cart.Cart;
import hust.soict.hesdpi.aims.media.Media;
import hust.soict.hesdpi.aims.media.Play;
import hust.soict.hesdpi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;

	public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Media, Integer> colMediaID;

	@FXML
	private Label costLabel;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	void f5efef(ActionEvent event) {

	}

	@FXML
	void btnOderClicked(ActionEvent event) {
		if (cart.getItemsOrdered().isEmpty()) {
			showAlert("Giỏ hàng trống!");
			return;
		}
		cart.getItemsOrdered().clear();
		tblMedia.setItems(cart.getItemsOrdered());
		updateTotalCost();
		showAlert("Đặt hàng thành công!");
	}

	private void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Thông báo");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
		if (selectedMedia != null) {
			PlayMediaController playMedia = new PlayMediaController(selectedMedia.getTitle());
			playMedia.show();
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		updateTotalCost();
	}

	@FXML
	void btnViewStorePressed(ActionEvent event) {
		try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hesdpi/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(store, cart));
			Parent root = fxmlLoader.load();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateTotalCost() {
		float total = 0;
		for (Media media : cart.getItemsOrdered()) {
			total += media.getCost();
		}
		costLabel.setText(String.format("%.1f$", total));
	}

	@FXML
	public void initialize() {
		colMediaID.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemsOrdered() != null)
			tblMedia.setItems(cart.getItemsOrdered());
		updateTotalCost();
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> obValue, Media oldMedia, Media newMedia) {
				updateButtonBar(newMedia);

			}

			private void updateButtonBar(Media Media) {
				if (Media == null) {
					btnPlay.setVisible(false);
					btnRemove.setVisible(false);
				} else {
					btnRemove.setVisible(true);
					if (Media instanceof Play) {
						btnPlay.setVisible(true);
					} else {
						btnPlay.setVisible(false);
					}
				}
			}
		});

	}

}