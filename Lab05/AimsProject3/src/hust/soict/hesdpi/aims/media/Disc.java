package hust.soict.hesdpi.aims.media;

public class Disc extends Media {
	private String director;
    private float length;
	public Disc(int id, String title, String category, float cost, String director, float length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
}
