public class EliminarArchivo {
    public void EliminarArchivo(String nombreArchivo) {
        java.io.File archivo = new java.io.File(nombreArchivo + ".txt");
        if (archivo.delete()) {
            System.out.println("El archivo " + nombreArchivo + ".txt ha sido eliminado.");
        } else {
            System.out.println("No se pudo eliminar el archivo " + nombreArchivo + ".txt. Puede que no exista.");
        }
    }
}
