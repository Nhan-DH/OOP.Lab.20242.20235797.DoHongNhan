/**
 * 
 */
/**
 * 
 */
module AimsProject3 {
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	opens hust.soict.hesdpi.aims.screen.customer.view to javafx.fxml;
    opens hust.soict.hesdpi.aims.screen.customer.controller to javafx.fxml;
    exports hust.soict.hesdpi.aims.screen.customer.controller;
    exports hust.soict.hesdpi.aims.media; 
    exports hust.soict.hesdpi.test.screen.customer.store;
    exports hust.soict.hesdpi.aims.screen.customer.view;
    exports hust.soict.hesdpi.aims.cart;
    exports hust.soict.hesdpi.aims;
    exports hust.soict.hesdpi.aims.screen.manager;
}