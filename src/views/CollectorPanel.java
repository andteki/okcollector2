package views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CollectorPanel extends JPanel {
    public JButton pasteFromClipBoardButton;
    public JButton startButton;
    public JButton aboutButton;
    public JButton exitButton;
    
    public CollectorPanel() {
        initCollectorPanel();
    }

    private void initCollectorPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        pasteFromClipBoardButton = new JButton("Beillesztés");
        startButton = new JButton("Start");
        aboutButton = new JButton("Névjegy");
        exitButton = new JButton("Kilépés");

        this.add(pasteFromClipBoardButton);
        this.add(startButton);
        this.add(aboutButton);
        this.add(exitButton);        
    }
}
