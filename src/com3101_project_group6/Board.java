/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com3101_project_group6;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author cyrus
 */
public class Board extends javax.swing.JFrame {

    private static Board _instance;
    private static Controller controller;

    private int num_player = 0;
    private int num_bot = 0;
    private boolean playing = false;
    private int dice_num = 0;
    private int turn_of_player_no = 1;
    private int player_one_pos = 1;
    private int player_two_pos = 1;
    private int player_three_pos = 1;
    private int player_four_pos = 1;


    public static Board getInstance() throws IOException {
        if (_instance == null) {
            _instance = new Board();
        }
        return _instance;
    }

    // Get the screen dimensions
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Calculate the desired width and height
    int maxWidth = screenSize.width;
    int maxHeight = screenSize.height;
    int boardLength = Math.min(maxWidth, maxHeight);  // Set width and height to the minimum value

    /**
     * Creates new form Board
     */
    private Board() {
    }

    public void showBoard(Controller controller) throws IOException {
        this.controller = controller;
        initComponents();
        setFrame();
        setBoard();
    }

    private void setFrame() {
        this.setSize(new Dimension(boardLength, boardLength + 50));
        this.setVisible(true);
        this.setResizable(false);
    }

    private void setBoard() throws IOException {
        Dimension labelDimension = new Dimension(boardLength, boardLength); // Create a new size with the calculated dimensions
        // Set the size of background
        jLayeredPane1.setPreferredSize(labelDimension);
        jPanel1.setPreferredSize(labelDimension);
        jLabel1.setPreferredSize(labelDimension);
        try { // Code that may potentially throw an IOException
            // Load the original image
            BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("images/hsu_board_final.png"));
            // Set width and height to the minimum value
            // Determine the scaling factors
            double widthRatio = (double) boardLength / originalImage.getWidth();
            double heightRatio = (double) boardLength / originalImage.getHeight();
            double scaleFactor = Math.min(widthRatio, heightRatio);
            // Calculate the new dimensions based on the aspect ratio
            int scaledWidth = (int) (originalImage.getWidth() * scaleFactor);
            int scaledHeight = (int) (originalImage.getHeight() * scaleFactor);
            // Create a scaled version of the image
            Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight - 30, Image.SCALE_SMOOTH);
            // Create a new ImageIcon with the scaled image
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            // Set the scaled image icon to the JLabel
            jLabel1.setIcon(scaledIcon);
        } catch (IOException e) {
            ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("images/hsu_board_final.png"));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(boardLength, boardLength, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            jLabel1.setIcon(scaledIcon);
        }

        // Set the size of palette
        jPanel_setting.setPreferredSize(labelDimension);
    }

    public void moveToken(int player_no, int move) {
        if (player_no == 1) {
            int oriPos = player_one_pos;
            player_one_pos = player_one_pos + move;
            if (player_one_pos > 40) {
                player_one_pos = player_one_pos - 40;
            }
            showHideIcon(player_no, oriPos, player_one_pos);
        } else if (player_no == 2) {
            int oriPos = player_two_pos;
            player_two_pos = player_two_pos + move;
            if (player_two_pos > 40) {
                player_two_pos = player_two_pos - 40;
            }
            showHideIcon(player_no, oriPos, player_two_pos);
        } else if (player_no == 3) {
            int oriPos = player_three_pos;
            player_three_pos = player_three_pos + move;
            if (player_three_pos > 40) {
                player_three_pos = player_three_pos - 40;
            }
            showHideIcon(player_no, oriPos, player_three_pos);
        } else {
            int oriPos = player_four_pos;
            player_four_pos = player_four_pos + move;
            if (player_four_pos > 40) {
                player_four_pos = player_four_pos - 40;
            }
            showHideIcon(player_no, oriPos, player_four_pos);
        }

    }

    private void showHideIcon(int player_no, int oriPos, int newPos) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel_setting = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_add_player = new javax.swing.JButton();
        btn_add_bot = new javax.swing.JButton();
        lb_players = new javax.swing.JLabel();
        label_bots = new javax.swing.JLabel();
        tf_num_bot = new javax.swing.JTextField();
        tf_num_player = new javax.swing.JTextField();
        btn_del_player = new javax.swing.JButton();
        btn_del_bot = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        img_2nd_dice = new javax.swing.JLabel();
        img_1st_dice = new javax.swing.JLabel();
        btn_roll_dice = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        img_token_one = new javax.swing.JLabel();
        lb_bal = new javax.swing.JLabel();
        current_player_one = new javax.swing.JLabel();
        current_player_two = new javax.swing.JLabel();
        current_player_three = new javax.swing.JLabel();
        current_player_four = new javax.swing.JLabel();
        lb_msg = new javax.swing.JLabel();
        btn_newgame = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        img_token_two = new javax.swing.JLabel();
        img_token_three = new javax.swing.JLabel();
        img_token_four = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btn_buy = new javax.swing.JButton();
        tf_trade_property = new javax.swing.JTextField();
        lb_avail_trade = new javax.swing.JLabel();
        btn_trade = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        img_token_one1 = new javax.swing.JLabel();
        img_token_two1 = new javax.swing.JLabel();
        img_token_three1 = new javax.swing.JLabel();
        img_token_four1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_token10 = new javax.swing.JTextField();
        img_token_one10 = new javax.swing.JLabel();
        img_token_two10 = new javax.swing.JLabel();
        img_token_four10 = new javax.swing.JLabel();
        img_token_three10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        img_token_three11_jailed = new javax.swing.JLabel();
        img_token_one11_jailed = new javax.swing.JLabel();
        img_token_two11_jailed = new javax.swing.JLabel();
        img_token_four11_jailed = new javax.swing.JLabel();
        img_token_one11 = new javax.swing.JLabel();
        img_token_three11 = new javax.swing.JLabel();
        img_token_four11 = new javax.swing.JLabel();
        img_token_two11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_token9 = new javax.swing.JTextField();
        img_token_one9 = new javax.swing.JLabel();
        img_token_two9 = new javax.swing.JLabel();
        img_token_four9 = new javax.swing.JLabel();
        img_token_three9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_token8 = new javax.swing.JTextField();
        img_token_one8 = new javax.swing.JLabel();
        img_token_two8 = new javax.swing.JLabel();
        img_token_four8 = new javax.swing.JLabel();
        img_token_three8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tf_token7 = new javax.swing.JTextField();
        img_token_on7 = new javax.swing.JLabel();
        img_token_two7 = new javax.swing.JLabel();
        img_token_four7 = new javax.swing.JLabel();
        img_token_three7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_token6 = new javax.swing.JTextField();
        img_token_one6 = new javax.swing.JLabel();
        img_token_two6 = new javax.swing.JLabel();
        img_token_four6 = new javax.swing.JLabel();
        img_token_three6 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_token5 = new javax.swing.JTextField();
        img_token_one5 = new javax.swing.JLabel();
        img_token_two5 = new javax.swing.JLabel();
        img_token_four5 = new javax.swing.JLabel();
        img_token_three5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_token4 = new javax.swing.JTextField();
        img_token_one4 = new javax.swing.JLabel();
        img_token_two4 = new javax.swing.JLabel();
        img_token_four4 = new javax.swing.JLabel();
        img_token_three4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tf_token3 = new javax.swing.JTextField();
        img_token_one3 = new javax.swing.JLabel();
        img_token_two3 = new javax.swing.JLabel();
        img_token_four3 = new javax.swing.JLabel();
        img_token_three3 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tf_token2 = new javax.swing.JTextField();
        img_token_one2 = new javax.swing.JLabel();
        img_token_two2 = new javax.swing.JLabel();
        img_token_four2 = new javax.swing.JLabel();
        img_token_three2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tf_token12 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        img_token_two13 = new javax.swing.JLabel();
        img_token_one13 = new javax.swing.JLabel();
        img_token_three13 = new javax.swing.JLabel();
        img_token_four13 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        tf_token13 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        img_token_two14 = new javax.swing.JLabel();
        img_token_one14 = new javax.swing.JLabel();
        img_token_three14 = new javax.swing.JLabel();
        img_token_four14 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        tf_token18 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        img_token_two19 = new javax.swing.JLabel();
        img_token_one19 = new javax.swing.JLabel();
        img_token_three19 = new javax.swing.JLabel();
        img_token_four19 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        tf_token20 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        img_token_two21 = new javax.swing.JLabel();
        img_token_one21 = new javax.swing.JLabel();
        img_token_three21 = new javax.swing.JLabel();
        img_token_four21 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        tf_token21 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        img_token_two22 = new javax.swing.JLabel();
        img_token_one22 = new javax.swing.JLabel();
        img_token_three22 = new javax.swing.JLabel();
        img_token_four22 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        tf_token22 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        img_token_two23 = new javax.swing.JLabel();
        img_token_one23 = new javax.swing.JLabel();
        img_token_three23 = new javax.swing.JLabel();
        img_token_four23 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        img_token_one24 = new javax.swing.JLabel();
        img_token_two24 = new javax.swing.JLabel();
        img_token_three24 = new javax.swing.JLabel();
        img_token_four24 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        img_token_two25 = new javax.swing.JLabel();
        img_token_one25 = new javax.swing.JLabel();
        img_token_three25 = new javax.swing.JLabel();
        img_token_four25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tf_token23 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        img_token_two26 = new javax.swing.JLabel();
        img_token_one26 = new javax.swing.JLabel();
        img_token_three26 = new javax.swing.JLabel();
        img_token_four26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tf_token24 = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        img_token_two27 = new javax.swing.JLabel();
        img_token_one27 = new javax.swing.JLabel();
        img_token_three27 = new javax.swing.JLabel();
        img_token_four27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tf_token25 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        img_token_two28 = new javax.swing.JLabel();
        img_token_one28 = new javax.swing.JLabel();
        img_token_three28 = new javax.swing.JLabel();
        img_token_four28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tf_token26 = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        img_token_two29 = new javax.swing.JLabel();
        img_token_one29 = new javax.swing.JLabel();
        img_token_three29 = new javax.swing.JLabel();
        img_token_four29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_token27 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        img_token_two30 = new javax.swing.JLabel();
        img_token_one30 = new javax.swing.JLabel();
        img_token_three30 = new javax.swing.JLabel();
        img_token_four30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tf_token28 = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        img_token_two31 = new javax.swing.JLabel();
        img_token_one31 = new javax.swing.JLabel();
        img_token_three31 = new javax.swing.JLabel();
        img_token_four31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tf_token29 = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        img_token_two32 = new javax.swing.JLabel();
        img_token_one32 = new javax.swing.JLabel();
        img_token_three32 = new javax.swing.JLabel();
        img_token_four32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tf_token30 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        img_token_two33 = new javax.swing.JLabel();
        img_token_one33 = new javax.swing.JLabel();
        img_token_three33 = new javax.swing.JLabel();
        img_token_four33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tf_token31 = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        img_token_one7 = new javax.swing.JLabel();
        img_token_two34 = new javax.swing.JLabel();
        img_token_three34 = new javax.swing.JLabel();
        img_token_four34 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        tf_token32 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        img_token_one34 = new javax.swing.JLabel();
        img_token_three35 = new javax.swing.JLabel();
        img_token_four35 = new javax.swing.JLabel();
        img_token_two35 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        tf_token33 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        img_token_one35 = new javax.swing.JLabel();
        img_token_three36 = new javax.swing.JLabel();
        img_token_four36 = new javax.swing.JLabel();
        img_token_two36 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        tf_token34 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        img_token_one36 = new javax.swing.JLabel();
        img_token_three37 = new javax.swing.JLabel();
        img_token_four37 = new javax.swing.JLabel();
        img_token_two37 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        tf_token35 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        img_token_one37 = new javax.swing.JLabel();
        img_token_three38 = new javax.swing.JLabel();
        img_token_four38 = new javax.swing.JLabel();
        img_token_two38 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        tf_token36 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        img_token_one38 = new javax.swing.JLabel();
        img_token_three39 = new javax.swing.JLabel();
        img_token_four39 = new javax.swing.JLabel();
        img_token_two39 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        tf_token37 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        img_token_one39 = new javax.swing.JLabel();
        img_token_three40 = new javax.swing.JLabel();
        img_token_four40 = new javax.swing.JLabel();
        img_token_two40 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        tf_token38 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        img_token_one40 = new javax.swing.JLabel();
        img_token_three41 = new javax.swing.JLabel();
        img_token_four41 = new javax.swing.JLabel();
        img_token_two41 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        tf_token39 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        img_token_one41 = new javax.swing.JLabel();
        img_token_three42 = new javax.swing.JLabel();
        img_token_four42 = new javax.swing.JLabel();
        img_token_two42 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        tf_token40 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        img_token_one42 = new javax.swing.JLabel();
        img_token_three43 = new javax.swing.JLabel();
        img_token_four43 = new javax.swing.JLabel();
        img_token_two43 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        tf_token14 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        img_token_two15 = new javax.swing.JLabel();
        img_token_one15 = new javax.swing.JLabel();
        img_token_three15 = new javax.swing.JLabel();
        img_token_four15 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        tf_token16 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        img_token_two17 = new javax.swing.JLabel();
        img_token_one17 = new javax.swing.JLabel();
        img_token_three17 = new javax.swing.JLabel();
        img_token_four17 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        tf_token17 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        img_token_two18 = new javax.swing.JLabel();
        img_token_one18 = new javax.swing.JLabel();
        img_token_three18 = new javax.swing.JLabel();
        img_token_four18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_setting.setOpaque(false);

        btn_add_player.setText("+");
        btn_add_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_playerActionPerformed(evt);
            }
        });

        btn_add_bot.setText("+");
        btn_add_bot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_botActionPerformed(evt);
            }
        });

        lb_players.setText("No. of Players:");

        label_bots.setText("No. of Bots:");

        tf_num_bot.setText("0");
        tf_num_bot.setEnabled(false);

        tf_num_player.setText("0");
        tf_num_player.setEnabled(false);
        tf_num_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_num_playerActionPerformed(evt);
            }
        });

        btn_del_player.setText("-");
        btn_del_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del_playerActionPerformed(evt);
            }
        });

        btn_del_bot.setText("-");
        btn_del_bot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del_botActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_add_player, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_num_player, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_del_player, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_players)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_add_bot, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_num_bot, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_del_bot, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label_bots, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_players)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_player)
                    .addComponent(tf_num_player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del_player))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_bots)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_bot)
                    .addComponent(tf_num_bot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del_bot))
                .addContainerGap())
        );

        img_2nd_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/dice_zero.png"))); // NOI18N

        img_1st_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/dice_one.png"))); // NOI18N

        btn_roll_dice.setText("Roll Dice");
        btn_roll_dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roll_diceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(img_1st_dice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_2nd_dice)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_roll_dice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_2nd_dice, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img_1st_dice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_roll_dice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("2000");

        img_token_one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_one.png"))); // NOI18N

        lb_bal.setText("Balance:");

        current_player_one.setText("↓");

        current_player_two.setText(" ");

        current_player_three.setText(" ");

        current_player_four.setText(" ");

        lb_msg.setText("Start a new game!");

        btn_newgame.setText("New Game");
        btn_newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newgameActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("2000");

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("2000");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("2000");

        img_token_two.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_two.png"))); // NOI18N

        img_token_three.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_three.png"))); // NOI18N

        img_token_four.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_four.png"))); // NOI18N

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_bal)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img_token_one)
                                            .addComponent(current_player_one))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img_token_two)
                                            .addComponent(current_player_two))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(current_player_three)
                                            .addComponent(img_token_three)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(img_token_four)
                                    .addComponent(current_player_four))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_newgame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(current_player_two)
                            .addComponent(current_player_one)
                            .addComponent(current_player_three)
                            .addComponent(current_player_four))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(img_token_two))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(img_token_one)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(img_token_three, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(img_token_four))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_bal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_msg)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_newgame)
                        .addComponent(btn_reset)))
                .addContainerGap())
        );

        jPanel5.setOpaque(false);

        btn_buy.setText("Buy");
        btn_buy.setEnabled(false);
        btn_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buyActionPerformed(evt);
            }
        });

        lb_avail_trade.setText("Now Available:");

        btn_trade.setText("Trade");
        btn_trade.setEnabled(false);
        btn_trade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btn_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_trade, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lb_avail_trade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_trade_property, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_avail_trade)
                    .addComponent(tf_trade_property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buy)
                    .addComponent(btn_trade))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setOpaque(false);

        img_token_one1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_one.png"))); // NOI18N

        img_token_two1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_two.png"))); // NOI18N

        img_token_three1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_three.png"))); // NOI18N

        img_token_four1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_four.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(img_token_one1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_two1))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(img_token_three1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_four1))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one1)
                    .addComponent(img_token_two1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three1)
                    .addComponent(img_token_four1)))
        );

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel2.setText("Owner:");

        tf_token10.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token10.setText("0");
        tf_token10.setEnabled(false);
        tf_token10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token10ActionPerformed(evt);
            }
        });

        img_token_one10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_token10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(img_token_one10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(img_token_three10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four10)))
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_token10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one10)
                    .addComponent(img_token_two10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three10)
                    .addComponent(img_token_four10))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        img_token_three11_jailed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one11_jailed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two11_jailed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four11_jailed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img_token_two11))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(img_token_one11_jailed)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two11_jailed))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(img_token_three11_jailed)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four11_jailed)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(img_token_three11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img_token_four11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(img_token_one11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(img_token_two11))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one11_jailed)
                            .addComponent(img_token_two11_jailed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three11_jailed)
                            .addComponent(img_token_four11_jailed))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_four11)
                            .addComponent(img_token_three11)))))
        );

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel5.setText("Owner:");

        tf_token9.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token9.setText("0");
        tf_token9.setEnabled(false);
        tf_token9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token9ActionPerformed(evt);
            }
        });

        img_token_one9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(img_token_one9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(img_token_three9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_token9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one9)
                    .addComponent(img_token_two9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three9)
                    .addComponent(img_token_four9))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel6.setText("Owner:");

        tf_token8.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token8.setText("0");
        tf_token8.setEnabled(false);
        tf_token8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token8ActionPerformed(evt);
            }
        });

        img_token_one8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(img_token_one8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two8))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(img_token_three8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four8))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_token8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one8)
                    .addComponent(img_token_two8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three8)
                    .addComponent(img_token_four8))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel7.setText("Owner:");

        tf_token7.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token7.setText("0");
        tf_token7.setEnabled(false);
        tf_token7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token7ActionPerformed(evt);
            }
        });

        img_token_on7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(img_token_on7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two7))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(img_token_three7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four7))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_token7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_on7)
                    .addComponent(img_token_two7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three7)
                    .addComponent(img_token_four7))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel8.setText("Owner:");

        tf_token6.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token6.setText("0");
        tf_token6.setEnabled(false);
        tf_token6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token6ActionPerformed(evt);
            }
        });

        img_token_one6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(img_token_one6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two6))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(img_token_three6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four6))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_token6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one6)
                    .addComponent(img_token_two6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three6)
                    .addComponent(img_token_four6))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel9.setText("Owner:");

        tf_token5.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token5.setText("0");
        tf_token5.setEnabled(false);
        tf_token5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token5ActionPerformed(evt);
            }
        });

        img_token_one5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(img_token_one5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two5))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(img_token_three5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four5))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_token5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one5)
                    .addComponent(img_token_two5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three5)
                    .addComponent(img_token_four5))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel10.setText("Owner:");

        tf_token4.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token4.setText("0");
        tf_token4.setEnabled(false);
        tf_token4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token4ActionPerformed(evt);
            }
        });

        img_token_one4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(img_token_one4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two4))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(img_token_three4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four4))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_token4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one4)
                    .addComponent(img_token_two4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three4)
                    .addComponent(img_token_four4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel11.setText("Owner:");

        tf_token3.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token3.setText("0");
        tf_token3.setEnabled(false);
        tf_token3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token3ActionPerformed(evt);
            }
        });

        img_token_one3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(img_token_one3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two3))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(img_token_three3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four3))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_token3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one3)
                    .addComponent(img_token_two3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three3)
                    .addComponent(img_token_four3))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel12.setText("Owner:");

        tf_token2.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token2.setText("0");
        tf_token2.setEnabled(false);
        tf_token2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token2ActionPerformed(evt);
            }
        });

        img_token_one2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(img_token_one2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two2))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(img_token_three2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four2))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tf_token2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_token2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one2)
                    .addComponent(img_token_two2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three2)
                    .addComponent(img_token_four2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tf_token12.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token12.setText("0");
        tf_token12.setEnabled(false);
        tf_token12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token12ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel4.setText("Owner:");

        img_token_two13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(img_token_one13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two13))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(img_token_three13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four13)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(tf_token12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one13)
                        .addComponent(img_token_two13))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three13)
                        .addComponent(img_token_four13))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        jPanel19.setPreferredSize(new java.awt.Dimension(124, 80));

        tf_token13.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token13.setText("0");
        tf_token13.setEnabled(false);
        tf_token13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token13ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel13.setText("Owner:");

        img_token_two14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addComponent(img_token_one14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two14))
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addComponent(img_token_three14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four14)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(8, 8, 8)
                .addComponent(tf_token13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one14)
                        .addComponent(img_token_two14))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three14)
                        .addComponent(img_token_four14))
                    .addContainerGap(14, Short.MAX_VALUE)))
        );

        tf_token18.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token18.setText("0");
        tf_token18.setEnabled(false);
        tf_token18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token18ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel18.setText("Owner:");

        img_token_two19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addComponent(img_token_one19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two19))
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addComponent(img_token_three19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four19)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(8, 8, 8)
                .addComponent(tf_token18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one19)
                        .addComponent(img_token_two19))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three19)
                        .addComponent(img_token_four19))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tf_token20.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token20.setText("0");
        tf_token20.setEnabled(false);
        tf_token20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token20ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel20.setText("Owner:");

        img_token_two21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(img_token_one21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two21))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(img_token_three21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four21)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(8, 8, 8)
                .addComponent(tf_token20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one21)
                        .addComponent(img_token_two21))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three21)
                        .addComponent(img_token_four21))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tf_token21.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token21.setText("0");
        tf_token21.setEnabled(false);
        tf_token21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token21ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel21.setText("Owner:");

        img_token_two22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(img_token_one22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two22))
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(img_token_three22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four22)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(8, 8, 8)
                .addComponent(tf_token21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one22)
                        .addComponent(img_token_two22))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three22)
                        .addComponent(img_token_four22))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tf_token22.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token22.setText("0");
        tf_token22.setEnabled(false);
        tf_token22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token22ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel22.setText("Owner:");

        img_token_two23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(img_token_one23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two23))
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(img_token_three23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four23)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(8, 8, 8)
                .addComponent(tf_token22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one23)
                        .addComponent(img_token_two23))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three23)
                        .addComponent(img_token_four23))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        img_token_one24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_two24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_three24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_four24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(img_token_one24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_two24))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(img_token_three24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_four24))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one24)
                    .addComponent(img_token_two24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three24)
                    .addComponent(img_token_four24)))
        );

        img_token_two25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel23.setText("Owner:");

        tf_token23.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token23.setText("0");
        tf_token23.setEnabled(false);
        tf_token23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(img_token_one25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two25))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(img_token_three25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four25))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one25)
                    .addComponent(img_token_two25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three25)
                    .addComponent(img_token_four25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel24.setText("Owner:");

        tf_token24.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token24.setText("0");
        tf_token24.setEnabled(false);
        tf_token24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(img_token_one26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two26))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(img_token_three26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four26))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one26)
                    .addComponent(img_token_two26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three26)
                    .addComponent(img_token_four26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel25.setText("Owner:");

        tf_token25.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token25.setText("0");
        tf_token25.setEnabled(false);
        tf_token25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(img_token_one27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two27))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(img_token_three27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four27))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one27)
                    .addComponent(img_token_two27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three27)
                    .addComponent(img_token_four27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel26.setText("Owner:");

        tf_token26.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token26.setText("0");
        tf_token26.setEnabled(false);
        tf_token26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(img_token_one28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two28))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(img_token_three28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four28))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one28)
                    .addComponent(img_token_two28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three28)
                    .addComponent(img_token_four28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel27.setText("Owner:");

        tf_token27.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token27.setText("0");
        tf_token27.setEnabled(false);
        tf_token27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(img_token_one29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two29))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(img_token_three29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four29))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one29)
                    .addComponent(img_token_two29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three29)
                    .addComponent(img_token_four29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel28.setText("Owner:");

        tf_token28.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token28.setText("0");
        tf_token28.setEnabled(false);
        tf_token28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(img_token_one30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two30))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(img_token_three30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four30))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one30)
                    .addComponent(img_token_two30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three30)
                    .addComponent(img_token_four30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel29.setText("Owner:");

        tf_token29.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token29.setText("0");
        tf_token29.setEnabled(false);
        tf_token29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(img_token_one31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two31))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(img_token_three31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four31))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one31)
                    .addComponent(img_token_two31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three31)
                    .addComponent(img_token_four31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel30.setText("Owner:");

        tf_token30.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token30.setText("0");
        tf_token30.setEnabled(false);
        tf_token30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(img_token_one32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two32))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(img_token_three32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four32))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one32)
                    .addComponent(img_token_two32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three32)
                    .addComponent(img_token_four32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_two33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel31.setText("Owner:");

        tf_token31.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token31.setText("0");
        tf_token31.setEnabled(false);
        tf_token31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(img_token_one33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two33))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(img_token_three33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four33))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one33)
                    .addComponent(img_token_two33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three33)
                    .addComponent(img_token_four33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_token31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        img_token_one7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_two34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_three34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        img_token_four34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none.png"))); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(img_token_one7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_two34))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(img_token_three34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_token_four34))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_one7)
                    .addComponent(img_token_two34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_token_three34)
                    .addComponent(img_token_four34)))
        );

        tf_token32.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token32.setText("0");
        tf_token32.setEnabled(false);
        tf_token32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token32ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel32.setText("Owner:");

        img_token_one34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(tf_token32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(img_token_one34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two35))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(img_token_three35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four35)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one34)
                            .addComponent(img_token_two35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three35)
                            .addComponent(img_token_four35)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token33.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token33.setText("0");
        tf_token33.setEnabled(false);
        tf_token33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token33ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel33.setText("Owner:");

        img_token_one35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(tf_token33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(img_token_one35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two36))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(img_token_three36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one35)
                            .addComponent(img_token_two36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three36)
                            .addComponent(img_token_four36)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token34.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token34.setText("0");
        tf_token34.setEnabled(false);
        tf_token34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token34ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel34.setText("Owner:");

        img_token_one36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(tf_token34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(img_token_one36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two37))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(img_token_three37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four37)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one36)
                            .addComponent(img_token_two37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three37)
                            .addComponent(img_token_four37)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token35.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token35.setText("0");
        tf_token35.setEnabled(false);
        tf_token35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token35ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel35.setText("Owner:");

        img_token_one37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(tf_token35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(img_token_one37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two38))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(img_token_three38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four38)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one37)
                            .addComponent(img_token_two38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three38)
                            .addComponent(img_token_four38)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token36.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token36.setText("0");
        tf_token36.setEnabled(false);
        tf_token36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token36ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel36.setText("Owner:");

        img_token_one38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(tf_token36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(img_token_one38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two39))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(img_token_three39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four39)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one38)
                            .addComponent(img_token_two39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three39)
                            .addComponent(img_token_four39)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token37.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token37.setText("0");
        tf_token37.setEnabled(false);
        tf_token37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token37ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel37.setText("Owner:");

        img_token_one39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(tf_token37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(img_token_one39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two40))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(img_token_three40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four40)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one39)
                            .addComponent(img_token_two40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three40)
                            .addComponent(img_token_four40)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token38.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token38.setText("0");
        tf_token38.setEnabled(false);
        tf_token38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token38ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel38.setText("Owner:");

        img_token_one40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(tf_token38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(img_token_one40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two41))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(img_token_three41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four41)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one40)
                            .addComponent(img_token_two41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three41)
                            .addComponent(img_token_four41)))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token39.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token39.setText("0");
        tf_token39.setEnabled(false);
        tf_token39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token39ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel39.setText("Owner:");

        img_token_one41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(tf_token39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(img_token_one41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two42))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(img_token_three42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four42)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one41)
                            .addComponent(img_token_two42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three42)
                            .addComponent(img_token_four42)))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tf_token40.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token40.setText("0");
        tf_token40.setEnabled(false);
        tf_token40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token40ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel40.setText("Owner:");

        img_token_one42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_two43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(tf_token40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(img_token_one42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_two43))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(img_token_three43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_token_four43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_one42)
                            .addComponent(img_token_two43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_token_three43)
                            .addComponent(img_token_four43)))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_token40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel49.setOpaque(false);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        tf_token14.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token14.setText("0");
        tf_token14.setEnabled(false);
        tf_token14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token14ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel14.setText("Owner:");

        img_token_two15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(img_token_one15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two15))
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(img_token_three15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four15)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(8, 8, 8)
                .addComponent(tf_token14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one15)
                        .addComponent(img_token_two15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three15)
                        .addComponent(img_token_four15))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        tf_token16.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token16.setText("0");
        tf_token16.setEnabled(false);
        tf_token16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token16ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel16.setText("Owner:");

        img_token_two17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(img_token_one17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two17))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(img_token_three17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four17)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(8, 8, 8)
                .addComponent(tf_token16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one17)
                        .addComponent(img_token_two17))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three17)
                        .addComponent(img_token_four17))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        tf_token17.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        tf_token17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_token17.setText("0");
        tf_token17.setEnabled(false);
        tf_token17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_token17ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 8)); // NOI18N
        jLabel17.setText("Owner:");

        img_token_two18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_one18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_three18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        img_token_four18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/token_none_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_token17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(img_token_one18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_two18))
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(img_token_three18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(img_token_four18)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(8, 8, 8)
                .addComponent(tf_token17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_one18)
                        .addComponent(img_token_two18))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_token_three18)
                        .addComponent(img_token_four18))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel_settingLayout = new javax.swing.GroupLayout(jPanel_setting);
        jPanel_setting.setLayout(jPanel_settingLayout);
        jPanel_settingLayout.setHorizontalGroup(
            jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_settingLayout.createSequentialGroup()
                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_settingLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel_settingLayout.createSequentialGroup()
                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_settingLayout.setVerticalGroup(
            jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_settingLayout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_settingLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_settingLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_settingLayout.createSequentialGroup()
                                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(48, 48, 48))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com3101_project_group6/images/hsu_board_final.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel_setting, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_token13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token13ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_token13ActionPerformed

    private void tf_token12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token12ActionPerformed

    private void tf_token2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token2ActionPerformed

    private void tf_token3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token3ActionPerformed

    private void tf_token4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token4ActionPerformed

    private void tf_token5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token5ActionPerformed

    private void tf_token6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token6ActionPerformed

    private void tf_token7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token7ActionPerformed

    private void tf_token8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token8ActionPerformed

    private void tf_token9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token9ActionPerformed

    private void tf_token10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token10ActionPerformed

    private void btn_tradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tradeActionPerformed

    private void btn_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buyActionPerformed

    private void btn_roll_diceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roll_diceActionPerformed
        // TODO add your handling code here:
        dice_num = controller.rollDice();
        if (turn_of_player_no == 1) {
            moveToken(turn_of_player_no, controller.rollDice());
            turn_of_player_no++;
        } else if (turn_of_player_no == 2) {
            moveToken(turn_of_player_no, controller.rollDice());
            turn_of_player_no++;
        } else if (turn_of_player_no == 3) {
            moveToken(turn_of_player_no, controller.rollDice());
            turn_of_player_no++;
        } else {
            moveToken(turn_of_player_no, controller.rollDice());
            turn_of_player_no = 1;
        }
    }//GEN-LAST:event_btn_roll_diceActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        num_player = 0;
        num_bot = 0;
        tf_num_player.setText(String.valueOf(num_player));
        tf_num_bot.setText(String.valueOf(num_bot));

    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newgameActionPerformed
        // TODO add your handling code here:
        playing = true;
        lb_msg.setText("Game has started");
    }//GEN-LAST:event_btn_newgameActionPerformed

    private void tf_token_oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token_oneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token_oneActionPerformed

    private void tf_token_twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token_twoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token_twoActionPerformed

    private void tf_token_threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token_threeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token_threeActionPerformed

    private void tf_token_fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token_fourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token_fourActionPerformed

    private void tf_token14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token14ActionPerformed

    private void tf_token16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token16ActionPerformed

    private void tf_token17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token17ActionPerformed

    private void tf_token18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token18ActionPerformed

    private void tf_token20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token20ActionPerformed

    private void tf_token21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token21ActionPerformed

    private void tf_token22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token22ActionPerformed

    private void tf_token23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token23ActionPerformed

    private void tf_token24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token24ActionPerformed

    private void tf_token25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token25ActionPerformed

    private void tf_token26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token26ActionPerformed

    private void tf_token27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token27ActionPerformed

    private void tf_token28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token28ActionPerformed

    private void tf_token29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token29ActionPerformed

    private void tf_token30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token30ActionPerformed

    private void tf_token31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token31ActionPerformed

    private void tf_token32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token32ActionPerformed

    private void tf_token33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token33ActionPerformed

    private void tf_token34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token34ActionPerformed

    private void tf_token35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token35ActionPerformed

    private void tf_token36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token36ActionPerformed

    private void tf_token37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token37ActionPerformed

    private void tf_token38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token38ActionPerformed

    private void tf_token39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token39ActionPerformed

    private void tf_token40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_token40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_token40ActionPerformed

    private void btn_add_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_playerActionPerformed
        // TODO add your handling code here:
        int total_num = num_player + num_bot;
        if (total_num < 4) {
            num_player++;
            tf_num_player.setText(String.valueOf(num_player));
        }
    }//GEN-LAST:event_btn_add_playerActionPerformed

    private void btn_del_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del_playerActionPerformed
        // TODO add your handling code here:
        int total_num = num_player + num_bot;
        if (total_num > 0 && num_player > 0) {
            num_player--;
            tf_num_player.setText(String.valueOf(num_player));
        }
    }//GEN-LAST:event_btn_del_playerActionPerformed

    private void tf_num_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_num_playerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_num_playerActionPerformed

    private void btn_add_botActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_botActionPerformed
        // TODO add your handling code here:
        int total_num = num_player + num_bot;
        if (total_num < 4) {
            num_bot++;
            tf_num_bot.setText(String.valueOf(num_bot));
        }
    }//GEN-LAST:event_btn_add_botActionPerformed

    private void btn_del_botActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del_botActionPerformed
        // TODO add your handling code here:
        int total_num = num_player + num_bot;
        if (total_num > 0 && num_bot > 0) {
            num_bot--;
            tf_num_bot.setText(String.valueOf(num_bot));
        }
    }//GEN-LAST:event_btn_del_botActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Board().setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_bot;
    private javax.swing.JButton btn_add_player;
    private javax.swing.JButton btn_buy;
    private javax.swing.JButton btn_del_bot;
    private javax.swing.JButton btn_del_player;
    private javax.swing.JButton btn_newgame;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_roll_dice;
    private javax.swing.JButton btn_trade;
    private javax.swing.JLabel current_player_four;
    private javax.swing.JLabel current_player_one;
    private javax.swing.JLabel current_player_three;
    private javax.swing.JLabel current_player_two;
    private javax.swing.JLabel img_1st_dice;
    private javax.swing.JLabel img_2nd_dice;
    private javax.swing.JLabel img_token_four;
    private javax.swing.JLabel img_token_four1;
    private javax.swing.JLabel img_token_four10;
    private javax.swing.JLabel img_token_four11;
    private javax.swing.JLabel img_token_four11_jailed;
    private javax.swing.JLabel img_token_four13;
    private javax.swing.JLabel img_token_four14;
    private javax.swing.JLabel img_token_four15;
    private javax.swing.JLabel img_token_four17;
    private javax.swing.JLabel img_token_four18;
    private javax.swing.JLabel img_token_four19;
    private javax.swing.JLabel img_token_four2;
    private javax.swing.JLabel img_token_four21;
    private javax.swing.JLabel img_token_four22;
    private javax.swing.JLabel img_token_four23;
    private javax.swing.JLabel img_token_four24;
    private javax.swing.JLabel img_token_four25;
    private javax.swing.JLabel img_token_four26;
    private javax.swing.JLabel img_token_four27;
    private javax.swing.JLabel img_token_four28;
    private javax.swing.JLabel img_token_four29;
    private javax.swing.JLabel img_token_four3;
    private javax.swing.JLabel img_token_four30;
    private javax.swing.JLabel img_token_four31;
    private javax.swing.JLabel img_token_four32;
    private javax.swing.JLabel img_token_four33;
    private javax.swing.JLabel img_token_four34;
    private javax.swing.JLabel img_token_four35;
    private javax.swing.JLabel img_token_four36;
    private javax.swing.JLabel img_token_four37;
    private javax.swing.JLabel img_token_four38;
    private javax.swing.JLabel img_token_four39;
    private javax.swing.JLabel img_token_four4;
    private javax.swing.JLabel img_token_four40;
    private javax.swing.JLabel img_token_four41;
    private javax.swing.JLabel img_token_four42;
    private javax.swing.JLabel img_token_four43;
    private javax.swing.JLabel img_token_four5;
    private javax.swing.JLabel img_token_four6;
    private javax.swing.JLabel img_token_four7;
    private javax.swing.JLabel img_token_four8;
    private javax.swing.JLabel img_token_four9;
    private javax.swing.JLabel img_token_on7;
    private javax.swing.JLabel img_token_one;
    private javax.swing.JLabel img_token_one1;
    private javax.swing.JLabel img_token_one10;
    private javax.swing.JLabel img_token_one11;
    private javax.swing.JLabel img_token_one11_jailed;
    private javax.swing.JLabel img_token_one13;
    private javax.swing.JLabel img_token_one14;
    private javax.swing.JLabel img_token_one15;
    private javax.swing.JLabel img_token_one17;
    private javax.swing.JLabel img_token_one18;
    private javax.swing.JLabel img_token_one19;
    private javax.swing.JLabel img_token_one2;
    private javax.swing.JLabel img_token_one21;
    private javax.swing.JLabel img_token_one22;
    private javax.swing.JLabel img_token_one23;
    private javax.swing.JLabel img_token_one24;
    private javax.swing.JLabel img_token_one25;
    private javax.swing.JLabel img_token_one26;
    private javax.swing.JLabel img_token_one27;
    private javax.swing.JLabel img_token_one28;
    private javax.swing.JLabel img_token_one29;
    private javax.swing.JLabel img_token_one3;
    private javax.swing.JLabel img_token_one30;
    private javax.swing.JLabel img_token_one31;
    private javax.swing.JLabel img_token_one32;
    private javax.swing.JLabel img_token_one33;
    private javax.swing.JLabel img_token_one34;
    private javax.swing.JLabel img_token_one35;
    private javax.swing.JLabel img_token_one36;
    private javax.swing.JLabel img_token_one37;
    private javax.swing.JLabel img_token_one38;
    private javax.swing.JLabel img_token_one39;
    private javax.swing.JLabel img_token_one4;
    private javax.swing.JLabel img_token_one40;
    private javax.swing.JLabel img_token_one41;
    private javax.swing.JLabel img_token_one42;
    private javax.swing.JLabel img_token_one5;
    private javax.swing.JLabel img_token_one6;
    private javax.swing.JLabel img_token_one7;
    private javax.swing.JLabel img_token_one8;
    private javax.swing.JLabel img_token_one9;
    private javax.swing.JLabel img_token_three;
    private javax.swing.JLabel img_token_three1;
    private javax.swing.JLabel img_token_three10;
    private javax.swing.JLabel img_token_three11;
    private javax.swing.JLabel img_token_three11_jailed;
    private javax.swing.JLabel img_token_three13;
    private javax.swing.JLabel img_token_three14;
    private javax.swing.JLabel img_token_three15;
    private javax.swing.JLabel img_token_three17;
    private javax.swing.JLabel img_token_three18;
    private javax.swing.JLabel img_token_three19;
    private javax.swing.JLabel img_token_three2;
    private javax.swing.JLabel img_token_three21;
    private javax.swing.JLabel img_token_three22;
    private javax.swing.JLabel img_token_three23;
    private javax.swing.JLabel img_token_three24;
    private javax.swing.JLabel img_token_three25;
    private javax.swing.JLabel img_token_three26;
    private javax.swing.JLabel img_token_three27;
    private javax.swing.JLabel img_token_three28;
    private javax.swing.JLabel img_token_three29;
    private javax.swing.JLabel img_token_three3;
    private javax.swing.JLabel img_token_three30;
    private javax.swing.JLabel img_token_three31;
    private javax.swing.JLabel img_token_three32;
    private javax.swing.JLabel img_token_three33;
    private javax.swing.JLabel img_token_three34;
    private javax.swing.JLabel img_token_three35;
    private javax.swing.JLabel img_token_three36;
    private javax.swing.JLabel img_token_three37;
    private javax.swing.JLabel img_token_three38;
    private javax.swing.JLabel img_token_three39;
    private javax.swing.JLabel img_token_three4;
    private javax.swing.JLabel img_token_three40;
    private javax.swing.JLabel img_token_three41;
    private javax.swing.JLabel img_token_three42;
    private javax.swing.JLabel img_token_three43;
    private javax.swing.JLabel img_token_three5;
    private javax.swing.JLabel img_token_three6;
    private javax.swing.JLabel img_token_three7;
    private javax.swing.JLabel img_token_three8;
    private javax.swing.JLabel img_token_three9;
    private javax.swing.JLabel img_token_two;
    private javax.swing.JLabel img_token_two1;
    private javax.swing.JLabel img_token_two10;
    private javax.swing.JLabel img_token_two11;
    private javax.swing.JLabel img_token_two11_jailed;
    private javax.swing.JLabel img_token_two13;
    private javax.swing.JLabel img_token_two14;
    private javax.swing.JLabel img_token_two15;
    private javax.swing.JLabel img_token_two17;
    private javax.swing.JLabel img_token_two18;
    private javax.swing.JLabel img_token_two19;
    private javax.swing.JLabel img_token_two2;
    private javax.swing.JLabel img_token_two21;
    private javax.swing.JLabel img_token_two22;
    private javax.swing.JLabel img_token_two23;
    private javax.swing.JLabel img_token_two24;
    private javax.swing.JLabel img_token_two25;
    private javax.swing.JLabel img_token_two26;
    private javax.swing.JLabel img_token_two27;
    private javax.swing.JLabel img_token_two28;
    private javax.swing.JLabel img_token_two29;
    private javax.swing.JLabel img_token_two3;
    private javax.swing.JLabel img_token_two30;
    private javax.swing.JLabel img_token_two31;
    private javax.swing.JLabel img_token_two32;
    private javax.swing.JLabel img_token_two33;
    private javax.swing.JLabel img_token_two34;
    private javax.swing.JLabel img_token_two35;
    private javax.swing.JLabel img_token_two36;
    private javax.swing.JLabel img_token_two37;
    private javax.swing.JLabel img_token_two38;
    private javax.swing.JLabel img_token_two39;
    private javax.swing.JLabel img_token_two4;
    private javax.swing.JLabel img_token_two40;
    private javax.swing.JLabel img_token_two41;
    private javax.swing.JLabel img_token_two42;
    private javax.swing.JLabel img_token_two43;
    private javax.swing.JLabel img_token_two5;
    private javax.swing.JLabel img_token_two6;
    private javax.swing.JLabel img_token_two7;
    private javax.swing.JLabel img_token_two8;
    private javax.swing.JLabel img_token_two9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_setting;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel label_bots;
    private javax.swing.JLabel lb_avail_trade;
    private javax.swing.JLabel lb_bal;
    private javax.swing.JLabel lb_msg;
    private javax.swing.JLabel lb_players;
    private javax.swing.JTextField tf_num_bot;
    private javax.swing.JTextField tf_num_player;
    private javax.swing.JTextField tf_token10;
    private javax.swing.JTextField tf_token12;
    private javax.swing.JTextField tf_token13;
    private javax.swing.JTextField tf_token14;
    private javax.swing.JTextField tf_token16;
    private javax.swing.JTextField tf_token17;
    private javax.swing.JTextField tf_token18;
    private javax.swing.JTextField tf_token2;
    private javax.swing.JTextField tf_token20;
    private javax.swing.JTextField tf_token21;
    private javax.swing.JTextField tf_token22;
    private javax.swing.JTextField tf_token23;
    private javax.swing.JTextField tf_token24;
    private javax.swing.JTextField tf_token25;
    private javax.swing.JTextField tf_token26;
    private javax.swing.JTextField tf_token27;
    private javax.swing.JTextField tf_token28;
    private javax.swing.JTextField tf_token29;
    private javax.swing.JTextField tf_token3;
    private javax.swing.JTextField tf_token30;
    private javax.swing.JTextField tf_token31;
    private javax.swing.JTextField tf_token32;
    private javax.swing.JTextField tf_token33;
    private javax.swing.JTextField tf_token34;
    private javax.swing.JTextField tf_token35;
    private javax.swing.JTextField tf_token36;
    private javax.swing.JTextField tf_token37;
    private javax.swing.JTextField tf_token38;
    private javax.swing.JTextField tf_token39;
    private javax.swing.JTextField tf_token4;
    private javax.swing.JTextField tf_token40;
    private javax.swing.JTextField tf_token5;
    private javax.swing.JTextField tf_token6;
    private javax.swing.JTextField tf_token7;
    private javax.swing.JTextField tf_token8;
    private javax.swing.JTextField tf_token9;
    private javax.swing.JTextField tf_trade_property;
    // End of variables declaration//GEN-END:variables
}
