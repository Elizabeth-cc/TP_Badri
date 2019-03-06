//travail fait par Benjamin Gelineau et Elizabeth Courtieu

package inf1004final;
public class Limousine {


	private String immatriculation;
	private int capaciteReservoir;
	private String couleur;

	public Limousine(String immatriculation, int capaciteReservoir, String couleur) {

		this.immatriculation =immatriculation;
		this.capaciteReservoir =capaciteReservoir;
		this.couleur = couleur;

	}
	//getters and setters

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getCapaciteReservoir() {
		return capaciteReservoir;
	}

	public void setCapaciteReservoir(int capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	//metode tostring
	public String toString(){
		return "La limousine " + this.couleur + " avec l'identifiant #" + this.immatriculation  + " a une capacite de " + this.capaciteReservoir + " litres. ";
	}

}
