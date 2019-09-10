package ejgeant;


public class Nodo<T> implements INodo {

    private final Comparable etiqueta;
    private final T dato;
    private Nodo<T> siguiente = null;

    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + " " + dato.toString());
    }

//    @Override
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public Nodo<T> clonar() {
        return new Nodo<>(this.dato, this.etiqueta);
    }


    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
