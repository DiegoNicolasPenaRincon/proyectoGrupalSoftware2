package co.edu.uniquindio.alquiler.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CarroCompra {
    private String id;
    private String codigo;
    private LocalDateTime fecha;
    private String estado;
    private String observaciones;
    private String descripcion;
    private double impuesto;
    private double subtotal;
    private double total;
    private List<DetalleProducto> detallesProducto;
}
