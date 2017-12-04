package tp.v6;

import correction.v5.ListeImmutable;

public class EtatFileImmutableAvecInversionParesseuseVide<E> implements EtatImmutableAvecInversionParesseuse<E> {

	@Override
	public EtatFileImmutable<E> creer(E dernier) {
		EtatFileImmutable<Miroir<E>> etatFileMiroirs = new EtatEnveloppeDeuxListesImmutables<Miroir<E>>();
		FileImmutable<Miroir<E>> fileMiroirs = new FileImmutableAvecEtatReifie<>(etatFileMiroirs).creer();
		return new EtatFileImmutableAvecInversionParesseuseNonVide(1, fileMiroirs, ListeImmutable.vide().creer(dernier),
				ListeImmutable.vide());
	}

	@Override
	public EtatFileImmutable<E> creer() {
		return new EtatFileImmutableAvecInversionParesseuseVide<>();
	}

}
