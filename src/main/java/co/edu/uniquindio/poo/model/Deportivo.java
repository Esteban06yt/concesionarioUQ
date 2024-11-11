package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Deportivo extends Vehiculo {
    private Integer numeroPasajeros;
    private Integer numeroPuertas;
    private Integer numeroBolsasAire;
    private Integer caballosFuerza;
    private Float tiempoCienKmh;

    public Deportivo (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Integer numeroBolsasAire, Integer caballosFuerza, Float tiempoCienKmh) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.numeroBolsasAire = numeroBolsasAire;
        this.caballosFuerza = caballosFuerza;
        this.tiempoCienKmh = tiempoCienKmh;
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

    public Integer getNumeroBolsasAire() {
        return numeroBolsasAire;
    }
    public void setNumeroBolsasAire(Integer numeroBolsasAire) {
        this.numeroBolsasAire = numeroBolsasAire;
    }

    public Integer getCaballosFuerza() {
        return caballosFuerza;
    }
    public void setCaballosFuerza(Integer caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    public Float getTiempoCienKmh() {
        return tiempoCienKmh;
    }
    public void setTiempoCienKmh(Float tiempoCienKmh) {
        this.tiempoCienKmh = tiempoCienKmh;
    }

    @Override
    public String toString() {
        return "Deportivo [numeroPasajeros=" + numeroPasajeros + ", numeroPuertas=" + numeroPuertas + ", numeroBolsasAire=" + numeroBolsasAire + ", caballosFuerza=" + caballosFuerza + ", tiempoCienKmh=" + tiempoCienKmh + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }
}