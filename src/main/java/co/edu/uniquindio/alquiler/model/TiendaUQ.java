package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.EstadoProducto;
import co.edu.uniquindio.alquiler.exceptions.ContraseniaException;
import co.edu.uniquindio.alquiler.exceptions.CorreoInvalidoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TiendaUQ {


    private ArrayList<Ciudadano> listaCiudadanos;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Categoria> listaCategorias;
    private static TiendaUQ tienda;

    private TiendaUQ(){
        this.listaCiudadanos = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaCategorias=new ArrayList<>();

        quemarDatos();
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

    public void quemarDatos() {

        // Categorías
        Categoria cat1 = new Categoria("Electrónica", "C1");
        Categoria cat2 = new Categoria("Hogar", "C2");
        Categoria cat3 = new Categoria("Ropa", "C3");
        Categoria cat4 = new Categoria("Deportes", "C4");
        listaCategorias.add(cat2);
        listaCategorias.add(cat3);
        listaCategorias.add(cat4);
        listaCategorias.add(cat1);

        //CarroCompra
        CarroCompra carro1=new CarroCompra("1", "CC001", LocalDateTime.now());
        CarroCompra carro2=new CarroCompra("2", "CC002", LocalDateTime.now().minusDays(1));
        CarroCompra carro3=new CarroCompra("3", "CC003", LocalDateTime.now().minusDays(2));
        CarroCompra carro4=new CarroCompra("4", "CC004", LocalDateTime.now().minusHours(3));


        // Ciudadanos
        Ciudadano ciu1 = new Ciudadano("Juan", "Pérez", "123456789", "Calle A 123", "marcela.aboncec@uqvirtual.edu.co", "1990-01-01", "pass123",carro1);
        Ciudadano ciu2 = new Ciudadano("Lucía", "Gómez", "987654321", "Calle B 456", "lucia@example.com", "1985-06-15", "clave456",carro2);
        Ciudadano ciu3 = new Ciudadano("Carlos", "Ramírez", "555666777", "Calle C 789", "hola", "1992-03-10", "secreto789",carro3);
        Ciudadano ciu4 = new Ciudadano("María", "López", "222333444", "Calle D 321", "maria@example.com", "1998-12-20", "contrasena321",carro4);

        listaCiudadanos.add(ciu1);
        listaCiudadanos.add(ciu2);
        listaCiudadanos.add(ciu3);
        listaCiudadanos.add(ciu4);

        // Productos
        Producto prod1 = new Producto("P1", "ELEC123", "Televisor 4K", "Pantalla Ultra HD 55 pulgadas", 799.99, 10,LocalDateTime.parse("2025-05-26T14:30:00"),LocalDateTime.parse("2025-05-27T14:30:00") ,EstadoProducto.NUEVO);
        prod1.getCategorias().add(cat1);
        prod1.getCategorias().add(cat2);

        Producto prod2 = new Producto("P2", "HOG456", "Licuadora", "Licuadora de acero inoxidable", 89.99, 99,LocalDateTime.parse("2024-10-26T14:30:00"),LocalDateTime.parse("2026-10-26T14:30:00") ,EstadoProducto.USADO );
        prod2.getCategorias().add(cat1);
        prod2.getCategorias().add(cat2);

        Producto prod3 = new Producto("P3", "ROP789", "Chaqueta impermeable", "Resistente al agua y al viento", 59.90, 15,LocalDateTime.parse("2024-10-26T14:30:00"),LocalDateTime.parse("2026-10-26T14:30:00") ,EstadoProducto.USADO);
        prod3.getCategorias().add(cat2);
        prod3.getCategorias().add(cat3);
        Producto prod4 = new Producto("P4", "DEP012", "Bicicleta de montaña", "Bicicleta con 21 velocidades", 299.50, 5, LocalDateTime.parse("2024-10-26T14:30:00"),LocalDateTime.parse("2026-10-26T14:30:00") ,EstadoProducto.USADO );
        prod4.getCategorias().add(cat2);
        prod4.getCategorias().add(cat3);

        listaProductos.add(prod1);
        listaProductos.add(prod2);
        listaProductos.add(prod3);
        listaProductos.add(prod4);
    }

    public String validarIDDetalle(ArrayList<DetalleProducto> detallesCarrito) {
        boolean seguir=true;
        int aleatorio=0;
        int contador;
        while(seguir)
        {
            aleatorio = (int)(Math.random() * 900) + 1;
            contador=0;
            for(int i=0;i<detallesCarrito.size();i++)
            {
                if (detallesCarrito.get(i).getId().equals("" + aleatorio))
                {
                    contador++;
                }
            }

            if(contador==0)
            {
                seguir=false;
            }
        }

        return ""+aleatorio;



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
