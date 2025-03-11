
public class Factura {
    private String dni;
    private String fecha;
    private Lista listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new Lista();
        cobrada = false;
    }

    public String getDni() {
        //Completar
        return dni;
    }

    public String getFecha() {
        //Completar
        return fecha;
    }

    public boolean estaCobrada() {
        // Completar;
        return this.cobrada;
    }

    public void cobrada() {
        // Completar;
        this.cobrada = true;
    }

    public void anyadirProducto(Producto producto) {
        //completar
        Iterador iterador = this.listaProductos.getIterador();
        boolean encontrado = false;

        while (iterador.hasNext() && !encontrado) {
            Producto p = iterador.next();
            if (p.equals(producto)) {
                p.setUnidades(p.getUnidades() + producto.getUnidades());
                encontrado = true;
            }
        }

        if (!encontrado) {
            this.listaProductos.insertar(producto);
        }
    }


    public void mostrar() {
        // Completar

        System.out.println("\nFACTURA DE: " + this.dni + ". " + "Fecha:" + this.fecha);
        for (int i = 0; i < this.listaProductos.getNumElementos(); i++) {
            this.listaProductos.getElemento(i).mostrar();
        }

        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");

    }

    public float importeTotal() {
        // Completar
        Iterador iterador = this.listaProductos.getIterador();
        float importeTotal = 0.0f;

        while(iterador.hasNext()){
            Producto p = iterador.next();
            importeTotal += (p.getUnidades() * p.getPrecio());
        }
        return importeTotal; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

    public int eliminarProducto(Producto producto) {
        // Completar
        Iterador iterador = this.listaProductos.getIterador();
        boolean encontrado = false;
        int numEliminado = 0;

        while(iterador.hasNext() && !encontrado){
            Producto p = iterador.next();
            if(p.equals(producto)){
                if(p.getUnidades() > producto.getUnidades()){
                    p.setUnidades(p.getUnidades() - producto.getUnidades());
                    numEliminado = producto.getUnidades();
                }
                else{
                    this.listaProductos.borrar(p);
                    numEliminado = p.getUnidades();
                }
                encontrado = true;
            }
        }
        return numEliminado; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

    public Lista mayoresPrecios(float precio) {
        // Completar
        Lista listaMayoresPrecios = new Lista();
        Iterador iterador = this.listaProductos.getIterador();

        while(iterador.hasNext()){
            Producto p = iterador.next();
            if(p.getPrecio() > precio){
                listaMayoresPrecios.insertar(p);
            }
        }
        return listaMayoresPrecios; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

}
