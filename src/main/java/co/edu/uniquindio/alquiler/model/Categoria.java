package co.edu.uniquindio.alquiler.model;

public class Categoria {
    private String id;
    private String nombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
}
