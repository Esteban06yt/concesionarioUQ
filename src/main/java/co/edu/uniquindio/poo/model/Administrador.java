package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Administrador extends Persona{
    private String idAdministrador;

    public Administrador (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacmiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idAdministrador){
        super (nombre, cedula, correo, telefono, fechaNacmiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
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
        return "Administrador [idAdministrador=" + idAdministrador + ", getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacmiento()=" + getFechaNacmiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }
}