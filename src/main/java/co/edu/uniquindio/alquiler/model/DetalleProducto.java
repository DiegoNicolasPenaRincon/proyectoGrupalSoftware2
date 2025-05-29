package co.edu.uniquindio.alquiler.model;

import javafx.fxml.FXML;

public class DetalleProducto {

    private String id;
    private int cantidad;
    private double monto;
    private double impuesto;
    private double subtotal;
    private String nombreProducto;
    private String codigoProducto;

    public DetalleProducto(String id, int cantidad, double monto, double impuesto, double subtotal,String nombreProducto,String codigoProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.monto = monto;
        this.impuesto = impuesto;
        this.subtotal = subtotal;
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override

    public String toString() {
        return nombreProducto+" "+codigoProducto;
    }
}
