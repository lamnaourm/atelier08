package com.ismo.prodcuts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produit {

	@Id
	@GeneratedValue
	@Column(name="numProd")
	private int code;
	
	@Column(name="description")
	private String libelle;
	
	@Column
	private String famille;
	
	@Column(name="prixAchat")
	private double prix_achat;
	
	@Column(name="prixVente")
	private double prix_vente;
	
	public Produit() {
		
	}
	
	public Produit(String libelle, String famille, double prix_achat, double prix_vente) {
		super();
		this.libelle = libelle;
		this.famille = famille;
		this.prix_achat = prix_achat;
		this.prix_vente = prix_vente;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public double getPrix_achat() {
		return prix_achat;
	}
	public void setPrix_achat(double prix_achat) {
		this.prix_achat = prix_achat;
	}
	public double getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(double prix_vente) {
		this.prix_vente = prix_vente;
	}
	
	
}
