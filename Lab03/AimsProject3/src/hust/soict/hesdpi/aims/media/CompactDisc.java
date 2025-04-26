package hust.soict.hesdpi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Play{
	
	private String artist;
    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	private ArrayList<Track> tracks;
    public void play() {
        System.out.println("Phát CD: " + this.getTitle());
        System.out.println("Nghệ sĩ: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
}
}
