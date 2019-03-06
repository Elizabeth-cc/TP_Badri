//travail fait par Benjamin Gelineau et Elizabeth Courtieu


package inf1004final;
import java.util.ArrayList;
public class Chauffeur {


	private String nom;
	private String prenom;
	private int anneeEmbauche;
	private String identification;
	private String adresse;
	private ArrayList<Trajet> trajets = new ArrayList<Trajet>();



	//constructeur
	Chauffeur(String prenom, String nom, int anneeEmbauche, String adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.anneeEmbauche = anneeEmbauche;
		this.adresse = adresse ;
		this.trajets = new ArrayList<Trajet>();
		this.identification = creerID(nom, prenom, anneeEmbauche);
	}

	//obtention des deux derniers chiffres de l<Annee

	private static String getLastDigits(int val){
		String tmp = String.valueOf(val);
		return tmp.substring(tmp.length()-2);
	}
	//Creation du ID a partir des informations du chauffeur
	public static String creerID(String nom, String prenom, int anneeEmbauche){
		String concat = Character.toString(nom.charAt(0)) +Character.toString(nom.charAt(1)) + Character.toString(nom.charAt(2))+ Character.toString(prenom.charAt(0)) + getLastDigits(anneeEmbauche);

		return concat;
	}




	//getters and setters

	public String getNom() {
		return nom;
	}
	public void ajouterTraj(Trajet trajet){
		this.trajets.add(trajet);
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAnneeEmbauche() {
		return anneeEmbauche;
	}

	public void setAnneeEmbauche(int anneeEmbauche) {
		this.anneeEmbauche = anneeEmbauche;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(ArrayList<Trajet> trajets) {
		this.trajets = trajets;
	}

	//Affichage textuel de cet objet
	public String toString(){
		return " Le chauffeur avec le ID :[" + this.identification + "] s'appelle " + this.prenom + " " + this.nom + " et habite au " + this.adresse + " et travaille pour l'entreprise depuis " + this.anneeEmbauche;
	}
}

