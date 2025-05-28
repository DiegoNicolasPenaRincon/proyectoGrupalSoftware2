package co.edu.uniquindio.alquiler.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarroCompra {
    private String id;
    private String codigo;
    private LocalDateTime fecha;
    private double impuesto;
    private double subtotal;
    private double total;
    private ArrayList<DetalleProducto> detallesProducto;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<DetalleProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(ArrayList<DetalleProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public CarroCompra(String id, String codigo, LocalDateTime fecha) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.impuesto = 0;
        this.subtotal = 0;
        this.total = 0;
        this.detallesProducto = new ArrayList<>();
    }
}
