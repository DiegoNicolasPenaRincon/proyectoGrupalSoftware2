package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.exceptions.ContraseniaException;
import co.edu.uniquindio.alquiler.exceptions.CorreoInvalidoException;

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

    public Ciudadano verificarUsuario(String correo,String contrasenia) throws ContraseniaException {
        for(int i=0;i<listaCiudadanos.size();i++)
        {
            if(listaCiudadanos.get(i).getEmail().equals(correo))
            {
               if(!listaCiudadanos.get(i).getContrasenia().equals(contrasenia))
               {
                   throw  new ContraseniaException("La contraseña es invalida");
               }
               return listaCiudadanos.get(i);
            }
        }
        return null;
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
