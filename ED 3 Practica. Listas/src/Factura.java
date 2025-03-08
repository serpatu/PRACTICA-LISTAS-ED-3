
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

    public String getDNI() {
        return "";
        // Completar;
    }

    public String getFecha() {
        return "";

        // Completar;
    }

    public boolean estaCobrada() {
        // Completar;
        return false;
    }

    public void cobrada() {

        // Completar;
    }

    public void anyadirProducto(Producto producto) {

        // Completar
    }

    public void mostrar() {
        // Completar
    }

    public float importeTotal() {
        // Completar
        return 0.0f; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

    public int eliminarProducto(Producto producto) {
        // Completar
        return 0; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }

    public Lista mayoresPrecios(float precio) {
        // Completar
        return null; // Línea puesta para evitar error. Eliminarla al codificar el metodo
    }
}
