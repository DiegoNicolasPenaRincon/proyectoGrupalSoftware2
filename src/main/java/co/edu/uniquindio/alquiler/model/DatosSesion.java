package co.edu.uniquindio.alquiler.model;

public class DatosSesion {

    Ciudadano ciudadanoSeleccionado;
    int elementosAlmacenadosCarrito;
    private static DatosSesion datos;

    private DatosSesion() {
    }

    public static DatosSesion getInstance() {
        if (datos == null) {
            datos = new DatosSesion();
        }

        return datos;
    }

    public Ciudadano getCiudadanoSeleccionado() {
        return ciudadanoSeleccionado;
    }

    public void setCiudadanoSeleccionado(Ciudadano ciudadanoSeleccionado) {
        this.ciudadanoSeleccionado = ciudadanoSeleccionado;
    }

    public static DatosSesion getDatos() {
        return datos;
    }

    public static void setDatos(DatosSesion datos) {
        DatosSesion.datos = datos;
    }

    public int getElementosAlmacenadosCarrito() {
        return elementosAlmacenadosCarrito;
    }

    public void setElementosAlmacenadosCarrito(int elementosAlmacenadosCarrito) {
        this.elementosAlmacenadosCarrito = elementosAlmacenadosCarrito;
    }
}
