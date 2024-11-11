package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Camion extends Vehiculo {
    private Float capacidadCarga;
    private Boolean aireAcondicionado;
    private Boolean frenosAire;
    private Boolean abs;
    private Integer numeroEjes;
    private String tipoCamion;

    public Camion (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Float capacidadCarga, Boolean aireAcondicionado, Boolean frenosAire, Boolean abs, Integer numeroEjes, String tipoCamion) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
        this.capacidadCarga = capacidadCarga;
        this.aireAcondicionado = aireAcondicionado;
        this.frenosAire = frenosAire;
        this.abs = abs;
        this.numeroEjes = numeroEjes;
        this.tipoCamion = tipoCamion;
    }

    public Float getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(Float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }
    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getFrenosAire() {
        return frenosAire;
    }
    public void setFrenosAire(Boolean frenosAire) {
        this.frenosAire = frenosAire;
    }

    public Boolean getAbs() {
        return abs;
    }
    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    public Integer getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(Integer numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }
    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    @Override
    public String toString() {
        return "Camion [capacidadCarga=" + capacidadCarga + ", aireAcondicionado=" + aireAcondicionado + ", frenosAire=" + frenosAire + ", abs=" + abs + ", numeroEjes=" + numeroEjes + ", tipoCamion=" + tipoCamion + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }
}