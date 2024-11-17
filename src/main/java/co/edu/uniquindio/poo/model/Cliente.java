package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Cliente extends Persona {

    private LinkedList<Transaccion> listatransacciones;

    public Cliente(String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad) {
        super(nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad, fraseSeguridad);
        listatransacciones = new LinkedList<>();
    }

    public LinkedList<Transaccion> getListatransacciones() {
        return listatransacciones;
    }
    public void setListatransacciones(LinkedList<Transaccion> listatransacciones) {
        this.listatransacciones = listatransacciones;
    }

    /**
     * Agrega una transacción si esta no existe
     *
     * @param transaccion
     * @return mensaje indicando si fue añadida o ya existe
     * @throws IllegalArgumentException
     */
    public String AgregarTransaccion(Transaccion transaccion) throws IllegalArgumentException {
        String respuesta = "La transaccion se añadió correctamente";
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        Transaccion transaccionaux = BuscarTransaccion(transaccion.getIdtransaccion());
        if (transaccionaux == null) {
            listatransacciones.add(transaccion);
        } else {
            respuesta = "Esta transaccion ya existe";
        }
        return respuesta;
    }

    /**
     * Busca una transaccion mediante su id en la lista de transacciones
     *
     * @param id
     * @return la transaccion si es encontrada o null en caso contrario
     */
    public Transaccion BuscarTransaccion(String id) {
        return listatransacciones.stream().filter(transaccionaux -> transaccionaux.getIdtransaccion().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * Elimina una transacción siempre y cuando esta exista en la lista
     *
     * @param transaccion
     * @return un mensaje indicando si fue eliminada o no existe
     * @throws IllegalArgumentException
     */
    public String EliminarTransaccion(Transaccion transaccion) throws IllegalArgumentException {
        String respuesta = "La transaccion se eliminó correctamente";
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        Transaccion transaccionaux = BuscarTransaccion(transaccion.getIdtransaccion());
        if (transaccionaux != null) {
            listatransacciones.remove(transaccion);
        } else {
            respuesta = "Esta transaccion no existe";
        }
        return respuesta;
    }

    /**
     * Actualiza una transacción de la lista eliminandola y añadiendo la version
     * actualizada siempre y cuando esta exista
     *
     * @param transaccion
     * @param transaccionactualizada
     * @return un mensaje indicando si se puedo actualizar o no existe
     */
    public String ActualizarTransaccion(Transaccion transaccion, Transaccion transaccionactualizada) {
        String respuesta = "La transacción ha sido actualizada";

        if (transaccion == null || transaccionactualizada == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        Transaccion transaccionaux = BuscarTransaccion(transaccion.getIdtransaccion());
        if (transaccionaux != null) {
            listatransacciones.remove(transaccion);
            listatransacciones.add(transaccionactualizada);
        } else {
            respuesta = "Esta transaccion no existe";
        }
        return respuesta;
    }
}