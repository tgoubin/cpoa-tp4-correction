package org.blagnac.cpoa.action.application.actions.general;

import org.blagnac.cpoa.Main;
import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.action.application.GenericActionAB;
import org.blagnac.cpoa.banque.AgenceBancaire;

public class ActionQuitterApplicationAB extends GenericActionAB {

	public ActionQuitterApplicationAB(String code, String message) {
		super(code, message);
	}

	@Override
	public void execute(ActionContext<AgenceBancaire> actionContext) {
		System.out.println("Bye bye !");
		Main.SCANNER.close();
		System.exit(0);
	}
}
