package org.blagnac.cpoa.action.application.actionList;

import org.blagnac.cpoa.action.application.ActionListAB;
import org.blagnac.cpoa.action.application.actions.general.ActionListeComptesAB;
import org.blagnac.cpoa.action.application.actions.general.ActionQuitterApplicationAB;
import org.blagnac.cpoa.action.application.actions.general.ActionVoirCompteAB;

public class ActionListGeneralMenu extends ActionListAB {

	public ActionListGeneralMenu(String title) {
		super(title);

		addAction(new ActionQuitterApplicationAB("0", "Quitter l'application"));
		addAction(new ActionListeComptesAB("1", "Liste des comptes de l'agence"));
		addAction(new ActionVoirCompteAB("2", "Voir un compte (par son numero)"));
//		generalMenu.addAction(new ActionOperationCompteAB("3", "Operation sur un compte"));
//		generalMenu.addAction(new ActionGestionComptesAB("4", "Gestion des comptes"));
	}
}
