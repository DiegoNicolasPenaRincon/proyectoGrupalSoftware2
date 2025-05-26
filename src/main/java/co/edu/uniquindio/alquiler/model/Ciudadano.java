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
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<CatalogoPreferencia> getCatalogoDePreferenciasComprasCarrito() {
        return catalogoDePreferenciasComprasCarrito;
    }

    public void setCatalogoDePreferenciasComprasCarrito(List<CatalogoPreferencia> catalogoDePreferenciasComprasCarrito) {
        this.catalogoDePreferenciasComprasCarrito = catalogoDePreferenciasComprasCarrito;
    }

    public CarroCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarroCompra carrito) {
        this.carrito = carrito;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
