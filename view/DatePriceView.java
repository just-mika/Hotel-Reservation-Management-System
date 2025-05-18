package view;

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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class DatePriceView{
    private JFrame mainFrame;
    private JLabel titleLbl, titleLbl_1, feedbackLbl, feedbackLbl_2, chooseLbl, enterDateLbl, 
    enterPercentLbl, hotelListLbl, feedbackLbl_3;
    private JButton enterBtn,chooseBtn, backBtn;
    private ImageIcon titleImageIcon, titleImageIcon_1, logoImageIcon;
    private JTextField dateOneTF, percentTF, chooseHotelTF;
    private JPanel hotelListPanel, cardPanel, priceModifierPanel;
    private JTextArea hotelListTA;

    public DatePriceView(){
        this.mainFrame = new JFrame("Modify Date Price");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_PriceModifier.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        titleImageIcon_1 = new ImageIcon(getClass().getResource("images/HRS Title_DatePrice_ChooseHotel.png"));
        titleLbl_1 = new JLabel("");
        titleLbl_1.setIcon(titleImageIcon_1);
        titleLbl_1.setBounds(230, 50, 650, 30);

        this.feedbackLbl = new JLabel("feedback/errors go here"); //delete text
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.BOLD,15));

        logoImageIcon = new ImageIcon(getClass().getResource("images/HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

         //Hotel Panel
          this.chooseLbl = new JLabel("Hotels: ", JLabel.CENTER);
        this.chooseLbl.setPreferredSize(new Dimension(620, 30));
        this.chooseLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseHotelTF = new JTextField();
        this.chooseHotelTF.setColumns(20);
        this.chooseHotelTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl = new JLabel("");
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseBtn = new JButton("Book");
        this.chooseBtn.setPreferredSize(new Dimension(100, 30));
        this.chooseBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(new Dimension(220, 30));
        this.backBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.hotelListTA = new JTextArea("");
        this.hotelListTA.setPreferredSize(new Dimension(330, 100));
        this.hotelListTA.setEditable(false);
        JScrollPane scroll = new JScrollPane(hotelListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(330, 100));

        JPanel listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listPanel.add(chooseLbl);
        listPanel.add(scroll);
        listPanel.setPreferredSize(new Dimension(620, 1080));

        JPanel chooseHotelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chooseHotelPanel.add(chooseHotelTF);
        chooseHotelPanel.add(chooseBtn);
        chooseHotelPanel.add(backBtn);

        hotelListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hotelListPanel.setPreferredSize(new Dimension(650, 1080));
        hotelListPanel.add(titleLbl_1);
        hotelListPanel.add(feedbackLbl);
        hotelListPanel.add(chooseHotelPanel);
        hotelListPanel.add(listPanel);

         //date Price Panel
         this.enterDateLbl = new JLabel("Enter Date: ");
         this.enterDateLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.dateOneTF = new JTextField();
        this.dateOneTF.setColumns(2);
        this.dateOneTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterBtn = new JButton("Enter");
        this.enterBtn.setPreferredSize(new Dimension(650, 30));
        this.enterBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterPercentLbl = new JLabel("Enter Percentage: ");
        this.percentTF = new JTextField();
        this.percentTF.setColumns(3);
        this.enterPercentLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.percentTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_2 = new JLabel("");
        this.feedbackLbl_2.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_3 = new JLabel("");
        this.feedbackLbl_3.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        priceModifierPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        priceModifierPanel.setPreferredSize(new Dimension(650, 1080));
         priceModifierPanel.add(titleLbl);
         priceModifierPanel.add(feedbackLbl_3);
         priceModifierPanel.add(enterDateLbl);
         priceModifierPanel.add(dateOneTF);
         priceModifierPanel.add(enterPercentLbl);
         priceModifierPanel.add(percentTF);
         priceModifierPanel.add(enterBtn);
         priceModifierPanel.add(feedbackLbl_2);

        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(hotelListPanel, "HotelListPanel");
        cardPanel.add(priceModifierPanel, "PriceModifierPanel");

        mainFrame.add(cardPanel);

    }

    //actionLsiteners
    public void goToDatePriceAL(ActionListener al){
        this.chooseBtn.addActionListener(al);
    }

    public void backToMainAL(ActionListener al){
        this.enterBtn.addActionListener(al);
    }

    public void backToMainAL_2(ActionListener al){
        this.backBtn.addActionListener(al);
    }


    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }
    
    //switch panels
    public void switchPanel(String panelName){
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    //text
    public String getChooseHotelText() {
        return chooseHotelTF.getText();
    }

    public void setFeedbackLbl(String text){
        this.feedbackLbl.setText(text);
    }

    public void clearTF(){
        this.chooseHotelTF.setText("");
    }

    public int getDateText() {
        try {
            return Integer.parseInt(dateOneTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + dateOneTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_2(){
        this.dateOneTF.setText("");
    }

    public double getPercetageText() {
        try {
            return Double.parseDouble(percentTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + percentTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_3(){
        this.percentTF.setText("");
    }

    public void setFeedbackLbl_2(String text){
        this.feedbackLbl_2.setText(text);
    }

    public void setFeedbackLbl_3(String text){
        this.feedbackLbl_3.setText(text);
    }

    public void setHotelListTA(String text) {
        this.hotelListTA.setText(text);
    }
}
