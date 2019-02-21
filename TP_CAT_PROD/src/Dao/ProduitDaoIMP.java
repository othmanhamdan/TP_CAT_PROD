package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Produit;

public class ProduitDaoIMP  implements IproduitDao{

	@Override
	public Produit save(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into produits (designiation, prix, quantite) values (?,?,?)");
			ps.setString(1, p.getDesigniation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("select MAX(id_prod) AS MAXID_PROD from produits");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId_prod(rs.getLong("MAXID_PROD"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> getProduitParMC(String mc) {
		List<Produit> prod=new ArrayList<Produit>();
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Produits where designiation like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId_prod(rs.getLong("id_prod"));
				p.setDesigniation(rs.getString("designiation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				prod.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prod;
	}

	@Override
	public Produit getProduit(Long id_prod) {
		Produit p=null;
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from produits where id_prod = ?");
			ps.setLong(1, id_prod);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p=new Produit();
				p.setId_prod(rs.getLong("id_prod"));
				p.setDesigniation(rs.getString("designiation"));
				p.setPrix(rs.getLong("prix"));
				p.setQuantite(rs.getInt("quantite"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit UpdatProduit(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update produits set designiation=?, prix=?, quantite=? where id_prod = ?");
			ps.setString(1, p.getDesigniation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId_prod());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id_prod) {
	  Connection con=SingletonConnection.getConnection();
	  try {
		PreparedStatement ps=con.prepareStatement("delete from produits where id_prod = ?");
		ps.setLong(1, id_prod);
		ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
