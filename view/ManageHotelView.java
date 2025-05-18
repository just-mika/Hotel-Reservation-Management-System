package view;

import model.hotel.Hotel;
import model.hotel.reservation.*;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
//import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JOptionPane;


public class ManageHotelView {
    private JFrame mainFrame;
    private JLabel chooseLbl, feedbackLbl, changeNameLbl, showRoomsLbl, enterRoomsToAddLbl, showMaxRoomsLbl, 
               enterRoomsToRemoveLbl, showCurrentPriceLbl, enterRoomPriceLbl, removeGuestLbl, removeRoomNoLbl, 
               removeCheckInLbl, removeCheckOutLbl, reservationLbl, hotelNameLbl, NumRoomLbl, MnthEarnLbl,
               feedbackLbl_2, feedbackLbl_3, feedbackLbl_4, feedbackLbl_5, feedbackLbl_6, feedbackLbl_7, 
               feedbackLbl_8, roomTypeLbl, updateRoomsLbl, roomTypeLbl_2, updateRoomsLbl_2, titleLbl, 
               titleLbl_1, titleLbl_2, titleLbl_3, titleLbl_4, titleLbl_5, titleLbl_6, titleLbl_7, 
               titleLbl_8, titleLbl_9, feedbackLbl_9, feedbackLbl_10, enterDateLbl, enterPercentLbl;
    private JButton backBtn, changeNameBtn, addRoomBtn, removeRoomBtn, updatePriceBtn, removeReserveBtn, 
                removeHotelBtn, backToMainBtn, manageBtn, backToManageBtn_1, backToManageBtn_2, 
                backToManageBtn_3, backToManageBtn_4, removeBtn, changeBtn, addBtn, removeBtn_2, 
                uPBtn, enterBtn, backBtn_2, datePriceBtn, backToManageBtn_5;
    private ImageIcon titleImageIcon, logoImageIcon, titleImageIcon_1, titleImageIcon_2;
    private JPanel hotelListPanel, manageHotelPanel, changeNamePanel, addRoomsPanel, removeRoomsPanel, 
               updatePricePanel, removeReservationPanel, reserveListPanel, highLvlInfoPanel, cardPanel, 
               priceModifierPanel;
    private JTextField changeNameTF, addRoomsTF, removeRoomsTF, updatePriceTF, removeReserveTF, chooseHotelTF, 
                   roomTypeTF_2, dateOneTF, percentTF;
    private JTextArea hotelListTA, reserveListTA;
    private JRadioButton addStandardRoom, addDeluxeRoom, addExecutiveRoom, removeStandardRoom, 
                     removeDeluxeRoom, removeExecutiveRoom;
    private ButtonGroup roomTypeSelect, roomTypeSelect2;

    public ManageHotelView(){
        this.mainFrame = new JFrame("Manage Hotel");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_ManageHotel.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        titleImageIcon_1 = new ImageIcon(getClass().getResource("images/HRS Title_ManageHotel_ChooseHotel.png"));
        titleLbl_1 = new JLabel("");
        titleLbl_1.setIcon(titleImageIcon_1);
        titleLbl_1.setBounds(230, 50, 650, 30);

        titleLbl_2 = new JLabel("");
        titleLbl_2.setIcon(titleImageIcon);
        titleLbl_2.setBounds(230, 50, 650, 30);

        titleLbl_3 = new JLabel("");
        titleLbl_3.setIcon(titleImageIcon);
        titleLbl_3.setBounds(230, 50, 650, 30);

        titleLbl_2 = new JLabel("");
        titleLbl_2.setIcon(titleImageIcon);
        titleLbl_2.setBounds(230, 50, 650, 30);

        titleLbl_4 = new JLabel("");
        titleLbl_4.setIcon(titleImageIcon);
        titleLbl_4.setBounds(230, 50, 650, 30);

        titleLbl_5 = new JLabel("");
        titleLbl_5.setIcon(titleImageIcon);
        titleLbl_5.setBounds(230, 50, 650, 30);

        titleLbl_6 = new JLabel("");
        titleLbl_6.setIcon(titleImageIcon);
        titleLbl_6.setBounds(230, 50, 650, 30);

        titleImageIcon_2 = new ImageIcon(getClass().getResource("images/HRS Title_ManageHotel_ChooseReservation.png"));
        titleLbl_7 = new JLabel("");
        titleLbl_7.setIcon(titleImageIcon_2);
        titleLbl_7.setBounds(230, 50, 650, 30);

        titleLbl_8 = new JLabel("");
        titleLbl_8.setIcon(titleImageIcon);
        titleLbl_8.setBounds(230, 50, 650, 30);

        titleLbl_9 = new JLabel("");
        titleLbl_9.setIcon(titleImageIcon);
        titleLbl_9.setBounds(230, 50, 650, 30);


        logoImageIcon = new ImageIcon(getClass().getResource("images/HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

        //manage Hotel panel

        this.changeNameBtn = new JButton("Change Name");
        this.changeNameBtn.setPreferredSize(new Dimension(620, 30));
        this.changeNameBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.addRoomBtn = new JButton("Add Rooms");
        this.addRoomBtn.setPreferredSize(new Dimension(620, 30));
        this.addRoomBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeRoomBtn = new JButton("Remove Rooms");
        this.removeRoomBtn.setPreferredSize(new Dimension(620, 30));
        this.removeRoomBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.updatePriceBtn = new JButton("Update Price");
        this.updatePriceBtn.setPreferredSize(new Dimension(620, 30));
        this.updatePriceBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeReserveBtn = new JButton("Remove Reservation");
        this.removeReserveBtn.setPreferredSize(new Dimension(620, 30));
        this.removeReserveBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeHotelBtn = new JButton("Remove Hotel");
        this.removeHotelBtn.setPreferredSize(new Dimension(620, 30));
        this.removeHotelBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.datePriceBtn = new JButton("Modify Date-Price");
        this.datePriceBtn.setPreferredSize(new Dimension(620, 30));
        this.datePriceBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToMainBtn = new JButton("Back to Main Menu");
        this.backToMainBtn.setPreferredSize(new Dimension(620, 30));
        this.backToMainBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl = new JLabel("");
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        manageHotelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        manageHotelPanel.setPreferredSize(new Dimension(650, 1080));
        manageHotelPanel.add(titleLbl);
        manageHotelPanel.add(feedbackLbl);
        manageHotelPanel.add(changeNameBtn);
        manageHotelPanel.add(addRoomBtn);
        manageHotelPanel.add(removeRoomBtn);
        manageHotelPanel.add(updatePriceBtn);
        manageHotelPanel.add(removeReserveBtn);
        manageHotelPanel.add(removeHotelBtn);
        manageHotelPanel.add(datePriceBtn);
        manageHotelPanel.add(backToMainBtn);


        //hotelListPanel
        this.chooseLbl = new JLabel("Hotels: ", JLabel.CENTER);
        this.chooseLbl.setPreferredSize(new Dimension(620, 30));
        this.chooseLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseHotelTF = new JTextField();
        this.chooseHotelTF.setColumns(20);
        this.chooseHotelTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.manageBtn = new JButton("Manage");
        this.manageBtn.setPreferredSize(new Dimension(100, 30));
        this.manageBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_2 = new JLabel("");
        this.feedbackLbl_2.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(new Dimension(220, 30));
        this.backBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.hotelListTA = new JTextArea(50,100);
        this.hotelListTA.setPreferredSize(new Dimension(330, 100));
        this.hotelListTA.setEditable(false);
        this.hotelListTA.setLineWrap(true);
        this.hotelListTA.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(hotelListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(330, 100));

        JPanel listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listPanel.add(chooseLbl);
        listPanel.add(scroll);
        listPanel.setPreferredSize(new Dimension(620, 1080));

        JPanel chooseHotelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chooseHotelPanel.add(chooseHotelTF);
        chooseHotelPanel.add(manageBtn);
        chooseHotelPanel.add(backBtn);

        hotelListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hotelListPanel.setPreferredSize(new Dimension(650, 1080));
        hotelListPanel.add(titleLbl_1);
        hotelListPanel.add(feedbackLbl_2);
        hotelListPanel.add(chooseHotelPanel);
        hotelListPanel.add(listPanel);

        //change Name Panel
        this.changeNameLbl = new JLabel("Change Name To: "); //probs fix after add hotel Btns
        this.changeNameLbl.setPreferredSize(new Dimension(450, 30));
        this.changeNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.changeNameTF = new JTextField();
        this.changeNameTF.setColumns(20);
        this.changeNameTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.changeBtn = new JButton("Change");
        this.changeBtn.setPreferredSize(new Dimension(150, 30));
        this.changeBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToManageBtn_5 = new JButton("Back to Manage Hotel");
        this.backToManageBtn_5 .setPreferredSize(new Dimension(200, 30));
        this.backToManageBtn_5 .setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_3 = new JLabel("");
        this.feedbackLbl_3.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        changeNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        changeNamePanel.setPreferredSize(new Dimension(650, 1080));
        changeNamePanel.add(titleLbl_2);
        changeNamePanel.add(changeNameLbl);
        changeNamePanel.add(changeNameTF);
        changeNamePanel.add(changeBtn);
        changeNamePanel.add(backToManageBtn_5);
        changeNamePanel.add(feedbackLbl_3);

        //add Rooms Panel
        this.showRoomsLbl = new JLabel("Current Total Rooms: ");
        this.showRoomsLbl.setPreferredSize(new Dimension(650, 30));
        this.showRoomsLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterRoomsToAddLbl = new JLabel("Enter Number Rooms to Add: "); 
        this.enterRoomsToAddLbl.setPreferredSize(new Dimension(450, 30));
        this.enterRoomsToAddLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomTypeLbl = new JLabel("Select Type of Rooms to Add: ");
        this.roomTypeLbl.setPreferredSize(new Dimension(200, 30));
        this.roomTypeLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.addRoomsTF = new JTextField();
        this.addRoomsTF.setColumns(20);
        this.addRoomsTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.addStandardRoom = new JRadioButton("Standard");
        this.addDeluxeRoom = new JRadioButton("Deluxe");
        this.addExecutiveRoom = new JRadioButton("Executive");

        roomTypeSelect = new ButtonGroup();
        roomTypeSelect.add(addStandardRoom);
        roomTypeSelect.add(addDeluxeRoom);
        roomTypeSelect.add(addExecutiveRoom);

        JPanel roomType = new JPanel(new FlowLayout(FlowLayout.CENTER));
        roomType.add(roomTypeLbl);
        roomType.add(addStandardRoom);
        roomType.add(addDeluxeRoom);
        roomType.add(addExecutiveRoom);

        this.backToManageBtn_1 = new JButton("Back to Manage Hotel");
        this.backToManageBtn_1.setPreferredSize(new Dimension(650, 30));
        this.backToManageBtn_1.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.addBtn = new JButton("Add Rooms");
        this.addBtn.setPreferredSize(new Dimension(650, 30));
        this.addBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_4 = new JLabel("");
        this.feedbackLbl_4.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_4.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.updateRoomsLbl = new JLabel("");
        this.updateRoomsLbl.setPreferredSize(new Dimension(620, 30));
        this.updateRoomsLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        addRoomsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addRoomsPanel.setPreferredSize(new Dimension(650, 1080));
        addRoomsPanel.add(titleLbl_3);
        addRoomsPanel.add(showRoomsLbl);
        addRoomsPanel.add(enterRoomsToAddLbl);
        addRoomsPanel.add(addRoomsTF);
        addRoomsPanel.add(roomType);
        addRoomsPanel.add(addBtn);
        addRoomsPanel.add(backToManageBtn_1);
        addRoomsPanel.add(feedbackLbl_4);
        addRoomsPanel.add(updateRoomsLbl);

        //remove rooms Panel
        this.showMaxRoomsLbl = new JLabel("Maximum Number Rooms to Remove: "); 
        this.showMaxRoomsLbl.setPreferredSize(new Dimension(650, 30));
        this.showMaxRoomsLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterRoomsToRemoveLbl = new JLabel("Enter Number of Rooms to Remove: ");
        this.enterRoomsToRemoveLbl.setPreferredSize(new Dimension(250, 30));
        this.enterRoomsToRemoveLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeRoomsTF = new JTextField();
        this.removeRoomsTF.setColumns(20);
        this.removeRoomsTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeBtn_2= new JButton("Remove Rooms");
        this.removeBtn_2.setPreferredSize(new Dimension(650, 30));
        this.removeBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToManageBtn_2 = new JButton("Back to Manage Hotel");
        this.backToManageBtn_2.setPreferredSize(new Dimension(650, 30));
        this.backToManageBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_5 = new JLabel("");
        this.feedbackLbl_5.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_5.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.updateRoomsLbl_2= new JLabel("");
        this.updateRoomsLbl_2.setPreferredSize(new Dimension(620, 30));
        this.updateRoomsLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomTypeLbl_2 = new JLabel("Enter Type of Rooms to Remove: "); 
        this.roomTypeLbl_2.setPreferredSize(new Dimension(300, 30));
        this.roomTypeLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeStandardRoom = new JRadioButton("Standard");
        this.removeDeluxeRoom = new JRadioButton("Deluxe");
        this.removeExecutiveRoom = new JRadioButton("Executive");

        roomTypeSelect2 = new ButtonGroup();
        roomTypeSelect2.add(removeStandardRoom);
        roomTypeSelect2.add(removeDeluxeRoom);
        roomTypeSelect2.add(removeExecutiveRoom);

        JPanel roomType2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        roomType2.add(roomTypeLbl_2);
        roomType2.add(removeStandardRoom);
        roomType2.add(removeDeluxeRoom);
        roomType2.add(removeExecutiveRoom);

        removeRoomsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        removeRoomsPanel.setPreferredSize(new Dimension(650, 1080));
        removeRoomsPanel.add(titleLbl_4);
        removeRoomsPanel.add(showMaxRoomsLbl);
        removeRoomsPanel.add(enterRoomsToRemoveLbl);
        removeRoomsPanel.add(removeRoomsTF);
        removeRoomsPanel.add(roomType2);
        removeRoomsPanel.add(removeBtn_2);
        removeRoomsPanel.add(backToManageBtn_2);
        removeRoomsPanel.add(feedbackLbl_5);
        removeRoomsPanel.add(updateRoomsLbl_2);

        //update Price Panel
        this.showCurrentPriceLbl = new JLabel("Current Price: "); 
        this.showCurrentPriceLbl.setPreferredSize(new Dimension(450, 30));
        this.showCurrentPriceLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterRoomPriceLbl = new JLabel("Enter New Room Price: "); 
        this.enterRoomPriceLbl.setPreferredSize(new Dimension(450, 30));
        this.enterRoomPriceLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.updatePriceTF = new JTextField();
        this.updatePriceTF.setColumns(20);
        this.updatePriceTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.uPBtn = new JButton("Update Price");
        this.uPBtn.setPreferredSize(new Dimension(650, 30));
        this.uPBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToManageBtn_3 = new JButton("Back to Manage Hotel");
        this.backToManageBtn_3.setPreferredSize(new Dimension(650, 30));
        this.backToManageBtn_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_6 = new JLabel("");
        this.feedbackLbl_6.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_6.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        updatePricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updatePricePanel.setPreferredSize(new Dimension(650, 1080));
        updatePricePanel.add(titleLbl_5);
        updatePricePanel.add(showCurrentPriceLbl);
        updatePricePanel.add(enterRoomPriceLbl);
        updatePricePanel.add(updatePriceTF);
        updatePricePanel.add(uPBtn);
        updatePricePanel.add(backToManageBtn_3);
        updatePricePanel.add(feedbackLbl_6);

        //reserve List Panel
        this.reservationLbl = new JLabel("Enter Reservation Name "); 
        this.reservationLbl.setPreferredSize(new Dimension(450, 30));
        this.reservationLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeReserveTF = new JTextField();
        this.removeReserveTF.setColumns(20);
        this.removeReserveTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.removeBtn = new JButton("Remove");
        this.removeBtn.setPreferredSize(new Dimension(100, 30));
        this.removeBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_7 = new JLabel("");
        this.feedbackLbl_7.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_7.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JLabel chooseReserveLbl = new JLabel("Reservations: ", JLabel.CENTER);
        chooseReserveLbl.setPreferredSize(new Dimension(620, 30));
        chooseReserveLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.reserveListTA = new JTextArea(50,100);
        this.reserveListTA.setPreferredSize(new Dimension(330, 100));
        this.reserveListTA.setEditable(false);
        this.reserveListTA.setLineWrap(true);
        this.reserveListTA.setLineWrap(true);

        JScrollPane reserveScroll = new JScrollPane(reserveListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        reserveScroll.setPreferredSize(new Dimension(330, 100));

        JPanel listPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listPanel2.add(chooseReserveLbl);
        listPanel2.add(reserveScroll);
        listPanel2.setPreferredSize(new Dimension(620, 200));

        this.backToManageBtn_4 = new JButton("Back");
        this.backToManageBtn_4.setPreferredSize(new Dimension(100, 30));
        this.backToManageBtn_4.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JPanel chooseReserve = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chooseReserve.add(removeReserveTF);
        chooseReserve.add(removeBtn);
        chooseReserve.add(backToManageBtn_4);

        reserveListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        reserveListPanel.setPreferredSize(new Dimension(620, 1080));
        reserveListPanel.add(titleLbl_7);
        reserveListPanel.add(reservationLbl);
        reserveListPanel.add(chooseReserve);
        reserveListPanel.add(feedbackLbl_7);
        reserveListPanel.add(listPanel2);


        //remove Reserve Panel
        JLabel reserveInfoLbl = new JLabel("Reservation Information", JLabel.CENTER);
        reserveInfoLbl.setPreferredSize(new Dimension(620, 15));
        reserveInfoLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.removeGuestLbl = new JLabel("Guest: "); 
        this.removeGuestLbl.setPreferredSize(new Dimension(620, 15));
        this.removeGuestLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.removeRoomNoLbl = new JLabel("Room No: "); 
        this.removeRoomNoLbl.setPreferredSize(new Dimension(620, 15));
        this.removeRoomNoLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.removeCheckInLbl = new JLabel("Guest Check-In Date: "); 
        this.removeCheckInLbl.setPreferredSize(new Dimension(620, 15));
        this.removeCheckInLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.removeCheckOutLbl = new JLabel("Guest Check-Out Date "); 
        this.removeCheckOutLbl.setPreferredSize(new Dimension(620, 15));
        this.removeCheckOutLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        removeReservationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        removeReservationPanel.setPreferredSize(new Dimension(650, 1080));
        removeReservationPanel.add(titleLbl_6);
        removeReservationPanel.add(reserveInfoLbl);
        removeReservationPanel.add(removeGuestLbl);
        removeReservationPanel.add(removeRoomNoLbl);
        removeReservationPanel.add(removeCheckInLbl);
        removeReservationPanel.add(removeCheckOutLbl);

        //high Lvl Info Panel
        this.hotelNameLbl = new JLabel("Hotel Name: ");
        this.hotelNameLbl.setPreferredSize(new Dimension(600, 30));
        this.hotelNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.NumRoomLbl = new JLabel("Total Number of Rooms: ");
        this.NumRoomLbl.setPreferredSize(new Dimension(600, 30));
        this.NumRoomLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.MnthEarnLbl = new JLabel("Estimate Monthly Earnings: ");
        this.MnthEarnLbl.setPreferredSize(new Dimension(600, 30));
        this.MnthEarnLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        highLvlInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        highLvlInfoPanel.setPreferredSize(new Dimension(650, 1080));
        highLvlInfoPanel.add(titleLbl_8);
        highLvlInfoPanel.add(hotelNameLbl);
        highLvlInfoPanel.add(NumRoomLbl);
        highLvlInfoPanel.add(MnthEarnLbl);

        //date Price Panel
        this.enterDateLbl = new JLabel("Enter Date: ");
        this.enterDateLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.dateOneTF = new JTextField();
       this.dateOneTF.setColumns(2);
       this.dateOneTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.enterBtn = new JButton("Enter");
       this.enterBtn.setPreferredSize(new Dimension(650, 30));
       this.enterBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.backBtn_2 = new JButton("Back To Main Menu");
       this.backBtn_2.setPreferredSize(new Dimension(650, 30));
       this.backBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.enterPercentLbl = new JLabel("Enter Percentage: ");
       this.percentTF = new JTextField();
       this.percentTF.setColumns(3);
       this.enterPercentLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
       this.percentTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.feedbackLbl_9 = new JLabel("");
       this.feedbackLbl_9.setPreferredSize(new Dimension(620, 30));
       this.feedbackLbl_9.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

       this.feedbackLbl_10 = new JLabel("");
       this.feedbackLbl_10.setPreferredSize(new Dimension(620, 30));
       this.feedbackLbl_10.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

       priceModifierPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       priceModifierPanel.setPreferredSize(new Dimension(650, 1080));
        priceModifierPanel.add(titleLbl_9);
        priceModifierPanel.add(feedbackLbl_9);
        priceModifierPanel.add(enterDateLbl);
        priceModifierPanel.add(dateOneTF);
        priceModifierPanel.add(enterPercentLbl);
        priceModifierPanel.add(percentTF);
        priceModifierPanel.add(enterBtn);
        priceModifierPanel.add(backBtn_2);
        priceModifierPanel.add(feedbackLbl_10);

        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(manageHotelPanel, "ManageHotelPanel");
        cardPanel.add(hotelListPanel, "HotelListPanel");
        cardPanel.add(changeNamePanel, "ChangeNamePanel");
        cardPanel.add(addRoomsPanel, "AddRoomsPanel");
        cardPanel.add(removeRoomsPanel, "RemoveRoomsPanel");
        cardPanel.add(updatePricePanel, "UpdatePricePanel");
        cardPanel.add(removeReservationPanel, "RemoveReservationPanel");
        cardPanel.add(highLvlInfoPanel, "HighLvlInfoPanel");
        cardPanel.add(reserveListPanel, "ReserveListPanel");
        cardPanel.add(priceModifierPanel, "PriceModifierPanel");
        

        mainFrame.add(cardPanel);



    }
    //action Listeners
    public void goToManageAL(ActionListener al){
        this.manageBtn.addActionListener(al);
    }

    public void goToManageAL_2(ActionListener al){
        this.changeBtn.addActionListener(al);
    }

    public void goToManageAL_3(ActionListener al){
        this.backToManageBtn_1.addActionListener(al);
    }

    public void goToManageAL_4(ActionListener al){
        this.backToManageBtn_2.addActionListener(al);
    }

    public void goToManageAL_5(ActionListener al){
        this.backToManageBtn_3.addActionListener(al);
    }

    public void goToRemoveReserveAL(ActionListener al){
        this.removeBtn.addActionListener(al);
    }

    public void changeNameAL(ActionListener al){
        this.changeNameBtn.addActionListener(al);
    }

    public void addRoomAL(ActionListener al){
        this.addRoomBtn.addActionListener(al);
    }

    public void addRoomInfoAL(ActionListener al){
        this.addBtn.addActionListener(al);
    }

    public void removeRoomInfoAL(ActionListener al){
        this.removeBtn_2.addActionListener(al);
    }

    public void removeRoomAL(ActionListener al){
        this.removeRoomBtn.addActionListener(al);
    }

    public void updatePriceAL(ActionListener al){
        this.updatePriceBtn.addActionListener(al);
    }
    
    
    public void updatePriceInfoAL(ActionListener al){
        this.uPBtn.addActionListener(al);
    }

    public void removeReserveAL(ActionListener al){
        this.removeReserveBtn.addActionListener(al);
    }

    public void removeReserveBackAL(ActionListener al){
        this.backToManageBtn_4.addActionListener(al);
    }

    public void removeHotelAL(ActionListener al){
        this.removeHotelBtn.addActionListener(al);
    }

    public void backToMainAL(ActionListener al){
        this.backToMainBtn.addActionListener(al);
    }
    public void backToMainAL_2(ActionListener al){
        this.backBtn.addActionListener(al);
    }

    public void enterPriceAL(ActionListener al){
        this.enterBtn.addActionListener(al);
    }

    public void goToManageAL_6(ActionListener al){
        this.backBtn_2.addActionListener(al);
    }

    public void goToManageAL_7(ActionListener al){
        this.backToManageBtn_5.addActionListener(al);
    }


    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void switchPanel(String panelName){
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    //Text
    public void setHotelListTA(String text) {
        this.hotelListTA.setText(text);
    }

    public void setFeedbackLbl(String text){
        this.feedbackLbl.setText(text);
    }

    public void clearTF(){
        this.chooseHotelTF.setText("");
    }

    public void setFeedbackLbl_2(String text){
        this.feedbackLbl_2.setText(text);
    }


    public void setFeedbackLbl_9(String text){
        this.feedbackLbl_9.setText(text);
    }

    public void setFeedbackLbl_10(String text){
        this.feedbackLbl_10.setText(text);
    }

    public int getDateText() {
        try {
            return Integer.parseInt(dateOneTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + dateOneTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_9(){
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

    public void clearTF_10(){
        this.percentTF.setText("");
    }

    public void modifyPriceAL(ActionListener al){
        this.datePriceBtn.addActionListener(al);
    }


    public String getChooseHotelText() {
        return chooseHotelTF.getText();
    }

    public String getChangeHotelText() {
        return changeNameTF.getText();
    }
    
    public void clearTF_2(){
        this.changeNameTF.setText("");
    }

    public void setFeedbackLbl_3(String text){
        this.feedbackLbl_3.setText(text);
    }

    public int getAddRoomsText() {
        try {
            return Integer.parseInt(addRoomsTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + addRoomsTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }
    
    public void clearTF_3(){
        this.addRoomsTF.setText("");
    }

    public void setFeedbackLbl_4(String text){
        this.feedbackLbl_4.setText(text);
    }

    public void displayRooms(Hotel hotel) {
        int standardRooms = hotel.getRoomManager().countRooms("Standard");
        int deluxeRooms = hotel.getRoomManager().countRooms("Deluxe");
        int executiveRooms = hotel.getRoomManager().countRooms("Executive");
        showRoomsLbl.setText("Current Total Rooms: " + hotel.getRoomManager().getRoomList().size()+
                " (Standard Rooms: " + standardRooms + "; Deluxe Rooms: " + deluxeRooms + "; ExecutiveRooms: "+ executiveRooms + ")");
        updateRoomsLbl.setText("");
    }
    public void displayAddedRooms(Hotel hotel, String roomType, int quantity) {
        displayRooms(hotel);
        updateRoomsLbl.setText("Room Type: " + roomType + " | Added Rooms: " + quantity);
    }

    public int getRemoveRoomsText() {
        try {
            return Integer.parseInt(removeRoomsTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + removeRoomsTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }
    
    public void clearTF_5(){
        this.removeRoomsTF.setText("");
    }

    public String getTypeRoomsText_2() {
        return roomTypeTF_2.getText();
    }

    public void clearTF_6(){
        this.roomTypeTF_2.setText("");
    }

    public void displayMaxRooms(Hotel hotel) {
        int standardRooms = hotel.getRoomManager().countRooms("Standard");
        int deluxeRooms = hotel.getRoomManager().countRooms("Deluxe");
        int executiveRooms = hotel.getRoomManager().countRooms("Executive");
        int totalRooms = hotel.getRoomManager().getRoomList().size() - 1;
        showMaxRoomsLbl.setText("Maximum Number of Rooms to Remove: " + totalRooms +
                " (Standard - " + standardRooms + "; Deluxe - " + deluxeRooms + "; Executive - "+ executiveRooms + ")");
        updateRoomsLbl_2.setText("");
    }

    public void setFeedbackLbl_5(String text){
        this.feedbackLbl_5.setText(text);
    }

    public double getPriceText() {
        try {
            return Double.parseDouble(updatePriceTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + updatePriceTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_7(){
        this.updatePriceTF.setText("");
    }

    public void setFeedbackLbl_6(String text){
        this.feedbackLbl_6.setText(text);
    }

    public void displayUpdatedPrice(Hotel hotel) {
        showCurrentPriceLbl.setText("Current Price: " +hotel.getBasePrice());
    }

    public String getRemoveReserveText(){
        return removeReserveTF.getText();
    }

    public void clearTF_8(){
        this.removeReserveTF.setText("");
    }

    public void setFeedbackLbl_7(String text){
        this.feedbackLbl_7.setText(text);
    }

    public void displayRemoveReserve(Hotel hotel, String guestName) {
        Reservation reservation = hotel.getReservationManager().findReservation(guestName);
        if (reservation != null) {
            removeGuestLbl.setText("Guest: " + reservation.getGuestName());
            removeRoomNoLbl.setText("Room No: " + reservation.getRoom().getRoomName());
            removeCheckInLbl.setText("Check-In Date: " + reservation.getCheckInDate());
            removeCheckOutLbl.setText("Check-Out Date: " + reservation.getCheckOutDate());
        }
    }

    public void setFeedbackLbl_8(String text){
        this.feedbackLbl_8.setText(text);
    }
    public void setRemoveReserveEnabled(boolean enabled){this.removeReserveBtn.setEnabled(enabled);}
    public void setRemoveHotelEnabled(boolean enabled){this.removeHotelBtn.setEnabled(enabled);}
    public void setUpdatePriceEnabled(boolean enabled){this.updatePriceBtn.setEnabled(enabled);}
    public void setAddRoomsEnabled(boolean enabled){
        this.addRoomBtn.setEnabled(enabled);
        this.addBtn.setEnabled(enabled);
    }
    public void setRemoveRoomsEnabled(boolean enabled){
        this.removeRoomBtn.setEnabled(enabled);
        this.removeBtn_2.setEnabled(enabled);
    }

    public boolean isAddStandardSelected(){
        if(addStandardRoom.isSelected())
            return true;
        return false;
    }
    public boolean isAddDeluxeSelected(){
        if(addDeluxeRoom.isSelected())
            return true;
        return false;
    }
    public boolean isAddExecSelected(){
        if(addExecutiveRoom.isSelected())
            return true;
        return false;
    }

    public boolean isRemoveStandardSelected(){
        if(removeStandardRoom.isSelected())
            return true;
        return false;
    }
    public boolean isRemoveDeluxeSelected(){
        if(removeDeluxeRoom.isSelected())
            return true;
        return false;
    }
    public boolean isRemoveExecSelected(){
        if(removeExecutiveRoom.isSelected())
            return true;
        return false;
    }
    public void setReserveListTA(String text){
        this.reserveListTA.setText(text);
    }

    public void clearButtonSelection(){
        roomTypeSelect.clearSelection();
        roomTypeSelect2.clearSelection();
    }
}
