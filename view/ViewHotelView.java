package view;

import model.hotel.Hotel;
import model.hotel.room.*;
import model.hotel.reservation.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;


public class ViewHotelView {
    private JFrame mainFrame;
    private JLabel titleLbl, titleLbl_1, titleLbl_2, titleLbl_3, chooseLbl, feedbackLbl, feedbackLbl_2, feedbackLbl_3, feedbackLbl_4, hotelNameLbl, NumRoomLbl, MnthEarnLbl, titleLbl_4, titleLbl_5, titleLbl_6, titleLbl_7, titleLbl_8, titleLbl_9;
    private JLabel showAvailRoomLbl, totalBookedLbl, roomNameLbl, roomTypeLbl, roomPriceLbl, reservedDatesLbl, guestNameLbl, roomNumLbl, checkInLbl, checkOutLbl, pricePerNytLbl, discountLbl, totalPriceLbl, inputDateLbl, inputRoomNameLbl, inputReservaLbl;
    private JButton highInfoBtn, lowInfoBtn, backToMainBtn, backBtn;
    private JPanel highLvlPanel, lowLvlPanel, hotelListPanel, mainPanel, cardPanel, chkAvailPanel, viewRoomPanel, viewReservePanel, inputDatePanel, roomListPanel, reservationListPanel; 
    private JButton backToViewBtn_1, viewBtn, checkBtn, chooseRoomBtn, chooseReserveBtn;
    private JTextField chooseHotelTF, inputDateTF, inputRoomNameTF, inputReserveTF; 
    private JButton chkAvailBtn, viewRoomBtn, viewReserveBtn, backToViewBtn_2, backToLowBtn_1, backToLowBtn_2, backToLowBtn_3, backToLowBtn_4, backToLowBtn_5, backToLowBtn_6;
    private JTextArea hotelListTA, reserveListTA, availRoomsTA, roomListTA;
    private JLabel hotelFeedbackLbl, dateFeedBackLbl;

    private ImageIcon titleImageIcon, titleImageIcon_1, titleImageIcon_2, titleImageIcon_3, titleImageIcon_4, titleImageIcon_5 , logoImageIcon, titleImageIcon_6;

    public ViewHotelView(){
        this.mainFrame = new JFrame("View Hotel");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 650, 30);

        titleImageIcon_1 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_ChooseHotel.png"));
        titleLbl_1 = new JLabel("");
        titleLbl_1.setIcon(titleImageIcon_1);
        titleLbl_1.setBounds(230, 50, 650, 30);


        titleImageIcon_2 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_HighInfo.png"));
        titleLbl_2 = new JLabel("");
        titleLbl_2.setIcon(titleImageIcon_2);
        titleLbl_2.setBounds(230, 50, 650, 30);

        titleImageIcon_3 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_LowInfo.png"));
        titleLbl_3 = new JLabel("");
        titleLbl_3.setIcon(titleImageIcon_3);
        titleLbl_3.setBounds(230, 50, 650, 30); 

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel.png"));
        titleLbl_4 = new JLabel("");
        titleLbl_4.setIcon(titleImageIcon);
        titleLbl_4.setBounds(230, 50, 650, 30);

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel.png"));
        titleLbl_5 = new JLabel("");
        titleLbl_5.setIcon(titleImageIcon);
        titleLbl_5.setBounds(230, 50, 650, 30);

        titleImageIcon = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel.png"));
        titleLbl_6 = new JLabel("");
        titleLbl_6.setIcon(titleImageIcon);
        titleLbl_6.setBounds(230, 50, 650, 30);

        titleImageIcon_4 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_ChooseRoom.png"));
        titleLbl_7 = new JLabel("");
        titleLbl_7.setIcon(titleImageIcon_4);
        titleLbl_7.setBounds(230, 50, 650, 30);

        titleImageIcon_5 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_ChooseReserve.png"));
        titleLbl_8 = new JLabel("");
        titleLbl_8.setIcon(titleImageIcon_5);
        titleLbl_8.setBounds(230, 50, 650, 30);

        titleImageIcon_6 = new ImageIcon(getClass().getResource("images/HRS Title_ViewHotel_InputDate.png"));
        titleLbl_9 = new JLabel("");
        titleLbl_9.setIcon(titleImageIcon_6);
        titleLbl_9.setBounds(230, 50, 650, 30);

        logoImageIcon = new ImageIcon(getClass().getResource("images/HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());

        this.highInfoBtn = new JButton("View High-Level Information");
        this.highInfoBtn.setPreferredSize(new Dimension(620, 30));
        this.highInfoBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.lowInfoBtn = new JButton("View Low-Level Information");
        this.lowInfoBtn.setPreferredSize(new Dimension(620, 30));
        this.lowInfoBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToMainBtn = new JButton("Back to Main Menu");
        this.backToMainBtn.setPreferredSize(new Dimension(620, 30));
        this.backToMainBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(new Dimension(220, 30));
        this.backBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToViewBtn_2 = new JButton("Back to View Hotel");
        this.backToViewBtn_2.setPreferredSize(new Dimension(620, 30));
        this.backToViewBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        //Hotel Panel
        this.chooseLbl = new JLabel("Hotels: ", JLabel.CENTER);
        this.chooseLbl.setPreferredSize(new Dimension(620, 30));
        this.chooseLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseHotelTF = new JTextField();
        this.chooseHotelTF.setColumns(20);
        this.chooseHotelTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl = new JLabel("");
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.hotelFeedbackLbl = new JLabel("");
        this.hotelFeedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.hotelFeedbackLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.viewBtn = new JButton("View");
        this.viewBtn.setPreferredSize(new Dimension(100, 30));
        this.viewBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.hotelListTA = new JTextArea(50, 100);
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
        chooseHotelPanel.add(viewBtn);
        chooseHotelPanel.add(backBtn);

        hotelListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hotelListPanel.setPreferredSize(new Dimension(650, 1080));
        hotelListPanel.add(titleLbl_1);
        hotelListPanel.add(hotelFeedbackLbl);
        hotelListPanel.add(chooseHotelPanel);
        hotelListPanel.add(listPanel);

        //highLvlPanel
        this.hotelNameLbl = new JLabel("Hotel Name: ");
        this.hotelNameLbl.setPreferredSize(new Dimension(600, 30));
        this.hotelNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.NumRoomLbl = new JLabel("Total Number of Rooms: ");
        this.NumRoomLbl.setPreferredSize(new Dimension(600, 30));
        this.NumRoomLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.MnthEarnLbl = new JLabel("Estimate Monthly Earnings: ");
        this.MnthEarnLbl.setPreferredSize(new Dimension(600, 30));
        this.MnthEarnLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToViewBtn_1 = new JButton("Back to View Hotel");
        this.backToViewBtn_1.setPreferredSize(new Dimension(620, 30));
        this.backToViewBtn_1.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        highLvlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        highLvlPanel.add(titleLbl_2);
        highLvlPanel.add(hotelNameLbl);
        highLvlPanel.add(NumRoomLbl);
        highLvlPanel.add(MnthEarnLbl);
        highLvlPanel.add(backToViewBtn_1);
        highLvlPanel.setPreferredSize(new Dimension(620, 1080));

        //lowLvlPanel
        this.chkAvailBtn = new JButton("Check Available Rooms");
        this.chkAvailBtn.setPreferredSize(new Dimension(620, 30));
        this.chkAvailBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.viewRoomBtn = new JButton("View Rooms");
        this.viewRoomBtn.setPreferredSize(new Dimension(620, 30));
        this.viewRoomBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.viewReserveBtn = new JButton("View Reservations");
        this.viewReserveBtn.setPreferredSize(new Dimension(620, 30));
        this.viewReserveBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToViewBtn_2 = new JButton("Back to View Hotel");
        this.backToViewBtn_2.setPreferredSize(new Dimension(620, 30));
        this.backToViewBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        lowLvlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lowLvlPanel.add(titleLbl_3);
        lowLvlPanel.add(chkAvailBtn);
        lowLvlPanel.add(viewRoomBtn);
        lowLvlPanel.add(viewReserveBtn);
        lowLvlPanel.add(backToViewBtn_2);
        lowLvlPanel.setPreferredSize(new Dimension(620, 1080));

        //input date Panel
        this.inputDateLbl = new JLabel("Input Date: ");
        this.inputDateLbl.setPreferredSize(new Dimension(600, 30));
        this.inputDateLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.inputDateTF = new JTextField();
        this.inputDateTF.setColumns(10);
        this.inputDateTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.checkBtn = new JButton("Check Available Rooms");
        this.checkBtn.setPreferredSize(new Dimension(620, 30));
        this.checkBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_2 = new JLabel("");
        this.feedbackLbl_2.setPreferredSize(new Dimension(600, 30));
        this.feedbackLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToLowBtn_4 = new JButton("Back");
        this.backToLowBtn_4.setPreferredSize(new Dimension(620, 30));
        this.backToLowBtn_4.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        inputDatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputDatePanel.setPreferredSize(new Dimension(620, 1080));
        inputDatePanel.add(titleLbl_9);
        inputDatePanel.add(inputDateLbl);
        inputDatePanel.add(inputDateTF);
        inputDatePanel.add(checkBtn);
        inputDatePanel.add(backToLowBtn_4);
        inputDatePanel.add(feedbackLbl_2);

        //show Avail Rooms Panel
        this.backToLowBtn_1 = new JButton("Back");
        this.backToLowBtn_1.setPreferredSize(new Dimension(620, 30));
        this.backToLowBtn_1.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.showAvailRoomLbl = new JLabel("Available Rooms: ");
        this.showAvailRoomLbl.setPreferredSize(new Dimension(330, 30));
        this.showAvailRoomLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.totalBookedLbl = new JLabel("Total Booked Rooms: ");
        this.totalBookedLbl.setPreferredSize(new Dimension(330, 30));
        this.totalBookedLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.availRoomsTA = new JTextArea(50, 100);
        this.availRoomsTA.setPreferredSize(new Dimension(330, 100));
        this.availRoomsTA.setEditable(false);
        this.availRoomsTA.setLineWrap(true);
        this.availRoomsTA.setWrapStyleWord(true);

        JScrollPane availScroll = new JScrollPane(availRoomsTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        availScroll.setPreferredSize(new Dimension(330, 100));

        JPanel listPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listPanel3.add(availScroll);
        listPanel3.setPreferredSize(new Dimension(620, 100));

        chkAvailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chkAvailPanel.setPreferredSize(new Dimension(620, 1080));
        chkAvailPanel.add(titleLbl_4);
        chkAvailPanel.add(totalBookedLbl);
        chkAvailPanel.add(showAvailRoomLbl);
        chkAvailPanel.add(listPanel3);
        chkAvailPanel.add(backToLowBtn_1);

        //roomList Panel
        this.inputRoomNameLbl = new JLabel("Input Room Name: ");
        this.inputRoomNameLbl.setPreferredSize(new Dimension(600, 30));
        this.inputRoomNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.inputRoomNameTF = new JTextField();
        this.inputRoomNameTF.setColumns(10);
        this.inputRoomNameTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseRoomBtn = new JButton("Choose Room");
        this.chooseRoomBtn.setPreferredSize(new Dimension(200, 30));
        this.chooseRoomBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_3 = new JLabel("");
        this.feedbackLbl_3.setPreferredSize(new Dimension(600, 30));
        this.feedbackLbl_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToLowBtn_5 = new JButton("Back");
        this.backToLowBtn_5.setPreferredSize(new Dimension(100, 30));
        this.backToLowBtn_5.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JLabel chooseRoomLbl = new JLabel("Rooms:", JLabel.CENTER);
        chooseRoomLbl.setPreferredSize(new Dimension(330, 30));
        chooseRoomLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JPanel chooseRoomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chooseRoomPanel.add(inputRoomNameTF);
        chooseRoomPanel.add(chooseRoomBtn);
        chooseRoomPanel.add(backToLowBtn_5);
        

        this.roomListTA = new JTextArea(50, 100);
        this.roomListTA.setPreferredSize(new Dimension(330, 100));
        this.roomListTA.setEditable(false);
        this.roomListTA.setLineWrap(true);
        this.roomListTA.setWrapStyleWord(true);

        JScrollPane roomScroll = new JScrollPane(roomListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        roomScroll.setPreferredSize(new Dimension(330, 100));

        JPanel roomList = new JPanel(new FlowLayout(FlowLayout.CENTER));
        roomList.add(chooseRoomLbl);
        roomList.add(roomScroll);
        roomList.setPreferredSize(new Dimension(620, 300));
        
        roomListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        roomListPanel.setPreferredSize(new Dimension(620, 1080));
        roomListPanel.add(titleLbl_7);
        roomListPanel.add(feedbackLbl_3);
        roomListPanel.add(inputRoomNameLbl);
        roomListPanel.add(chooseRoomPanel);
        roomListPanel.add(roomList);

        //view Room Panel
        this.roomNameLbl = new JLabel("Room Name: ");
        this.roomNameLbl.setPreferredSize(new Dimension(600, 30));
        this.roomNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomPriceLbl = new JLabel("Room Price: ");
        this.roomPriceLbl.setPreferredSize(new Dimension(600, 30));
        this.roomPriceLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomTypeLbl = new JLabel("Room Type: ");
        this.roomTypeLbl.setPreferredSize(new Dimension(600, 30));
        this.roomTypeLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.reservedDatesLbl = new JLabel("Reservation Dates: ");
        this.reservedDatesLbl.setPreferredSize(new Dimension(600, 30));
        this.reservedDatesLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToLowBtn_2 = new JButton("Back");
        this.backToLowBtn_2.setPreferredSize(new Dimension(620, 30));
        this.backToLowBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        viewRoomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewRoomPanel.setPreferredSize(new Dimension(620, 1080));
        viewRoomPanel.add(titleLbl_5);
        viewRoomPanel.add(roomNameLbl);
        viewRoomPanel.add(roomTypeLbl);
        viewRoomPanel.add(roomPriceLbl);
        viewRoomPanel.add(reservedDatesLbl);
        viewRoomPanel.add(backToLowBtn_2);

        //ReservationList Panel
        this.inputReservaLbl = new JLabel("Input Reservation Name: ");
        this.inputReservaLbl.setPreferredSize(new Dimension(600, 30));
        this.inputReservaLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.inputReserveTF = new JTextField();
        this.inputReserveTF.setColumns(10);
        this.inputReserveTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseReserveBtn = new JButton("Choose Reservation");
        this.chooseReserveBtn.setPreferredSize(new Dimension(200, 30));
        this.chooseReserveBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToLowBtn_6 = new JButton("Back");
        this.backToLowBtn_6.setPreferredSize(new Dimension(100, 30));
        this.backToLowBtn_6.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_4 = new JLabel("");
        this.feedbackLbl_4.setPreferredSize(new Dimension(600, 30));
        this.feedbackLbl_4.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.reserveListTA = new JTextArea(50, 100);
        this.reserveListTA.setPreferredSize(new Dimension(330, 100));
        this.reserveListTA.setEditable(false);
        this.reserveListTA.setLineWrap(true);
        this.reserveListTA.setLineWrap(true);
        
        JScrollPane scroll2 = new JScrollPane(reserveListTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setPreferredSize(new Dimension(330, 100));

        JLabel chooseLbl2 = new JLabel("Reservations: ", JLabel.CENTER);
        chooseLbl2.setPreferredSize(new Dimension(620, 30));
        chooseLbl2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        JPanel chooseReserve = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chooseReserve.add(inputReserveTF);
        chooseReserve.add(chooseReserveBtn);
        chooseReserve.add(backToLowBtn_6);
        chooseReserve.setPreferredSize(new Dimension(620, 50));

        JPanel listPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listPanel2.add(chooseLbl2);
        listPanel2.add(scroll2);
        listPanel2.setPreferredSize(new Dimension(620, 200));
        
        reservationListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        reservationListPanel.setPreferredSize(new Dimension(620, 1080));
        reservationListPanel.add(titleLbl_8);
        reservationListPanel.add(inputReservaLbl);
        reservationListPanel.add(feedbackLbl_4);
        reservationListPanel.add(chooseReserve);
        reservationListPanel.add(listPanel2);

        //view Reservation Panel
        this.guestNameLbl = new JLabel("Guest Name: ");
        this.guestNameLbl.setPreferredSize(new Dimension(600, 30));
        this.guestNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomNumLbl = new JLabel("Room Number: ");
        this.roomNumLbl.setPreferredSize(new Dimension(600, 30));
        this.roomNumLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.checkInLbl = new JLabel("Check-In Date: ");
        this.checkInLbl.setPreferredSize(new Dimension(600, 30));
        this.checkInLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.checkOutLbl = new JLabel("Check-Out Date: ");
        this.checkOutLbl.setPreferredSize(new Dimension(600, 30));
        this.checkOutLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.pricePerNytLbl = new JLabel("Price-per-Night: ");
        this.pricePerNytLbl.setPreferredSize(new Dimension(600, 30));
        this.pricePerNytLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.discountLbl = new JLabel("Price-per-Night: ");
        this.discountLbl.setPreferredSize(new Dimension(600, 30));
        this.discountLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.totalPriceLbl = new JLabel("Total Price: ");
        this.totalPriceLbl.setPreferredSize(new Dimension(600, 30));
        this.totalPriceLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToLowBtn_3 = new JButton("Back to View Hotel");
        this.backToLowBtn_3.setPreferredSize(new Dimension(620, 30));
        this.backToLowBtn_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        viewReservePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewReservePanel.setPreferredSize(new Dimension(620, 1080));
        viewReservePanel.add(titleLbl_6);
        viewReservePanel.add(guestNameLbl);
        viewReservePanel.add(roomNumLbl);
        viewReservePanel.add(checkInLbl);
        viewReservePanel.add(checkOutLbl);
        viewReservePanel.add(pricePerNytLbl);
        viewReservePanel.add(discountLbl);
        viewReservePanel.add(totalPriceLbl);
        viewReservePanel.add(backToLowBtn_3);

        //main
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(new Dimension(650, 630));
        mainPanel.add(titleLbl);
        mainPanel.add(feedbackLbl);
        mainPanel.add(highInfoBtn);
        mainPanel.add(lowInfoBtn);
        mainPanel.add(backToMainBtn);

        //private JPanel chkAvailPanel, viewRoomPanel, viewReservePanel, inputDatePanel, roomListPanel, reservationListPanel; 

        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(hotelListPanel, "HotelListPanel");
        cardPanel.add(mainPanel, "MainPanel");
        cardPanel.add(highLvlPanel, "HighLvlPanel");
        cardPanel.add(lowLvlPanel, "LowLvlPanel");

        cardPanel.add(inputDatePanel, "InputDatePanel");
        cardPanel.add(chkAvailPanel, "CheckAvailPanel");
        cardPanel.add(roomListPanel, "RoomListPanel");
        cardPanel.add(viewRoomPanel, "ViewRoomPanel");
        cardPanel.add(reservationListPanel, "ReservationListPanel");
        cardPanel.add(viewReservePanel, "ViewReservePanel");

        mainFrame.add(cardPanel);

    }

    //action Listeners
    public void highLvlAL(ActionListener al){
        this.highInfoBtn.addActionListener(al);
    }

    public void backToViewAL_1(ActionListener al){
        this.backToViewBtn_1.addActionListener(al);
    }

    public void lowLvlAL(ActionListener al){
        this.lowInfoBtn.addActionListener(al);
    }
    
    public void backToViewAL_2(ActionListener al){
        this.backToViewBtn_2.addActionListener(al);
    }

    public void backToMainAL(ActionListener al){
        this.backToMainBtn.addActionListener(al);
    }
    public void backToMainAL_2(ActionListener al){
        this.backBtn.addActionListener(al);
    }

    public void goToViewAL(ActionListener al){
        this.viewBtn.addActionListener(al);
    }

    //check Avail Room Panel

    public void goToInputDateAL(ActionListener al){
        this.chkAvailBtn.addActionListener(al);
    }

    public void goToChkAvailAL(ActionListener al){
        this.checkBtn.addActionListener(al);
    }

    public void backToLowAL_1(ActionListener al){
        this.backToLowBtn_1.addActionListener(al);
    }
    public void backToLowAL_4(ActionListener al){
        this.backToLowBtn_4.addActionListener(al);
    }

    //view Room Panel
    public void goToChooseRoomAL(ActionListener al){
        this.viewRoomBtn.addActionListener(al);
    }

    public void goToViewRoomAL(ActionListener al){
        this.chooseRoomBtn.addActionListener(al);
    }

    public void backToLowAL_2(ActionListener al){
        this.backToLowBtn_2.addActionListener(al);
    }
    public void backToLowAL_5(ActionListener al){
        this.backToLowBtn_5.addActionListener(al);
    }

    //view Reservation Panel
    public void goToChooseReserveAL(ActionListener al){
        this.viewReserveBtn.addActionListener(al);
    }

    public void goToViewReserveAL(ActionListener al){
        this.chooseReserveBtn.addActionListener(al);
    }

    public void backToLowAL_3(ActionListener al){
        this.backToLowBtn_3.addActionListener(al);
    }
    public void backToLowAL_6(ActionListener al){
        this.backToLowBtn_6.addActionListener(al);
    }

    //show/close
    public void show(boolean visible){
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }

    //Text
    public void setFeedbackLbl(String text){
        this.feedbackLbl.setText(text);
    }

    public void setFeedbackLbl_2(String text){
        this.feedbackLbl_2.setText(text);
    }

    public void setFeedbackLbl_3(String text){
        this.feedbackLbl_3.setText(text);
    }

    public void setFeedbackLbl_4(String text){
        this.feedbackLbl_4.setText(text);
    }

    public void setHotelFeedbackLbl(String text){this.hotelFeedbackLbl.setText(text);}

    public void clearTF(){
        this.chooseHotelTF.setText("");
    }

    public void clearTF_2(){
        this.inputDateTF.setText("");
    }

    public void clearTF_3(){
        this.inputRoomNameTF.setText("");
    }

    public void clearTF_4(){
        this.inputReserveTF.setText("");
    }

    public String getChooseHotelText() {
        return chooseHotelTF.getText();
    }

    public int getInputDateText() {
        try {
            return Integer.parseInt(inputDateTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + inputDateTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }


    public int getInputRoomNameText() {
        try {
            return Integer.parseInt(inputRoomNameTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + inputRoomNameTF.getText() + " is not a valid integer.");
            return -1;
        }
    }

    public String getInputReserveText() {
        return inputReserveTF.getText();
    }


    // Method to display high level info
    public void displayHotelHighInfo(Hotel hotel) {
        hotelNameLbl.setText("Hotel Name: " + hotel.getHotelName());
        NumRoomLbl.setText("Total Number of Rooms: " + hotel.getRoomManager().getRoomList().size());
        MnthEarnLbl.setText("Estimated Monthly Earnings: " + String.format("%.2f", hotel.computeEarnings()));
    }

    public void displayAvailableRooms(List<Room> rooms, int totalBookedRooms) {
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.getRoomName()).append("\n");
        }
        availRoomsTA.setText(sb.toString());
        totalBookedLbl.setText("Total Booked Rooms: " + totalBookedRooms);
    }

    public void displayRoomInfo(Room room) {
        if (room != null) {
            StringBuilder sb = new StringBuilder();
            int[] reservedDates = room.getReservedDates();
  
            if (room.computeReservedDates() > 0) {
                for (int i = 0; i < 31; i++) {
                    if (reservedDates[i] != 0) {
                        if(i > 0)
                            sb.append(", ");
                        sb.append(i+1);
                    }
                }
            } else {
                sb.append("None");
            }
            System.out.println("Room Name: " + room.getRoomName());
            roomNameLbl.setText("Room Name: " + room.getRoomName());
            roomTypeLbl.setText("Room Type: " + room.getRoomType());
            roomPriceLbl.setText("Room Price: " + room.getRoomPrice());
            reservedDatesLbl.setText("Reserved Dates: " + sb.toString());
        } 
    }
    

    public void displayReservations(Reservation reservation, Hotel hotel) {
        if (reservation != null && hotel != null) {
            int date;
            String discount = "";
            if(reservation instanceof DiscountedReservation) {
                discount = ((DiscountedReservation) reservation).getDiscountCode();
                if(discount.equals("STAY4_GET1"))
                    date = reservation.getCheckInDate() + 1;
                else
                    date = reservation.getCheckInDate();
            } else
                date = reservation.getCheckInDate();
            guestNameLbl.setText("Guest Name: " + reservation.getGuestName());
            roomNumLbl.setText("Room No.: " + reservation.getRoom().getRoomName());
            checkInLbl.setText("Check-In Date: " + reservation.getCheckInDate());
            checkOutLbl.setText("Check-Out Date: " + reservation.getCheckOutDate());
            pricePerNytLbl.setText("Price-per-Night: $" + String.format("%.2f", reservation.getDatePrice(date, hotel)) + " x " + (reservation.getCheckOutDate() - reservation.getCheckInDate()) + " nights");

            if(discount.equals("I_WORK_HERE"))
                discountLbl.setText("Discount: I_WORK_HERE (less 10% of $" + String.format("%.2f",(reservation.getDatePrice(date, hotel)) * (reservation.getCheckOutDate() - reservation.getCheckInDate()))+ ")");
            else if(discount.equals("STAY4_GET1"))
                discountLbl.setText("Discount: STAY4_GET1 (less $" + String.format("%.2f",reservation.getDatePrice(date, hotel))+")");
            else if(discount.equals("PAYDAY"))
                discountLbl.setText("Discount: PAYDAY (less 7% of $" + String.format("%.2f",(reservation.getDatePrice(date, hotel)) * (reservation.getCheckOutDate() - reservation.getCheckInDate()))+ ")");
            else
                discountLbl.setText("Discount: (none)");
            totalPriceLbl.setText("Total Price: $" + String.format("%.2f", reservation.computeTotalPrice(hotel)));
        }
    }

    //switch panels
    public void switchPanel(String panelName){
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    public void setHotelListTA(String text) {
        this.hotelListTA.setText(text);
    }
    public void setReserveListTA(String text){this.reserveListTA.setText(text);}
    public void setViewReserveEnabled(boolean enabled){this.viewReserveBtn.setEnabled(enabled);}
    public void setRoomListTA(String text){this.roomListTA.setText(text);}
}
