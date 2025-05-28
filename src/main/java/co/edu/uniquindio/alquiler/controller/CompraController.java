package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class CompraController {

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

    int elementosEnCarrito=0;

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


        categoriaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));

        this.productosTable.setItems(FXCollections.observableList(tienda.getListaProductos()));
    }

    public void agregarCarritoOnAction(ActionEvent actionEvent) {
        Producto producto=productosTable.getSelectionModel().getSelectedItem();
        try
        {
            if(producto!=null)
            {
                DetalleProducto detalle=new DetalleProducto(tienda.validarIDDetalle(datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto()),cantidadSpinner.getValue(),producto.getPrecio(),0.16,0.16* producto.getPrecio());
                int cantidadActualCarrito= datos.getElementosAlmacenadosCarrito();
                datos.setElementosAlmacenadosCarrito(cantidadActualCarrito+cantidadSpinner.getValue());
                datos.getCiudadanoSeleccionado().getCarrito().getDetallesProducto().add(detalle);
                String elementosAlmacenadosCarrito=""+datos.getElementosAlmacenadosCarrito();
                if(datos.getElementosAlmacenadosCarrito()>99)
                {
                    contadorElementosCarritoLbl.setText("99+");
                }
                else
                {
                    contadorElementosCarritoLbl.setText(elementosAlmacenadosCarrito);
                }
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

    public void abrirVentanaCarrito(ActionEvent actionEvent) {
    }
}
