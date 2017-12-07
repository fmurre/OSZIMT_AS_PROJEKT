package application.Save;

import java.sql.SQLException;
import java.util.List;

import application.Objects.Flugzeug;
import application.Objects.Kunde;

public class BuilderXML {

//Erstellt Objekte
	//Flugzeug
	public static Flugzeug newflu(int id, String modell, int sitze) throws SQLException {
		Flugzeug flugzeug = new Flugzeug(id, modell, sitze);	//erstellt Objekt aus �bergebenen Werten
		//TODO
		//flugzeug in XML speichern
		return flugzeug;
	}
	//Kunde
	public static Kunde newku(int id, String nname, String vname, String str, int strnr, int plz, String ort) throws SQLException {
		Kunde kunde = new Kunde(id, plz, strnr, vname, nname, str, ort);	//erstellt Objekt aus �bergebenen Werten
		//TODO
		//kunde in XML speichern
		return kunde;
	}
//L�scht Objekte
	//Flugzeug
	public static void delflu(int id) throws SQLException {
		//TODO
		//flugzeug (id-> wird �bergeben) wird gel�scht aus XML
	}
	//Kunde
	public static void delku(int id) throws SQLException {
		//TODO
		//kunde (id-> wird �bergeben) wird gel�scht aus XML
	}
	
//erzeugt aus XML Liste mit Objekten	
	//Flugzeug
	public static List<Flugzeug> getflu() throws SQLException {
		List<Flugzeug> flugzeuge=null;
		//TODO
		//die List muss aus der XML Datei gef�llt werden (null ersetzen)
		if (flugzeuge != null) return flugzeuge;
		else return null;
	}
	//Kunde
	public static List<Kunde> getku() throws SQLException {
		List<Kunde> kunden=null;
		//TODO
		//die List muss aus der XML Datei gef�llt werden (null ersetzen)
		if (kunden != null) return kunden;
		else return null;
	}	
}
