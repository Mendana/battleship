package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GamePanel extends JFrame {

	private JTextField txtMessageStatusGame;
	private JTextField txtYourBoard;
	private JPanel panel_1;
	private JTextField txtBonusLeft;
	private JTextField txtXBombs;
	private JTextField txtXLine;
	private JTextField txtShipsRemainingX;
	private JTextField txtOpponentsBoard;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel frame = new GamePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GamePanel() {
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Battleship");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 1158, 70);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/gui/img/abstract-user-flat-3 (1).png")));
		lblNewLabel_2.setBounds(37, 10, 55, 50);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Battleship <Mode> Game");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3.setBounds(97, 20, 348, 29);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/gui/img/free-settings-1768072-1502245 (1).png")));
		btnNewButton_1.setBounds(1081, 10, 67, 50);
		panel.add(btnNewButton_1);
		
		txtMessageStatusGame = new JTextField();
		txtMessageStatusGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtMessageStatusGame.setFont(new Font("Verdana", Font.BOLD, 18));
		txtMessageStatusGame.setText("Message Status Game");
		txtMessageStatusGame.setBounds(461, 96, 241, 58);
		getContentPane().add(txtMessageStatusGame);
		txtMessageStatusGame.setColumns(10);
		
		txtYourBoard = new JTextField();
		txtYourBoard.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourBoard.setText("Your Board");
		txtYourBoard.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtYourBoard.setBounds(156, 176, 138, 29);
		getContentPane().add(txtYourBoard);
		txtYourBoard.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(45, 254, 380, 380);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton.setBounds(1, 1, 74, 74);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(77, 1, 74, 74);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(153, 1, 74, 74);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3_1.setForeground(Color.BLACK);
		btnNewButton_3_1.setBounds(229, 1, 74, 74);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("");
		btnNewButton_3_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3_2.setForeground(Color.BLACK);
		btnNewButton_3_2.setBounds(305, 1, 74, 74);
		panel_1.add(btnNewButton_3_2);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBounds(1, 77, 74, 74);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setBounds(77, 77, 74, 74);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setBounds(153, 77, 74, 74);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_7.setForeground(Color.BLACK);
		btnNewButton_7.setBounds(229, 77, 74, 74);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("");
		btnNewButton_7_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_7_1.setForeground(Color.BLACK);
		btnNewButton_7_1.setBounds(305, 77, 74, 74);
		panel_1.add(btnNewButton_7_1);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1.setForeground(Color.BLACK);
		btnNewButton_4_1.setBounds(1, 153, 74, 74);
		panel_1.add(btnNewButton_4_1);
		
		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setBounds(77, 153, 74, 74);
		panel_1.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("");
		btnNewButton_5_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_2.setForeground(Color.BLACK);
		btnNewButton_5_2.setBounds(153, 153, 74, 74);
		panel_1.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("");
		btnNewButton_5_3.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_3.setForeground(Color.BLACK);
		btnNewButton_5_3.setBounds(229, 153, 74, 74);
		panel_1.add(btnNewButton_5_3);
		
		JButton btnNewButton_5_4 = new JButton("");
		btnNewButton_5_4.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_4.setForeground(Color.BLACK);
		btnNewButton_5_4.setBounds(305, 153, 74, 74);
		panel_1.add(btnNewButton_5_4);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1.setBounds(1, 229, 74, 74);
		panel_1.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1_2 = new JButton("");
		btnNewButton_4_1_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_2.setForeground(Color.BLACK);
		btnNewButton_4_1_2.setBounds(77, 229, 74, 74);
		panel_1.add(btnNewButton_4_1_2);
		
		JButton btnNewButton_4_1_3 = new JButton("");
		btnNewButton_4_1_3.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_3.setForeground(Color.BLACK);
		btnNewButton_4_1_3.setBounds(153, 229, 74, 74);
		panel_1.add(btnNewButton_4_1_3);
		
		JButton btnNewButton_4_1_4 = new JButton("");
		btnNewButton_4_1_4.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_4.setForeground(Color.BLACK);
		btnNewButton_4_1_4.setBounds(229, 229, 74, 74);
		panel_1.add(btnNewButton_4_1_4);
		
		JButton btnNewButton_4_1_5 = new JButton("");
		btnNewButton_4_1_5.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_5.setForeground(Color.BLACK);
		btnNewButton_4_1_5.setBounds(305, 229, 74, 74);
		panel_1.add(btnNewButton_4_1_5);
		
		JButton btnNewButton_4_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_1.setBounds(1, 306, 74, 74);
		panel_1.add(btnNewButton_4_1_1_1);
		
		JButton btnNewButton_4_1_1_2 = new JButton("");
		btnNewButton_4_1_1_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_2.setForeground(Color.BLACK);
		btnNewButton_4_1_1_2.setBounds(77, 306, 74, 74);
		panel_1.add(btnNewButton_4_1_1_2);
		
		JButton btnNewButton_4_1_1_3 = new JButton("");
		btnNewButton_4_1_1_3.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_3.setForeground(Color.BLACK);
		btnNewButton_4_1_1_3.setBounds(153, 306, 74, 74);
		panel_1.add(btnNewButton_4_1_1_3);
		
		JButton btnNewButton_4_1_1_4 = new JButton("");
		btnNewButton_4_1_1_4.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_4.setBounds(229, 306, 74, 74);
		panel_1.add(btnNewButton_4_1_1_4);
		
		JButton btnNewButton_4_1_1_5 = new JButton("");
		btnNewButton_4_1_1_5.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_5.setForeground(Color.BLACK);
		btnNewButton_4_1_1_5.setBounds(305, 306, 74, 74);
		panel_1.add(btnNewButton_4_1_1_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(740, 254, 380, 380);
		getContentPane().add(panel_1_1);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_8.setForeground(Color.BLACK);
		btnNewButton_8.setBounds(1, 1, 74, 74);
		panel_1_1.add(btnNewButton_8);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setBounds(77, 1, 74, 74);
		panel_1_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_3 = new JButton("");
		btnNewButton_3_3.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3_3.setForeground(Color.BLACK);
		btnNewButton_3_3.setBounds(153, 1, 74, 74);
		panel_1_1.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_1_1 = new JButton("");
		btnNewButton_3_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setBounds(229, 1, 74, 74);
		panel_1_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_2_1 = new JButton("");
		btnNewButton_3_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_3_2_1.setForeground(Color.BLACK);
		btnNewButton_3_2_1.setBounds(305, 1, 74, 74);
		panel_1_1.add(btnNewButton_3_2_1);
		
		JButton btnNewButton_4_2 = new JButton("");
		btnNewButton_4_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_2.setForeground(Color.BLACK);
		btnNewButton_4_2.setBounds(1, 77, 74, 74);
		panel_1_1.add(btnNewButton_4_2);
		
		JButton btnNewButton_5_5 = new JButton("");
		btnNewButton_5_5.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_5.setForeground(Color.BLACK);
		btnNewButton_5_5.setBounds(77, 77, 74, 74);
		panel_1_1.add(btnNewButton_5_5);
		
		JButton btnNewButton_6_1 = new JButton("");
		btnNewButton_6_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_6_1.setForeground(Color.BLACK);
		btnNewButton_6_1.setBounds(153, 77, 74, 74);
		panel_1_1.add(btnNewButton_6_1);
		
		JButton btnNewButton_7_2 = new JButton("");
		btnNewButton_7_2.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_7_2.setForeground(Color.BLACK);
		btnNewButton_7_2.setBounds(229, 77, 74, 74);
		panel_1_1.add(btnNewButton_7_2);
		
		JButton btnNewButton_7_1_1 = new JButton("");
		btnNewButton_7_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_7_1_1.setForeground(Color.BLACK);
		btnNewButton_7_1_1.setBounds(305, 77, 74, 74);
		panel_1_1.add(btnNewButton_7_1_1);
		
		JButton btnNewButton_4_1_6 = new JButton("");
		btnNewButton_4_1_6.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_6.setForeground(Color.BLACK);
		btnNewButton_4_1_6.setBounds(1, 153, 74, 74);
		panel_1_1.add(btnNewButton_4_1_6);
		
		JButton btnNewButton_5_1_1 = new JButton("");
		btnNewButton_5_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setBounds(77, 153, 74, 74);
		panel_1_1.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_2_1 = new JButton("");
		btnNewButton_5_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_2_1.setForeground(Color.BLACK);
		btnNewButton_5_2_1.setBounds(153, 153, 74, 74);
		panel_1_1.add(btnNewButton_5_2_1);
		
		JButton btnNewButton_5_3_1 = new JButton("");
		btnNewButton_5_3_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_3_1.setForeground(Color.BLACK);
		btnNewButton_5_3_1.setBounds(229, 153, 74, 74);
		panel_1_1.add(btnNewButton_5_3_1);
		
		JButton btnNewButton_5_4_1 = new JButton("");
		btnNewButton_5_4_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_5_4_1.setForeground(Color.BLACK);
		btnNewButton_5_4_1.setBounds(305, 153, 74, 74);
		panel_1_1.add(btnNewButton_5_4_1);
		
		JButton btnNewButton_4_1_1_6 = new JButton("");
		btnNewButton_4_1_1_6.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_6.setForeground(Color.BLACK);
		btnNewButton_4_1_1_6.setBounds(1, 229, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_6);
		
		JButton btnNewButton_4_1_2_1 = new JButton("");
		btnNewButton_4_1_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_2_1.setForeground(Color.BLACK);
		btnNewButton_4_1_2_1.setBounds(77, 229, 74, 74);
		panel_1_1.add(btnNewButton_4_1_2_1);
		
		JButton btnNewButton_4_1_3_1 = new JButton("");
		btnNewButton_4_1_3_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_3_1.setForeground(Color.BLACK);
		btnNewButton_4_1_3_1.setBounds(153, 229, 74, 74);
		panel_1_1.add(btnNewButton_4_1_3_1);
		
		JButton btnNewButton_4_1_4_1 = new JButton("");
		btnNewButton_4_1_4_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_4_1.setForeground(Color.BLACK);
		btnNewButton_4_1_4_1.setBounds(229, 229, 74, 74);
		panel_1_1.add(btnNewButton_4_1_4_1);
		
		JButton btnNewButton_4_1_5_1 = new JButton("");
		btnNewButton_4_1_5_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_5_1.setForeground(Color.BLACK);
		btnNewButton_4_1_5_1.setBounds(305, 229, 74, 74);
		panel_1_1.add(btnNewButton_4_1_5_1);
		
		JButton btnNewButton_4_1_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_1_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_1_1.setBounds(1, 306, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_1_1);
		
		JButton btnNewButton_4_1_1_2_1 = new JButton("");
		btnNewButton_4_1_1_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_2_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_2_1.setBounds(77, 306, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_2_1);
		
		JButton btnNewButton_4_1_1_3_1 = new JButton("");
		btnNewButton_4_1_1_3_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_3_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_3_1.setBounds(153, 306, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_3_1);
		
		JButton btnNewButton_4_1_1_4_1 = new JButton("");
		btnNewButton_4_1_1_4_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_4_1.setBounds(229, 306, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_4_1);
		
		JButton btnNewButton_4_1_1_5_1 = new JButton("");
		btnNewButton_4_1_1_5_1.setIcon(new ImageIcon(GamePanel.class.getResource("/gui/img/water.jpg")));
		btnNewButton_4_1_1_5_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_5_1.setBounds(305, 306, 74, 74);
		panel_1_1.add(btnNewButton_4_1_1_5_1);
		
		txtBonusLeft = new JTextField();
		txtBonusLeft.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBonusLeft.setText("Bonus left:");
		txtBonusLeft.setBounds(536, 253, 96, 19);
		getContentPane().add(txtBonusLeft);
		txtBonusLeft.setColumns(10);
		
		txtXBombs = new JTextField();
		txtXBombs.setHorizontalAlignment(SwingConstants.CENTER);
		txtXBombs.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtXBombs.setText("x  ----  Bombs ---- x");
		txtXBombs.setBounds(481, 311, 201, 19);
		getContentPane().add(txtXBombs);
		txtXBombs.setColumns(10);
		
		txtXLine = new JTextField();
		txtXLine.setText("x  ----  Line Destroyers ---- x");
		txtXLine.setHorizontalAlignment(SwingConstants.CENTER);
		txtXLine.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtXLine.setColumns(10);
		txtXLine.setBounds(448, 357, 268, 19);
		getContentPane().add(txtXLine);
		
		txtShipsRemainingX = new JTextField();
		txtShipsRemainingX.setHorizontalAlignment(SwingConstants.CENTER);
		txtShipsRemainingX.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtShipsRemainingX.setText("Ships Remaining: x");
		txtShipsRemainingX.setBounds(130, 215, 186, 29);
		getContentPane().add(txtShipsRemainingX);
		txtShipsRemainingX.setColumns(10);
		
		txtOpponentsBoard = new JTextField();
		txtOpponentsBoard.setText("Opponents Board");
		txtOpponentsBoard.setHorizontalAlignment(SwingConstants.CENTER);
		txtOpponentsBoard.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtOpponentsBoard.setColumns(10);
		txtOpponentsBoard.setBounds(861, 176, 186, 29);
		getContentPane().add(txtOpponentsBoard);
		
		textField_1 = new JTextField();
		textField_1.setText("Ships Remaining: x");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(861, 215, 186, 29);
		getContentPane().add(textField_1);
	}
}
