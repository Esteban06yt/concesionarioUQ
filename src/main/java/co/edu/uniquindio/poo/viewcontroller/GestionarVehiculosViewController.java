package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'GestionarVehiculosView.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.VehiculoController;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.BusDiesel;
import co.edu.uniquindio.poo.model.BusElectrico;
import co.edu.uniquindio.poo.model.BusGasolina;
import co.edu.uniquindio.poo.model.BusHibrido;
import co.edu.uniquindio.poo.model.CamionDiesel;
import co.edu.uniquindio.poo.model.CamionElectrico;
import co.edu.uniquindio.poo.model.CamionGasolina;
import co.edu.uniquindio.poo.model.CamionHibrido;
import co.edu.uniquindio.poo.model.CamionetaDiesel;
import co.edu.uniquindio.poo.model.CamionetaElectrico;
import co.edu.uniquindio.poo.model.CamionetaGasolina;
import co.edu.uniquindio.poo.model.CamionetaHibrido;
import co.edu.uniquindio.poo.model.DeporivoDiesel;
import co.edu.uniquindio.poo.model.DeportivoElectrico;
import co.edu.uniquindio.poo.model.DeportivoGasolina;
import co.edu.uniquindio.poo.model.DeportivoHibrido;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.MotoDiesel;
import co.edu.uniquindio.poo.model.MotoElectrico;
import co.edu.uniquindio.poo.model.MotoGasolina;
import co.edu.uniquindio.poo.model.MotoHibrido;
import co.edu.uniquindio.poo.model.PickupDiesel;
import co.edu.uniquindio.poo.model.PickupElectrico;
import co.edu.uniquindio.poo.model.PickupGasolina;
import co.edu.uniquindio.poo.model.PickupHibrido;
import co.edu.uniquindio.poo.model.SedanDiesel;
import co.edu.uniquindio.poo.model.SedanElectrico;
import co.edu.uniquindio.poo.model.SedanGasolina;
import co.edu.uniquindio.poo.model.SedanHibrido;
import co.edu.uniquindio.poo.model.SuvDiesel;
import co.edu.uniquindio.poo.model.SuvElectrico;
import co.edu.uniquindio.poo.model.SuvGasolina;
import co.edu.uniquindio.poo.model.SuvHibrido;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.VanDiesel;
import co.edu.uniquindio.poo.model.VanElectrico;
import co.edu.uniquindio.poo.model.VanGasolina;
import co.edu.uniquindio.poo.model.VanHibrido;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.VehiculoDiesel;
import co.edu.uniquindio.poo.model.VehiculoElectrico;
import co.edu.uniquindio.poo.model.VehiculoGasolina;
import co.edu.uniquindio.poo.model.VehiculoHibrido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionarVehiculosViewController {
    App app;
    VehiculoController vehiculocontroller;
    Vehiculo vehiculoseleccionado;
    Empleado empleado;
    ObservableList<Vehiculo> listavehiculos = FXCollections.observableArrayList();
    ObservableList<String> tipomotor = FXCollections.observableArrayList("Gasolina", "Diesel", "Hibrido", "Electrico");
    ObservableList<String> tipovehiculo = FXCollections.observableArrayList("Moto", "Deportivo", "Camion", "Pickup",
            "Camioneta", "Suv", "Bus", "Van", "Sedan");
    ObservableList<Transmision> transmision = FXCollections.observableArrayList(Transmision.AUTOMATICA,
            Transmision.MANUAL);
    ObservableList<Estado> estado = FXCollections.observableArrayList(Estado.NUEVO, Estado.USADO);

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnDetallesVehiculo"
    private Button btnDetallesVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxtipovehiculo"
    private ComboBox<String> comboboxtipovehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxtransmision"
    private ComboBox<Transmision> comboboxtransmision; // Value injected by FXMLLoader

    @FXML // fx:id="checkhibrido"
    private CheckBox checkhibrido; // Value injected by FXMLLoader

    @FXML // fx:id="txtsalidas"
    private TextField txtsalidas; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxtipomotor"
    private ComboBox<String> comboboxtipomotor; // Value injected by FXMLLoader

    @FXML // fx:id="checktrafico"
    private CheckBox checktrafico; // Value injected by FXMLLoader

    @FXML // fx:id="columntransmision"
    private TableColumn<Vehiculo, String> columntransmision; // Value injected by FXMLLoader

    @FXML // fx:id="btnregresar"
    private Button btnregresar; // Value injected by FXMLLoader

    @FXML // fx:id="columntipomotor"
    private TableColumn<Vehiculo, String> columntipomotor; // Value injected by FXMLLoader

    @FXML // fx:id="txtpuertas"
    private TextField txtpuertas; // Value injected by FXMLLoader

    @FXML // fx:id="txtid"
    private TextField txtid; // Value injected by FXMLLoader

    @FXML // fx:id="txttipocamion"
    private TextField txttipocamion; // Value injected by FXMLLoader

    @FXML // fx:id="txtpasajeros"
    private TextField txtpasajeros; // Value injected by FXMLLoader

    @FXML // fx:id="colummodelo"
    private TableColumn<Vehiculo, String> colummodelo; // Value injected by FXMLLoader

    @FXML // fx:id="checkenchufable"
    private CheckBox checkenchufable; // Value injected by FXMLLoader

    @FXML // fx:id="checkfrenosaire"
    private CheckBox checkfrenosaire; // Value injected by FXMLLoader

    @FXML // fx:id="checkaire"
    private CheckBox checkaire; // Value injected by FXMLLoader

    @FXML // fx:id="checkcrucerp"
    private CheckBox checkcrucerp; // Value injected by FXMLLoader

    @FXML // fx:id="checktraccion"
    private CheckBox checktraccion; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarVehiculo"
    private Button btnActualizarVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="columnid"
    private TableColumn<Vehiculo, String> columnid; // Value injected by FXMLLoader

    @FXML // fx:id="checkcamara"
    private CheckBox checkcamara; // Value injected by FXMLLoader

    @FXML // fx:id="txtejes"
    private TextField txtejes; // Value injected by FXMLLoader

    @FXML // fx:id="txtvelocidad"
    private TextField txtvelocidad; // Value injected by FXMLLoader

    @FXML // fx:id="txtcarga"
    private TextField txtcarga; // Value injected by FXMLLoader

    @FXML // fx:id="columnclasevehiculo"
    private TableColumn<Vehiculo, String> columnclasevehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="columncambios"
    private TableColumn<Vehiculo, String> columncambios; // Value injected by FXMLLoader

    @FXML // fx:id="txttiempo"
    private TextField txttiempo; // Value injected by FXMLLoader

    @FXML // fx:id="txtcaballos"
    private TextField txtcaballos; // Value injected by FXMLLoader

    @FXML // fx:id="txtmaletero"
    private TextField txtmaletero; // Value injected by FXMLLoader

    @FXML // fx:id="txtmarca"
    private TextField txtmarca; // Value injected by FXMLLoader

    @FXML // fx:id="txtbolsas"
    private TextField txtbolsas; // Value injected by FXMLLoader

    @FXML // fx:id="columnmarca"
    private TableColumn<Vehiculo, String> columnmarca; // Value injected by FXMLLoader

    @FXML // fx:id="columncilindraje"
    private TableColumn<Vehiculo, String> columncilindraje; // Value injected by FXMLLoader

    @FXML // fx:id="columnvelocidad"
    private TableColumn<Vehiculo, String> columnvelocidad; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxestado"
    private ComboBox<Estado> comboboxestado; // Value injected by FXMLLoader

    @FXML // fx:id="txtcilindraje"
    private TextField txtcilindraje; // Value injected by FXMLLoader

    @FXML // fx:id="checkcolision"
    private CheckBox checkcolision; // Value injected by FXMLLoader

    @FXML // fx:id="checkasistente"
    private CheckBox checkasistente; // Value injected by FXMLLoader

    @FXML // fx:id="txtcambios"
    private TextField txtcambios; // Value injected by FXMLLoader

    @FXML // fx:id="columnestado"
    private TableColumn<Vehiculo, String> columnestado; // Value injected by FXMLLoader

    @FXML // fx:id="txttiempocarga"
    private TextField txttiempocarga; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarVehiculo"
    private Button btnEliminarVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="checkabs"
    private CheckBox checkabs; // Value injected by FXMLLoader

    @FXML // fx:id="txtautonomia"
    private TextField txtautonomia; // Value injected by FXMLLoader

    @FXML // fx:id="tblvehiculos"
    private TableView<Vehiculo> tblvehiculos; // Value injected by FXMLLoader

    @FXML // fx:id="txtcajacarga"
    private TextField txtcajacarga; // Value injected by FXMLLoader

    @FXML // fx:id="btnAgregarvehiculo"
    private Button btnAgregarvehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="txtmodelo"
    private TextField txtmodelo; // Value injected by FXMLLoader

    @FXML
    void MostrarDetallesVehiculo(ActionEvent event) {
        Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
        if (vehiculoseleccionado!=null) {
            mostrarmensaje("Vehiculo", vehiculoseleccionado.toString(), AlertType.INFORMATION);
        }else{
            mostrarmensaje("Detalles de vehiculo", "Seleccione un vehiculo de la tabla",
            AlertType.WARNING);
        }
    
    }

    @FXML
    void TipoMotorAction(ActionEvent event) {
        ocultarCamposMotor();
        VaciarCamposMotor();
        String seleccion = comboboxtipomotor.getSelectionModel().getSelectedItem();
        if (seleccion.equals("Hibrido")) {
            checkenchufable.setVisible(true);
            checkhibrido.setVisible(true);
        }
        if (seleccion.equals("Electrico")) {
            txtautonomia.setVisible(true);
            txttiempocarga.setVisible(true);
        }
    }

    @FXML
    void TipoVehiculoAction(ActionEvent event) {
        ocultarCampos();
        Vaciarcampos();
        String seleccion = comboboxtipovehiculo.getSelectionModel().getSelectedItem();
        if (seleccion.equals("Deportivo")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtbolsas.setVisible(true);
            txtcaballos.setVisible(true);
            txttiempo.setVisible(true);
        }
        if (seleccion.equals("Camion")) {
            txtcarga.setVisible(true);
            checkaire.setVisible(true);
            checkfrenosaire.setVisible(true);
            checkabs.setVisible(true);
            txtejes.setVisible(true);
            txttipocamion.setVisible(true);
        }
        if (seleccion.equals("Pickup")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);
            checktraccion.setVisible(true);
            txtcajacarga.setVisible(true);
        }
        if (seleccion.equals("Camioneta")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtmaletero.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);

            checkcrucerp.setVisible(true);
            checkcolision.setVisible(true);
            checktrafico.setVisible(true);
            checkasistente.setVisible(true);
            checktraccion.setVisible(true);
        }
        if (seleccion.equals("Suv")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtmaletero.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);
            checkcrucerp.setVisible(true);
            checkcolision.setVisible(true);
            checktrafico.setVisible(true);
            checkasistente.setVisible(true);
            checktraccion.setVisible(true);
        }
        if (seleccion.equals("Bus")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtmaletero.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);
            txtejes.setVisible(true);
            txtsalidas.setVisible(true);
        }
        if (seleccion.equals("Van")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtmaletero.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);
        }
        if (seleccion.equals("Sedan")) {
            txtpasajeros.setVisible(true);
            txtpuertas.setVisible(true);
            txtmaletero.setVisible(true);
            checkaire.setVisible(true);
            checkcamara.setVisible(true);
            txtbolsas.setVisible(true);
            checkabs.setVisible(true);
            checkcrucerp.setVisible(true);
            checkcolision.setVisible(true);
            checktrafico.setVisible(true);
            checkasistente.setVisible(true);
        }
    }

    @FXML
    void Regresar(ActionEvent event) {
        app.openEmpleado(empleado);
    }

// Método AgregarVehiculo
@FXML
void AgregarVehiculo(ActionEvent event) {
    String id = txtid.getText();
    String marca = txtmarca.getText();
    String modelo = txtmodelo.getText();
    String cambios = txtcambios.getText();
    String velocidad = txtvelocidad.getText();
    String cilindraje = txtcilindraje.getText();
    Transmision transmision = comboboxtransmision.getSelectionModel().getSelectedItem();
    Estado estado = comboboxestado.getSelectionModel().getSelectedItem();
    String autonomia = txtautonomia.getText();
    String tiempocarga = txttiempocarga.getText();
    boolean enchufable = checkenchufable.selectedProperty().getValue();
    boolean hibridoligero = checkhibrido.selectedProperty().getValue();
    String numeropasajeros = txtpasajeros.getText();
    String puertas = txtpuertas.getText();
    String bolsas = txtbolsas.getText();
    String caballos = txtcaballos.getText();
    String tiempo = txttiempo.getText();
    String carga = txtcarga.getText();
    boolean aire = checkaire.selectedProperty().getValue();
    boolean frenosaire = checkfrenosaire.selectedProperty().getValue();
    boolean abs = checkabs.selectedProperty().getValue();
    String ejes = txtejes.getText();
    String tipocamion = txttipocamion.getText();
    boolean camara = checkcamara.selectedProperty().getValue();
    boolean traccion = checktraccion.selectedProperty().getValue();
    String cajacarga = txtcajacarga.getText();
    String maletero = txtmaletero.getText();
    boolean crucero = checkcrucerp.selectedProperty().getValue();
    boolean colision = checkcolision.selectedProperty().getValue();
    boolean trafico = checktrafico.selectedProperty().getValue();
    boolean asistente = checkasistente.selectedProperty().getValue();
    String salidas = txtsalidas.getText();
    
    // Validar los datos
    boolean validar = ValidarDatos(id, marca, modelo, cambios, velocidad, cilindraje, transmision, estado, autonomia, tiempocarga, enchufable, hibridoligero, numeropasajeros, puertas, bolsas, caballos, tiempo, carga, aire, frenosaire, abs, ejes, tipocamion, camara, traccion, cajacarga, maletero, crucero, colision, trafico, asistente, salidas);
    
    if (validar) {
        String tipoMotor = comboboxtipomotor.getSelectionModel().getSelectedItem();  // "Diesel" o "Electrico"
        String tipoVehiculo = comboboxtipovehiculo.getSelectionModel().getSelectedItem();  // "Moto", "Camion", etc.
        
        // Crear vehículo según el tipo de motor y tipo de vehículo
        if (tipoMotor.equals("Diesel")) {
            if (tipoVehiculo.equals("Moto")) {
                MotoDiesel moto = new MotoDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado);
                agregarVehiculo(moto);
            } else if (tipoVehiculo.equals("Camion")) {
                CamionDiesel camion = new CamionDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Float.parseFloat(carga), aire, frenosaire, abs, Integer.parseInt(ejes), tipocamion);
                agregarVehiculo(camion);
            } else if (tipoVehiculo.equals("Camioneta")) {
                CamionetaDiesel camioneta = new CamionetaDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Float.parseFloat(maletero), aire, camara, Integer.parseInt(bolsas), abs, crucero, colision, trafico, asistente, traccion);
                agregarVehiculo(camioneta);
            } else if (tipoVehiculo.equals("Deportivo")) {
                DeporivoDiesel deportivo = new DeporivoDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Integer.parseInt(bolsas), Integer.parseInt(caballos), Float.parseFloat(tiempo));
                agregarVehiculo(deportivo);
            } else if (tipoVehiculo.equals("Pickup")) {
                PickupDiesel pickup = new PickupDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), aire, camara, Integer.parseInt(bolsas), abs, traccion, Float.parseFloat(cajacarga));
                agregarVehiculo(pickup);
            }else if (tipoVehiculo.equals("Suv")){
                SuvDiesel suv = new SuvDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Float.parseFloat(maletero), aire, camara, Integer.parseInt(bolsas), abs, crucero, colision, trafico, asistente, traccion);
                agregarVehiculo(suv);
            }else if (tipoVehiculo.equals("Bus")) {
                BusDiesel bus = new BusDiesel(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    Integer.parseInt(ejes), 
                    Integer.parseInt(salidas)
                );
                agregarVehiculo(bus);
            } else if (tipoVehiculo.equals("Sedan")) {
                SedanDiesel sedan = new SedanDiesel(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente
                );
                agregarVehiculo(sedan);
            } else if (tipoVehiculo.equals("Van")) {
                VanDiesel van = new VanDiesel(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs
                );
                agregarVehiculo(van);
            }
            
        } else if (tipoMotor.equals("Electrico")) {
    if (tipoVehiculo.equals("Moto")) {
        MotoElectrico moto = new MotoElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga)
        );
        agregarVehiculo(moto);
    } else if (tipoVehiculo.equals("Camion")) {
        CamionElectrico camion = new CamionElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Float.parseFloat(carga), 
            aire, 
            frenosaire, 
            abs, 
            Integer.parseInt(ejes), 
            tipocamion
        );
        agregarVehiculo(camion);
    } else if (tipoVehiculo.equals("Camioneta")) {
        CamionetaElectrico camioneta = new CamionetaElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(camioneta);
    } else if (tipoVehiculo.equals("Deportivo")) {
        DeportivoElectrico deportivo = new DeportivoElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Integer.parseInt(bolsas), 
            Integer.parseInt(caballos), 
            Float.parseFloat(tiempo)
        );
        agregarVehiculo(deportivo);
    } else if (tipoVehiculo.equals("Pickup")) {
        PickupElectrico pickup = new PickupElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            traccion, 
            Float.parseFloat(cajacarga)
        );
        agregarVehiculo(pickup);
    } else if (tipoVehiculo.equals("Suv")) {
        SuvElectrico suv = new SuvElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(suv);
    } else if (tipoVehiculo.equals("Bus")) {
        BusElectrico bus = new BusElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            Integer.parseInt(ejes), 
            Integer.parseInt(salidas)
        );
        agregarVehiculo(bus);
    } else if (tipoVehiculo.equals("Sedan")) {
        SedanElectrico sedan = new SedanElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente
        );
        agregarVehiculo(sedan);
    } else if (tipoVehiculo.equals("Van")) {
        VanElectrico van = new VanElectrico(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(autonomia), 
            Float.parseFloat(tiempocarga), 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs
        );
        agregarVehiculo(van);
    }
}else if (tipoMotor.equals("Gasolina")) {
    if (tipoVehiculo.equals("Moto")) {
        MotoGasolina moto = new MotoGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado
        );
        agregarVehiculo(moto);
    } else if (tipoVehiculo.equals("Camion")) {
        CamionGasolina camion = new CamionGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Float.parseFloat(carga), 
            aire, 
            frenosaire, 
            abs, 
            Integer.parseInt(ejes), 
            tipocamion
        );
        agregarVehiculo(camion);
    } else if (tipoVehiculo.equals("Camioneta")) {
        CamionetaGasolina camioneta = new CamionetaGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(camioneta);
    } else if (tipoVehiculo.equals("Deportivo")) {
        DeportivoGasolina deportivo = new DeportivoGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Integer.parseInt(bolsas), 
            Integer.parseInt(caballos), 
            Float.parseFloat(tiempo)
        );
        agregarVehiculo(deportivo);
    } else if (tipoVehiculo.equals("Pickup")) {
        PickupGasolina pickup = new PickupGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            traccion, 
            Float.parseFloat(cajacarga)
        );
        agregarVehiculo(pickup);
    } else if (tipoVehiculo.equals("Suv")) {
        SuvGasolina suv = new SuvGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(suv);
    } else if (tipoVehiculo.equals("Bus")) {
        BusGasolina bus = new BusGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            Integer.parseInt(ejes), 
            Integer.parseInt(salidas)
        );
        agregarVehiculo(bus);
    } else if (tipoVehiculo.equals("Sedan")) {
        SedanGasolina sedan = new SedanGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente
        );
        agregarVehiculo(sedan);
    } else if (tipoVehiculo.equals("Van")) {
        VanGasolina van = new VanGasolina(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs
        );
        agregarVehiculo(van);
    }
}else if (tipoMotor.equals("Hibrido")) {
    Boolean hibridoLigero = checkhibrido.selectedProperty().getValue();

    if (tipoVehiculo.equals("Moto")) {
        MotoHibrido motoHibrido = new MotoHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero
        );
        agregarVehiculo(motoHibrido);
    } else if (tipoVehiculo.equals("Camion")) {
        CamionHibrido camionHibrido = new CamionHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Float.parseFloat(carga), 
            aire, 
            frenosaire, 
            abs, 
            Integer.parseInt(ejes), 
            tipocamion
        );
        agregarVehiculo(camionHibrido);
    } else if (tipoVehiculo.equals("Camioneta")) {
        CamionetaHibrido camionetaHibrido = new CamionetaHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(camionetaHibrido);
    } else if (tipoVehiculo.equals("Deportivo")) {
        DeportivoHibrido deportivoHibrido = new DeportivoHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Integer.parseInt(bolsas), 
            Integer.parseInt(caballos), 
            Float.parseFloat(tiempo)
        );
        agregarVehiculo(deportivoHibrido);
    } else if (tipoVehiculo.equals("Pickup")) {
        PickupHibrido pickupHibrido = new PickupHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            traccion, 
            Float.parseFloat(cajacarga)
        );
        agregarVehiculo(pickupHibrido);
    } else if (tipoVehiculo.equals("Suv")) {
        SuvHibrido suvHibrido = new SuvHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente, 
            traccion
        );
        agregarVehiculo(suvHibrido);
    } else if (tipoVehiculo.equals("Bus")) {
        BusHibrido busHibrido = new BusHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            Integer.parseInt(ejes), 
            Integer.parseInt(salidas)
        );
        agregarVehiculo(busHibrido);
    } else if (tipoVehiculo.equals("Sedan")) {
        SedanHibrido sedanHibrido = new SedanHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs, 
            crucero, 
            colision, 
            trafico, 
            asistente
        );
        agregarVehiculo(sedanHibrido);
    } else if (tipoVehiculo.equals("Van")) {
        VanHibrido vanHibrido = new VanHibrido(
            id, 
            marca, 
            modelo, 
            Integer.parseInt(cambios), 
            Float.parseFloat(velocidad), 
            Float.parseFloat(cilindraje), 
            transmision, 
            estado, 
            enchufable, 
            hibridoLigero, 
            Integer.parseInt(numeropasajeros), 
            Integer.parseInt(puertas), 
            Float.parseFloat(maletero), 
            aire, 
            camara, 
            Integer.parseInt(bolsas), 
            abs
        );
        agregarVehiculo(vanHibrido);
    }
}



        }
        
    }


private void agregarVehiculo(Vehiculo vehiculo) {
    String respuesta = vehiculocontroller.AgregarVehiculo(vehiculo);
    if (respuesta.equals("El vehículo se añadió correctamente")) {
        listavehiculos.add(vehiculo);
        empleado.AgregarVehiculo(vehiculo);
        Limpiarseleccion();
    }
}

private void ActualizarVehiculo(Vehiculo vehiculo, Vehiculo vehiculoact){
    String respuesta = vehiculocontroller.ActualizarVehiculo(vehiculo, vehiculoact);
    if (respuesta.equals("")) {
        listavehiculos.remove(vehiculo);
        listavehiculos.add(vehiculoact);
        empleado.ActualizarVehiculo(vehiculo, vehiculoact);
        Limpiarseleccion();
    }
}

        
    

    @FXML
    void EliminarVehiculo(ActionEvent event) {
        Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
        if (vehiculoseleccionado!=null) {
            String resultado = vehiculocontroller.EliminarVehiculo(vehiculoseleccionado);
            mostrarmensaje("Eliminar vehiculo", resultado, AlertType.INFORMATION);
            if (resultado.equals("El vehículo se eliminó correctamente")) {
                listavehiculos.remove(vehiculoseleccionado);
                empleado.EliminarVehiculo(vehiculoseleccionado);
                Limpiarseleccion();
            }
        }else{
            mostrarmensaje("Eliminacion de Vehiculo", "Seleccione un vehiculo de la tabla",
            AlertType.WARNING);
        }
    }

    @FXML
    void ActualizarVehiculo(ActionEvent event) {
        Vehiculo vehiculoselec = tblvehiculos.getSelectionModel().getSelectedItem();
        String id = txtid.getText();
        String marca = txtmarca.getText();
        String modelo = txtmodelo.getText();
        String cambios = txtcambios.getText();
        String velocidad = txtvelocidad.getText();
        String cilindraje = txtcilindraje.getText();
        Transmision transmision = comboboxtransmision.getSelectionModel().getSelectedItem();
        Estado estado = comboboxestado.getSelectionModel().getSelectedItem();
        String autonomia = txtautonomia.getText();
        String tiempocarga = txttiempocarga.getText();
        boolean enchufable = checkenchufable.selectedProperty().getValue();
        boolean hibridoligero = checkhibrido.selectedProperty().getValue();
        String numeropasajeros = txtpasajeros.getText();
        String puertas = txtpuertas.getText();
        String bolsas = txtbolsas.getText();
        String caballos = txtcaballos.getText();
        String tiempo = txttiempo.getText();
        String carga = txtcarga.getText();
        boolean aire = checkaire.selectedProperty().getValue();
        boolean frenosaire = checkfrenosaire.selectedProperty().getValue();
        boolean abs = checkabs.selectedProperty().getValue();
        String ejes = txtejes.getText();
        String tipocamion = txttipocamion.getText();
        boolean camara = checkcamara.selectedProperty().getValue();
        boolean traccion = checktraccion.selectedProperty().getValue();
        String cajacarga = txtcajacarga.getText();
        String maletero = txtmaletero.getText();
        boolean crucero = checkcrucerp.selectedProperty().getValue();
        boolean colision = checkcolision.selectedProperty().getValue();
        boolean trafico = checktrafico.selectedProperty().getValue();
        boolean asistente = checkasistente.selectedProperty().getValue();
        String salidas = txtsalidas.getText();
        
        // Validar los datos
        boolean validar = ValidarDatos(id, marca, modelo, cambios, velocidad, cilindraje, transmision, estado, autonomia, tiempocarga, enchufable, hibridoligero, numeropasajeros, puertas, bolsas, caballos, tiempo, carga, aire, frenosaire, abs, ejes, tipocamion, camara, traccion, cajacarga, maletero, crucero, colision, trafico, asistente, salidas);
        if (vehiculoselec!=null) {
            if (validar) {
                String tipoMotor = comboboxtipomotor.getSelectionModel().getSelectedItem();  // "Diesel" o "Electrico"
                String tipoVehiculo = comboboxtipovehiculo.getSelectionModel().getSelectedItem();  // "Moto", "Camion", etc.
                
                // Crear vehículo según el tipo de motor y tipo de vehículo
                if (tipoMotor.equals("Diesel")) {
                    if (tipoVehiculo.equals("Moto")) {
                        MotoDiesel moto = new MotoDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado);
                        ActualizarVehiculo(vehiculoselec,moto);
                    } else if (tipoVehiculo.equals("Camion")) {
                        CamionDiesel camion = new CamionDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Float.parseFloat(carga), aire, frenosaire, abs, Integer.parseInt(ejes), tipocamion);
                        ActualizarVehiculo(vehiculoselec,camion);
                    } else if (tipoVehiculo.equals("Camioneta")) {
                        CamionetaDiesel camioneta = new CamionetaDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Float.parseFloat(maletero), aire, camara, Integer.parseInt(bolsas), abs, crucero, colision, trafico, asistente, traccion);
                        ActualizarVehiculo(vehiculoselec,camioneta);
                    } else if (tipoVehiculo.equals("Deportivo")) {
                        DeporivoDiesel deportivo = new DeporivoDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Integer.parseInt(bolsas), Integer.parseInt(caballos), Float.parseFloat(tiempo));
                        ActualizarVehiculo(vehiculoselec,deportivo);
                    } else if (tipoVehiculo.equals("Pickup")) {
                        PickupDiesel pickup = new PickupDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), aire, camara, Integer.parseInt(bolsas), abs, traccion, Float.parseFloat(cajacarga));
                        ActualizarVehiculo(vehiculoselec,pickup);
                    }else if (tipoVehiculo.equals("Suv")){
                        SuvDiesel suv = new SuvDiesel(id, marca, modelo, Integer.parseInt(cambios), Float.parseFloat(velocidad), Float.parseFloat(cilindraje), transmision, estado, Integer.parseInt(numeropasajeros), Integer.parseInt(puertas), Float.parseFloat(maletero), aire, camara, Integer.parseInt(bolsas), abs, crucero, colision, trafico, asistente, traccion);
                        ActualizarVehiculo(vehiculoselec,suv);
                    }else if (tipoVehiculo.equals("Bus")) {
                        BusDiesel bus = new BusDiesel(
                            id, 
                            marca, 
                            modelo, 
                            Integer.parseInt(cambios), 
                            Float.parseFloat(velocidad), 
                            Float.parseFloat(cilindraje), 
                            transmision, 
                            estado, 
                            Integer.parseInt(numeropasajeros), 
                            Integer.parseInt(puertas), 
                            Float.parseFloat(maletero), 
                            aire, 
                            camara, 
                            Integer.parseInt(bolsas), 
                            abs, 
                            Integer.parseInt(ejes), 
                            Integer.parseInt(salidas)
                        );
                        ActualizarVehiculo(vehiculoselec,bus);
                    } else if (tipoVehiculo.equals("Sedan")) {
                        SedanDiesel sedan = new SedanDiesel(
                            id, 
                            marca, 
                            modelo, 
                            Integer.parseInt(cambios), 
                            Float.parseFloat(velocidad), 
                            Float.parseFloat(cilindraje), 
                            transmision, 
                            estado, 
                            Integer.parseInt(numeropasajeros), 
                            Integer.parseInt(puertas), 
                            Float.parseFloat(maletero), 
                            aire, 
                            camara, 
                            Integer.parseInt(bolsas), 
                            abs, 
                            crucero, 
                            colision, 
                            trafico, 
                            asistente
                        );
                        ActualizarVehiculo(vehiculoselec,sedan);
                    } else if (tipoVehiculo.equals("Van")) {
                        VanDiesel van = new VanDiesel(
                            id, 
                            marca, 
                            modelo, 
                            Integer.parseInt(cambios), 
                            Float.parseFloat(velocidad), 
                            Float.parseFloat(cilindraje), 
                            transmision, 
                            estado, 
                            Integer.parseInt(numeropasajeros), 
                            Integer.parseInt(puertas), 
                            Float.parseFloat(maletero), 
                            aire, 
                            camara, 
                            Integer.parseInt(bolsas), 
                            abs
                        );
                        ActualizarVehiculo(vehiculoselec,van);
                    }
                    
                } else if (tipoMotor.equals("Electrico")) {
            if (tipoVehiculo.equals("Moto")) {
                MotoElectrico moto = new MotoElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga)
                );
                ActualizarVehiculo(vehiculoselec,moto);
            } else if (tipoVehiculo.equals("Camion")) {
                CamionElectrico camion = new CamionElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Float.parseFloat(carga), 
                    aire, 
                    frenosaire, 
                    abs, 
                    Integer.parseInt(ejes), 
                    tipocamion
                );
                ActualizarVehiculo(vehiculoselec,camion);
            } else if (tipoVehiculo.equals("Camioneta")) {
                CamionetaElectrico camioneta = new CamionetaElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,camioneta);
            } else if (tipoVehiculo.equals("Deportivo")) {
                DeportivoElectrico deportivo = new DeportivoElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Integer.parseInt(bolsas), 
                    Integer.parseInt(caballos), 
                    Float.parseFloat(tiempo)
                );
                ActualizarVehiculo(vehiculoselec,deportivo);
            } else if (tipoVehiculo.equals("Pickup")) {
                PickupElectrico pickup = new PickupElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    traccion, 
                    Float.parseFloat(cajacarga)
                );
                ActualizarVehiculo(vehiculoselec,pickup);
            } else if (tipoVehiculo.equals("Suv")) {
                SuvElectrico suv = new SuvElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,suv);
            } else if (tipoVehiculo.equals("Bus")) {
                BusElectrico bus = new BusElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    Integer.parseInt(ejes), 
                    Integer.parseInt(salidas)
                );
                ActualizarVehiculo(vehiculoselec,bus);
            } else if (tipoVehiculo.equals("Sedan")) {
                SedanElectrico sedan = new SedanElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente
                );
                ActualizarVehiculo(vehiculoselec,sedan);
            } else if (tipoVehiculo.equals("Van")) {
                VanElectrico van = new VanElectrico(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(autonomia), 
                    Float.parseFloat(tiempocarga), 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs
                );
                ActualizarVehiculo(vehiculoselec,van);
            }
        }else if (tipoMotor.equals("Gasolina")) {
            if (tipoVehiculo.equals("Moto")) {
                MotoGasolina moto = new MotoGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado
                );
                ActualizarVehiculo(vehiculoselec,moto);
            } else if (tipoVehiculo.equals("Camion")) {
                CamionGasolina camion = new CamionGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Float.parseFloat(carga), 
                    aire, 
                    frenosaire, 
                    abs, 
                    Integer.parseInt(ejes), 
                    tipocamion
                );
                ActualizarVehiculo(vehiculoselec,camion);
            } else if (tipoVehiculo.equals("Camioneta")) {
                CamionetaGasolina camioneta = new CamionetaGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,camioneta);
            } else if (tipoVehiculo.equals("Deportivo")) {
                DeportivoGasolina deportivo = new DeportivoGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Integer.parseInt(bolsas), 
                    Integer.parseInt(caballos), 
                    Float.parseFloat(tiempo)
                );
                ActualizarVehiculo(vehiculoselec,deportivo);
            } else if (tipoVehiculo.equals("Pickup")) {
                PickupGasolina pickup = new PickupGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    traccion, 
                    Float.parseFloat(cajacarga)
                );
                ActualizarVehiculo(vehiculoselec,pickup);
            } else if (tipoVehiculo.equals("Suv")) {
                SuvGasolina suv = new SuvGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,suv);
            } else if (tipoVehiculo.equals("Bus")) {
                BusGasolina bus = new BusGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    Integer.parseInt(ejes), 
                    Integer.parseInt(salidas)
                );
                ActualizarVehiculo(vehiculoselec,bus);
            } else if (tipoVehiculo.equals("Sedan")) {
                SedanGasolina sedan = new SedanGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente
                );
                ActualizarVehiculo(vehiculoselec,sedan);
            } else if (tipoVehiculo.equals("Van")) {
                VanGasolina van = new VanGasolina(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs
                );
                ActualizarVehiculo(vehiculoselec,van);
            }
        }else if (tipoMotor.equals("Hibrido")) {
            Boolean hibridoLigero = checkhibrido.selectedProperty().getValue();
        
            if (tipoVehiculo.equals("Moto")) {
                MotoHibrido motoHibrido = new MotoHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero
                );
                ActualizarVehiculo(vehiculoselec,motoHibrido);
            } else if (tipoVehiculo.equals("Camion")) {
                CamionHibrido camionHibrido = new CamionHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Float.parseFloat(carga), 
                    aire, 
                    frenosaire, 
                    abs, 
                    Integer.parseInt(ejes), 
                    tipocamion
                );
                ActualizarVehiculo(vehiculoselec,camionHibrido);
            } else if (tipoVehiculo.equals("Camioneta")) {
                CamionetaHibrido camionetaHibrido = new CamionetaHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,camionetaHibrido);
            } else if (tipoVehiculo.equals("Deportivo")) {
                DeportivoHibrido deportivoHibrido = new DeportivoHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Integer.parseInt(bolsas), 
                    Integer.parseInt(caballos), 
                    Float.parseFloat(tiempo)
                );
                ActualizarVehiculo(vehiculoselec,deportivoHibrido);
            } else if (tipoVehiculo.equals("Pickup")) {
                PickupHibrido pickupHibrido = new PickupHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    traccion, 
                    Float.parseFloat(cajacarga)
                );
                ActualizarVehiculo(vehiculoselec,pickupHibrido);
            } else if (tipoVehiculo.equals("Suv")) {
                SuvHibrido suvHibrido = new SuvHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente, 
                    traccion
                );
                ActualizarVehiculo(vehiculoselec,suvHibrido);
            } else if (tipoVehiculo.equals("Bus")) {
                BusHibrido busHibrido = new BusHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    Integer.parseInt(ejes), 
                    Integer.parseInt(salidas)
                );
                ActualizarVehiculo(vehiculoselec,busHibrido);
            } else if (tipoVehiculo.equals("Sedan")) {
                SedanHibrido sedanHibrido = new SedanHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs, 
                    crucero, 
                    colision, 
                    trafico, 
                    asistente
                );
                ActualizarVehiculo(vehiculoselec,sedanHibrido);
            } else if (tipoVehiculo.equals("Van")) {
                VanHibrido vanHibrido = new VanHibrido(
                    id, 
                    marca, 
                    modelo, 
                    Integer.parseInt(cambios), 
                    Float.parseFloat(velocidad), 
                    Float.parseFloat(cilindraje), 
                    transmision, 
                    estado, 
                    enchufable, 
                    hibridoLigero, 
                    Integer.parseInt(numeropasajeros), 
                    Integer.parseInt(puertas), 
                    Float.parseFloat(maletero), 
                    aire, 
                    camara, 
                    Integer.parseInt(bolsas), 
                    abs
                );
                ActualizarVehiculo(vehiculoselec,vanHibrido);
            }
        }
        
        
        
                }
                
            }else{
                mostrarmensaje("Actualizar vehiculo", "Seleccione un vehiculo en la tabla", AlertType.WARNING);
            }
        }
        
    

    public void setApp(App app) {
        this.app = app;
        vehiculocontroller = new VehiculoController(app.getConcesionario());
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        initView();

    }

    private void initView() {
        initDataBinding();
        ObtenerVehiculos();
        tblvehiculos.getItems().clear();
        tblvehiculos.setItems(listavehiculos);
        listenerSelection();
        ocultarCampos();
        ocultarCamposMotor();
    }

    public void ObtenerVehiculos() {
        listavehiculos.addAll(vehiculocontroller.ObtenerVehiculosEmpleado(empleado));
    }

    /**
     * Obtiene el vehiculo seleccionado de la tabla y muestra su informacion
     */
    private void listenerSelection() {
        tblvehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !listavehiculos.isEmpty()) {
                vehiculoseleccionado = newSelection;
                mostrarInformacionVehiculo(vehiculoseleccionado);// Muestra la informacion del vehiculo seleccionado
            }
        });
    }

    /**
     * Muestra la información del vehiculo seleccionado en los campos de texto y los
     * atributos propios
     * 
     * @param vehiculo
     */
    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txtid.setText(vehiculo.getIdVehiculo());
            txtmarca.setText(vehiculo.getMarca());
            txtmodelo.setText(vehiculo.getModelo());
            txtcambios.setText(vehiculo.getCambios().toString());
            txtvelocidad.setText(vehiculo.getVelocidadMaxima().toString());
            txtcilindraje.setText(vehiculo.getCilindraje().toString());
            comboboxestado.setValue(vehiculo.getEstado());
            comboboxtransmision.setValue(vehiculo.getTransmision());
            if (vehiculo instanceof VehiculoElectrico) {
                txtautonomia.setText(((VehiculoElectrico) vehiculo).getAutonomia().toString());
                txttiempocarga.setText(((VehiculoElectrico) vehiculo).getTiempoCarga().toString());
            }
            if (vehiculo instanceof VehiculoHibrido) {
                checkenchufable.setSelected(((VehiculoHibrido) vehiculo).getEnchufable());
                checkhibrido.setSelected(((VehiculoHibrido) vehiculo).getHibridoLigero());
            }
            if (vehiculo instanceof DeporivoDiesel) {
                DeporivoDiesel deportivo = (DeporivoDiesel) vehiculo;
                txtpasajeros.setText(deportivo.getNumeroPasajeros().toString());
                txtpuertas.setText(deportivo.getNumeroPuertas().toString());
                txtbolsas.setText(deportivo.getNumeroBolsasAire().toString());
                txtcaballos.setText(deportivo.getCaballosFuerza().toString());
                txttiempo.setText(deportivo.getTiempoCienKmh().toString());
            }
            if (vehiculo instanceof CamionDiesel) {
                CamionDiesel camion = (CamionDiesel) vehiculo;
                txtcarga.setText(camion.getCapacidadCarga().toString());
                checkaire.setSelected(camion.getAireAcondicionado());
                checkfrenosaire.setSelected(camion.getFrenosAire());
                checkabs.setSelected(camion.getAbs());
                txtejes.setText(camion.getNumeroEjes().toString());
                txttipocamion.setText(camion.getTipoCamion());
            }
            if (vehiculo instanceof PickupDiesel) {
                PickupDiesel pickup = (PickupDiesel) vehiculo;
                txtpasajeros.setText(pickup.getNumeroPasajeros().toString());
                txtpuertas.setText(pickup.getNumeroPuertas().toString());
                checkaire.setSelected(pickup.getAireAcondicionado());
                checkcamara.setSelected(pickup.getCamaraReversa());
                txtbolsas.setText(pickup.getNumeroBolsasAire().toString());
                checkabs.setSelected(pickup.getAbs());
                checktraccion.setSelected(pickup.getTraccion4x4());
                txtcajacarga.setText(pickup.getCapacidadCajaCarga().toString());
            }
            if (vehiculo instanceof CamionetaDiesel) {
                CamionetaDiesel camioneta = (CamionetaDiesel) vehiculo;
                txtpasajeros.setText(camioneta.getNumeroPasajeros().toString());
                txtpuertas.setText(camioneta.getNumeroPuertas().toString());
                txtmaletero.setText(camioneta.getCapacidadMaletero().toString());
                checkaire.setSelected(camioneta.getAireAcondicionado());
                checkcamara.setSelected(camioneta.getCamaraReversa());
                txtbolsas.setText(camioneta.getNumeroBolsasAire().toString());
                checkabs.setSelected(camioneta.getAbs());
                checkcrucerp.setSelected(camioneta.getVelocidadCrucero());
                checkcolision.setSelected(camioneta.getSensoresColision());
                checktrafico.setSelected(camioneta.getSensorTraficoCruzado());
                checktraccion.setSelected(camioneta.getTraccion4x4());
            }
            if (vehiculo instanceof SuvDiesel) {
                SuvDiesel suv = (SuvDiesel) vehiculo;
                txtpasajeros.setText(suv.getNumeroPasajeros().toString());
                txtpuertas.setText(suv.getNumeroPuertas().toString());
                txtmaletero.setText(suv.getCapacidadMaletero().toString());
                checkaire.setSelected(suv.getAireAcondicionado());
                checkcamara.setSelected(suv.getCamaraReversa());
                txtbolsas.setText(suv.getNumeroBolsasAire().toString());
                checkabs.setSelected(suv.getAbs());
                checkcrucerp.setSelected(suv.getVelocidadCrucero());
                checkcolision.setSelected(suv.getSensoresColision());
                checktrafico.setSelected(suv.getSensorTraficoCruzado());
                checktraccion.setSelected(suv.getTraccion4x4());
            }
            if (vehiculo instanceof BusDiesel) {
                BusDiesel bus = (BusDiesel) vehiculo;
                txtpasajeros.setText(bus.getNumeroPasajeros().toString());
                txtpuertas.setText(bus.getNumeroPuertas().toString());
                txtmaletero.setText(bus.getCapacidadMaletero().toString());
                checkaire.setSelected(bus.getAireAcondicionado());
                checkcamara.setSelected(bus.getCamaraReversa());
                txtbolsas.setText(bus.getNumeroBolsasAire().toString());
                checkabs.setSelected(bus.getAbs());
                txtejes.setText(bus.getNumeroEjes().toString());
                txtsalidas.setText(bus.getNumeroSalidasEmergencia().toString());
            }
            if (vehiculo instanceof VanDiesel) {
                VanDiesel van = (VanDiesel) vehiculo;
                txtpasajeros.setText(van.getNumeroPasajeros().toString());
                txtpuertas.setText(van.getNumeroPuertas().toString());
                txtmaletero.setText(van.getCapacidadMaletero().toString());
                checkaire.setSelected(van.getAireAcondicionado());
                checkcamara.setSelected(van.getCamaraReversa());
                txtbolsas.setText(van.getNumeroBolsasAire().toString());
                checkabs.setSelected(van.getAbs());
            }
            if (vehiculo instanceof SedanDiesel) {
                SedanDiesel sedan = (SedanDiesel) vehiculo;
                txtpasajeros.setText(sedan.getNumeroPasajeros().toString());
                txtpuertas.setText(sedan.getNumeroPuertas().toString());
                txtmaletero.setText(sedan.getCapacidadMaletero().toString());
                checkaire.setSelected(sedan.getAireAcondicionado());
                checkcamara.setSelected(sedan.getCamaraReversa());
                txtbolsas.setText(sedan.getNumeroBolsasAire().toString());
                checkabs.setSelected(sedan.getAbs());
                checkcrucerp.setSelected(sedan.getVelocidadCrucero());
                checkcolision.setSelected(sedan.getSensoresColision());
                checktrafico.setSelected(sedan.getSensorTraficoCruzado());
            }
            if (vehiculo instanceof DeportivoElectrico) {
                DeportivoElectrico deportivo = (DeportivoElectrico) vehiculo;
                txtpasajeros.setText(deportivo.getNumeroPasajeros().toString());
                txtpuertas.setText(deportivo.getNumeroPuertas().toString());
                txtbolsas.setText(deportivo.getNumeroBolsasAire().toString());
                txtcaballos.setText(deportivo.getCaballosFuerza().toString());
                txttiempo.setText(deportivo.getTiempoCienKmh().toString());
            }
            if (vehiculo instanceof DeportivoHibrido) {
                DeportivoHibrido deportivo = (DeportivoHibrido) vehiculo;
                txtpasajeros.setText(deportivo.getNumeroPasajeros().toString());
                txtpuertas.setText(deportivo.getNumeroPuertas().toString());
                txtbolsas.setText(deportivo.getNumeroBolsasAire().toString());
                txtcaballos.setText(deportivo.getCaballosFuerza().toString());
                txttiempo.setText(deportivo.getTiempoCienKmh().toString());
            }
            if (vehiculo instanceof DeportivoGasolina) {
                DeportivoGasolina deportivo = (DeportivoGasolina) vehiculo;
                txtpasajeros.setText(deportivo.getNumeroPasajeros().toString());
                txtpuertas.setText(deportivo.getNumeroPuertas().toString());
                txtbolsas.setText(deportivo.getNumeroBolsasAire().toString());
                txtcaballos.setText(deportivo.getCaballosFuerza().toString());
                txttiempo.setText(deportivo.getTiempoCienKmh().toString());
            }

            if (vehiculo instanceof CamionElectrico) {
                CamionElectrico camion = (CamionElectrico) vehiculo;
                txtcarga.setText(camion.getCapacidadCarga().toString());
                checkaire.setSelected(camion.getAireAcondicionado());
                checkfrenosaire.setSelected(camion.getFrenosAire());
                checkabs.setSelected(camion.getAbs());
                txtejes.setText(camion.getNumeroEjes().toString());
                txttipocamion.setText(camion.getTipoCamion());
            }
            if (vehiculo instanceof CamionHibrido) {
                CamionHibrido camion = (CamionHibrido) vehiculo;
                txtcarga.setText(camion.getCapacidadCarga().toString());
                checkaire.setSelected(camion.getAireAcondicionado());
                checkfrenosaire.setSelected(camion.getFrenosAire());
                checkabs.setSelected(camion.getAbs());
                txtejes.setText(camion.getNumeroEjes().toString());
                txttipocamion.setText(camion.getTipoCamion());
            }
            if (vehiculo instanceof CamionGasolina) {
                CamionGasolina camion = (CamionGasolina) vehiculo;
                txtcarga.setText(camion.getCapacidadCarga().toString());
                checkaire.setSelected(camion.getAireAcondicionado());
                checkfrenosaire.setSelected(camion.getFrenosAire());
                checkabs.setSelected(camion.getAbs());
                txtejes.setText(camion.getNumeroEjes().toString());
                txttipocamion.setText(camion.getTipoCamion());
            }

            if (vehiculo instanceof PickupElectrico) {
                PickupElectrico pickup = (PickupElectrico) vehiculo;
                txtpasajeros.setText(pickup.getNumeroPasajeros().toString());
                txtpuertas.setText(pickup.getNumeroPuertas().toString());
                checkaire.setSelected(pickup.getAireAcondicionado());
                checkcamara.setSelected(pickup.getCamaraReversa());
                txtbolsas.setText(pickup.getNumeroBolsasAire().toString());
                checkabs.setSelected(pickup.getAbs());
                checktraccion.setSelected(pickup.getTraccion4x4());
                txtcajacarga.setText(pickup.getCapacidadCajaCarga().toString());
            }
            if (vehiculo instanceof PickupHibrido) {
                PickupHibrido pickup = (PickupHibrido) vehiculo;
                txtpasajeros.setText(pickup.getNumeroPasajeros().toString());
                txtpuertas.setText(pickup.getNumeroPuertas().toString());
                checkaire.setSelected(pickup.getAireAcondicionado());
                checkcamara.setSelected(pickup.getCamaraReversa());
                txtbolsas.setText(pickup.getNumeroBolsasAire().toString());
                checkabs.setSelected(pickup.getAbs());
                checktraccion.setSelected(pickup.getTraccion4x4());
                txtcajacarga.setText(pickup.getCapacidadCajaCarga().toString());
            }
            if (vehiculo instanceof PickupGasolina) {
                PickupGasolina pickup = (PickupGasolina) vehiculo;
                txtpasajeros.setText(pickup.getNumeroPasajeros().toString());
                txtpuertas.setText(pickup.getNumeroPuertas().toString());
                checkaire.setSelected(pickup.getAireAcondicionado());
                checkcamara.setSelected(pickup.getCamaraReversa());
                txtbolsas.setText(pickup.getNumeroBolsasAire().toString());
                checkabs.setSelected(pickup.getAbs());
                checktraccion.setSelected(pickup.getTraccion4x4());
                txtcajacarga.setText(pickup.getCapacidadCajaCarga().toString());
            }
            // Camioneta
            if (vehiculo instanceof CamionetaElectrico) {
                CamionetaElectrico camioneta = (CamionetaElectrico) vehiculo;
                txtpasajeros.setText(camioneta.getNumeroPasajeros().toString());
                txtpuertas.setText(camioneta.getNumeroPuertas().toString());
                txtmaletero.setText(camioneta.getCapacidadMaletero().toString());
                checkaire.setSelected(camioneta.getAireAcondicionado());
                checkcamara.setSelected(camioneta.getCamaraReversa());
                txtbolsas.setText(camioneta.getNumeroBolsasAire().toString());
                checkabs.setSelected(camioneta.getAbs());
                checkcrucerp.setSelected(camioneta.getVelocidadCrucero());
                checkcolision.setSelected(camioneta.getSensoresColision());
                checktrafico.setSelected(camioneta.getSensorTraficoCruzado());
                checktraccion.setSelected(camioneta.getTraccion4x4());
            }
            if (vehiculo instanceof CamionetaHibrido) {
                CamionetaHibrido camioneta = (CamionetaHibrido) vehiculo;
                txtpasajeros.setText(camioneta.getNumeroPasajeros().toString());
                txtpuertas.setText(camioneta.getNumeroPuertas().toString());
                txtmaletero.setText(camioneta.getCapacidadMaletero().toString());
                checkaire.setSelected(camioneta.getAireAcondicionado());
                checkcamara.setSelected(camioneta.getCamaraReversa());
                txtbolsas.setText(camioneta.getNumeroBolsasAire().toString());
                checkabs.setSelected(camioneta.getAbs());
                checkcrucerp.setSelected(camioneta.getVelocidadCrucero());
                checkcolision.setSelected(camioneta.getSensoresColision());
                checktrafico.setSelected(camioneta.getSensorTraficoCruzado());
                checktraccion.setSelected(camioneta.getTraccion4x4());
            }
            if (vehiculo instanceof CamionetaGasolina) {
                CamionetaGasolina camioneta = (CamionetaGasolina) vehiculo;
                txtpasajeros.setText(camioneta.getNumeroPasajeros().toString());
                txtpuertas.setText(camioneta.getNumeroPuertas().toString());
                txtmaletero.setText(camioneta.getCapacidadMaletero().toString());
                checkaire.setSelected(camioneta.getAireAcondicionado());
                checkcamara.setSelected(camioneta.getCamaraReversa());
                txtbolsas.setText(camioneta.getNumeroBolsasAire().toString());
                checkabs.setSelected(camioneta.getAbs());
                checkcrucerp.setSelected(camioneta.getVelocidadCrucero());
                checkcolision.setSelected(camioneta.getSensoresColision());
                checktrafico.setSelected(camioneta.getSensorTraficoCruzado());
                checktraccion.setSelected(camioneta.getTraccion4x4());
            }

            // Suv
            if (vehiculo instanceof SuvElectrico) {
                SuvElectrico suv = (SuvElectrico) vehiculo;
                txtpasajeros.setText(suv.getNumeroPasajeros().toString());
                txtpuertas.setText(suv.getNumeroPuertas().toString());
                txtmaletero.setText(suv.getCapacidadMaletero().toString());
                checkaire.setSelected(suv.getAireAcondicionado());
                checkcamara.setSelected(suv.getCamaraReversa());
                txtbolsas.setText(suv.getNumeroBolsasAire().toString());
                checkabs.setSelected(suv.getAbs());
                checkcrucerp.setSelected(suv.getVelocidadCrucero());
                checkcolision.setSelected(suv.getSensoresColision());
                checktrafico.setSelected(suv.getSensorTraficoCruzado());
                checktraccion.setSelected(suv.getTraccion4x4());
            }
            if (vehiculo instanceof SuvHibrido) {
                SuvHibrido suv = (SuvHibrido) vehiculo;
                txtpasajeros.setText(suv.getNumeroPasajeros().toString());
                txtpuertas.setText(suv.getNumeroPuertas().toString());
                txtmaletero.setText(suv.getCapacidadMaletero().toString());
                checkaire.setSelected(suv.getAireAcondicionado());
                checkcamara.setSelected(suv.getCamaraReversa());
                txtbolsas.setText(suv.getNumeroBolsasAire().toString());
                checkabs.setSelected(suv.getAbs());
                checkcrucerp.setSelected(suv.getVelocidadCrucero());
                checkcolision.setSelected(suv.getSensoresColision());
                checktrafico.setSelected(suv.getSensorTraficoCruzado());
                checktraccion.setSelected(suv.getTraccion4x4());
            }
            if (vehiculo instanceof SuvGasolina) {
                SuvGasolina suv = (SuvGasolina) vehiculo;
                txtpasajeros.setText(suv.getNumeroPasajeros().toString());
                txtpuertas.setText(suv.getNumeroPuertas().toString());
                txtmaletero.setText(suv.getCapacidadMaletero().toString());
                checkaire.setSelected(suv.getAireAcondicionado());
                checkcamara.setSelected(suv.getCamaraReversa());
                txtbolsas.setText(suv.getNumeroBolsasAire().toString());
                checkabs.setSelected(suv.getAbs());
                checkcrucerp.setSelected(suv.getVelocidadCrucero());
                checkcolision.setSelected(suv.getSensoresColision());
                checktrafico.setSelected(suv.getSensorTraficoCruzado());
                checktraccion.setSelected(suv.getTraccion4x4());
            }
            // Bus
            if (vehiculo instanceof BusElectrico) {
                BusElectrico bus = (BusElectrico) vehiculo;
                txtpasajeros.setText(bus.getNumeroPasajeros().toString());
                txtpuertas.setText(bus.getNumeroPuertas().toString());
                txtmaletero.setText(bus.getCapacidadMaletero().toString());
                checkaire.setSelected(bus.getAireAcondicionado());
                checkcamara.setSelected(bus.getCamaraReversa());
                txtbolsas.setText(bus.getNumeroBolsasAire().toString());
                checkabs.setSelected(bus.getAbs());
                txtejes.setText(bus.getNumeroEjes().toString());
                txtsalidas.setText(bus.getNumeroSalidasEmergencia().toString());
            }
            if (vehiculo instanceof BusHibrido) {
                BusHibrido bus = (BusHibrido) vehiculo;
                txtpasajeros.setText(bus.getNumeroPasajeros().toString());
                txtpuertas.setText(bus.getNumeroPuertas().toString());
                txtmaletero.setText(bus.getCapacidadMaletero().toString());
                checkaire.setSelected(bus.getAireAcondicionado());
                checkcamara.setSelected(bus.getCamaraReversa());
                txtbolsas.setText(bus.getNumeroBolsasAire().toString());
                checkabs.setSelected(bus.getAbs());
                txtejes.setText(bus.getNumeroEjes().toString());
                txtsalidas.setText(bus.getNumeroSalidasEmergencia().toString());
            }
            if (vehiculo instanceof BusGasolina) {
                BusGasolina bus = (BusGasolina) vehiculo;
                txtpasajeros.setText(bus.getNumeroPasajeros().toString());
                txtpuertas.setText(bus.getNumeroPuertas().toString());
                txtmaletero.setText(bus.getCapacidadMaletero().toString());
                checkaire.setSelected(bus.getAireAcondicionado());
                checkcamara.setSelected(bus.getCamaraReversa());
                txtbolsas.setText(bus.getNumeroBolsasAire().toString());
                checkabs.setSelected(bus.getAbs());
                txtejes.setText(bus.getNumeroEjes().toString());
                txtsalidas.setText(bus.getNumeroSalidasEmergencia().toString());
            }

            // Van
            if (vehiculo instanceof VanElectrico) {
                VanElectrico van = (VanElectrico) vehiculo;
                txtpasajeros.setText(van.getNumeroPasajeros().toString());
                txtpuertas.setText(van.getNumeroPuertas().toString());
                txtmaletero.setText(van.getCapacidadMaletero().toString());
                checkaire.setSelected(van.getAireAcondicionado());
                checkcamara.setSelected(van.getCamaraReversa());
                txtbolsas.setText(van.getNumeroBolsasAire().toString());
                checkabs.setSelected(van.getAbs());
            }
            if (vehiculo instanceof VanHibrido) {
                VanHibrido van = (VanHibrido) vehiculo;
                txtpasajeros.setText(van.getNumeroPasajeros().toString());
                txtpuertas.setText(van.getNumeroPuertas().toString());
                txtmaletero.setText(van.getCapacidadMaletero().toString());
                checkaire.setSelected(van.getAireAcondicionado());
                checkcamara.setSelected(van.getCamaraReversa());
                txtbolsas.setText(van.getNumeroBolsasAire().toString());
                checkabs.setSelected(van.getAbs());
            }
            if (vehiculo instanceof VanGasolina) {
                VanGasolina van = (VanGasolina) vehiculo;
                txtpasajeros.setText(van.getNumeroPasajeros().toString());
                txtpuertas.setText(van.getNumeroPuertas().toString());
                txtmaletero.setText(van.getCapacidadMaletero().toString());
                checkaire.setSelected(van.getAireAcondicionado());
                checkcamara.setSelected(van.getCamaraReversa());
                txtbolsas.setText(van.getNumeroBolsasAire().toString());
                checkabs.setSelected(van.getAbs());
            }

            // Sedan
            if (vehiculo instanceof SedanElectrico) {
                SedanElectrico sedan = (SedanElectrico) vehiculo;
                txtpasajeros.setText(sedan.getNumeroPasajeros().toString());
                txtpuertas.setText(sedan.getNumeroPuertas().toString());
                txtmaletero.setText(sedan.getCapacidadMaletero().toString());
                checkaire.setSelected(sedan.getAireAcondicionado());
                checkcamara.setSelected(sedan.getCamaraReversa());
                txtbolsas.setText(sedan.getNumeroBolsasAire().toString());
                checkabs.setSelected(sedan.getAbs());
                checkcrucerp.setSelected(sedan.getVelocidadCrucero());
                checkcolision.setSelected(sedan.getSensoresColision());
                checktrafico.setSelected(sedan.getSensorTraficoCruzado());
            }
            if (vehiculo instanceof SedanHibrido) {
                SedanHibrido sedan = (SedanHibrido) vehiculo;
                txtpasajeros.setText(sedan.getNumeroPasajeros().toString());
                txtpuertas.setText(sedan.getNumeroPuertas().toString());
                txtmaletero.setText(sedan.getCapacidadMaletero().toString());
                checkaire.setSelected(sedan.getAireAcondicionado());
                checkcamara.setSelected(sedan.getCamaraReversa());
                txtbolsas.setText(sedan.getNumeroBolsasAire().toString());
                checkabs.setSelected(sedan.getAbs());
                checkcrucerp.setSelected(sedan.getVelocidadCrucero());
                checkcolision.setSelected(sedan.getSensoresColision());
                checktrafico.setSelected(sedan.getSensorTraficoCruzado());
            }
            if (vehiculo instanceof SedanGasolina) {
                SedanGasolina sedan = (SedanGasolina) vehiculo;
                txtpasajeros.setText(sedan.getNumeroPasajeros().toString());
                txtpuertas.setText(sedan.getNumeroPuertas().toString());
                txtmaletero.setText(sedan.getCapacidadMaletero().toString());
                checkaire.setSelected(sedan.getAireAcondicionado());
                checkcamara.setSelected(sedan.getCamaraReversa());
                txtbolsas.setText(sedan.getNumeroBolsasAire().toString());
                checkabs.setSelected(sedan.getAbs());
                checkcrucerp.setSelected(sedan.getVelocidadCrucero());
                checkcolision.setSelected(sedan.getSensoresColision());
                checktrafico.setSelected(sedan.getSensorTraficoCruzado());
            }

        } else {
            Limpiarseleccion();
        }
    }

    private void initDataBinding() {
        // Tabla vehiculos
        columnid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdVehiculo()));
        columnmarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        colummodelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        columncambios
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCambios().toString()));
        columnvelocidad.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getVelocidadMaxima().toString()));
        columncilindraje.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getCilindraje().toString()));
        columntransmision.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getTransmision().toString()));
        columnestado
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        columntipomotor.setCellValueFactory(cellData -> {
            Vehiculo vehiculo = cellData.getValue();
            if (vehiculo instanceof VehiculoElectrico) {
                return new SimpleStringProperty("Eléctrico");
            } else if (vehiculo instanceof VehiculoHibrido) {
                return new SimpleStringProperty("Híbrido");
            } else if (vehiculo instanceof VehiculoGasolina) {
                return new SimpleStringProperty("Gasolina");
            } else if (vehiculo instanceof VehiculoDiesel) {
                return new SimpleStringProperty("Diésel");
            } else {
                return new SimpleStringProperty("");
            }
        });
        columnclasevehiculo.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
        comboboxestado.setItems(estado);
        comboboxtipomotor.setItems(tipomotor);
        comboboxtipovehiculo.setItems(tipovehiculo);
        comboboxtransmision.setItems(transmision);
    }

    private void ocultarCamposMotor() {
        txtautonomia.setVisible(false);
        txttiempocarga.setVisible(false);
        checkenchufable.setVisible(false);
        checkhibrido.setVisible(false);
    }

    private void ocultarCampos() {

        txtpasajeros.setVisible(false);
        txtpuertas.setVisible(false);
        txtbolsas.setVisible(false);
        txtcaballos.setVisible(false);
        txttiempo.setVisible(false);
        txtcarga.setVisible(false);
        checkaire.setVisible(false);
        checkfrenosaire.setVisible(false);
        checkabs.setVisible(false);
        txtejes.setVisible(false);
        txttipocamion.setVisible(false);
        checkcamara.setVisible(false);
        checktraccion.setVisible(false);
        txtcajacarga.setVisible(false);
        txtmaletero.setVisible(false);
        checkcrucerp.setVisible(false);
        checkcolision.setVisible(false);
        checktrafico.setVisible(false);
        checkasistente.setVisible(false);
        txtsalidas.setVisible(false);
    }

    private void VaciarCamposMotor() {
        txtautonomia.clear();
        txttiempocarga.clear();
        checkenchufable.setSelected(false);
        checkhibrido.setSelected(false);
    }

    private void Vaciarcampos() {

        txtpasajeros.clear();
        txtpuertas.clear();
        txtbolsas.clear();
        txtcaballos.clear();
        txttiempo.clear();
        txtcarga.clear();
        txtejes.clear();
        txttipocamion.clear();
        txtcajacarga.clear();
        txtmaletero.clear();
        txtsalidas.clear();

        checkaire.setSelected(false);
        checkfrenosaire.setSelected(false);
        checkabs.setSelected(false);
        checkcamara.setSelected(false);
        checktraccion.setSelected(false);
        checkcrucerp.setSelected(false);
        checkcolision.setSelected(false);
        checktrafico.setSelected(false);
        checkasistente.setSelected(false);
    }

    private void Limpiarseleccion() {
        VaciarCamposMotor();
        Vaciarcampos();
        tblvehiculos.getSelectionModel().clearSelection();
        txtid.clear();
        txtmarca.clear();
        txtmodelo.clear();
        txtcambios.clear();
        txtvelocidad.clear();
        txtcilindraje.clear();
        comboboxtransmision.setSelectionModel(null);
        comboboxestado.setSelectionModel(null);
        comboboxtipomotor.setSelectionModel(null);
        comboboxtipovehiculo.setSelectionModel(null);
    }

    public void mostrarmensaje(String titulo, String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public boolean ValidarDatos(String id, String marca, String modelo, String cambios, String velocidadMaxima,
            String cilindraje, Transmision transmision, Estado estado, String autonomia, String tiempoCarga,
            boolean enchufable, boolean hibridoligero, String numeropasajeros, String numeropuertas,
            String numerobolsas, String caballos, String tiempo0100, String carga,boolean aire,boolean frenosaire, boolean abs, String ejes,
            String tipocamion, boolean camara, boolean traccion, String cajacarga, String maletero, boolean crucero,
            boolean scolision, boolean strafico, boolean AsistenteP, String salidas) {
                if (id.isEmpty()||marca.isEmpty()||modelo.isEmpty()||cambios.isEmpty()||velocidadMaxima.isEmpty()||cilindraje.isEmpty()|| transmision == null|| estado == null||(numeropasajeros.isEmpty()|| numeropuertas.isEmpty()||numerobolsas.isEmpty()||caballos.isEmpty()||tiempo0100.isEmpty()) &&(carga.isEmpty()|| ejes.isEmpty() ||tipocamion.isEmpty())&& (numeropasajeros.isEmpty() ||numeropuertas.isEmpty()||numerobolsas.isEmpty()||cajacarga.isEmpty())&&(numeropasajeros.isEmpty()||numeropuertas.isEmpty()||maletero.isEmpty()||numerobolsas.isEmpty())&& (numeropasajeros.isEmpty()||numeropuertas.isEmpty()||maletero.isEmpty()||numerobolsas.isEmpty()||ejes.isEmpty()||salidas.isEmpty()))  {
                    mostrarmensaje("Error", "Llene todos los datos correctamente", AlertType.WARNING);
                    return false;
                }
                if (!velocidadMaxima.isEmpty()) {
                    try {
                        Float.parseFloat(velocidadMaxima);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico",
                                AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                        return false;
                    }
                }
                    if (!cilindraje.isEmpty()) {
                        try {
                            Float.parseFloat(cilindraje);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }        
                }
                if (!autonomia.isEmpty()) {
                    try {
                        Float.parseFloat(autonomia);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico",
                                AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                        return false;
                    }
                }
                    if (!tiempoCarga.isEmpty()) {
                        try {
                            Float.parseFloat(tiempoCarga);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }
                    }
                    if (!tiempo0100.isEmpty()) {
                        try {
                            Float.parseFloat(tiempo0100);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }
                    }
                    if (!carga.isEmpty()) {
                        try {
                            Float.parseFloat(carga);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }
                    }
                    if (!cajacarga.isEmpty()) {
                        try {
                            Float.parseFloat(cajacarga);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }
                    }
                    if (!maletero.isEmpty()) {
                        try {
                            Float.parseFloat(maletero);
                        } catch (NumberFormatException e) {
                            mostrarmensaje("Error",  "El valor debe ser númerico",
                                    AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                            return false;
                        }
                    }
                if (!cambios.isEmpty()) {
                    try {
                        Integer.parseInt(cambios);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!ejes.isEmpty()) {
                    try {
                        Integer.parseInt(ejes);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!salidas.isEmpty()) {
                    try {
                        Integer.parseInt(salidas);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!numeropasajeros.isEmpty()) {
                    try {
                        Integer.parseInt(numeropasajeros);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!numeropuertas.isEmpty()) {
                    try {
                        Integer.parseInt(numeropuertas);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!numerobolsas.isEmpty()) {
                    try {
                        Integer.parseInt(numerobolsas);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                if (!caballos.isEmpty()) {
                    try {
                        Integer.parseInt(caballos);
                    } catch (NumberFormatException e) {
                        mostrarmensaje("Error",  "El valor debe ser númerico", AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    }
                }
                
                return true;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboboxtipovehiculo != null
                : "fx:id=\"comboboxtipovehiculo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert comboboxtransmision != null
                : "fx:id=\"comboboxtransmision\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkhibrido != null
                : "fx:id=\"checkhibrido\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtsalidas != null
                : "fx:id=\"txtsalidas\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert comboboxtipomotor != null
                : "fx:id=\"comboboxtipomotor\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checktrafico != null
                : "fx:id=\"checktrafico\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columntransmision != null
                : "fx:id=\"columntransmision\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert btnregresar != null
                : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columntipomotor != null
                : "fx:id=\"columntipomotor\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtpuertas != null
                : "fx:id=\"txtpuertas\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtid != null : "fx:id=\"txtid\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txttipocamion != null
                : "fx:id=\"txttipocamion\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtpasajeros != null
                : "fx:id=\"txtpasajeros\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert colummodelo != null
                : "fx:id=\"colummodelo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkenchufable != null
                : "fx:id=\"checkenchufable\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkfrenosaire != null
                : "fx:id=\"checkfrenosaire\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkaire != null
                : "fx:id=\"checkaire\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkcrucerp != null
                : "fx:id=\"checkcrucerp\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checktraccion != null
                : "fx:id=\"checktraccion\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert btnActualizarVehiculo != null
                : "fx:id=\"btnActualizarVehiculo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columnid != null
                : "fx:id=\"columnid\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkcamara != null
                : "fx:id=\"checkcamara\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtejes != null
                : "fx:id=\"txtejes\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtvelocidad != null
                : "fx:id=\"txtvelocidad\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtcarga != null
                : "fx:id=\"txtcarga\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columnclasevehiculo != null
                : "fx:id=\"columnclasevehiculo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columncambios != null
                : "fx:id=\"columncambios\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txttiempo != null
                : "fx:id=\"txttiempo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtcaballos != null
                : "fx:id=\"txtcaballos\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtmaletero != null
                : "fx:id=\"txtmaletero\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtmarca != null
                : "fx:id=\"txtmarca\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtbolsas != null
                : "fx:id=\"txtbolsas\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columnmarca != null
                : "fx:id=\"columnmarca\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columncilindraje != null
                : "fx:id=\"columncilindraje\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columnvelocidad != null
                : "fx:id=\"columnvelocidad\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert comboboxestado != null
                : "fx:id=\"comboboxestado\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtcilindraje != null
                : "fx:id=\"txtcilindraje\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkcolision != null
                : "fx:id=\"checkcolision\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkasistente != null
                : "fx:id=\"checkasistente\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtcambios != null
                : "fx:id=\"txtcambios\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert columnestado != null
                : "fx:id=\"columnestado\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txttiempocarga != null
                : "fx:id=\"txttiempocarga\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert btnEliminarVehiculo != null
                : "fx:id=\"btnEliminarVehiculo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert checkabs != null
                : "fx:id=\"checkabs\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtautonomia != null
                : "fx:id=\"txtautonomia\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert tblvehiculos != null
                : "fx:id=\"tblvehiculos\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtcajacarga != null
                : "fx:id=\"txtcajacarga\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert btnAgregarvehiculo != null
                : "fx:id=\"btnAgregarvehiculo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";
        assert txtmodelo != null
                : "fx:id=\"txtmodelo\" was not injected: check your FXML file 'GestionarVehiculosView.fxml'.";

    }
}
