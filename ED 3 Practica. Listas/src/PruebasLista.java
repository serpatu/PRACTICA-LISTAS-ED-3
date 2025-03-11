public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica

        Producto p1 = new Producto("Mesa escritorio", 185, 2);
        Producto p2 = new Producto("Silla oficina", 95.9F, 3);
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

        /* métodos anyadirProducto y mostrar */
        Factura f1 = new Factura("12345678B", "17/03/2021");
        f1.anyadirProducto(p1);
        f1.anyadirProducto(p2);
        f1.anyadirProducto(p3);
        f1.anyadirProducto(p4);

        f1.mostrar();

        Producto p5 = new Producto("Silla oficina", 95.9F, 1);

        f1.anyadirProducto(p5);
        f1.mostrar();

        /* método eliminar */

        Producto p6 = new Producto("Silla oficina", 95.9F, 2);
        Producto p7 = new Producto("Sillón reclinable", 230, 3);
        int unidadesEliminadas = 0;
        unidadesEliminadas += f1.eliminarProducto(p6);
        unidadesEliminadas += f1.eliminarProducto(p7);

        System.out.println("\nSe han eliminado " + unidadesEliminadas + " unidades");

        f1.mostrar();

        /* método mayoresPrecios */
        float precio = 100;
        Lista listaMayoresPrecios = f1.mayoresPrecios(precio);

        System.out.println("\nSe han obtenido "+ listaMayoresPrecios.getNumElementos() + " productos con precio " +
                "mayor a " + precio + " € por unidad");
        listaMayoresPrecios.mostrar();



    }
}
