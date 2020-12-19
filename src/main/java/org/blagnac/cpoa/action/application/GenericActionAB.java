package org.blagnac.cpoa.action.application;

import org.blagnac.cpoa.action.Action;
import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.banque.AgenceBancaire;

public abstract class GenericActionAB implements Action<AgenceBancaire> {

	private String code;
	private String message;

	public GenericActionAB(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public String stringCode() {
		return code + " - ";
	}

	@Override
	public abstract void execute(ActionContext<AgenceBancaire> actionContext);
}
