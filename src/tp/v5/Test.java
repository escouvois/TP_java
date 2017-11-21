package tp.v5;

public class Test {

	public static void main(String[] args) {

		FileMutableImplParEtat<Integer> fileM = new FileMutableImplParEtat<>();
		
		fileM.ajouter(1);
		System.out.println(fileM);
	}

}
