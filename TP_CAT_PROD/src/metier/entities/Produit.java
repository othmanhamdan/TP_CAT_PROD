package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	private Long id_prod;
	private String designiation;
	private double prix;
	private int quantite;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Produit [id_prod=" + id_prod + ", designiation=" + designiation + ", prix=" + prix + ", quantite="
				+ quantite + "]";
	}
	public Long getId_prod() {
		return id_prod;
	}
	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	public String getDesigniation() {
		return designiation;
	}
	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit(String designiation, double prix, int quantite) {
		super();
		this.designiation = designiation;
		this.prix = prix;
		this.quantite = quantite;
	}
	

}
