package hust.soict.hesdpi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	// .constain : kiem tra xem 1 phan tu co trong 1 tap hop hay khong ??
	// .add va .remove la them va xoa 1 phan tu ra khoi list .
	 public void themTG(String ten) {
	        if(authors.contains(ten)) {
	            System.out.println(ten + "Đã có trong list !");
	        } else {
	            authors.add(ten);
	        }
	    }

	    public void xoaTG(String ten) {
	    	
	        if(authors.contains(ten)) {
	            authors.remove(ten);
	        } else {
	            System.out.println(ten + "không có tỏng list !");
	        }
	    }
	    public String toString() {
	        StringBuilder print = new StringBuilder("Book: " +
	                " [id=" + getId() +
	                ", title='" + getTitle() + '\'' +
	                ", category='" + getCategory() + '\'' +
	                ", authors: ");
	        for(String a : authors) {
	            print.append(a);
	            print.append(" ");
	        }
	        print.append(", cost: ");
	        print.append(getCost());
	        print.append("$]");
	        return print.toString();
	    }

}
