package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.exceptions.CarritoException;
import co.edu.uniquindio.alquiler.exceptions.SaldoException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CompraController {

    @FXML
    private TableView<DetalleProducto> carritoTable;
    @FXML
    private TableColumn<DetalleProducto,String> nombreCarritoColumn;
    @FXML
    private TableColumn<DetalleProducto,String>  codigoCarritoColumn;
    @FXML
    private Label elementosCarritoLbl;
    @FXML
    private Label precioTotalLbl;
    @FXML
    private Label precioTotalMostrarLbl;
    @FXML
    private Label saldoCiudadanoLabel;
    @FXML
    private Button comprarObjetosCarrito;
    @FXML
    private Label saldoLabel;
    @FXML
    private Button ventanaCarritoButton;
    @FXML
    private Spinner<Integer> cantidadSpinner;
    @FXML
    private Label cantidadLbl;
    @FXML
    private Label contadorElementosCarritoLbl;
    @FXML
    protected Button carrito;
    @FXML
    private ImageView carritoComprasImageView;
    @FXML
    private TableView<Producto> productosTable;
    @FXML
    private TableColumn<Producto,String> nombreColumn;
    @FXML
    private TableColumn<Producto,String> codigoColumn;
    @FXML
    private TableColumn<Producto,String> precioColumn;
    @FXML
    private TableColumn<Producto,String> unidadesColumn;
    @FXML
    private TableColumn<Producto,String> iGarantiaolumn;
    @FXML
    private TableColumn<Producto,String> fGarantiaColumn;
    @FXML
    private TableColumn<Producto,String> estadoColumn;
    @FXML
    private TableView<Categoria> categoriasTable;
    @FXML
    private TableColumn<Categoria,String> categoriaColumn;
    @FXML
    private Label descripcionLabel;
    @FXML
    private TextArea descripcionTxtArea;
    @FXML
    private Button agregarCarritoButton;

    public TiendaUQ tienda= TiendaUQ.getInstance();

    public DatosSesion datos=DatosSesion.getInstance();

    public void initialize() {
        descripcionTxtArea.setDisable(true);
        carrito=new Button("Click", carritoComprasImageView);


        nombreColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        codigoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCodigo()));
        precioColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getPrecio()) ) );
        unidadesColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getStock()) ) );
        iGarantiaolumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getGarantiaInicio())));
        fGarantiaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getGarantiaFin())));
        estadoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getEstado()) ) );

        nombreCarritoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombreProducto()));
        codigoCarritoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCodigoProducto()));

        productosTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            Producto producto=productosTable.getSelectionModel().getSelectedItem();
            if (newVal != null) {
                this.categoriasTable.setItems(FXCollections.observableList(producto.getCategorias()));
                this.descripcionTxtArea.setText(producto.getDescripcion());

                SpinnerValueFactory<Integer> valueFactory =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, producto.getStock(),1);
                cantidadSpinner.setValueFactory(valueFactory);

            }

        });
        saldoLabel.setText(""+datos.getCiudadanoSeleccionado().getSaldo());

        categoriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));

        this.productosTable.setItems(FXCollections.observableList(tienda.getListaProductos()));

        this.carritoTable.setItems(FXCollections.observableList(datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto()));
    }

    public void agregarCarritoOnAction(ActionEvent actionEvent) {
        Producto producto=productosTable.getSelectionModel().getSelectedItem();
        try
        {
            if(producto!=null)
            {
                String nombre=producto.getNombre();
                String codigo=producto.getCodigo();
                DetalleProducto detalle=tienda.verificarProductoYaAgregado(producto,datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto());
                if(detalle!=null)
                {
                    detalle.setCantidad(detalle.getCantidad()+cantidadSpinner.getValue());
                }
                else
                {
                    detalle=new DetalleProducto(tienda.validarIDDetalle(datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto()),cantidadSpinner.getValue(),producto.getPrecio(),0.16,producto.getPrecio(),nombre,codigo);
                }
                int cantidadActualCarrito= datos.getElementosAlmacenadosCarrito();
                datos.setElementosAlmacenadosCarrito(cantidadActualCarrito+cantidadSpinner.getValue());
                datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto().add(detalle);
                String elementosAlmacenadosCarrito=""+datos.getElementosAlmacenadosCarrito();
                producto.setStock(producto.getStock()-cantidadSpinner.getValue());
                datos.getCiudadanoSeleccionado().getCarrito().setTotal(datos.getCiudadanoSeleccionado().getCarrito().getTotal()+detalle.getSubtotal());
                if(datos.getElementosAlmacenadosCarrito()>99)
                {
                    contadorElementosCarritoLbl.setText("99+");
                }
                else
                {
                    contadorElementosCarritoLbl.setText(elementosAlmacenadosCarrito);
                }

                productosTable.refresh();
                carritoTable.refresh();

                precioTotalMostrarLbl.setText(""+Double.parseDouble(precioTotalMostrarLbl.getText())+datos.getCiudadanoSeleccionado().getCarrito().getTotal());
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar algun producto");
            }
        }
        catch(AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }


    public void comprarObjetosOnAction(ActionEvent actionEvent) {
        try
        {
            double costoTotal=0;
            CarroCompra carritoCiudadano=datos.getCiudadanoSeleccionado().getCarrito();
            if(!carritoCiudadano.getDetallesProducto().isEmpty())
            {
               for(int i=0;i<carritoCiudadano.getDetallesProducto().size();i++)
               {
                   costoTotal+=carritoCiudadano.getDetallesProducto().get(i).getSubtotal()*carritoCiudadano.getDetallesProducto().get(i).getCantidad();
                   System.out.println(costoTotal);
               }
               if(datos.getCiudadanoSeleccionado().getSaldo()<costoTotal)
               {
                   throw new SaldoException("No tiene el saldo suficiente para realizar esa compra");
               }
               else
               {
                   datos.getCiudadanoSeleccionado().setSaldo(datos.getCiudadanoSeleccionado().getSaldo()-costoTotal);
                   saldoLabel.setText(""+datos.getCiudadanoSeleccionado().getSaldo());
                   contadorElementosCarritoLbl.setText("0");
                   datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto().clear();
                   carritoTable.refresh();
                   productosTable.refresh();
                   datos.getCiudadanoSeleccionado().getCarrito().setTotal(0.0);
                   precioTotalMostrarLbl.setText("0.0");
               }

            }
            else
            {
                throw new CarritoException("Ingrese por lo menos un producto al carrito");
            }
        }
        catch (NullPointerException | SaldoException | CarritoException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
