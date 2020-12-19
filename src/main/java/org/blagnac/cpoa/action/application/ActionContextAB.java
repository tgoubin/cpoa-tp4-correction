package org.blagnac.cpoa.action.application;

import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.banque.AgenceBancaire;

public class ActionContextAB implements ActionContext<AgenceBancaire> {

	private AgenceBancaire agenceBancaire;

	public ActionContextAB(AgenceBancaire agenceBancaire) {
		this.agenceBancaire = agenceBancaire;
	}

	@Override
	public AgenceBancaire getContext() {
		return agenceBancaire;
	}
}
