package tp.v2;

import tp.v1.exceptions.EmptyQueueException;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Test {

	private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
	private static long diviseur = 100000;

	public static void main(String[] args) {
		testFileMut(1000000, 500000);
		testFileImmut(1000000, 500000);
	}

	private static void testListe(){
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

	private static void testFileMut(int ajout, int retrait){
		long temps = threadBean.getCurrentThreadCpuTime();
		FileMutableImpl fileMut = new FileMutableImpl();

		for(int i=1; i<=ajout; i++)
			fileMut.ajout(i);

		try {
			for(int i=1; i<=retrait; i++)
				fileMut.retrait();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}

		temps = threadBean.getCurrentThreadCpuTime() - temps;
		System.out.println(fileMut.getClass() + " - ajout/retrait: " + (temps / diviseur));
	}

	private static void testFileImmut(int ajout, int retrait){
		long temps = threadBean.getCurrentThreadCpuTime();
		FileImmutableImpl fileImmut = new FileImmutableImpl();

		for(int i=1; i<ajout; i++)
			fileImmut.ajout(i);

		try {
			for(int i=1; i<retrait; i++)
				fileImmut.retrait();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}

		temps = threadBean.getCurrentThreadCpuTime() - temps;
		System.out.println(fileImmut.getClass() + " - ajout/retrait: " + (temps / diviseur));
	}

}
