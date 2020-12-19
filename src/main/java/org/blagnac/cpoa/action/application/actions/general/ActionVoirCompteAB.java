package org.blagnac.cpoa.action.application.actions.general;

import org.blagnac.cpoa.Main;
import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.action.application.GenericActionAB;
import org.blagnac.cpoa.banque.AgenceBancaire;
import org.blagnac.cpoa.banque.Compte;

public class ActionVoirCompteAB extends GenericActionAB {

	public ActionVoirCompteAB(String code, String message) {
		super(code, message);
	}

	@Override
	public void execute(ActionContext<AgenceBancaire> actionContext) {
		// Gestion du choix du numero de compte
		String choixCompte = null;
		Compte compte = null;
		do {
			System.out.println("Numero de compte ? ");

			choixCompte = Main.SCANNER.next().toLowerCase();
			compte = actionContext.getContext().getCompte(choixCompte);
			if (compte == null) {
				System.out.println("Ce numero de compte n'existe pas !!");
				System.out.println();
			}
		} while (compte == null);

		System.out.println();

		compte.afficher();
	}
}
