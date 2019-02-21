package Dao;

import java.util.List;

import metier.entities.Produit;

public interface IproduitDao {
     public Produit save(Produit p);
     public List<Produit> getProduitParMC(String mc);
     public Produit getProduit(Long id_prod);
     public Produit UpdatProduit(Produit p);
     public void deleteProduit(Long id_prod);
}
