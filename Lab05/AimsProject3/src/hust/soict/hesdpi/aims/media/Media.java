package hust.soict.hesdpi.aims.media;

import java.util.Comparator;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new SapXepTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new SapXepCostTitle();
	private int id;
    private String title;
    private String category;
    private float cost;
    
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Media [id =" + id + ", tieu de la :" + title + ", the loai la :" + category + " va gia la: " + cost + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
