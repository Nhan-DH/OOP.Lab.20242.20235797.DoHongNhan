package hust.soict.hesdpi.aims.media;

import java.util.Comparator;

public class SapXepTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getTitle().compareTo(o2.getTitle()) != 0) {
            return o1.getTitle().compareTo(o2.getTitle());
        } else {
            if(o1.getCost() > o2.getCost()) return 1;
            else return -1;
        }
    }
}
