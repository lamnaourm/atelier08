package com.ismo.products.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnRechercher;
	private JButton btnFermer;
	private JButton btnAnnuler;
	private JButton btnEnregistrer;
	private JButton btnFermer_1;
	private JButton button;
	private JTextField textField;
	private JList list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JRadioButton rdbtnEpicerie;
	private JRadioButton rdbtnLegumes;
	private JRadioButton rdbtnFruit;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setTitle("Fiche produit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 11, 256, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 167, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 65, 235, 262);
		panel.add(list);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_First_20px.png")));
		btnNewButton.setBounds(10, 338, 89, 35);
		panel.add(btnNewButton);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Google_Web_Search_20px.png")));
		button.setBounds(190, 11, 55, 35);
		panel.add(button);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Last_20px_1.png")));
		btnNewButton_1.setBounds(156, 338, 89, 35);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(277, 11, 512, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code produit : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 62, 96, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblDes = new JLabel("Libelle produit : ");
		lblDes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDes.setBounds(10, 102, 96, 14);
		panel_1.add(lblDes);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 59, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 99, 207, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 152, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblPrixAchat = new JLabel("Prix achat :");
		lblPrixAchat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrixAchat.setBounds(10, 155, 96, 14);
		panel_1.add(lblPrixAchat);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 204, 86, 20);
		panel_1.add(textField_4);
		
		JLabel lblPrixVente = new JLabel("Prix vente :");
		lblPrixVente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrixVente.setBounds(10, 207, 96, 14);
		panel_1.add(lblPrixVente);
		
		JLabel lblFamilleProduit = new JLabel("Famille produit : ");
		lblFamilleProduit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFamilleProduit.setBounds(10, 261, 113, 14);
		panel_1.add(lblFamilleProduit);
		
		rdbtnEpicerie = new JRadioButton("Epicerie");
		buttonGroup.add(rdbtnEpicerie);
		rdbtnEpicerie.setBounds(22, 282, 84, 23);
		panel_1.add(rdbtnEpicerie);
		
		rdbtnLegumes = new JRadioButton("Legumes");
		buttonGroup.add(rdbtnLegumes);
		rdbtnLegumes.setBounds(108, 282, 86, 23);
		panel_1.add(rdbtnLegumes);
		
		rdbtnFruit = new JRadioButton("Fruit");
		buttonGroup.add(rdbtnFruit);
		rdbtnFruit.setBounds(196, 282, 55, 23);
		panel_1.add(rdbtnFruit);
		
		rdbtnNewRadioButton = new JRadioButton("Electromenager");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(268, 282, 124, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setHorizontalAlignment(SwingConstants.LEADING);
		btnAjouter.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Add_New_20px.png")));
		btnAjouter.setBounds(347, 62, 126, 33);
		panel_1.add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setHorizontalAlignment(SwingConstants.LEADING);
		btnModifier.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Edit_Image_20px.png")));
		btnModifier.setBounds(347, 98, 126, 31);
		panel_1.add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEADING);
		btnSupprimer.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Delete_20px.png")));
		btnSupprimer.setBounds(347, 134, 126, 33);
		panel_1.add(btnSupprimer);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setHorizontalAlignment(SwingConstants.LEADING);
		btnRechercher.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Google_Web_Search_20px.png")));
		btnRechercher.setBounds(347, 169, 126, 33);
		panel_1.add(btnRechercher);
		
		btnFermer = new JButton("Fermer");
		btnFermer.setHorizontalAlignment(SwingConstants.LEADING);
		btnFermer.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Close_Window_20px.png")));
		btnFermer.setBounds(347, 210, 126, 33);
		panel_1.add(btnFermer);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Save_20px.png")));
		btnEnregistrer.setBounds(20, 322, 125, 33);
		panel_1.add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Cancel_20px.png")));
		btnAnnuler.setBounds(148, 322, 120, 33);
		panel_1.add(btnAnnuler);
		
		btnFermer_1 = new JButton("Initailiser");
		btnFermer_1.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Initiate_Money_Transfer_20px.png")));
		btnFermer_1.setBounds(273, 322, 113, 33);
		panel_1.add(btnFermer_1);
	}

}
