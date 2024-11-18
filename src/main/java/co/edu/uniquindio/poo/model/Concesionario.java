package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Concesionario {

    private String nombre;
    private LinkedList<Transaccion> listatransacciones;
    private LinkedList<Persona> listapersonas;
    private LinkedList<Vehiculo> listavehiculos;

    public Concesionario(String nombre) {
        this.nombre = nombre;
        listatransacciones = new LinkedList<>();
        listapersonas = new LinkedList<>();
        listavehiculos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Transaccion> getListatransacciones() {
        return listatransacciones;
    }
    public void setListatransacciones(LinkedList<Transaccion> listatransacciones) {
        this.listatransacciones = listatransacciones;
    }

    public LinkedList<Persona> getListapersonas() {
        return listapersonas;
    }
    public void setListapersonas(LinkedList<Persona> listapersonas) {
        this.listapersonas = listapersonas;
    }

    public LinkedList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }
    public void setListavehiculoss(LinkedList<Vehiculo> listavehiculos) {
        this.listavehiculos = listavehiculos;
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
            transaccion.getCliente().EliminarTransaccion(transaccion);
            transaccion.getEmpleado().EliminarTransaccion(transaccion);
            transaccion.getVehiculo().EliminarTransaccion(transaccion);
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
     * @throws IllegalArgumentException
     */
    public String ActualizarTransaccion(Transaccion transaccion, Transaccion transaccionactualizada)
            throws IllegalArgumentException {
        String respuesta = "La transacción ha sido actualizada";

        if (transaccion == null || transaccionactualizada == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        Transaccion transaccionaux = BuscarTransaccion(transaccion.getIdtransaccion());
        if (transaccionaux != null) {
            listatransacciones.remove(transaccion);
            listatransacciones.add(transaccionactualizada);
            transaccion.getCliente().ActualizarTransaccion(transaccionaux, transaccionactualizada);
            transaccion.getVehiculo().ActualizarTransaccion(transaccionaux, transaccionactualizada);
            transaccion.getEmpleado().ActualizarTransaccion(transaccionaux, transaccionactualizada);
        } else {
            respuesta = "Esta transaccion no existe";
        }
        return respuesta;
    }

    /**
     * Agrega una persona si esta no existe
     *
     * @param persona
     * @return mensaje indicando si fue añadida o ya existe
     * @throws IllegalArgumentException
     */
    public String AgregarPersona(Persona persona) throws IllegalArgumentException {
        String respuesta = "La persona se añadió correctamente";
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        Persona personaAux = BuscarPersona(persona.getCedula());
        if (personaAux == null) {
            listapersonas.add(persona);
        } else {
            respuesta = "Esta persona ya existe";
        }
        return respuesta;
    }

    /**
     * Busca una persona mediante su cédula en la lista de personas
     *
     * @param cedula
     * @return la persona si es encontrada o null en caso contrario
     */
    public Persona BuscarPersona(String cedula) {
        return listapersonas.stream()
                .filter(personaAux -> personaAux.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    /**
     * Elimina una persona siempre y cuando esta exista en la lista
     *
     * @param persona
     * @return un mensaje indicando si fue eliminada o no existe
     * @throws IllegalArgumentException
     */
    public String EliminarPersona(Persona persona) throws IllegalArgumentException {
        String respuesta = "La persona se eliminó correctamente";
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        Persona personaAux = BuscarPersona(persona.getCedula());
        if (personaAux != null) {
            listapersonas.remove(persona);
        } else {
            respuesta = "Esta persona no existe";
        }
        return respuesta;
    }

    /**
     * Actualiza una persona de la lista eliminándola y añadiendo la versión
     * actualizada siempre y cuando esta exista
     *
     * @param persona
     * @param personaActualizada
     * @return un mensaje indicando si se pudo actualizar o no existe
     * @throws IllegalArgumentException
     */
    public String ActualizarPersona(Persona persona, Persona personaActualizada) throws IllegalArgumentException {
        String respuesta = "La persona ha sido actualizada";

        if (persona == null || personaActualizada == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        Persona personaAux = BuscarPersona(persona.getCedula());
        if (personaAux != null) {
            listapersonas.remove(persona);
            listapersonas.add(personaActualizada);
        } else {
            respuesta = "Esta persona no existe";
        }
        return respuesta;
    }

    /**
     * Agrega un vehículo si este no existe
     *
     * @param vehiculo
     * @return mensaje indicando si fue añadido o ya existe
     * @throws IllegalArgumentException
     */
    public String AgregarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        String respuesta = "El vehículo se añadió correctamente";
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        Vehiculo vehiculoAux = BuscarVehiculo(vehiculo.getIdVehiculo());
        if (vehiculoAux == null) {
            listavehiculos.add(vehiculo);
        } else {
            respuesta = "Este vehículo ya existe";
        }
        return respuesta;
    }

    /**
     * Busca un vehículo mediante su ID en la lista de vehículos
     *
     * @param idvehiculo
     * @return el vehículo si es encontrado o null en caso contrario
     */
    public Vehiculo BuscarVehiculo(String idvehiculo) {
        return listavehiculos.stream()
                .filter(vehiculoAux -> vehiculoAux.getIdVehiculo().equals(idvehiculo))
                .findFirst()
                .orElse(null);
    }

    /**
     * Elimina un vehículo siempre y cuando este exista en la lista
     *
     * @param vehiculo
     * @return un mensaje indicando si fue eliminado o no existe
     * @throws IllegalArgumentException
     */
    public String EliminarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        String respuesta = "El vehículo se eliminó correctamente";
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        Vehiculo vehiculoAux = BuscarVehiculo(vehiculo.getIdVehiculo());
        if (vehiculoAux != null) {
            listavehiculos.remove(vehiculo);
        } else {
            respuesta = "Este vehículo no existe";
        }
        return respuesta;
    }

    /**
     * Actualiza un vehículo de la lista eliminándolo y añadiendo la versión
     * actualizada siempre y cuando este exista
     *
     * @param vehiculo
     * @param vehiculoActualizado
     * @return un mensaje indicando si se pudo actualizar o no existe
     * @throws IllegalArgumentException
     */
    public String ActualizarVehiculo(Vehiculo vehiculo, Vehiculo vehiculoActualizado) throws IllegalArgumentException {
        String respuesta = "El vehículo ha sido actualizado";

        if (vehiculo == null || vehiculoActualizado == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        Vehiculo vehiculoAux = BuscarVehiculo(vehiculo.getIdVehiculo());
        if (vehiculoAux != null) {
            listavehiculos.remove(vehiculo);
            listavehiculos.add(vehiculoActualizado);
        } else {
            respuesta = "Este vehículo no existe";
        }
        return respuesta;
    }

    public boolean Login(String correo, String contraseña){
        for (Persona persona : listapersonas) {
            if (persona.getCorreo().equals(correo) && persona.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }
}