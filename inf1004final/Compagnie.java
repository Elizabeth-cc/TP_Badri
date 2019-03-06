//travail fait par Benjamin Gelineau et Elizabeth Courtieu

package inf1004final;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Compagnie {

	static Scanner scan = new Scanner(System.in);
	static int choix;
	static ArrayList<Chauffeur> chauffeurs = new ArrayList<Chauffeur>();
	static ArrayList<Trajet> trajets = new ArrayList<Trajet>();
	static ArrayList<Limousine> limousines = new ArrayList<Limousine>();

	// program
	public static void main(String[] args) throws TropDeChauffeursException, IOException {

		
		//données de TEST
		
		Chauffeur c1 = new Chauffeur("asdasd", "asdas", 5555, "asdasd");
		Chauffeur c2 = new Chauffeur("zxczxczxc", "zxczxc", 5555, "asdasd");
		Chauffeur c3 = new Chauffeur("hjkhjk", "hjkhjk", 5555, "asdasd");
		chauffeurs.add(c1);
		chauffeurs.add(c2);
		chauffeurs.add(c3);

		Limousine l1 = new Limousine("asda", 123, "asdasd");
		Limousine l2 = new Limousine("asda", 123, "asdasd");
		Limousine l3 = new Limousine("asda", 123, "asdasd");
		limousines.add(l1);
		limousines.add(l2);
		limousines.add(l3);
		Trajet t1 = new Trajet(c1, "asd", "asdas", 15, 16, l1);
		Trajet t2 = new Trajet(c2, "asd", "asdas", 15, 16, l2);
		Trajet t3 = new Trajet(c3, "asd", "asdas", 15, 16, l3);
		trajets.add(t1);
		trajets.add(t2);
		trajets.add(t3);

		
		//menu principal
		
		boolean arret = false;
		while (!arret) {
			System.out.println("----------------------Menu principal AutodeLuxe--------------------------");
			System.out.println("1.Ajouter des chauffeurs");
			System.out.println("2.Ajouter des limousines");
			System.out.println("3.Reserver une limousine(creer les trajets)");
			System.out.println("4.Consulter la liste de limousines conduites par le chauffeur");
			System.out.println("5.Afficher les caractéristiques des trajets et des limousines utilisées.");
			System.out.println("0. Quitter");
			// System.out.println("5.Afficher les caracteristiques des trajets et les
			// limousines utilisees");
			
			

			choix = -1;
			while(choix < 0 | choix > 5){
				try{
					choix = scan.nextInt();
					scan.nextLine();
				}
				catch(Exception e){
				choix = -1; 
				scan.nextLine();
				System.out.println("Selectionnez un nombre entre 0 et 5");
				choix = scan.nextInt();
				scan.nextLine();}
					switch (choix) {
					default:
						System.out.println("Selectionnez le choix approprié");
						break;
					case 1:
						ajouterChauffeur();
						break;
					case 2:
						ajouterLimousine();
						break;
					case 3:
						ajouterTrajet();
						break;
					case 4:	
						getLimousinesParChauffeur();         // cette fonction ne fonctionne pas. SVP arranger
						break;
					case 5:
						for (int i = 0; i < trajets.size(); i++) {
							System.out.println(trajets.get(i));}
						break;
					case 0:
						arret = true;
						break;
					}
				}
			}

		scan.close();
		}

	// Ajouter un chauffeur dans la liste
	public static void ajouterChauffeur() throws TropDeChauffeursException {
		if (chauffeurs.size() >= 10) {
			throw new TropDeChauffeursException();
		} else {
			boolean boucle = true;
			String[] donnees;
			Chauffeur chauffeur1;
			System.out.println("Entrez votre liste de chauffeurs");
			System.out.println("Entrez les dans le format suivant : ");
			System.out.println(" NomFamille\t Prenom\t  anneeEmbauche\t adresse ");
			while (boucle) {
				String str = scan.nextLine();
				if (str.equals(""))
					boucle = false;
				else {
					donnees = str.split("\t", 4);
					// String idChauffeur = Chauffeur.creerID(donnees[0], donnees[1],
					// Integer.parseInt(donnees[2]));
					chauffeur1 = new Chauffeur(donnees[0], donnees[1], Integer.parseInt(donnees[2]), donnees[3]);
					chauffeurs.add(chauffeur1);
				}
			}
			for (int i = 0; i < chauffeurs.size(); i++) {
				System.out.println(chauffeurs.get(i));
			}
		}
	}

	// Ajouter une Limousine dans la liste
	public static void ajouterLimousine() {
		boolean boucle = true;
		String[] donnees;
		Limousine limousine1;
		System.out.println("Entrez votre liste de limousines");
		System.out.println("Entrez les dans le format suivant : ");
		System.out.println(" NoPlaque\t CapacitéReservoir\t  Couleur\t ");
		while (boucle) {
			String str = scan.nextLine();
			if (str.equals(""))
				boucle = false;
			else {
				donnees = str.split("\t", 3);
				limousine1 = new Limousine(donnees[0], Integer.parseInt(donnees[1]), donnees[2]); // enleve du trajet
				limousines.add(limousine1);
			}
		}
		for (int i = 0; i < limousines.size(); i++) {
			System.out.println(limousines.get(i));
		}
	}

	// Ajouter un trajet dans la liste
	public static void ajouterTrajet() {
		boolean boucle = true;
		String[] donnees;
		Trajet trajet1;
		System.out.println("Entrez la liste des Trajets");
		System.out.println("Entrez les dans le format suivant : ");
		System.out.println(" CodeEmployé\t VilleDepart\t  VilleArrivee\t KilometrageDebut\t kilometrageFin\t NumeroPlaqueLimousine ");
		while (boucle) {
			String str = scan.nextLine();
			if (str.equals(""))
				boucle = false;
			else {
				donnees = str.split("\t", 6);
				getLimousineParID(donnees[5]);
				trajet1 = new Trajet(getChauffeurParID(donnees[0]), donnees[1], donnees[2],
						Integer.parseInt(donnees[3]), Integer.parseInt(donnees[4]), getLimousineParID(donnees[5]));
				trajets.add(trajet1);

			}
		}
		for (int i = 0; i < trajets.size(); i++) {
			System.out.println(trajets.get(i));
		}
	}

	// Retourne une limousine par sa plaque
	public static Limousine getLimousineParID(String immatriculation) {

		for (int i = 0; i < limousines.size(); i++) {
			if (limousines.get(i).getImmatriculation().equalsIgnoreCase(immatriculation)) {
				return limousines.get(i);
			}

		}
		return null;
	}

	// Retourne un conducteur en le recherchant par son code
	public static Chauffeur getChauffeurParID(String identification) {

		for (int i = 0; i < chauffeurs.size(); i++) {
			if (chauffeurs.get(i).getIdentification().equalsIgnoreCase(identification)) {
				return chauffeurs.get(i);
			}
		}
		return null;
	}

	// Retourne la liste des limousines associées à un conducteur
	public static String getLimousinesParChauffeur() {
		System.out.println("entrez l'identifiant du chauffeur");
		for (int i = 0; i < chauffeurs.size(); i++) {
			System.out.println(chauffeurs.get(i).getIdentification());

		}
		String limousines = "";

		String input = scan.nextLine();

		for (Chauffeur chauffeur : chauffeurs) {
			if (chauffeur.getIdentification().equalsIgnoreCase(input)) {
				for (Trajet trajet1 : chauffeur.getTrajets()) {
					limousines += trajet1.toString() + "\n";
				}
			}
		}
		return limousines;
	}

	// Liste des assenceurs disponibles au publique

	public static ArrayList<Limousine> getLimousines() {
		return limousines;
	}

	public ArrayList<Chauffeur> getChauffeurs() {
		return chauffeurs;
	}

	public static ArrayList<Trajet> getTrajets() {
		return trajets;
	}

}
