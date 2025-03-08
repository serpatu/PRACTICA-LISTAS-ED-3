public class Lista {
    private Nodo inicio, fin;
    private int numElementos;

    // Inicializa una lista vac�a (sin elementos)
    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.numElementos = 0;
    }

    // Determina si la lista est� vac�a o no (sin elementos)
    public boolean vacia() {
        return inicio == null;
    }

    // A�ade un nuevo dato al final de la lista
    public void insertar(Producto dato) {
        Nodo nuevo = new Nodo(dato, null);  // Crear un nodo nuevo
        if (inicio == null) {  // Insertar el nodo al final de la lista enlazada
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }

    public Producto getElemento(int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return null;
        } else {
            Nodo actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            return actual.getDato();
        }
    }


    // Almacena elemento en la posicion indicada por posicion
    // Si la posici�n es incorrecta, devuelve false
    public boolean setElemento(Producto dato, int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return false;
        } else {
            Nodo actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            actual.setDato(dato);
            return true;
        }
    }

    // Borra la primera ocurrencia del par�metro dato (si existe)
    public boolean borrar(Producto dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            if (actual == inicio) {
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            if (actual == fin) {
                fin = anterior;
            }
            numElementos--;
            return true;
        } else {
            return false;
        }
    }

    // Devuelve la primera posici�n en la que se encuentra el par�metro dato (si existe)
    public int posicion(Producto dato) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null && !actual.getDato().equals(dato)) {
            actual = actual.getSiguiente();
            posicion++;
        }
        if (actual != null) {  // Dato encontrado
            return posicion;
        } else {
            return -1;
        }
    }

    // Determina si el par�metro dato existe en la lista.
    public boolean contiene(Producto dato) {
        return this.posicion(dato) >= 0;
    }

    // Devuelve el n�mero de elementos que tiene la lista
    public int getNumElementos() {
        return numElementos;
    }

    // Devuelve un iterador para recorrer la lista desde el principio
    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    // Muestra el contenido de la lista.
    public void mostrar() {
        if (this.vacia()) {
            System.out.println("Lista vac�a");
        } else {
            Nodo actual = inicio;
            while (actual != null) {
                actual.getDato().mostrar();
                actual = actual.getSiguiente();
            }
            System.out.println();
        }
    }

}
