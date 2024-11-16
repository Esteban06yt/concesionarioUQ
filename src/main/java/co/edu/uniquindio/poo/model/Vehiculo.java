package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String idVehiculo;
    private String marca;
    private String modelo;
    private Integer cambios;
    private Float velocidadMaxima;
    private Float cilindraje;
    private Transmision transmision;
    private Estado estado;

    public Vehiculo (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.cambios = cambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.transmision = transmision;
        this.estado = estado;
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
}