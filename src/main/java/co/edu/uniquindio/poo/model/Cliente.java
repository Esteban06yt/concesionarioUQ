package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Cliente extends Persona {
    private LinkedList<Cliente> listaClientes = new LinkedList<>();

    public Cliente (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad){
        super(nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
    }

    @Override
    public String toString() {
        return "Cliente [getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }

    public String crear(Cliente nuevoCliente) {
        if (buscar(nuevoCliente.getCedula()) != null) {
            return "\nEl cliente ya está registrado.";
        }
        listaClientes.add(nuevoCliente);
        return "\nCliente agregado exitosamente.";
    }

    public LinkedList<Cliente> obtener() {
        return listaClientes;
    }

    public Cliente buscar(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public String actualizar(String cedula, String nombre, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad) {
        Cliente cliente = buscar(cedula);
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setUsuario(usuario);
            cliente.setContraseña(contraseña);
            cliente.setPreguntaSeguridad(preguntaSeguridad);
            cliente.setFraseSeguridad(fraseSeguridad);
            return "\nInformación del cliente actualizada correctamente.";
        }
        return "\nEl cliente no se encuentra registrado.";
    }

    public String eliminar(String cedula) {
        Cliente cliente = buscar(cedula);
        if (cliente != null) {
            listaClientes.remove(cliente);
            return "\nEl cliente ha sido eliminado correctamente.";
        }
        return "\nEl cliente no existe.";
    }
}