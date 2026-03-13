package hust.soict.hesdpi.aims.media;

public class DigitalVideoDisc extends Disc implements Play{
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, float length) {
		super(id, title, category, cost, director, length);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void play() {
        System.out.println("Phát DVD: " + this.getTitle());
        System.out.println("Độ dài DVD: " + this.getLength());
    }
	
	
}
