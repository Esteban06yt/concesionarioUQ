package co.edu.uniquindio.poo.Controller;

import java.util.LinkedList;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Transaccion;

public class TransaccionController {
    Concesionario concesionario;

    public TransaccionController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public LinkedList<Transaccion> ObtenerTransaccionesCliente(Cliente cliente){
        return cliente.getListatransacciones();
    }
    public LinkedList<Transaccion> ObtenerTransaccionesEmpleado(Empleado empleado){
        return empleado.getListatransacciones();
    }
    public String AgregarTransaccion(Transaccion transaccion){
        return concesionario.AgregarTransaccion(transaccion);
    }
    public String EliminarTransaccion(Transaccion transaccion){
        return concesionario.EliminarTransaccion(transaccion);
    }
    public String ActualizarTransaccion(Transaccion transaccion, Transaccion transaccionact){
        return concesionario.ActualizarTransaccion(transaccion, transaccionact);
    }
}
