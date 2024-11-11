package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Cliente extends Persona {

    public Cliente (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacmiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad){
        super(nombre, cedula, correo, telefono, fechaNacmiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
    }

    @Override
    public String toString() {
        return "Cliente [getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacmiento()=" + getFechaNacmiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }
}