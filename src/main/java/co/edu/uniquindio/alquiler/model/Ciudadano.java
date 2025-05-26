package co.edu.uniquindio.alquiler.model;

import java.util.List;

public class Ciudadano {

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String fechaNacimiento;
    private List<CatalogoPreferencia> catalogoDePreferenciasComprasCarrito;
    private CarroCompra carrito;
}
