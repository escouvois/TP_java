package filesibro;


public class Element<E> {

    private E item;
    private Element next;


    public Element(E item){
        this.item = item;
        this.next = null;
    }

    public Element(E item, Element next){
        this.item = item;
        this.next = next;
    }

    public E getItem(){
        return item;
    }

    public Element getNext(){
        return next;
    }
}
