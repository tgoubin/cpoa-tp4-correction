package org.blagnac.cpoa.action.application.actions.general;

import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.action.application.GenericActionAB;
import org.blagnac.cpoa.banque.AgenceBancaire;

public class ActionListeComptesAB extends GenericActionAB {

	public ActionListeComptesAB(String code, String message) {
		super(code, message);
	}

	@Override
	public void execute(ActionContext<AgenceBancaire> actionContext) {
		actionContext.getContext().afficher();
	}
}
