package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Empleado extends Persona {
    private String idEmpleado;
    private LinkedList<Empleado> listaEmpleados = new LinkedList<>();

    public Empleado (String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idEmpleado){
        super (nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
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
        return "Empleado [idEmpleado=" + idEmpleado + ", getNombre()=" + getNombre() + ", getCedula()=" + getCedula() + ", getCorreo()=" + getCorreo() + ", getTelefono()=" + getTelefono() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getUsuario()=" + getUsuario() + ", getContraseña()=" + getContraseña() + ", getPreguntaSeguridad()=" + getPreguntaSeguridad() + ", getFraseSeguridad()=" + getFraseSeguridad() + "]";
    }

    public String crear(Empleado nuevoEmpleado) {
        if (buscar(nuevoEmpleado.getIdEmpleado()) != null) {
            return "\nEl empleado ya está registrado.";
        }
        listaEmpleados.add(nuevoEmpleado);
        return "\nEmpleado agregado exitosamente.";
    }

    public LinkedList<Empleado> obtener() {
        return listaEmpleados;
    }

    public Empleado buscar(String idEmpleado) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getIdEmpleado().equals(idEmpleado)) {
                return empleado;
            }
        }
        return null;
    }

    public String actualizar(String idEmpleado, String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad) {
        Empleado empleado = buscar(idEmpleado);
        if (empleado != null) {
            empleado.setNombre(nombre);
            empleado.setCedula(cedula);
            empleado.setCorreo(correo);
            empleado.setTelefono(telefono);
            empleado.setFechaNacimiento(fechaNacimiento);
            empleado.setUsuario(usuario);
            empleado.setContraseña(contraseña);
            empleado.setPreguntaSeguridad(preguntaSeguridad);
            empleado.setFraseSeguridad(fraseSeguridad);
            return "\nInformación del empleado actualizada correctamente.";
        }
        return "\nEl empleado no se encuentra registrado.";
    }

    public String eliminar(String idEmpleado) {
        Empleado empleado = buscar(idEmpleado);
        if (empleado != null) {
            listaEmpleados.remove(empleado);
            return "\nEl empleado ha sido eliminado correctamente.";
        }
        return "\nEl empleado no existe.";
    }
}