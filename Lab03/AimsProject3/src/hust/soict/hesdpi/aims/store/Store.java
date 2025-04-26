package hust.soict.hesdpi.aims.store;

import java.util.LinkedList;

import hust.soict.hesdpi.aims.media.Media;

public class Store {
    private LinkedList<Media> itemsInStore = new LinkedList<Media>();

    private boolean checkMedia(Media disc) {
        for (Media item : itemsInStore) {
            if (item.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public Media findMedia(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public LinkedList<Media> getItemsInStore() { return itemsInStore; }

    public void removeMedia(Media disc) {
        if(checkMedia(disc)) {
            itemsInStore.remove(disc);
            System.out.println( disc.getTitle() + " 've been deleted from the store !");
        } else {
            System.out.println("There is no "+ disc.getTitle() + " in the store !");
        }
    }

    public void addMedia(Media disc) {
        if(!checkMedia(disc)) {
            itemsInStore.add(disc);
            System.out.println( disc.getTitle() + " Đã thêm vào kho!");
        } else {
            System.out.println( disc.getTitle() + "Đã có trong kho !");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\n**********STORE***************\n sản phẩm trong kho : \n");
        if(itemsInStore.isEmpty()) string.append("Kho trống !\n");
        else {
            for (Media item : itemsInStore) {
                string.append(item.getTitle() + " - " + item.getCost() + " $\n");
            }
        }
        string.append("*********************************\n");
        return string.toString();
    }
}