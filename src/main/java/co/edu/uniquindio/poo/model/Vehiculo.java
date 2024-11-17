package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public abstract class Vehiculo {

    private String idVehiculo;
    private String marca;
    private String modelo;
    private Integer cambios;
    private Float velocidadMaxima;
    private Float cilindraje;
    private Transmision transmision;
    private Estado estado;
    private LinkedList<Transaccion> listatransacciones;

    public Vehiculo(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.cambios = cambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.transmision = transmision;
        this.estado = estado;
        listatransacciones = new LinkedList<>();
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }
    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCambios() {
        return cambios;
    }
    public void setCambios(Integer cambios) {
        this.cambios = cambios;
    }

    public Float getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public void setVelocidadMaxima(Float velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Float getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(Float cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Transmision getTransmision() {
        return transmision;
    }
    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVehiculo == null) ? 0 : idVehiculo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (idVehiculo == null) {
            if (other.idVehiculo != null)
                return false;
        } else if (!idVehiculo.equals(other.idVehiculo))
            return false;
        return true;
    }
}