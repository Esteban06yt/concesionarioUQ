package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Administrador extends Persona{
    private String idAdministrador;
    private LinkedList<Administrador> listaAdministradores = new LinkedList<>();

    public Administrador (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idAdministrador){
        super (nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador [idAdministrador=" + idAdministrador + ", getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }

    public String crear(Administrador nuevoAdministrador) {
        if (buscar(nuevoAdministrador.getIdAdministrador()) != null) {
            return "\nEl administrador ya está registrado.";
        }
        listaAdministradores.add(nuevoAdministrador);
        return "\nAdministrador agregado exitosamente.";
    }

    public LinkedList<Administrador> obtener() {
        return listaAdministradores;
    }

    public Administrador buscar(String idAdministrador) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getIdAdministrador().equals(idAdministrador)) {
                return administrador;
            }
        }
        return null;
    }

    public String actualizar(String idAdministrador, String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad) {
        Administrador administrador = buscar(idAdministrador);
        if (administrador != null) {
            administrador.setNombre(nombre);
            administrador.setCedula(cedula);
            administrador.setCorreo(correo);
            administrador.setTelefono(telefono);
            administrador.setFechaNacimiento(fechaNacimiento);
            administrador.setUsuario(usuario);
            administrador.setContraseña(contraseña);
            administrador.setPreguntaSeguridad(preguntaSeguridad);
            administrador.setFraseSeguridad(fraseSeguridad);
            return "\nInformación del administrador actualizada correctamente.";
        }
        return "\nEl administrador no se encuentra registrado.";
    }

    public String eliminar(String idAdministrador) {
        Administrador administrador = buscar(idAdministrador);
        if (administrador != null) {
            listaAdministradores.remove(administrador);
            return "\nEl administrador ha sido eliminado correctamente.";
        }
        return "\nEl administrador no existe.";
    }
}