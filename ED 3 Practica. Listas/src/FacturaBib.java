
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {

    private String dni;
    private String fecha;
    private ArrayList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        this.listaProductos = new ArrayList<>();
        cobrada = false;
    }

    public String getDni() {
        //Completar
        return this.dni;
    }

    public String getFecha() {
        //Completar
        return this.fecha;
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
        Iterator<Producto> iterador = this.listaProductos.iterator();
        boolean encontrado = false;

        while (iterador.hasNext() && !encontrado) {
            Producto p = iterador.next();
            if (p.equals(producto)) {
                p.setUnidades(p.getUnidades() + producto.getUnidades());
                encontrado = true;
            }
        }

        if (!encontrado) {
            this.listaProductos.add(producto);
        }
    }

    public void mostrar() {
        System.out.println("\nFACTURA DE: " + this.dni + ". Fecha: " + this.fecha);

        Iterator<Producto> iterador = this.listaProductos.iterator();
        while (iterador.hasNext()) {
            iterador.next().mostrar();
        }

        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        // Completar
        Iterator<Producto> iterador = this.listaProductos.iterator();
        float importeTotal = 0.0f;

        while(iterador.hasNext()){
            Producto p = iterador.next();
            importeTotal += (p.getUnidades() * p.getPrecio());
        }
        return importeTotal; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }


    public int eliminarProducto(Producto producto) {
        // Completar
        Iterator<Producto> iterador = this.listaProductos.iterator();
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
                    this.listaProductos.remove(p);
                    numEliminado = p.getUnidades();
                }
                encontrado = true;
            }
        }
        return numEliminado; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        // Completar
        LinkedList<Producto> listaMayoresPrecios = new LinkedList<>();
        Iterator<Producto> iterador = this.listaProductos.iterator();

        while(iterador.hasNext()){
            Producto p = iterador.next();
            if(p.getPrecio() > precio){
                listaMayoresPrecios.add(p);
            }
        }
        return listaMayoresPrecios; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }
}