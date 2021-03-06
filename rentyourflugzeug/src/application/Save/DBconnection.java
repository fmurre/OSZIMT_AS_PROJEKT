package application.Save;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import application.Objects.Flugzeug;
import application.Objects.Kunde;


public class DBconnection {
	static Connection connection = null;	//Instanzvariable, auf der die Verbindung gespeichert wird
	static Statement stmt = null;
	static ResultSet rs = null;
	static String host="localhost";
	static String db="db_flugzeugverleih";
	static String user="root";
	static String pw="oszimt";
	
//Verbindung herstellen
	public static boolean connectToMysql(String host, String database, String user, String passwd){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //erzeugt neue Instanz vom Treiber, f�r neue Java Versionen nicht notwendig
			String connectionCommand = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+passwd; //Port nicht notwendig, da Standard (3306) genutzt (Sonst hinter Host)
			connection = DriverManager.getConnection(connectionCommand);
			return true;
		}
		catch (Exception ex){
			return false;
		}
	}

//Kundenobjekte aus DB erzeugen	
	public static List<Kunde> showDBku(String sqlquery) throws SQLException {
		//Liste mit Kunden-Objekten die anschlie�end �bergeben wird
		//Result Set kann nicht �bergeben werden da es in finally bereits geschlossen wird
		List<Kunde> kunden = new ArrayList<Kunde>();
		
		try {
			//Test ob DB erreichbar
			if (!(DBconnection.connectToMysql(host, db, user, pw))) {
				System.out.println("FEHLER-DATENBANKVERBINDUNG KONNTE NICHT HERGESTELLT WERDEN");
				return null;
			}
			else {
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Ergebnis scrollbar, Query kann DB leseb
				rs = stmt.executeQuery(sqlquery);
				//Erstellung der Kundenobjekte f�r jede Zeile der Tabelle & anschlie�ende Speicherung in Liste
				while (rs.next()) {
					Kunde kunde = new Kunde();
					kunde.setId(rs.getInt("pk_ID"));
					kunde.setNname(rs.getString("Nachname"));
					kunde.setVname(rs.getString("Vorname"));
					kunde.setStr(rs.getString("Stra�e"));
					kunde.setStrnr(rs.getInt("Nummer"));
					kunde.setPlz(rs.getInt("PLZ"));
					kunde.setOrt(rs.getString("Ort"));
					kunden.add(kunde);
				}
				return kunden;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) connection.close();
		}
	}
	
	
//Flugzeug Objekte aus DB erzeugen	
	public static List<Flugzeug> showDBflu(String sqlquery) throws SQLException {
		//Liste mit Flugzeug-Objekten die anschlie�end �bergeben wird
		//Result Set kann nicht �bergeben werden da es in finally bereits geschlossen wird
		List<Flugzeug> flugzeuge = new ArrayList<Flugzeug>();
		
		try {
			//Test ob DB erreichbar
			if (!(DBconnection.connectToMysql(host, db, user, pw))) {
				System.out.println("FEHLER-DATENBANKVERBINDUNG KONNTE NICHT HERGESTELLT WERDEN");
				return null;
			}
			else {
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Ergebnis scrollbar, Query kann DB leseb
				rs = stmt.executeQuery(sqlquery);
				//Erstellung der Flugzeugobjekte f�r jede Zeile der Tabelle & anschlie�ende Speicherung in Liste
				while (rs.next()) {
					Flugzeug flugzeug = new Flugzeug();
					flugzeug.setId(rs.getInt("pk_ID"));
					flugzeug.setModell(rs.getString("Modell"));
					flugzeug.setSitze(rs.getInt("Sitze"));
					flugzeug.setIdku(rs.getInt("f_kunden_flugzeuge"));
					flugzeuge.add(flugzeug);
				}
				return flugzeuge;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) connection.close();
		}
	}
	
	
//DB updaten	
	public static void updateDB(String sqlquery) throws SQLException {		
		try {
			//Test ob DB erreichbar
			if (!(DBconnection.connectToMysql(host, db, user, pw)))	System.out.println("FEHLER-DATENBANKVERBINDUNG KONNTE NICHT HERGESTELLT WERDEN");
			else {
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//Ergebnis scrollbar, Query kann DB updaten
				stmt.executeUpdate(sqlquery);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) connection.close();
		}
	}

	
}
