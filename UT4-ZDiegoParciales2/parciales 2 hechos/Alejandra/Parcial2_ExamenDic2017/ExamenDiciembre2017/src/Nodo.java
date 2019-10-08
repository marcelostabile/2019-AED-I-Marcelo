public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato) {
        this.dato = dato;
        this.etiqueta = etiqueta;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
        public void imprimir() {
        System.out.println(dato.toString());
    }


    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta,this.dato);
    }


    @Override
    public boolean equals(Nodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    
    public void setSiguiente(Nodo<T> nodo) {
         this.siguiente = nodo;
    }

  

}
