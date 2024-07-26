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

import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class DatePriceView{
    private JFrame mainFrame;
    private JLabel titleLbl, titleLbl_1, feedbackLbl, chooseLbl, enterDateLbl, enterPercentLbl;
    private JButton enterBtn, backToMainBtn, chooseBtn;
    private ImageIcon titleImageIcon, titleImageIcon_1, logoImageIcon;
    private JTextField dateOneTF, dateTwoTF, percentTF, chooseHotelTF;
    private JPanel hotelListPanel, cardPanel, priceModifierPanel;

    public DatePriceView(){
        this.mainFrame = new JFrame("Modify Date Price");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("HRS Title_PriceModifier.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        titleImageIcon_1 = new ImageIcon(getClass().getResource("HRS Title_DatePrice_ChooseHotel.png"));
        titleLbl_1 = new JLabel("");
        titleLbl_1.setIcon(titleImageIcon_1);
        titleLbl_1.setBounds(230, 50, 650, 30);

        this.feedbackLbl = new JLabel("feedback/errors go here"); //delete text
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.BOLD,15));

        logoImageIcon = new ImageIcon(getClass().getResource("HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

         //Hotel Panel
         this.chooseLbl = new JLabel("Hotels: "); //probs fix after add hotel Btns
         this.chooseLbl.setPreferredSize(new Dimension(620, 30));
         this.chooseLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));
 
         this.chooseHotelTF = new JTextField();
         this.chooseHotelTF.setColumns(20);
         this.chooseHotelTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
 
         this.chooseBtn = new JButton("Modify Price");
         this.chooseBtn.setPreferredSize(new Dimension(100, 30));
         this.chooseBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
 
         hotelListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         hotelListPanel.add(titleLbl_1);
         hotelListPanel.add(chooseLbl);
         hotelListPanel.add(chooseHotelTF);
         hotelListPanel.add(chooseBtn);
         //btns?
         hotelListPanel.setPreferredSize(new Dimension(650, 1080));

         //date Price Panel
         this.enterDateLbl = new JLabel("Enter Dates: ");
        this.dateOneTF = new JTextField();
        this.dateOneTF.setColumns(2);
        this.dateTwoTF = new JTextField();
        this.dateTwoTF.setColumns(2);
        this.enterDateLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.dateOneTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.dateTwoTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterBtn = new JButton("Enter");
        this.enterBtn.setPreferredSize(new Dimension(320, 30));
        this.enterBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToMainBtn = new JButton("Back to Main Menu");
        this.backToMainBtn.setPreferredSize(new Dimension(320, 30));
        this.backToMainBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterPercentLbl = new JLabel("Enter Percentage: ");
        this.percentTF = new JTextField();
        this.percentTF.setColumns(3);
        this.enterPercentLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.percentTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        priceModifierPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        priceModifierPanel.setPreferredSize(new Dimension(650, 1080));
         priceModifierPanel.add(titleLbl);
         priceModifierPanel.add(enterDateLbl);
         priceModifierPanel.add(dateOneTF);
         priceModifierPanel.add(dateTwoTF);
         priceModifierPanel.add(enterPercentLbl);
         priceModifierPanel.add(percentTF);
         priceModifierPanel.add(enterBtn);
         priceModifierPanel.add(backToMainBtn);

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
        this.backToMainBtn.addActionListener(al);
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
}
