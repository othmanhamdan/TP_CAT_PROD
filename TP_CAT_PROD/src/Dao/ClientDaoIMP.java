package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.entities.Client;

public class ClientDaoIMP implements IclientDao {

	@Override
	public Client saveClient(Client c) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into client (nom, prenom, adresse, E_mail, tele, motPass ) values (?,?,?,?,?,?)");
			ps.setString(1, c.getNom());
		    ps.setString(2, c.getPrenom());
		    ps.setString(3, c.getAdresse());
		    ps.setString(4, c.getEmail());
		    ps.setString(5, c.getTele());
		    ps.setString(6, c.getMotPass());
		    ps.executeUpdate();
		    System.out.println("ajout effectué avec succès");
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
