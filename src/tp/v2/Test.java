package tp.v2;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("Liste");
		System.out.println("---------------------------------");
		ListeMutable<Integer> vide = ListeMutable.vide();
		System.out.println(vide.taille());
		System.out.println(vide.casCons());
		System.out.println(vide.casVide());
		System.out.println(vide.miroir());
		
		
		System.out.println("Liste Mutable");
		System.out.println("---------------------------------");
		Integer un = 1;
		
		ListeMutable<Integer> liste = ListeMutable.cons(un, vide);
		System.out.println(liste);
		liste.changerReste(ListeMutable.cons(3, liste.reste()));
		System.out.println(liste);
		liste.changerReste(ListeMutable.cons(4, liste.reste()));
		System.out.println(liste);
		liste = liste.miroir();
		System.out.println(liste);
	}
}
