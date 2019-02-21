package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	public static  Connection connection;
static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cat_prod1","root","");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Connection getConnection() {
	return connection;
}

}
