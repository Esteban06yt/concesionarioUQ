package co.edu.uniquindio.poo.Controller;

import java.util.LinkedList;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Persona;

public class Personacontroller {
    Concesionario concesionario;

    public Personacontroller(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public LinkedList<Persona> obtenerlistapersonas(){
        return concesionario.getListapersonas();
    }

    public LinkedList<Empleado> ObtenerEmpleadosAdmin(Administrador administrador){
        return administrador.getListaempleados();
    }
    public LinkedList<Cliente> ObtenerClientesEmpleado(Empleado empleado){
        return empleado.getListaclientes();
    }
    public String Agregarpersona(Persona persona){
        return concesionario.AgregarPersona(persona);
    }

    public String EliminarPersona(Persona persona){
        return concesionario.EliminarPersona(persona);
    }

    public String ActualizarPersona(Persona persona, Persona personaact){
        return concesionario.ActualizarPersona(persona, personaact);
    }
}