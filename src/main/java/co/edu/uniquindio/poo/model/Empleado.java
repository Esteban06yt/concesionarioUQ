package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Empleado extends Persona {
    private String idEmpleado;

    public Empleado (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacmiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idEmpleado){
        super (nombre, cedula, correo, telefono, fechaNacmiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacmiento()=" + getFechaNacmiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }
}