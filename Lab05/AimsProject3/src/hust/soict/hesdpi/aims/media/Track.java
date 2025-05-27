package hust.soict.hesdpi.aims.media;

public class Track {
    private String title;
    private int length;

    public int getLength() { return length; }

    public String getTitle() { return title; }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public boolean equals(Track tenbanghi) {
        return (title == tenbanghi.getTitle()) && (length == tenbanghi.getLength());
    }

    public void play() {
        System.out.println("Phát track: " + this.title);
        System.out.println("Độ dài track: " + this.length);
    }
}
