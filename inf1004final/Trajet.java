//travail fait par Benjamin Gelineau et Elizabeth Courtieu


package inf1004final;

public class Trajet {
	private Chauffeur chauffeur;
	private String villeDepart;
	private String villeArrivee;
	private int kilometrageDepart;
	private int kilometrageArrivee;
	private Limousine limousine; 

	//constructeur

	Trajet(Chauffeur chauffeur,String villeDepart, String villeArrivee, int kilometrageDepart, int kilometrageArrivee, Limousine limousine){
		try {
			this.villeDepart = villeDepart;
			this.villeArrivee = villeArrivee;
			this.kilometrageDepart = kilometrageDepart;
			this.kilometrageArrivee = kilometrageArrivee;
			this.limousine = limousine;
			this.chauffeur = chauffeur;
			this.chauffeur.ajouterTraj(this);
		}catch(Exception e) {
			System.out.println("chauffeur introuve");
			//
		}
	}
	//getters and setters
	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public int getKilometrageDepart() {
		return kilometrageDepart;
	}

	public void setKilometrageDepart(int kilometrageDepart) {
		this.kilometrageDepart = kilometrageDepart;
	}

	public int getKilometrageArrivee() {
		return kilometrageArrivee;
	}

	public void setKilometrageArrivee(int kilometrageArrivee) {
		this.kilometrageArrivee = kilometrageArrivee;
	}

	public Limousine getLimousine() {
		return limousine;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}


	//Affichage textuel de cet objet
	public String toString(){
		return "Le trajet entre " + this.villeDepart + " et " + this.villeArrivee +  " est de " + (this.kilometrageArrivee - this.kilometrageDepart)  + "km. Le trajet a été effectué par " + limousine.toString() + "\n" ;  }

}
