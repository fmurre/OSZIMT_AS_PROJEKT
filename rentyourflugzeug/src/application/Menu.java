package application;

import java.sql.SQLException;
import java.util.Scanner;

import application.Objects.Helper;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	//HAUPTMEN�====================
	public static int hauptmenu() {
		System.out.println("==========RentYourFlugzeug==========\n______________________________________\n");
	    System.out.println("----Men�----");
	    System.out.println("1. Flugzeugverwaltung");
	    System.out.println("2. Kundenverwaltung");
	    System.out.println("3. Flugzeugvermietung");
	    System.out.println("0. Beenden");
	    int menu=sc.nextInt();
	    
	    int i=0;
	    while (i==0) { 
	        if ((menu>6)||(menu<0)) {
	          System.out.print("\nSie haben keinen der Men�punkte gew�hlt.\n Erneute Eingabe:");
	          menu=sc.nextInt();
	        } // end of if
	        else i=1;
	    } // end of while
	    return menu;
	    
	    
	    
	}//end of method hauptmenu
//-----------------------------------------------
//--------------UNTERMEN�S-----------------------
//-----------------------------------------------	
	//FLUGZEUGVERWALTUNG==============
	public static int menu_fluverw() {
		System.out.println("\n==========Flugzeugverwaltung==========\n________________________________________\n");
	    System.out.println("----Men�----");
	    System.out.println("1. Objekt hinzuf�gen");
	    System.out.println("2. Objekt entfernen");
	    System.out.println("3. Ein Objekt anzeigen");
	    System.out.println("4. Alle Objekte anzeigen");
	    System.out.println("0. Beenden");
	    int menu=sc.nextInt();
	    int i=0;
	    while (i==0) { 
	        if ((menu>4)||(menu<0)) {
	          System.out.print("\nSie haben keinen der Men�punkte gew�hlt.\n Erneute Eingabe:");
	          menu=sc.nextInt();
	        } // end of if
	        else i=1;
	    }//end of while    
	    return menu;	    
	}//end of method menu_objverw
	
	//KUNDENVERWALTUNG===============
	public static int menu_kuverw() {
		System.out.println("\n==========Kundenverwaltung==========\n________________________________________\n");
	    System.out.println("----Men�----");
	    System.out.println("1. Objekt hinzuf�gen");
	    System.out.println("2. Objekt entfernen");
	    System.out.println("3. Ein Objekt anzeigen");
	    System.out.println("4. Alle Objekte anzeigen");
	    System.out.println("0. Hauptmen�");
	    int menu=sc.nextInt();
	    int i=0;
	    while (i==0) { 
	        if ((menu>4)||(menu<0)) {
	          System.out.print("\nSie haben keinen der Men�punkte gew�hlt.\n Erneute Eingabe:");
	          menu=sc.nextInt();
	        } // end of if
	        else i=1;
	    }//end of while    
	    return menu;	    
	}//end of method kuverw
	
	//VERMIETUNG===================
	public static int menu_verm() {
		System.out.println("\n==========Flugzeugvermietung==========\n________________________________________\n");
		System.out.println("----Men�----");
	    System.out.println("1. Vermietung");
	    System.out.println("2. R�ckgabe");
	    System.out.println("3. Suche (Kundennummer)");
	    System.out.println("4. Suche (Flugzeugnummer)");
	    System.out.println("0. Hauptmen�");
	    int menu=sc.nextInt();
	    int i=0;
	    while (i==0) { 
	        if ((menu>4)||(menu<0)) {
	          System.out.print("\nSie haben keinen der Men�punkte gew�hlt.\n Erneute Eingabe:");
	          menu=sc.nextInt();
	        } // end of if
	        else i=1;
	    }//end of while    
		return menu;
	}
//----------------------------------------------
//--FORTFAHREN
//----------------------------------------------
	//im MAIN MENU
	public static void fortfahrenMainMenu(Helper help) throws SQLException {
		int i;
		
		do {
			System.out.println("\nFortfahren im Hauptmen�? (Y/N)");
	    	char del=sc.next().toLowerCase().charAt(0);
	    	switch (del) {
	    	case 'y' :
	    		i=1;
	    		Menuswitch.mainMenu(help);
	    		break;
	    	case 'n' :
	    		i=1;
	    		System.out.print("\n\nBeendet...");
	    		break;
	    	default:
	    		i=0;
	    	}
		}while (i==0);
	}//end of method fortfahrenMainMenu
	
	//in FLUGZEUGVERWALTUNG
	public static void fortfahrenfluverw(Helper help) throws SQLException {
		int i;
		do {
			System.out.println("\nFortfahren? (Y/N)");
	    	char del=sc.next().toLowerCase().charAt(0);
	    	switch (del) {
	    	case 'y' :
	    		i=1;
	    		Menuswitch.fluverw(help);
	    		break;
	    	case 'n' :
	    		i=1;
	    		Menuswitch.mainMenu(help);
	    		break;
	    	default:
	    		i=0;
	    	}
		}while (i==0);
	}//end of method fortfahrenfluverw
	
	//in KUNDENVERWALTUNG
	public static void fortfahrenkuverw(Helper help) throws SQLException {
		int i;
		do {
			System.out.println("\nFortfahren? (Y/N)");
	    	char del=sc.next().toLowerCase().charAt(0);
	    	switch (del) {
	    	case 'y' :
	    		i=1;
	    		Menuswitch.kuverw(help);
	    		break;
	    	case 'n' :
	    		i=1;
	    		Menuswitch.mainMenu(help);
	    		break;
	    	default:
	    		i=0;
	    	}
		}while (i==0);
	}//end of method fortfahrenkuverw
	
	//in VERMIETUNG
	public static void fortfahrenverm(Helper help) throws SQLException {
		int i;
		do {
			System.out.println("\nFortfahren? (Y/N)");
	    	char del=sc.next().toLowerCase().charAt(0);
	    	switch (del) {
	    	case 'y' :
	    		i=1;
	    		Menuswitch.verm(help);
	    		break;
	    	case 'n' :
	    		i=1;
	    		Menuswitch.mainMenu(help);
	    		break;
	    	default:
	    		i=0;
	    	}
		}while (i==0);
	}//end of method fortfahrenverm
	
}