import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Queue<ObjArticulo> cola = new LinkedList<>();
        Metodos m = new Metodos();
        Scanner sc = new Scanner(System.in);
        ExportarArticulos ea = new ExportarArticulos();
        ImportarArticulos ia = new ImportarArticulos();
        EliminarArchivo el = new EliminarArchivo();
        boolean bandera = true;
        int opt = 0;
        while (bandera) {

        System.out.println("bienvenido al menu de articulos");
        System.out.println("1. llenar cola de articulos");
        System.out.println("2. mostrar cola de articulos");
        System.out.println("3. exportar cola de articulos a un archivo txt");
        System.out.println("4. importar cola de articulos desde un archivo txt");
        System.out.println("5. eliminar archivo txt");
        System.out.println("6. salir del programa");
        System.out.println("ingrese una opcion: ");
        opt = m.Validaropt(sc);
        sc.nextLine(); // Limpiar el buffer

        while(opt < 1 || opt > 6) {
            System.out.println("opcion no valida, ingrese nuevamente");
            opt = m.Validaropt(sc);
            sc.nextLine(); // Limpiar el buffer después de cada validación
        }
        switch (opt) {
            case 1:
                cola = m.LlenarCola();
                break;
            case 2:
                m.MostrarCola(cola);
                break;
            case 3:
                ea.ExportarArticulos(cola);
                break;
            case 4:
                System.out.println("ingrese el nombre del archivo (sin .txt): ");
                String nombreArchivo = sc.nextLine();
                cola = ia.LeerArchivo(nombreArchivo);
                break;
            case 5:
                System.out.println("ingrese el nombre del archivo a eliminar (sin .txt): ");
                String archivoEliminar = sc.nextLine();
                el.EliminarArchivo(archivoEliminar);
                break;
            default:
                System.out.println("gracias por usar el programa");
                bandera = false;
                break;
        }
        }
    }
}
