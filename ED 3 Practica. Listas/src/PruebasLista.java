public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica

        Producto p1 = new Producto("Mesa escritorio", 185, 2);
        Producto p2 = new Producto("Silla oficina", 95.0F, 3);
        Producto p3 = new Producto("Mesa cocina", 125, 1);
        Producto p4 = new Producto("Sillón reclinable", 230, 2);

        Lista listaProductos = new Lista();

        listaProductos.insertar(p1);
        listaProductos.insertar(p2);
        listaProductos.insertar(p3);
        listaProductos.insertar(p4);

        listaProductos.mostrar();

        listaProductos.borrar(p2);

        listaProductos.mostrar();

    }
}
