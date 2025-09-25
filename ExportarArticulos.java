import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ExportarArticulos {
    public void ExportarArticulos(Queue<ObjArticulo> cola) {
        if (cola.isEmpty()) {
            Metodos m1 = new Metodos();
            cola = m1.LlenarCola();
        }else {
            try (FileWriter escriba = new FileWriter("Inventario.txt")) {
                for (ObjArticulo o : cola) {
                    escriba.write("ID Articulo: " + o.getIdArticulo() + "\n");
                    escriba.write("Nombre: " + o.getNombre() + "\n");
                    escriba.write("Precio: " + o.getPrecio() + "\n");
                    escriba.write("-------------------------\n");
                }
                System.out.println("Archivo creado exitosamente.");
            }catch (IOException e) {
            e.printStackTrace();
            }
        }
    }
}
