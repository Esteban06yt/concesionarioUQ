package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Administrador extends Persona {

    private String idAdministrador;
    private LinkedList<Empleado> listaempleados;

    public Administrador(String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idAdministrador) {
        super(nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
        this.idAdministrador = idAdministrador;
        listaempleados = new LinkedList<>();
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public LinkedList<Empleado> getListaempleados() {
        return listaempleados;
    }
    public void setListaempleados(LinkedList<Empleado> listaempleados) {
        this.listaempleados = listaempleados;
    }

    /**
     * Agrega un empleado si este no existe
     *
     * @param empleado
     * @return mensaje indicando si fue añadido o ya existe
     * @throws IllegalArgumentException
     */
    public String AgregarEmpleado(Empleado empleado) throws IllegalArgumentException {
        String respuesta = "El empleado se añadió correctamente";
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        Empleado empleadoAux = BuscarEmpleado(empleado.getCedula());
        if (empleadoAux == null) {
            listaempleados.add(empleado);
        } else {
            respuesta = "Este empleado ya existe";
        }
        return respuesta;
    }

    /**
     * Busca un empleado mediante su cédula en la lista de empleados
     *
     * @param cedula
     * @return el empleado si es encontrado o null en caso contrario
     */
    public Empleado BuscarEmpleado(String cedula) {
        return listaempleados.stream()
                .filter(empleadoAux -> empleadoAux.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    /**
     * Elimina un empleado siempre y cuando este exista en la lista
     *
     * @param empleado
     * @return un mensaje indicando si fue eliminado o no existe
     * @throws IllegalArgumentException
     */
    public String EliminarEmpleado(Empleado empleado) throws IllegalArgumentException {
        String respuesta = "El empleado se eliminó correctamente";
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        Empleado empleadoAux = BuscarEmpleado(empleado.getCedula());
        if (empleadoAux != null) {
            listaempleados.remove(empleado);
        } else {
            respuesta = "Este empleado no existe";
        }
        return respuesta;
    }

    /**
     * Actualiza un empleado de la lista eliminándolo y añadiendo la versión
     * actualizada siempre y cuando este exista
     *
     * @param empleado
     * @param empleadoActualizado
     * @return un mensaje indicando si se pudo actualizar o no existe
     * @throws IllegalArgumentException
     */
    public String ActualizarEmpleado(Empleado empleado, Empleado empleadoActualizado) throws IllegalArgumentException {
        String respuesta = "El empleado ha sido actualizado";

        if (empleado == null || empleadoActualizado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        Empleado empleadoAux = BuscarEmpleado(empleado.getCedula());
        if (empleadoAux != null) {
            listaempleados.remove(empleado);
            listaempleados.add(empleadoActualizado);
        } else {
            respuesta = "Este empleado no existe";
        }
        return respuesta;
    }
}