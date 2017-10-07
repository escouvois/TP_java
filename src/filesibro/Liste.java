package filesibro;


public class Liste<E> implements File<E> {

    private Element tete;
    private Element queue;

    public Liste(E tete){
        this.tete = (Element)tete;
        this.queue = this.tete;
    }

    public Liste(E tete, Element queue){
        this.tete = (Element)tete;
        this.queue = queue;
    }

    @Override
    public void retirerTete() {
        if(!estVide())
            this.tete = tete.getNext();
    }

    @Override
    public void insererQueue(E e) {
        if(!estVide()){
            queue = new Element(queue, (Element)e);
            Element newQueue = new Element(e, null);
            queue = newQueue;
        } else
            tete = new Element(e);
    }

    @Override
    public int longueur() {
        int i = 0;

        if (tete != null) {
            i++;
            while (tete.getNext() != null)
                i++;
        }
        return i;
    }

    @Override
    public boolean estVide() {
        return tete == null;
    }
}
