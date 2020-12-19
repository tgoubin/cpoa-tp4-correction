package org.blagnac.cpoa.banque;

public class Compte {

	private String proprietaire;
	private String numeroCompte;
	private double debits;
	private double credits;
	private int nbDebits;
	private int nbCredits;

	public Compte() {

	}

	public Compte(String proprietaire, String numeroCompte) {
		this.proprietaire = proprietaire;
		this.numeroCompte = numeroCompte;
		this.debits = 0;
		this.credits = 0;
		this.nbDebits = 0;
		this.nbCredits = 0;
	}

	public double soldeCompte() {
		return credits - debits;
	}

	public void afficher() {
		System.out.println(toString());
	}

	public void retirer(double somme) {
		debits += somme;
		nbDebits++;
	}

	public void deposer(double somme) {
		credits += somme;
		nbCredits++;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	@Override
	public String toString() {
		return "[proprietaire=" + proprietaire + ", numeroCompte=" + numeroCompte + ", debits=" + debits + ", credits="
				+ credits + ", nbDebits=" + nbDebits + ", nbCredits=" + nbCredits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCompte == null) ? 0 : numeroCompte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (numeroCompte == null) {
			if (other.numeroCompte != null)
				return false;
		} else if (!numeroCompte.equals(other.numeroCompte))
			return false;
		return true;
	}
}
