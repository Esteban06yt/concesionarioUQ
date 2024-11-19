package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'ClienteView.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.TransaccionController;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Venta;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClienteViewController {
    Cliente cliente;
    App app;
    TransaccionController transaccionontroller;
    ObservableList<Transaccion> listatransacciones = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="columnFecha"
    private TableColumn<Transaccion, String> columnFecha; // Value injected by FXMLLoader

    @FXML // fx:id="columnPrecioTotal"
    private TableColumn<Transaccion, String> columnPrecioTotal; // Value injected by FXMLLoader

    @FXML // fx:id="columnGarantia"
    private TableColumn<Transaccion, String> columnGarantia; // Value injected by FXMLLoader

    @FXML // fx:id="columnFechaDevolucion"
    private TableColumn<Transaccion, String> columnFechaDevolucion; // Value injected by FXMLLoader

    @FXML // fx:id="columnDuracionAlquiler"
    private TableColumn<Transaccion, String> columnDuracionAlquiler; // Value injected by FXMLLoader

    @FXML // fx:id="columnVehiculo"
    private TableColumn<Transaccion, String> columnVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="columnNombreEmpleado"
    private TableColumn<Transaccion, String> columnNombreEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="columnMetodoDePago"
    private TableColumn<Transaccion, String> columnMetodoDePago; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesion1"
    private Button btnCerrarSesion1; // Value injected by FXMLLoader

    @FXML // fx:id="tableClienteReservas"
    private TableView<Transaccion> tableClienteReservas; // Value injected by FXMLLoader

    @FXML // fx:id="columnIDTransaccion"
    private TableColumn<Transaccion, String> columnIDTransaccion; // Value injected by FXMLLoader

    @FXML
    void cerrarSesion(ActionEvent event) {
        app.openViewPrincipal();
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert columnFecha != null : "fx:id=\"columnFecha\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnPrecioTotal != null
                : "fx:id=\"columnPrecioTotal\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnGarantia != null
                : "fx:id=\"columnGarantia\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnFechaDevolucion != null
                : "fx:id=\"columnFechaDevolucion\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnDuracionAlquiler != null
                : "fx:id=\"columnDuracionAlquiler\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnVehiculo != null
                : "fx:id=\"columnVehiculo\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnNombreEmpleado != null
                : "fx:id=\"columnNombreEmpleado\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnMetodoDePago != null
                : "fx:id=\"columnMetodoDePago\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert btnCerrarSesion1 != null
                : "fx:id=\"btnCerrarSesion1\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert tableClienteReservas != null
                : "fx:id=\"tableClienteReservas\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert columnIDTransaccion != null
                : "fx:id=\"columnIDTransaccion\" was not injected: check your FXML file 'ClienteView.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
        transaccionontroller = new TransaccionController(app.getConcesionario());

    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        initView();// Inicia la información de la tabla
    }

    private void initView() {
        initDataBinding();
        ObtenerTransacciones();
        tableClienteReservas.getItems().clear();
        tableClienteReservas.setItems(listatransacciones);
        }

    public void ObtenerTransacciones(){
        listatransacciones.addAll(transaccionontroller.ObtenerTransaccionesCliente(cliente));
    }

    private void initDataBinding() {
        columnIDTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdtransaccion()));
        columnFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        columnPrecioTotal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreciototal().toString()));
        columnNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getNombre()));
        columnVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty("ID" + cellData.getValue().getVehiculo().getIdVehiculo() + " - " +cellData.getValue().getVehiculo().getMarca()));
        columnFechaDevolucion.setCellValueFactory(cellData -> {if (cellData.getValue() instanceof Alquiler) {
            return new SimpleStringProperty(((Alquiler) cellData.getValue()).getFechaDevolucion().toString());
        }else{
            return new SimpleStringProperty("N/A");
        }});
        columnDuracionAlquiler.setCellValueFactory(cellData -> {if (cellData.getValue()instanceof Alquiler) {
            return new SimpleStringProperty(((Alquiler)cellData.getValue()).getDuracionalquiler().toString());
        }else{
            return new SimpleStringProperty("N/A");
        }});
        columnMetodoDePago.setCellValueFactory(cellData -> {if (cellData.getValue() instanceof Venta) {
            return new SimpleStringProperty(((Venta) cellData.getValue()).getMetodopago());
        }else{
            return new SimpleStringProperty("N/A");
        }});
        columnGarantia.setCellValueFactory(cellData -> {if (cellData.getValue()instanceof Venta) {
            if (((Venta)cellData.getValue()).getGarantia() == true) {
                return new SimpleStringProperty("Si");
            }else{
                return new SimpleStringProperty("No");
            }
        }else{
            return new SimpleStringProperty("N/A");
        }});
    }
}
