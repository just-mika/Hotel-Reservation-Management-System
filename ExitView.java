import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExitView {
    private JFrame mainFrame;
    private JLabel titleLbl;
    private ImageIcon titleImageIcon, logoImageIcon;

    public ExitView(){
        this.mainFrame = new JFrame("Exit Screen");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("HRS Title_ExitProgram.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        logoImageIcon = new ImageIcon(getClass().getResource("HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

        this.mainFrame.add(titleLbl);
    }

    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }
    
}
