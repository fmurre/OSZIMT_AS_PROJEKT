package application;


import java.sql.SQLException;

import application.Objects.Helper;

public class Menuswitch {
//HAUPTMEN�=======================================================
	public static void mainMenu(Helper help) throws SQLException {
		int hauptmenu=Menu.hauptmenu();		
		switch (hauptmenu) {
			case 1 : //Flugzeugverwaltung
				Menuswitch.fluverw(help);
			break;
			case 2 : //Kundenverwaltung
				Menuswitch.kuverw(help);
			break;
			case 3 : //Vermietung
				Menuswitch.verm(help);
			break;
			case 0: //beenden
				System.out.print("\n\nBeendet...");
			break;
			default:
		} //end of switch hauptmenu
	}//end of method MainMenu
	
	public static void fluverw(Helper help) throws SQLException {
		int untermenu=Menu.menu_fluverw();
		String save, look;
		switch (untermenu) {
		//FLUGZEUG HINZUF�GEN==========================================
			case 1: 
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Fluverw.new_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Fluverw.new_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Fluverw.new_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Fluverw.new_gui_xml(help);
				}
			break;
			case 2: //Objekt entfernen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Fluverw.del_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Fluverw.del_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Fluverw.del_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Fluverw.del_gui_xml(help);
				}								
			break;
			case 3: //Ein Objekt anzeigen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Fluverw.show_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Fluverw.show_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Fluverw.show_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Fluverw.show_gui_xml(help);
				}	
			break;
			case 4: //Alle Objekte anzeigen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Fluverw.showall_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Fluverw.showall_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Fluverw.showall_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Fluverw.showall_gui_xml(help);
				}
			break;
			case 0: //beenden
				Menuswitch.mainMenu(help);
			break;
			default:
		}//end of switch untermenu
	}//end of method fluverw
	
	public static void kuverw(Helper help) throws SQLException {
		int untermenu=Menu.menu_kuverw();
		String save, look;
		switch (untermenu) {
			case 1: //Objekt hinzuf�gen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Kuverw.new_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Kuverw.new_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Kuverw.new_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Kuverw.new_gui_xml(help);
				}
			break;
			case 2: //Objekt entfernen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Kuverw.del_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Kuverw.del_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Kuverw.del_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Kuverw.del_gui_xml(help);
				}								
			break;
			case 3: //Ein Objekt anzeigen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Kuverw.show_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Kuverw.show_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Kuverw.show_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Kuverw.show_gui_xml(help);
				}	
			break;
			case 4: //Alle Objekte anzeigen
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Kuverw.showall_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Kuverw.showall_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Kuverw.showall_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Kuverw.showall_gui_xml(help);
				}
			break;
			case 0: //beenden
				Menuswitch.mainMenu(help);
			break;
			default:
		}//end of switch untermenu
	}//end of method kuverw
	
	public static void verm(Helper help) throws SQLException {
		int untermenu=Menu.menu_verm();
		String save, look;
		switch (untermenu) {
			case 1://Vermietung
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Verm.verm_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Verm.verm_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Verm.verm_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Verm.verm_gui_xml(help);
				}
			break;
			case 2://R�ckgabe
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Verm.ruck_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Verm.ruck_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Verm.ruck_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Verm.ruck_gui_xml(help);
				}
			break;
			case 3://Suche (Kundennummer)
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Verm.sk_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Verm.sk_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Verm.sk_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Verm.sk_gui_xml(help);
				}
			break;
			case 4://Suche (Flugzeug)
				save = help.getSave();
				look = help.getLook();		
				if (look.equals("con")) {
					// CONSOLE + SQL =========================
					if (save.equals("sql")) Verm.sf_con_sql(help);
					// CONSOLE + XML =========================
					else if (save.equals("xml")) Verm.sf_con_xml(help);
				}
				else if (look.equals("gui")) {
					// GUI + SQL =============================
					if (save.equals("sql")) Verm.sf_gui_sql(help);
					// GUI + XML =============================
					else if (save.equals("xml")) Verm.sf_gui_xml(help);
				}
			break;
			case 0: //beenden
				Menuswitch.mainMenu(help);
			break;
		}//end of switch untermenu
	}//end of method verm
	
		

}
