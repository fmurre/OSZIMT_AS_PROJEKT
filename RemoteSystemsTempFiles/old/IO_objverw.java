package application.old;

import java.util.Scanner;

public class IO_objverw {
	static Scanner sc = new Scanner(System.in);
//====Neues Objekt====	
	public static void neuobj(String[][] flugzeug, String[][] kunde) {
		//Eingaben
		System.out.println("\n----------Neues Flugzeug hinzuf�gen-----------");                                            //--Eingabe Beginn
	    System.out.print("\nGeben Sie das Flugzeugmodell ein: ");
	    String modell=sc.next();
	    System.out.print("\nGeben Sie die Sitzpl�tze des Flugzeugs ein: ");
	    int sitze=sc.nextInt();
	    System.out.println("\nGeben Sie die Nummer des Flugzeugs ein:  (0=automatisch zuweisen)");
	    System.out.println("Achtung wenn die Nummer bereits vergeben ist wird diese �berschrieben!");
	    int nr=sc.nextInt();
	    if (nr==0) {
			for (int i=1; i<=24;i++){
				if (flugzeug[i][0]==null) {
					nr=i;
					break;
				}
				if (i==24) {
					System.out.println("Es gibt keinen freien Platz, welcher soll �berschrieben werden?");
					nr=sc.nextInt();
				}
			}
		 }
	    //�berpr�fung ob ID zul�ssig
	    int i=0;
	    while (i==0) { //l�uft bis zul�ssige ID gew�hlt wurde
	    	if ((nr<=24) && (nr>0)) i=1;
	    	else {
	    		System.out.println("Es k�nnen maximal 24 Objekte verwaltet werden geben Sie eine Zahl von 1-24 ein:");
	            nr = sc.nextInt();
	            i=0;  
	    	}//end of else
	    }//end of while
	   
	    //Flugzeug Objekt erstellen
	    flugzeug=Objekte.flugzeug_eintrag(nr, modell, flugzeug, sitze);
	   
	    //Ausgabe Check
	    System.out.println("\nSie haben folgendes Flugzeug hinzugef�gt:");                                                     //--Ausgabe Beginn
	    System.out.println("Flugzeugnummer: "+nr);
	    System.out.println("Modell: "+flugzeug[nr][0]);
	    System.out.println("Sitzpl�tze: "+flugzeug[nr][1]); 
	    IO_MainMenu.fortfahren(flugzeug, kunde);
	}//end of method neuobj
	
//====Objekt l�schen	
	public static void delobj(String flugzeug[][], String[][] kunde) {
		System.out.println("\n----------Flugzeug entfernen-----------");                                            //--Eingabe Beginn
	    int i=0, id=0;	
	    System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
		id=sc.nextInt();
	    i=0;
		while (i==0) { 
			if ((id<=24) && (id>0)) {
				i=1;
				if (flugzeug[id][0]==null) {
					System.out.println("\nEs gibt kein Flugzeug zu dieser Nummer");
					i=0;
				}
				else i=1;
			}
		    else {
		        System.out.println("Es k�nnen maximal 24 Flugzeuge verwaltet werden geben Sie eine Zahl von 1-24 ein:");
		        id = sc.nextInt();
		        i=0;  
		    } // end of if-else
		} // end of while 
	    
	    System.out.println("\nSie l�schen folgendes Flugzeug:");
	    System.out.println("Flugzeugnummer: "+ id );
	    System.out.println("Modell: "+ flugzeug[id][0]);
	    System.out.println("Sitzpl�tze: "+ flugzeug[id][1]);
	    i=0;
	    while (i==0) {
	    	System.out.println("L�schen best�tigen (Y/N)");
	    	char del=sc.next().toLowerCase().charAt(0);
	    	switch (del) {
	    	case 'y' :
	    		i=1;
	    		flugzeug=Objekte.flugzeug_loeschen(flugzeug, id);
	    		System.out.println("Erfolgreich gel�scht");
	    		break;
	    	case 'n' :
	    		i=1;
	    		System.out.println("L�schen beendet");
	    		break;
	    	default:
	    		i=0;
	    	}//end of switch
	    }//end of while
	    IO_MainMenu.fortfahren(flugzeug, kunde);
	}//end of method delobj
	
//===Objekt anzeigen
	public static void showobj(String[][] flugzeug, String[][] kunde) {
		 System.out.println("\n----------Anzeigen eines Flugzeugs-----------");
		 System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
		 int nr=sc.nextInt();
		 int i=0;
		 while (i==0) { 
			if ((nr<=24) && (nr>0)) {
					i=1;
					if (flugzeug[nr][0]==null) {
						System.out.println("\nEs gibt kein Flugzeug zu dieser Nummer");
						i=0;
					}
					else i=1;
				}
			    else {
			        System.out.println("Es k�nnen maximal 24 Flugzeuge verwaltet werden geben Sie eine Zahl von 1-24 ein:");
			        nr = sc.nextInt();
			        i=0;  
			    } // end of if-else
			} // end of while 
		 if ((flugzeug[nr][0]!=null)&&(flugzeug[nr-1][1]!=null)) {
		      System.out.println("\nFlugzeugnummer: "+(nr));
		      System.out.println("Modell: "+flugzeug[nr][0]);
		      System.out.println("Sitzpl�tze: "+flugzeug[nr][1]);
		 } // end of if
		 else System.out.println("\nEs gibt kein Flugzeug mit der Nummer "+nr+"\n");	
		 IO_MainMenu.fortfahren(flugzeug, kunde);
	}//end of method showobj
	
	public static void showall(String[][] flugzeug, String[][] kunde) {
		System.out.println("\n----------Anzeigen aller Flugzeuge-----------");
	    for (int i=1; i<=24 ;i++ ) {
	      if ((flugzeug[i][0]!=null)&&(flugzeug[i][1]!=null)) {
	        System.out.println("\nFlugzeugnummer: "+(i));
	        System.out.println("Modell: "+flugzeug[i][0]);
	        System.out.println("Sitzpl�tze: "+flugzeug[i][1]);
	      } // end of if
	    } // end of for
	    IO_MainMenu.fortfahren(flugzeug, kunde);
	}//end of method showall
}//end of class Objektverwaltung
