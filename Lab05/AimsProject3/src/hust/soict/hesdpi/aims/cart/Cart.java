package hust.soict.hesdpi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hesdpi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media item) {
        if(itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + "da co trong gio hang !");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " them thanh cong vao gio hang !");
        }
    }

    public void removeMedia(Media item) {
        if(itemsOrdered.contains(item)) {
            itemsOrdered.remove(item);
        } else {
            System.out.println(item.getClass().getSimpleName() + ' ' + item.getTitle() + " khong co tỏng gio hang !");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }
   //.isEmpty de khiem tra mang rong hay khong ??
    // .apnd de noi thong tin .
    public void printCart() {
        StringBuilder output = new StringBuilder("*************GIO HANG CUA BAN************************** \n");
        if(itemsOrdered.isEmpty()) {
            output.append("No time\n");
        } else {
            int i = 1;
            for (Media item : itemsOrdered) {
                output.append(i + ".[" + item.getTitle() + "] - [" + item.getCategory() + "] - "
                        + item.getCost() + " $\n");
                i++;
            }
        }
        output.append("Tong so tien can thanh toan: ").append(totalCost()).append(" $\n");
        output.append("================================================\n");
        System.out.println(output);
    }
    public void searchById(int i) {
        if(i > itemsOrdered.size()) {
            System.out.println("No match found !");
        } else {
            System.out.println("Result: " +  "[" + itemsOrdered.get(i-1).getTitle() +
                    "] - [" + itemsOrdered.get(i-1).getCategory() + "] -"
                    +  + itemsOrdered.get(i-1).getCost() + " $\n");
        }
    }

    public void searchByTitle(String title) {
        for(Media item : itemsOrdered) {
            if(item.getTitle().equals(title)) {
                System.out.println("Result: " +  "[" + item.getTitle() +
                        "] - [" + item.getCategory() + "] -"
                        +item.getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found");
    }
    public Media findMedia(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
    }
    public void emptyCart() {
        itemsOrdered.clear(); // Xóa toàn bộ các phần tử trong giỏ hàng
        System.out.println("Giỏ hàng đã được làm trống.");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
