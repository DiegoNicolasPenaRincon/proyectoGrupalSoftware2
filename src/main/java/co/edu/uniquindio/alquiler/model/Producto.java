package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoProducto;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String id;
    private String codigo;
    private String nombre;
    private List<Categoria> categorias;
    private String descripcion;
    private double precio;
    private int stock;
    private ArrayList<String> caracteristicas;
    private boolean garantia;
    private EstadoProducto estado;
    private List<DetalleProducto> detallesProducto;
}
