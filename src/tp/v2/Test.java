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
		liste = liste.miroir();
		liste = ListeMutable.cons(3, liste);
		liste = liste.miroir();
		System.out.println(liste);
		
		liste = liste.miroir();
		liste = ListeMutable.cons(4, liste);
		liste = liste.miroir();
		System.out.println(liste);
		
		liste = liste.miroir();
		liste = ListeMutable.cons(5, liste);
		liste = liste.miroir();
		System.out.println(liste);
		
		liste.changerTete(6);
		System.out.println(liste);
		
		ListeMutable<Integer> listeReste = ListeMutable.cons(7, ListeMutable.cons(8, vide));
		System.out.println(listeReste);
		liste.changerReste(listeReste);
		System.out.println(liste);
		
		System.out.println(liste.miroir());
	}
}
