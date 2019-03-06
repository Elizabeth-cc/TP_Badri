//travail fait par Benjamin Gelineau et Elizabeth Courtieu

package inf1004final;

public class TropDeChauffeursException extends Exception{



	private static final long serialVersionUID = 1L;

	public TropDeChauffeursException() {
		super("La compagnie ne peut avoir seulement 10 chauffeurs");
	}

}


