import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionListener;

public class CreateHotelView {
    private JFrame mainFrame;
    private JLabel nameLbl, titleLbl, feedbackLbl;
    private JTextField nameTxt;
    private JButton addBtn, backBtn;
    private JTextArea hotelListTA;
    private ImageIcon titleImageIcon, logoImageIcon;
    
    public CreateHotelView(){
        this.mainFrame = new JFrame("Create Hotel");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("HRS Title_CreateHotel.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        this.feedbackLbl = new JLabel(""); //delete text
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.BOLD,15));

        logoImageIcon = new ImageIcon(getClass().getResource("HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

        this.hotelListTA = new JTextArea(50,100);
        this.hotelListTA.setPreferredSize(new Dimension(330, 150));
        this.hotelListTA.setEditable(false);
	this.hotelListTA.setLineWrap(true);
        this.hotelListTA.setWrapStyleWord(true);
	    
        JScrollPane scroll = new JScrollPane(hotelListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(330, 150));

        this.nameLbl = new JLabel("Enter Name: ");
        this.nameTxt = new JTextField();
        this.nameTxt.setColumns(20);
        this.nameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.nameTxt.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.addBtn = new JButton("Add");
        this.addBtn.setPreferredSize(new Dimension(220, 30));
        this.addBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(new Dimension(220, 30));
        this.backBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(this.nameLbl);
        mainPanel.add(this.nameTxt);
        mainPanel.setPreferredSize(new Dimension(620, 50));
        

        //add panel to confirm hotel name
        this.mainFrame.add(titleLbl);
        this.mainFrame.add(mainPanel);
        this.mainFrame.add(feedbackLbl);
        this.mainFrame.add(addBtn);
        this.mainFrame.add(backBtn);
        this.mainFrame.add(scroll);



    }

    //actionListeners
    public void addBtnAL(ActionListener al){
        this.addBtn.addActionListener(al);
    }

    public void setHotelListTA(String text) {
		this.hotelListTA.setText(text);
	}

    public void backToMainAL(ActionListener al){
        this.backBtn.addActionListener(al);
    }

    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }
    

    //feedbackLbl 
    public void setFeedbackLbl(String text){
        this.feedbackLbl.setText(text);
    }

    //get hotel Name txt
    public String getHotelNameTf(){
        return this.nameTxt.getText();
    }

    public void clearTF(){
        this.nameTxt.setText("");
    }

}
