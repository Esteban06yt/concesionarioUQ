package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private Integer cambios;
    private Float velocidadMaxima;
    private Float cilindraje;
    private Image foto;
    private Transmision transmision;
    private Estado estado;
    private Combustible combustible;

    public Vehiculo (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.cambios = cambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.foto = foto;
        this.transmision = transmision;
        this.estado = estado;
        this.combustible = combustible;
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

    public Image getFoto() {
        return foto;
    }
    public void setFoto(Image foto) {
        this.foto = foto;
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

    public Combustible getCombustible() {
        return combustible;
    }
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", cambios=" + cambios + ", velocidadMaxima=" + velocidadMaxima + ", cilindraje=" + cilindraje + ", foto=" + foto + ", transmision=" + transmision + ", estado=" + estado + ", combustible=" + combustible + "]";
    }
}