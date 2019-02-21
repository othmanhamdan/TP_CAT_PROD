package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModel {
	private String monCle;
	private List<Produit> prod =new ArrayList<Produit>();
	public String getMonCle() {
		return monCle;
	}
	public void setMonCle(String monCle) {
		this.monCle = monCle;
	}
	public List<Produit> getProd() {
		return prod;
	}
	public void setProd(List<Produit> prod) {
		this.prod = prod;
	}

}
