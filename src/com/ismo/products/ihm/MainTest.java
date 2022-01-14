package com.ismo.products.ihm;

import com.ismo.prodcuts.metier.IMetier;
import com.ismo.prodcuts.metier.MetierProduit;
import com.ismo.prodcuts.model.Produit;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IMetier<Produit> products = new MetierProduit();
		System.out.println(products.getAll().size());
	}

}
