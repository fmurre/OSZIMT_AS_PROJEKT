package application.old;

import java.util.Scanner;


public class IO_MainMenu {
	static Scanner sc = new Scanner(System.in);
	public static int hauptmenu() {
		System.out.println("==========FLUGZEUGVERWALTUNG==========\n______________________________________\n");
	    System.out.println("----Men�----");
	    System.out.println("1. Mietobjektverwaltung");
	    System.out.println("2. Kundenverwaltung");
	    System.out.println("3. Flugzeugvermietung");
	    System.out.println("4. Men�punkt");
	    System.out.println("5. Men�punkt");
	    System.out.println("6. Men�punkt");
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
	public static int menu_objverw() {
		System.out.println("\n==========Mietobjektverwaltung==========\n________________________________________\n");
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
	
	public static int menu_kuverw() {
		System.out.println("\n==========Kundenverwaltung==========\n________________________________________\n");
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
	}//end of method kuverw
	
	public static int menu_verm() {
		System.out.println("\n==========Flugzeugvermietung==========\n________________________________________\n");
		System.out.println("----Men�----");
	    System.out.println("1. Vermietung");
	    System.out.println("2. R�ckgabe");
	    System.out.println("3. Suche (Kundennummer)");
	    System.out.println("4. Suche (Flugzeugnummer)");
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
	}
//----------------------------------------------
//
//
	public static void fortfahren(String[][] flugzeug, String[][] kunde) {
		int i=0; 
		while (i==0) {
		    	System.out.println("\nFortfahren? (Y/N)");
		    	char del=sc.next().toLowerCase().charAt(0);
		    	switch (del) {
		    	case 'y' :
		    		i=1;
		    		Menuswitch.main(flugzeug, kunde);
		    		break;
		    	case 'n' :
		    		i=1;
		    		System.out.println("Ende...");
		    		break;
		    	default:
		    		i=0;
		    	}
		 }
	}
	
}//end of class Console
