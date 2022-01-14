package com.ismo.products.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.ismo.prodcuts.metier.IMetier;
import com.ismo.prodcuts.metier.MetierProduit;
import com.ismo.prodcuts.model.Produit;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txt_code;
	private JTextField txt_lib;
	private JTextField txt_achat;
	private JTextField txt_vente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnRechercher;
	private JButton btnFermer;
	private JButton btnAnnuler;
	private JButton btnEnregistrer;
	private JButton btnInitialiser;
	private JButton button;
	private JTextField txt_find;
	private JList listprod;
	private JButton btnFirst;
	private JButton btnLast;
	private JRadioButton rdEpicerie;
	private JRadioButton rdLegumes;
	private JRadioButton rdFruit;
	private JRadioButton rdElectromenager;
	
	DefaultListModel<String> model = new DefaultListModel<>();
	IMetier<Produit> metier = new MetierProduit();
	ArrayList<Produit> products;
	int position=0;
	private JScrollPane scrollPane;
	Mode mode = Mode.NORMAL;

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
		
		txt_find = new JTextField();
		txt_find.setBounds(10, 11, 167, 35);
		panel.add(txt_find);
		txt_find.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 235, 262);
		panel.add(scrollPane);
		
		listprod = new JList();
		scrollPane.setViewportView(listprod);
		listprod.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(model.size()>0 && listprod.getSelectedIndex()>=0) {
					position = listprod.getSelectedIndex();
					remplirTextFields();
				}
			}
		});
		listprod.setModel(model);
		listprod.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = listprod.getSelectedIndex();
				
				if(i==0)
					i=products.size()-1;
				else 
					i--;
				
				listprod.setSelectedIndex(i);
				remplirTextFields();
			}
		});
		btnFirst.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_First_20px.png")));
		btnFirst.setBounds(10, 338, 89, 35);
		panel.add(btnFirst);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ch = txt_find.getText();
				filterProduits(ch);
			}
		});
		button.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Google_Web_Search_20px.png")));
		button.setBounds(190, 11, 55, 35);
		panel.add(button);
		
		btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listprod.getSelectedIndex();
				
				if(i==products.size()-1)
					i=0;
				else 
					i++;
				
				listprod.setSelectedIndex(i);
				remplirTextFields();
			}
		});
		btnLast.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Last_20px_1.png")));
		btnLast.setBounds(156, 338, 89, 35);
		panel.add(btnLast);
		
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
		lblDes.setBounds(10, 112, 96, 14);
		panel_1.add(lblDes);
		
		txt_code = new JTextField();
		txt_code.setBounds(116, 59, 86, 20);
		panel_1.add(txt_code);
		txt_code.setColumns(10);
		
		txt_lib = new JTextField();
		txt_lib.setColumns(10);
		txt_lib.setBounds(116, 109, 207, 20);
		panel_1.add(txt_lib);
		
		txt_achat = new JTextField();
		txt_achat.setColumns(10);
		txt_achat.setBounds(116, 152, 86, 20);
		panel_1.add(txt_achat);
		
		JLabel lblPrixAchat = new JLabel("Prix achat :");
		lblPrixAchat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrixAchat.setBounds(10, 155, 96, 14);
		panel_1.add(lblPrixAchat);
		
		txt_vente = new JTextField();
		txt_vente.setColumns(10);
		txt_vente.setBounds(116, 204, 86, 20);
		panel_1.add(txt_vente);
		
		JLabel lblPrixVente = new JLabel("Prix vente :");
		lblPrixVente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrixVente.setBounds(10, 207, 96, 14);
		panel_1.add(lblPrixVente);
		
		JLabel lblFamilleProduit = new JLabel("Famille produit : ");
		lblFamilleProduit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFamilleProduit.setBounds(10, 261, 113, 14);
		panel_1.add(lblFamilleProduit);
		
		rdEpicerie = new JRadioButton("Epicerie");
		buttonGroup.add(rdEpicerie);
		rdEpicerie.setBounds(22, 282, 84, 23);
		panel_1.add(rdEpicerie);
		
		rdLegumes = new JRadioButton("Legumes");
		buttonGroup.add(rdLegumes);
		rdLegumes.setBounds(108, 282, 86, 23);
		panel_1.add(rdLegumes);
		
		rdFruit = new JRadioButton("Fruit");
		buttonGroup.add(rdFruit);
		rdFruit.setBounds(196, 282, 55, 23);
		panel_1.add(rdFruit);
		
		rdElectromenager = new JRadioButton("Electromenager");
		buttonGroup.add(rdElectromenager);
		rdElectromenager.setBounds(268, 282, 124, 23);
		panel_1.add(rdElectromenager);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeDesactiveControls(true);
				mode = Mode.ADD;
			}
		});
		btnAjouter.setHorizontalAlignment(SwingConstants.LEADING);
		btnAjouter.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Add_New_20px.png")));
		btnAjouter.setBounds(347, 62, 126, 33);
		panel_1.add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeDesactiveControls(true);
				mode = Mode.UPDATE;
			}
		});
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
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produit p = new Produit();
				p.setCode(Integer.valueOf(txt_code.getText()));
				p.setLibelle(txt_lib.getText());
				p.setPrix_achat(Double.parseDouble(txt_achat.getText()));
				p.setPrix_vente(Double.parseDouble(txt_vente.getText()));
				String famille = "";
				if(rdElectromenager.isSelected())
					famille = rdElectromenager.getText();
				else if(rdFruit.isSelected())
					famille = rdFruit.getText();
				else if(rdLegumes.isSelected())
					famille = rdLegumes.getText();
				else famille = rdEpicerie.getText();
				p.setFamille(famille);
				
				switch (mode) {
				case ADD: 
					metier.save(p); 
					JOptionPane.showMessageDialog(null, "Produit ajoute avec succes");
					break;
				case UPDATE: 
					metier.update(p); 
					JOptionPane.showMessageDialog(null, "Produit modifier avec succes");
					break;
				}
				
				mode = Mode.NORMAL;
				activeDesactiveControls(false);
				txt_find.setText("");
				filterProduits("");
			}
		});
		panel_1.add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Cancel_20px.png")));
		btnAnnuler.setBounds(148, 322, 120, 33);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				activeDesactiveControls(false);
				txt_find.setText("");
				filterProduits("");
			}
		});
		panel_1.add(btnAnnuler);
		
		btnInitialiser = new JButton("Initailiser");
		btnInitialiser.setIcon(new ImageIcon(Main.class.getResource("/images/icons8_Initiate_Money_Transfer_20px.png")));
		btnInitialiser.setBounds(273, 322, 113, 33);
		btnInitialiser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt_lib.setText("");
				txt_achat.setText("");
				txt_vente.setText("");
				txt_lib.requestFocus();
			}
		});
		panel_1.add(btnInitialiser);
		
		
		products = (ArrayList<Produit>) metier.getAll();
		if(products.size()>0) {
			RemplirListProduit();
			listprod.setSelectedIndex(0);
			position = 0;
			remplirTextFields();
		}
		
		activeDesactiveControls(false);
	}

	void RemplirListProduit() {
		model.clear();
		
		for(Produit p:products)
			model.addElement(String.format("P%05d - %s", p.getCode(),p.getLibelle()));
	}
	
	void remplirTextFields() {
		txt_code.setText(String.valueOf(products.get(position).getCode()));
		txt_lib.setText(products.get(position).getLibelle());
		txt_achat.setText(String.valueOf(products.get(position).getPrix_achat()));
		txt_vente.setText(String.valueOf(products.get(position).getPrix_vente()));
		
		if(products.get(position).getFamille().toLowerCase().equals("epicerie")) {
			rdEpicerie.setSelected(true);
		}else if(products.get(position).getFamille().toLowerCase().equals("fruit")) {
			rdFruit.setSelected(true);
		}else if(products.get(position).getFamille().toLowerCase().equals("eletromenager")) {
			rdElectromenager.setSelected(true);
		} else 
			rdLegumes.setSelected(true); 
	}
	
	void filterProduits(String ch) {
		products = (ArrayList<Produit>) metier.getAll();
		
		if(!ch.trim().isEmpty())
			for(int i=0;i<products.size();i++)
				if(!products.get(i).getLibelle().contains(txt_find.getText())) {
					products.remove(i);
					i--;
				}
		
		RemplirListProduit();
		if(products.size()!=0) {
			position = 0;
			listprod.setSelectedIndex(position);
		}
	}
	
	void activeDesactiveControls(boolean etat) {
		txt_code.setEditable(false);
		txt_lib.setEditable(etat);
		txt_achat.setEditable(etat);
		txt_vente.setEditable(etat);
		rdElectromenager.setEnabled(etat);
		rdFruit.setEnabled(etat);
		rdEpicerie.setEnabled(etat);
		rdLegumes.setEnabled(etat);
		btnEnregistrer.setEnabled(etat);
		btnAnnuler.setEnabled(etat);
		btnInitialiser.setEnabled(etat);
		btnAjouter.setEnabled(!etat);
		btnModifier.setEnabled(!etat);
		btnSupprimer.setEnabled(!etat);
		listprod.setEnabled(!etat);
		btnLast.setEnabled(!etat);
		btnFirst.setEnabled(!etat);
		button.setEnabled(!etat);
		txt_find.setEditable(!etat);
		btnRechercher.setEnabled(!etat);
	}
	
	
}


enum Mode {
	ADD,
	UPDATE,
	NORMAL
}