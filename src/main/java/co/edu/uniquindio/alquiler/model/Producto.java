package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoProducto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private ArrayList<Categoria> categorias;
    private LocalDateTime garantiaInicio;
    private LocalDateTime garantiaFin;
    private EstadoProducto estado;
    private List<DetalleProducto> detallesProducto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public LocalDateTime getGarantiaInicio() {
        return garantiaInicio;
    }

    public void setGarantiaInicio(LocalDateTime garantiaInicio) {
        this.garantiaInicio = garantiaInicio;
    }

    public LocalDateTime getGarantiaFin() {
        return garantiaFin;
    }

    public void setGarantiaFin(LocalDateTime garantiaFin) {
        this.garantiaFin = garantiaFin;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public List<DetalleProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetalleProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Producto(String id, String codigo, String nombre, String descripcion, double precio, int stock, LocalDateTime garantiaInicio, LocalDateTime garantiaFin, EstadoProducto estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categorias = new ArrayList<>();
        this.garantiaInicio = garantiaInicio;
        this.garantiaFin = garantiaFin;
        this.estado = estado;
        this.detallesProducto = new ArrayList<>();
    }
}
