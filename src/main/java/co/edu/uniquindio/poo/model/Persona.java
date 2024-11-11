package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String cedula;
    private String correo;
    private String telefono;
    private LocalDate fechaNacmiento;
    private String usuario;
    private String contraseña;
    private String preguntaSeguridad;
    private String fraseSeguridad;

    public Persona (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacmiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacmiento = fechaNacmiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.preguntaSeguridad = preguntaSeguridad;
        this.fraseSeguridad = fraseSeguridad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacmiento() {
        return fechaNacmiento;
    }
    public void setFechaNacmiento(LocalDate fechaNacmiento) {
        this.fechaNacmiento = fechaNacmiento;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }
    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    public String getFraseSeguridad() {
        return fraseSeguridad;
    }
    public void setFraseSeguridad(String fraseSeguridad) {
        this.fraseSeguridad = fraseSeguridad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", telefono=" + telefono + ", fechaNacmiento=" + fechaNacmiento + ", usuario=" + usuario + ", contraseña=" + contraseña + ", preguntaSeguridad=" + preguntaSeguridad + ", fraseSeguridad=" + fraseSeguridad + "]";
    }
}