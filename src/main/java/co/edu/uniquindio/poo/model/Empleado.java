package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Empleado extends Persona {

    private String idEmpleado;
    private LinkedList<Transaccion> listatransacciones;
    private LinkedList<Vehiculo> listavehiculos;
    private LinkedList<Cliente> listaclientes;

    public Empleado(String nombre, String cedula, String correo, String telefono, LocalDate fechaNacimiento,
            String usuario, String contraseña, String preguntaSeguridad, String fraseSeguridad, String idEmpleado) {
        super(nombre, cedula, correo, telefono, fechaNacimiento, usuario, contraseña, preguntaSeguridad,
                fraseSeguridad);
        this.idEmpleado = idEmpleado;
        listatransacciones = new LinkedList<>();
        listavehiculos = new LinkedList<>();
        listaclientes = new LinkedList<>();
    }

    public LinkedList<Cliente> getListaclientes() {
        return listaclientes;
    }
    public void setListaclientes(LinkedList<Cliente> listaclientes) {
        this.listaclientes = listaclientes;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LinkedList<Transaccion> getListatransacciones() {
        return listatransacciones;
    }
    public void setListatransacciones(LinkedList<Transaccion> listatransacciones) {
        this.listatransacciones = listatransacciones;
    }

    public LinkedList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }
    public void setListavehiculos(LinkedList<Vehiculo> listavehiculos) {
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

    /**
     * Agrega un cliente si este no existe
     *
     * @param cliente
     * @return mensaje indicando si fue añadido o ya existe
     * @throws IllegalArgumentException
     */
    public String AgregarCliente(Cliente cliente) throws IllegalArgumentException {
        String respuesta = "El cliente se añadió correctamente";
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        Cliente clienteAux = BuscarCliente(cliente.getCedula());
        if (clienteAux == null) {
            listaclientes.add(cliente);
        } else {
            respuesta = "Este cliente ya existe";
        }
        return respuesta;
    }

    /**
     * Busca un cliente mediante su cédula en la lista de clientes
     *
     * @param cedula
     * @return el cliente si es encontrado o null en caso contrario
     */
    public Cliente BuscarCliente(String cedula) {
        return listaclientes.stream()
                .filter(clienteAux -> clienteAux.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    /**
     * Elimina un cliente siempre y cuando este exista en la lista
     *
     * @param cliente
     * @return un mensaje indicando si fue eliminado o no existe
     * @throws IllegalArgumentException
     */
    public String EliminarCliente(Cliente cliente) throws IllegalArgumentException {
        String respuesta = "El cliente se eliminó correctamente";
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        Cliente clienteAux = BuscarCliente(cliente.getCedula());
        if (clienteAux != null) {
            listaclientes.remove(cliente);
        } else {
            respuesta = "Este cliente no existe";
        }
        return respuesta;
    }

    /**
     * Actualiza un cliente de la lista eliminándolo y añadiendo la versión
     * actualizada siempre y cuando este exista
     *
     * @param cliente
     * @param clienteActualizado
     * @return un mensaje indicando si se pudo actualizar o no existe
     * @throws IllegalArgumentException
     */
    public String ActualizarCliente(Cliente cliente, Cliente clienteActualizado) throws IllegalArgumentException {
        String respuesta = "El cliente ha sido actualizado";

        if (cliente == null || clienteActualizado == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        Cliente clienteAux = BuscarCliente(cliente.getCedula());
        if (clienteAux != null) {
            listaclientes.remove(cliente);
            listaclientes.add(clienteActualizado);
        } else {
            respuesta = "Este cliente no existe";
        }
        return respuesta;
    }
}