package org.blagnac.cpoa.banque;

import java.util.ArrayList;
import java.util.List;

public class AgenceBancaire {

	private String nom;
	private String localisation;
	private List<Compte> comptes;

	public AgenceBancaire(String nom, String localisation) {
		this.nom = nom;
		this.localisation = localisation;
		this.comptes = new ArrayList<>();
	}

	public void addCompte(Compte compte) {
		comptes.add(compte);
	}

	public void removeCompte(Compte compte) {
		// Pour utiliser la methode 'uneListe.remove()' il faut implementer les methodes
		// 'equals' et 'hashCode' sur 'Compte' (sur le champ numeroCompte, qui sert
		// d'element de comparaison)
		comptes.remove(compte);
	}

	public int getNbComptes() {
		return comptes.size();
	}

	public Compte getCompte(String numeroCompte) {
		Compte compte = null;

		int i = 0;
		while (compte == null && i < comptes.size()) {
			System.out.println(comptes.get(i).getNumeroCompte() + " / " + numeroCompte);
			if (comptes.get(i).getNumeroCompte().equals(numeroCompte)) {
				compte = comptes.get(i);
			}
			i++;
		}

		return compte;
	}

	public Compte[] getComptesDe(String proprietaire) {
		List<Compte> comptesList = new ArrayList<>();

		for (Compte compte : comptes) {
			if (compte.getProprietaire().equals(proprietaire)) {
				comptesList.add(compte);
			}
		}

		// Conversion List -> Array avec la methode "uneListe.toArray(<un tableau deja
		// initialise>)"
		Compte[] comptes = new Compte[comptesList.size()];
		return comptesList.toArray(comptes);
	}

	public void afficher() {
		System.out.println("AGENCE BANCAIRE :");
		System.out.println(toString());
		System.out.println();

		System.out.println("LISTE DES COMPTES :");
		for (Compte compte : comptes) {
			compte.afficher();
		}
	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", localisation=" + localisation + "]";
	}

	public String getNom() {
		return nom;
	}

	public String getLocalisation() {
		return localisation;
	}
}
