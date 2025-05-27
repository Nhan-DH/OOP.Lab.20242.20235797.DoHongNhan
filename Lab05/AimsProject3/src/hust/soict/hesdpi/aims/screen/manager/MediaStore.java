package hust.soict.hesdpi.aims.screen.manager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hust.soict.hesdpi.aims.media.Media;
import hust.soict.hesdpi.aims.media.Play;

public class MediaStore extends JPanel {
	private Media media;
    public MediaStore(Media media) {
    	this.setMedia(media); 
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createEmptyBorder(5,5,5,5), 
        		BorderFactory.createLineBorder(Color.GRAY))
        		);
        JLabel cost = new JLabel("Price : " + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        
   
        if (media instanceof Play) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(e -> {
                JDialog dialog = new JDialog();
                dialog.setTitle("Playing Media");
                JTextArea area = new JTextArea();
                area.setEditable(false);
                dialog.add(area);
                dialog.setSize(300, 200);
                dialog.setVisible(true);
            });
           
            this.add(playButton);
            
        }
        
    }
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
}