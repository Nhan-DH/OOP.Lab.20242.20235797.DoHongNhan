package hust.soict.hesdpi.aims.screen.customer.controller;


import javafx.event.ActionEvent;

import java.io.IOException;

import hust.soict.hesdpi.aims.cart.Cart;
import hust.soict.hesdpi.aims.media.Media;
import hust.soict.hesdpi.aims.media.Play;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

	@FXML
	void btnAddToCartClicked(ActionEvent event) {
        if (media != null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " đã được thêm vào giỏ hàng.");
        }
    }	
	@FXML
	void btnPlayClicked(ActionEvent event) {
	    String mediaTitle = lblTitle.getText(); // Lấy text từ Label lblTitle
	    PlayMediaController playMedia = new PlayMediaController(mediaTitle);
	    playMedia.show();
	}

	
    private Media media;
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(String.valueOf(media.getCost()+"$"));
        if(media instanceof Play) {
        	btnPlay.setVisible(true);
        }
        else {
        	btnPlay.setVisible(false);
        	HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
        }
    
    }
}
