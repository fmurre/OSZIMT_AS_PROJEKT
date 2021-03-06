package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import application.Objects.Helper;
import application.Objects.Kunde;
import application.Save.BuilderDB;

public class Kuverw {
	static Scanner sc = new Scanner(System.in);
//NEUER KUNDE
	// CONSOLE + SQL =========================	
	public static void new_con_sql(Helper help) throws SQLException {
		//Eingaben
		System.out.println("\n----------Neuen Kunden hinzuf�gen-----------");                                           
	    System.out.print("\nVorname: ");
	    String vname=sc.next();
	    System.out.print("\nNachname: ");
	    String nname=sc.next();
	    System.out.print("\n---Adresse--- ");
	    System.out.print("\nStra�e: ");
	    String str=sc.next();
	    System.out.print("\nNummer: ");
	    int strnr=sc.nextInt();
	    System.out.print("\nPLZ: ");
	    int plz=sc.nextInt();
	    System.out.print("\nOrt: ");
	    String ort=sc.next();
	    
	    //n�chste freie ID wird aus DB geladen
	    List<Kunde> kunden=BuilderDB.getku();
	    int id=1;
	    try {
	    	id=kunden.get(kunden.size()-1).getId()+1;
	    }	    	
	    catch (ArrayIndexOutOfBoundsException e) {//kunden.size()-1 wirft diese Exception wenn das Array Kunden keine Elemente enth�lt (Size=0)
	    	System.out.println("\nDies ist der erste Datensatz, ID=1");
	    }
	   /* catch (NullPointerException e) {
	    	System.out.println("\nNullPointerException");
	    }*/
	    //Kunden Objekt erstellen
	    Kunde kunde=BuilderDB.newku(id, nname, vname, str, strnr, plz, ort);
	    //Ausgabe Check
	    System.out.println("\nSie haben folgenden Kunden hinzugef�gt:");                                                     
	    System.out.println("Kundennummer: "+kunde.getId());
	    System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
	    System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()); 
	    
	    
	    Menu.fortfahrenkuverw(help);
	}
	// CONSOLE + XML =========================	
	public static void new_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void new_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void new_gui_xml(Helper help) {
		
	}
	
	
//KUNDE L�SCHEN
	// CONSOLE + SQL =========================	
	public static void del_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
	    List<Kunde> kunden=BuilderDB.getku();
	   
	    System.out.println("\n----------Kunde entfernen-----------");
		System.out.print("\nGeben Sie die Kundennummer ein: ");
		int id=sc.nextInt();
		
		//Pr�fung ob ID vergeben
		int i=0;
		while (i==0) {
			for (Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
				if (id==kunde.getId()) {
					System.out.println("\nSie l�schen folgenden Kunden:");                                                     
				    System.out.println("Kundennummer: "+id);
				    System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
				    System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()); 
					i=0;
					while (i==0) {//l�schen best�tigen
						System.out.println("L�schen best�tigen (Y/N)");
						char del=sc.next().toLowerCase().charAt(0);
						switch (del) {
						case 'y' : //wird gel�scht
							i=1;
							BuilderDB.delku(id);
							System.out.println("Erfolgreich gel�scht");
							break;
						case 'n' : //wird nicht gel�scht
							i=1;
							System.out.println("L�schen beendet");
							break;
						default:
							i=0;
						}//end of switch
					}//end of while
				}
			}//end of for
			if (i==0) {
				System.out.print("\nDie eingegebene Kundenummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
				id=sc.nextInt();
			}
			if (id==0) break;//break weil User 0=beenden ausgew�hlt hat
		}//end of while	
		Menu.fortfahrenkuverw(help);
	}
	// CONSOLE + XML =========================	
	public static void del_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void del_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void del_gui_xml(Helper help) {
		
	}
	
		
//1 KUNDEN ANZEIGEN
	// CONSOLE + SQL =========================	
	public static void show_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
		List<Kunde> kunden=BuilderDB.getku();
		
		
		System.out.println("\n----------Anzeigen eines Kunden-----------");
		System.out.print("\nGeben Sie die Kundennummer ein:");
		int id=sc.nextInt();
		
		//�berpr�fung ob Kundennummer vorhanden
		int i=0;
		while (i==0) {	
			for (Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
				if (id==kunde.getId()) { //wenn Kundenobjekt mit gesuchter ID gefunden wird
					i=1;
					System.out.println("Kundennummer: "+id);
					System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
					System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt());
					break;
				}//end of if
			}//end of for
			if (i==0) {
				System.out.print("\nDie eingegebene Kundenummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
				id=sc.nextInt();
			}//end of if			
			if (id==0) break; //wenn User 0=beenden gew�hlt hat
		}//end of while	
		
		
		Menu.fortfahrenkuverw(help);
	}
	// CONSOLE + XML =========================	
	public static void show_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void show_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void show_gui_xml(Helper help) {
		
	}
	
//ALLE KUNDEN ANZEIGEN
	// CONSOLE + SQL =========================	
	public static void showall_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
		List<Kunde> kunden=BuilderDB.getku();
		
		System.out.println("\n----------Anzeigen aller Kunden-----------");
		for (Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
				System.out.println("Kundennummer: "+kunde.getId());
				System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
				System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()+"\n");
		}
	    Menu.fortfahrenkuverw(help);
		
	}
	// CONSOLE + XML =========================	
	public static void showall_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void showall_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void showall_gui_xml(Helper help) {
		
	}
}
