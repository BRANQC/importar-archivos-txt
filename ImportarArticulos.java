import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ImportarArticulos {
    public Queue<ObjArticulo> LeerArchivo(String nombreArchivo) {
        String rutaArticulo = nombreArchivo + ".txt";
        Queue<ObjArticulo> cola = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArticulo))) {
            String line;
            ObjArticulo o = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("ID Articulo: ")) {
                    if (o != null) {
                        cola.add(o);
                    }
                    o = new ObjArticulo();
                    o.setIdArticulo(Integer.parseInt(line.substring(13)));
                }else if (line.startsWith("Nombre: ")) {
                    if (o != null) {
                        o.setNombre(line.substring(8));
                    }
                } else if (line.startsWith("Precio: ")) {
                    if (o != null) {
                        o.setPrecio(Double.parseDouble(line.substring(8)));
                        cola.add(o);
                        o = null; // Reiniciar para el siguiente artículo
                    }
                }
            }
            System.out.println("Archivo importado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cola;
    }
}
