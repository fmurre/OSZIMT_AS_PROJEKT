package application;

import java.sql.*;
import java.util.Vector;



public class DBconnection {

	static Connection connection;	//Instanzvariable, auf der die Verbindung gespeichert wird

	public static boolean connectToMysql(String host, String database, String user, String passwd){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionCommand = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+passwd; //Port nicht notwendig, da Standard (3306) genutzt (Sonst hinter Host)
			connection = DriverManager.getConnection(connectionCommand);
			return true;
		}
		catch (Exception ex){
			System.out.println("false");
			return false;
		}
	}
	





}