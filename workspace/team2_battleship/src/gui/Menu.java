package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
	private JTextField txtUserStats;
	private JTextField txtGameWith_1;
	private JTextField txtBothFleetsAre;
	private JTextField txtGeneratedTheGame;
	private JTextField txtWhen;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtGeneratedTheGame_1;
	private JTextField txtFinishesWhenOne;
	private JTextField txtLikeANormal;
	private JTextField txtButThereIs;
	private JTextField txtAndALine;
	private JTextField txtForBothPlayers;
	private JTextField txtIsFullyDestroyed;
	private JTextField txtIsFullyDestroyed_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
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
		
		JLabel lblNewLabel_3 = new JLabel("Battleship Menu");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3.setBounds(97, 20, 201, 29);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setForeground(new Color(0, 128, 64));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton.setBounds(903, 18, 155, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/gui/img/free-settings-1768072-1502245 (1).png")));
		btnNewButton_1.setBounds(1081, 10, 67, 50);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/gui/img/8020144884_1315b343ab_b (1) (1).jpg")));
		lblNewLabel.setBounds(47, 97, 656, 261);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/gui/img/free-statistics-graph-2130797-1798577.jpg")));
		lblNewLabel_1.setBounds(820, 120, 279, 250);
		getContentPane().add(lblNewLabel_1);
		
		txtUserStats = new JTextField();
		txtUserStats.setBackground(new Color(255, 255, 255));
		txtUserStats.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtUserStats.setText("User Stats");
		txtUserStats.setBounds(899, 97, 111, 30);
		txtUserStats.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		getContentPane().add(txtUserStats);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(47, 392, 1070, 285);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(99, 99, 99));
		panel_2.setBounds(30, 20, 251, 250);
		panel_1.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("Normal Game");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(124, 124, 124));
		btnNewButton_2.setBounds(42, 10, 159, 31);
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_2.setLayout(null);
		panel_2.add(btnNewButton_2);
		
		txtGameWith_1 = new JTextField();
		txtGameWith_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameWith_1.setBackground(new Color(99, 99, 99));
		txtGameWith_1.setForeground(new Color(255, 255, 255));
		txtGameWith_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtGameWith_1.setText("Game with 2 boards.");
		txtGameWith_1.setBounds(30, 51, 191, 44);
		txtGameWith_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2.add(txtGameWith_1);
		txtGameWith_1.setColumns(10);
		
		txtBothFleetsAre = new JTextField();
		txtBothFleetsAre.setHorizontalAlignment(SwingConstants.CENTER);
		txtBothFleetsAre.setText("Player fleet is selected by");
		txtBothFleetsAre.setForeground(Color.WHITE);
		txtBothFleetsAre.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBothFleetsAre.setColumns(10);
		txtBothFleetsAre.setBackground(new Color(99, 99, 99));
		txtBothFleetsAre.setBounds(10, 81, 231, 44);
		txtBothFleetsAre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2.add(txtBothFleetsAre);
		
		txtGeneratedTheGame = new JTextField();
		txtGeneratedTheGame.setText("the user. The game");
		txtGeneratedTheGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeneratedTheGame.setForeground(Color.WHITE);
		txtGeneratedTheGame.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtGeneratedTheGame.setColumns(10);
		txtGeneratedTheGame.setBackground(new Color(99, 99, 99));
		txtGeneratedTheGame.setBounds(10, 114, 231, 44);
		txtGeneratedTheGame.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2.add(txtGeneratedTheGame);
		
		txtWhen = new JTextField();
		txtWhen.setText("finishes when one fleet");
		txtWhen.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhen.setForeground(Color.WHITE);
		txtWhen.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtWhen.setColumns(10);
		txtWhen.setBackground(new Color(99, 99, 99));
		txtWhen.setBounds(10, 146, 231, 44);
		txtWhen.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2.add(txtWhen);
		
		txtIsFullyDestroyed = new JTextField();
		txtIsFullyDestroyed.setText("is fully destroyed");
		txtIsFullyDestroyed.setHorizontalAlignment(SwingConstants.CENTER);
		txtIsFullyDestroyed.setForeground(Color.WHITE);
		txtIsFullyDestroyed.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIsFullyDestroyed.setColumns(10);
		txtIsFullyDestroyed.setBackground(new Color(99, 99, 99));
		txtIsFullyDestroyed.setBounds(10, 176, 231, 44);
		txtIsFullyDestroyed.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2.add(txtIsFullyDestroyed);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(99, 99, 99));
		panel_2_1.setBounds(405, 20, 251, 250);
		panel_1.add(panel_2_1);
		
		JButton btnNewButton_2_1 = new JButton("Quick Game");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_2_1.setBackground(new Color(124, 124, 124));
		btnNewButton_2_1.setBounds(42, 10, 159, 31);
		panel_2_1.add(btnNewButton_2_1);
		
		textField = new JTextField();
		textField.setText("Game with 2 boards.");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(new Color(99, 99, 99));
		textField.setBounds(30, 51, 191, 44);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Both fleets are randomly");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(99, 99, 99));
		textField_1.setBounds(10, 81, 231, 44);
		textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_1.add(textField_1);
		
		txtGeneratedTheGame_1 = new JTextField();
		txtGeneratedTheGame_1.setText("generated. The game");
		txtGeneratedTheGame_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeneratedTheGame_1.setForeground(Color.WHITE);
		txtGeneratedTheGame_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtGeneratedTheGame_1.setColumns(10);
		txtGeneratedTheGame_1.setBackground(new Color(99, 99, 99));
		txtGeneratedTheGame_1.setBounds(10, 114, 231, 44);
		txtGeneratedTheGame_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_1.add(txtGeneratedTheGame_1);
		
		txtFinishesWhenOne = new JTextField();
		txtFinishesWhenOne.setText("finishes when one fleet");
		txtFinishesWhenOne.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinishesWhenOne.setForeground(Color.WHITE);
		txtFinishesWhenOne.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtFinishesWhenOne.setColumns(10);
		txtFinishesWhenOne.setBackground(new Color(99, 99, 99));
		txtFinishesWhenOne.setBounds(10, 146, 231, 44);
		txtFinishesWhenOne.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_1.add(txtFinishesWhenOne);
		
		txtIsFullyDestroyed_1 = new JTextField();
		txtIsFullyDestroyed_1.setText("is fully destroyed");
		txtIsFullyDestroyed_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtIsFullyDestroyed_1.setForeground(Color.WHITE);
		txtIsFullyDestroyed_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIsFullyDestroyed_1.setColumns(10);
		txtIsFullyDestroyed_1.setBackground(new Color(99, 99, 99));
		txtIsFullyDestroyed_1.setBounds(10, 176, 231, 44);
		txtIsFullyDestroyed_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_1.add(txtIsFullyDestroyed_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(99, 99, 99));
		panel_2_2.setBounds(786, 20, 251, 250);
		panel_1.add(panel_2_2);
		
		JButton btnNewButton_2_2 = new JButton("Bonus Game");
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_2_2.setBackground(new Color(124, 124, 124));
		btnNewButton_2_2.setBounds(42, 10, 159, 31);
		panel_2_2.add(btnNewButton_2_2);
		
		txtLikeANormal = new JTextField();
		txtLikeANormal.setText("Like a normal game");
		txtLikeANormal.setHorizontalAlignment(SwingConstants.CENTER);
		txtLikeANormal.setForeground(Color.WHITE);
		txtLikeANormal.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtLikeANormal.setColumns(10);
		txtLikeANormal.setBackground(new Color(99, 99, 99));
		txtLikeANormal.setBounds(30, 63, 191, 44);
		txtLikeANormal.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_2.add(txtLikeANormal);
		
		txtButThereIs = new JTextField();
		txtButThereIs.setText("but there is also a bomb");
		txtButThereIs.setHorizontalAlignment(SwingConstants.CENTER);
		txtButThereIs.setForeground(Color.WHITE);
		txtButThereIs.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtButThereIs.setColumns(10);
		txtButThereIs.setBackground(new Color(99, 99, 99));
		txtButThereIs.setBounds(10, 93, 231, 44);
		txtButThereIs.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_2.add(txtButThereIs);
		
		txtAndALine = new JTextField();
		txtAndALine.setText("and a line destroyer bonus");
		txtAndALine.setHorizontalAlignment(SwingConstants.CENTER);
		txtAndALine.setForeground(Color.WHITE);
		txtAndALine.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAndALine.setColumns(10);
		txtAndALine.setBackground(new Color(99, 99, 99));
		txtAndALine.setBounds(10, 126, 231, 44);
		txtAndALine.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_2.add(txtAndALine);
		
		txtForBothPlayers = new JTextField();
		txtForBothPlayers.setText("for both players");
		txtForBothPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtForBothPlayers.setForeground(Color.WHITE);
		txtForBothPlayers.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtForBothPlayers.setColumns(10);
		txtForBothPlayers.setBackground(new Color(99, 99, 99));
		txtForBothPlayers.setBounds(10, 158, 231, 44);
		txtForBothPlayers.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_2_2.add(txtForBothPlayers);
	}
}
