package application.Save;

public class Sqlquery {
	
	public static String newKunde(int id, String Nachname, String Vorname, String Stra�e, int Nummer, int PLZ, String Ort) {
		String sqlquery=null;
		sqlquery=("INSERT INTO t_kunden (pk_id, Nachname, Vorname, Stra�e, Nummer, PLZ, Ort) VALUES ('"+id+"', '"+Nachname+"', '"+Vorname+"', '"+Stra�e+"', '"+Nummer+"', '"+PLZ+"', '"+Ort+"');");
		return sqlquery;
	}
	public static String delKunde(int id) {
		String sqlquery=null;
		sqlquery=("DELETE FROM t_kunden WHERE pk_id="+id);
		return sqlquery;
	}
	public static String getKunden() {
		String sqlquery=null;
		sqlquery=("SELECT * FROM t_kunden");
		return sqlquery;
	}
	
	
	public static String newFlugzeug(int id, String Modell, int Sitze) {
		String sqlquery=null;
		sqlquery=("INSERT INTO t_flugzeuge (pk_id, Modell, Sitze) VALUES ('"+id+"', '"+Modell+"', '"+Sitze+"');");
		return sqlquery;
	}
	public static String delFlugzeug(int id) {
		String sqlquery=null;
		sqlquery=("DELETE FROM t_flugzeuge WHERE pk_id="+id);
		return sqlquery;
	}
	public static String getFlugzeuge() {
		String sqlquery=null;
		sqlquery=("SELECT * FROM t_flugzeuge");
		return sqlquery;
	}
	
	

	public static String verm(int idku, int idflu) {
		String sqlquery=null;
		sqlquery=("UPDATE t_flugzeuge SET f_kunden_flugzeuge = "+idku+" WHERE t_flugzeuge.pk_id ="+idflu);
		return sqlquery;
	}
	public static String ruckgabe(int idflu) {
		String sqlquery=null;
		sqlquery=("UPDATE t_flugzeuge SET f_kunden_flugzeuge = NULL WHere t_flugzeuge.pk_id ="+idflu);
		return sqlquery;
	}
}
