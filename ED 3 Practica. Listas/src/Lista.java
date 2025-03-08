public class Lista {
    private Nodo inicio, fin;
    private int numElementos;

    // Inicializa una lista vacía (sin elementos)
    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.numElementos = 0;
    }

    // Determina si la lista está vacía o no (sin elementos)
    public boolean vacia() {
        return inicio == null;
    }

    // Añade un nuevo dato al final de la lista
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
    // Si la posición es incorrecta, devuelve false
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

    // Borra la primera ocurrencia del parámetro dato (si existe)
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

    // Devuelve la primera posición en la que se encuentra el parámetro dato (si existe)
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

    // Determina si el parámetro dato existe en la lista.
    public boolean contiene(Producto dato) {
        return this.posicion(dato) >= 0;
    }

    // Devuelve el número de elementos que tiene la lista
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
            System.out.println("Lista vacía");
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
