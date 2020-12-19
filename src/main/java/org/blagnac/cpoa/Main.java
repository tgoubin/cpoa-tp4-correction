package org.blagnac.cpoa;

import java.util.Locale;
import java.util.Scanner;

import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.action.application.ActionContextAB;
import org.blagnac.cpoa.action.application.ActionListAB;
import org.blagnac.cpoa.action.application.actionList.ActionListGeneralMenu;
import org.blagnac.cpoa.banque.AgenceBancaire;
import org.blagnac.cpoa.banque.Compte;

public class Main {

	public static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		Main.SCANNER.useLocale(Locale.US);

		AgenceBancaire agenceBancaire = initialiserAgenceBancaire();
		ActionContext<AgenceBancaire> actionContextAB = new ActionContextAB(agenceBancaire);

		ActionListAB generalMenu = new ActionListGeneralMenu("Menu general");

		generalMenu.execute(actionContextAB);
	}

	private static AgenceBancaire initialiserAgenceBancaire() {
		AgenceBancaire agenceBancaire = new AgenceBancaire("IUT Bank", "Blagnac");

		agenceBancaire.addCompte(new Compte("Thibault GOUBIN", "012345"));
		agenceBancaire.addCompte(new Compte("J.M. BRUEL", "543210"));

		return agenceBancaire;
	}
}
