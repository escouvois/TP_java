package tp.v2;

public class Test {
	public static void main(String[] args) {
		ListeMutable<Integer> vide = ListeMutable.vide();
		System.out.println(vide.taille());
		System.out.println(vide.casCons());
		System.out.println(vide.casVide());
		System.out.println(vide.miroir());
		
		Integer un = 1;
		
		ListeMutable<Integer> liste = ListeMutable.cons(un, vide);
		System.out.println(liste);
	}
}
