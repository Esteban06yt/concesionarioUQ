package co.edu.uniquindio.poo.Controller;

import java.util.LinkedList;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Vehiculo;

public class VehiculoController {

    Concesionario concesionario;

    public VehiculoController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public LinkedList<Vehiculo> Obtenerlistavehiculos(){
        return concesionario.getListavehiculos();
    }

    public LinkedList<Vehiculo> ObtenerVehiculosEmpleado(Empleado empleado){
        return empleado.getListavehiculos();
    }

    public String AgregarVehiculo(Vehiculo vehiculo){
        return concesionario.AgregarVehiculo(vehiculo);
    }

    public String EliminarVehiculo(Vehiculo vehiculo){
        return concesionario.EliminarVehiculo(vehiculo);
    }

    public String ActualizarVehiculo(Vehiculo vehiculo, Vehiculo vehiculoact){
        return concesionario.ActualizarVehiculo(vehiculo, vehiculoact);
    }

}
