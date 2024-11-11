package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public abstract class VehiculoConfort extends Vehiculo {
    private Integer numeroPasajeros;
    private Integer numeroPuertas;
    private Float capacidadMaletero;
    private Boolean aireAcondicionado;
    private Boolean camaraReversa;
    private Integer numeroBolsasAire;
    private Boolean abs;

    public VehiculoConfort (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.capacidadMaletero = capacidadMaletero;
        this.aireAcondicionado = aireAcondicionado;
        this.camaraReversa = camaraReversa;
        this.numeroBolsasAire = numeroBolsasAire;
        this.abs = abs;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }
    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Integer getNumeroPuertas() {
        return numeroPuertas;
    }
    public void setNumeroPuertas(Integer numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public Float getCapacidadMaletero() {
        return capacidadMaletero;
    }
    public void setCapacidadMaletero(Float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }
    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getCamaraReversa() {
        return camaraReversa;
    }
    public void setCamaraReversa(Boolean camaraReversa) {
        this.camaraReversa = camaraReversa;
    }

    public Integer getNumeroBolsasAire() {
        return numeroBolsasAire;
    }
    public void setNumeroBolsasAire(Integer numeroBolsasAire) {
        this.numeroBolsasAire = numeroBolsasAire;
    }

    public Boolean getAbs() {
        return abs;
    }
    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    @Override
    public String toString() {
        return "VehiculoConfort [numeroPasajeros=" + numeroPasajeros + ", numeroPuertas=" + numeroPuertas + ", capacidadMaletero=" + capacidadMaletero + ", aireAcondicionado=" + aireAcondicionado + ", camaraReversa=" + camaraReversa + ", numeroBolsasAire=" + numeroBolsasAire + ", abs=" + abs + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }
}