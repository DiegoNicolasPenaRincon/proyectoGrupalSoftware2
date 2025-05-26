package co.edu.uniquindio.alquiler.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CatalogoPreferencia {

    private String id;
    private String coodigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private LocalDateTime fecha;
    private List<Producto> productosRecomendados;
}
