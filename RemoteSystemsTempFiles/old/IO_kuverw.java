package application.old;
import java.util.Scanner;

public class IO_kuverw {
	static Scanner sc = new Scanner(System.in);
	//====Neues Objekt====	
		public static void neuobj(String[][] flugzeug, String[][] kunde) {
			//Eingaben
			System.out.println("\n----------Neuen Kunden hinzuf�gen-----------");                                            //--Eingabe Beginn
		    System.out.print("\nVorname: ");
		    String vname=sc.next();
		    System.out.print("\nNachname: ");
		    String nname=sc.next();
		    System.out.print("\n---Adresse--- ");
		    System.out.print("\nStra�e: ");
		    String str=sc.next();
		    System.out.print("\nNummer: ");
		    int adrnr=sc.nextInt();
		    System.out.print("\nPLZ: ");
		    int plz=sc.nextInt();
		    System.out.print("\nOrt: ");
		    String ort=sc.next();
		    System.out.println("\nGeben Sie die Kundennummer ein:  (1-500; 0=automatisch zuweisen)");
		    System.out.println("Achtung wenn die Nummer bereits vergeben ist wird diese �berschrieben!");
		    int nr=sc.nextInt();
		    if (nr==0) {
				for (int i=1; i<=500;i++){
					if (kunde[i][0]==null) {
						nr=i;
						break;
					}
					if (i==500) {
						System.out.println("Es gibt keinen freien Platz, welcher soll �berschrieben werden?");
						nr=sc.nextInt();
					}
				}
			 }
		    //�berpr�fung ob ID zul�ssig
		    int i=0;
		    while (i==0) { //l�uft bis zul�ssige ID gew�hlt wurde
		    	if ((nr<=500) && (nr>0)) i=1;
		    	else {
		    		System.out.println("Es k�nnen maximal 500 Kunden verwaltet werden geben Sie eine Zahl von 1-500 ein:");
		            nr = sc.nextInt();
		            i=0;  
		    	}//end of else
		    }//end of while
		   
		    //Kunden Objekt erstellen
		    kunde=Objekte.kunde_eintrag(kunde, nr, vname, nname, str, adrnr, plz, ort);
		   
		    //Ausgabe Check
		    System.out.println("\nSie haben folgenden Kunden hinzugef�gt:");                                                     //--Ausgabe Beginn
		    System.out.println("Kundennummer: "+nr);
		    System.out.println("Name: "+kunde[nr][0]+ ", " +kunde[nr][1]);
		    System.out.println("Adresse: "+kunde[nr][2]+" "+kunde[nr][3]+", "+kunde[nr][4]+" "+kunde[nr][5]); 
		    IO_MainMenu.fortfahren(flugzeug, kunde);
		}//end of method neuobj
		
	//====Objekt l�schen	
		public static void delobj(String[][] flugzeug, String[][] kunde) {
			System.out.println("\n----------Kunde entfernen-----------");                                            //--Eingabe Beginn
		    int i=0, nr = 0;
			while (i==0) {
				System.out.print("\nGeben Sie die Kundennummer ein: ");	
				nr=sc.nextInt();
				if (kunde[nr][0]==null) System.out.println("\nEs gibt keinen Kunden zu dieser Nummer");
				else i=1;
		    }
		    System.out.println("\nSie l�schen folgenden Kunden:");
		    System.out.println("Kundennummer: "+nr);
		    System.out.println("Name: "+kunde[nr][0]+ ", " +kunde[nr][1]);
		    System.out.println("Adresse: "+kunde[nr][3]+" "+kunde[nr][4]+", "+kunde[nr][5]+" "+kunde[nr][6]); 
		    i=0;
		    while (i==0) {
		    	System.out.println("L�schen best�tigen (Y/N)");
		    	char del=sc.next().toLowerCase().charAt(0);
		    	switch (del) {
		    	case 'y' :
		    		i=1;
		    		kunde=Objekte.kunde_loeschen(kunde, nr);
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
			 System.out.println("\n----------Anzeigen eines Kunden-----------");
			 System.out.print("\nGeben Sie die Kundennummer ein:");
			 int nr=sc.nextInt();
			 int i=0;
				while (i==0) { 
					if ((nr<=500) && (nr>0)) {
						i=1;
						if (kunde[nr][0]==null) {
							System.out.println("\nEs gibt keinen Kunden zu dieser Nummer");
							i=0;
						}
						else i=1;
					}
				    else {
				        System.out.println("Es k�nnen maximal 500 Kunden verwaltet werden geben Sie eine Zahl von 1-500 ein:");
				        nr = sc.nextInt();
				        i=0;  
				    } // end of if-else
				} // end of while   
			 if ((kunde[nr][0]!=null)&&(kunde[nr][1]!=null)) {
				 System.out.println("Kundennummer: "+nr);
				 System.out.println("Name: "+kunde[nr][0]+ ", " +kunde[nr][1]);
				 System.out.println("Adresse: "+kunde[nr][2]+" "+kunde[nr][3]+", "+kunde[nr][4]+" "+kunde[nr][5]);
			 } // end of if
			 else System.out.println("\nEs gibt kein Kunden mit der Nummer "+nr+"\n");	
			 IO_MainMenu.fortfahren(flugzeug, kunde);
		}//end of method showobj
		
		public static void showall(String[][] flugzeug, String[][] kunde) {
			System.out.println("\n----------Anzeigen aller Kunden-----------");
		    for (int i=1; i<=500 ;i++ ) {
		      if ((kunde[i][0]!=null)&&(kunde[i][1]!=null)) {
		    	  System.out.println("Kundennummer: "+ i);
				  System.out.println("Name: "+kunde[i][0]+ ", " +kunde[i][1]);
				  System.out.println("Adresse: "+kunde[i][2]+" "+kunde[i][3]+", "+kunde[i][4]+" "+kunde[i][5]); 
		      } // end of if
		    } // end of for
		    IO_MainMenu.fortfahren(flugzeug, kunde);
		}//end of method showall
}
