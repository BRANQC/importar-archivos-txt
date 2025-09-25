import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public Queue<ObjArticulo> LlenarCola() {
        Queue<ObjArticulo> c = new LinkedList<>();
        boolean bandera = true;
        int opt = 0;
        Metodos m = new Metodos();
        while (bandera) {
            ObjArticulo o = new ObjArticulo();
            o.setIdArticulo((int) (Math.random() * 1000 + 1));
            System.out.println("ingrese el nombre del articulo: ");
            o.setNombre(sc.nextLine());
            System.out.println("ingrese el precio del articulo: ");
            o.setPrecio(sc.nextDouble());
            sc.nextLine(); // Limpiar el buffer
            c.offer(o);

            System.out.println("desea agregar otro articulo? 1.si 2.no");
            opt = m.Validaropt(sc);
            sc.nextLine(); // Limpiar el buffer

            while (opt < 1 || opt > 2) {
                System.out.println("opcion no valida, ingrese nuevamente");
                opt = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                
            }
            if (opt == 2) {
                System.out.println("gracias por usar el programa");
                bandera = false;
            }
        }
        return c;
    }

    public void MostrarCola(Queue<ObjArticulo> c) {
        for (ObjArticulo o : c) {
            System.out.println("ID Articulo: " + o.getIdArticulo());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Precio: " + o.getPrecio());
            System.out.println("-------------------------");
        }
    }

    public int Validaropt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("opcion no valida, ingrese nuevamente");
            sc.next(); // Limpiar la entrada no válida
            
        }
        return sc.nextInt();
    }
}
