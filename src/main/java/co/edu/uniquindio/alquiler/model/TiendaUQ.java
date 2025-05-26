package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class TiendaUQ {


    private ArrayList<Ciudadano> listaCiudadanos;
    private ArrayList<Producto> listaProductos;
    private static TiendaUQ tienda;

    private TiendaUQ(){
        this.listaCiudadanos = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    public static TiendaUQ getInstance(){
        if(tienda == null){
            tienda = new TiendaUQ();
        }

        return tienda;
    }

    public ArrayList<Ciudadano> getListaCiudadanos() {
        return listaCiudadanos;
    }

    public void setListaCiudadanos(ArrayList<Ciudadano> listaCiudadanos) {
        this.listaCiudadanos = listaCiudadanos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
