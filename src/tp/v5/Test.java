package tp.v5;

public class Test {

	//Bastien casser
	public static void main(String[] args) {
		/*
		 * Cas d'une file immutable
		 */
		FileImmutableImplParEtat<Integer> fileIm = new FileImmutableImplParEtat<>();
		
		fileIm = (FileImmutableImplParEtat<Integer>) fileIm.creer(2);
		fileIm = (FileImmutableImplParEtat<Integer>) fileIm.ajout(3);
		fileIm = (FileImmutableImplParEtat<Integer>) fileIm.ajout(4);

		System.out.println(fileIm);
		
		fileIm = (FileImmutableImplParEtat<Integer>) fileIm.retrait();
		
		System.out.println(fileIm);
		
		/*
		 * Cas d'une file mutable
		 */
		FileMutableImplParEtat<Integer> fileM = new FileMutableImplParEtat<>();
		
		fileM.ajouter(1);
		fileM.ajouter(2);
		fileM.ajouter(3);
		//NE FONCTIONNE PAS
		//System.out.println(fileM);
		
		
	}

}
