package org.blagnac.cpoa.action.application;

import java.util.ArrayList;
import java.util.List;

import org.blagnac.cpoa.Main;
import org.blagnac.cpoa.action.Action;
import org.blagnac.cpoa.action.ActionContext;
import org.blagnac.cpoa.action.ActionList;
import org.blagnac.cpoa.banque.AgenceBancaire;

public class ActionListAB implements ActionList<AgenceBancaire> {

	private String title;
	private List<Action<AgenceBancaire>> menu;

	public ActionListAB(String title) {
		this.title = title;
		this.menu = new ArrayList<>();
	}

	@Override
	public String title() {
		return title;
	}

	@Override
	public boolean addAction(Action<AgenceBancaire> actionContext) {
		return menu.add(actionContext);
	}

	@Override
	public boolean removeAction(Action<AgenceBancaire> actionContext) {
		// Pour utiliser la methode 'uneListe.remove()' il faut implementer les methodes
		// 'equals' et 'hashCode' sur 'GenericActionAB' (sur le champ code, qui sert
		// d'element de comparaison)
		return menu.remove(actionContext);
	}

	@Override
	public int listSize() {
		return menu.size();
	}

	@Override
	public Action<AgenceBancaire> getAction(int index) {
		// On pourrait (devrait) lever une exception si index < 0 ou index > menu.size()
		return menu.get(index);
	}

	public void execute(ActionContext<AgenceBancaire> actionContext) {
		System.out.println("---------------------------------------");
		System.out.println(actionContext.getContext().getNom());
		System.out.println(actionContext.getContext().getLocalisation());
		System.out.println("---------------------------------------");
		System.out.println();

		for (int i = 1; i < menu.size(); i++) {
			System.out.println(menu.get(i).stringCode() + menu.get(i).message());
		}
		System.out.println(menu.get(0).stringCode() + menu.get(0).message());

		// Gestion du choix du menu (saisie clavier) - erreur si invalide (< 0 ou >= la
		// taille du menu)
		// N.B. Le code de l'action = l'index de l'action dans le menu
		String choixMenu = null;
		Boolean choixMenuValide = null;
		do {
			System.out.println();
			System.out.println("Saisissez votre choix : ");

			choixMenu = Main.SCANNER.next().toLowerCase();
			choixMenuValide = Integer.parseInt(choixMenu) >= 0 && Integer.parseInt(choixMenu) < listSize();

			if (!choixMenuValide) {
				System.out.println("Ce choix est invalide !!");
			}
		} while (!choixMenuValide);

		System.out.println();
		getAction(Integer.parseInt(choixMenu)).execute(actionContext);

		System.out.println();

		// On revient a l'affichage du menu
		execute(actionContext);
	}
}
