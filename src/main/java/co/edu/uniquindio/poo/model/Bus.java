package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Bus extends VehiculoConfort {
    private Integer numeroEjes;
    private Integer numeroSalidasEmergencia;

    public Bus (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes, Integer numeroSalidasEmergencia) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
        this.numeroEjes = numeroEjes;
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
    }

    public Integer getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(Integer numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public Integer getNumeroSalidasEmergencia() {
        return numeroSalidasEmergencia;
    }
    public void setNumeroSalidasEmergencia(Integer numeroSalidasEmergencia) {
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
    }

    @Override
    public String toString() {
        return "Bus [numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia=" + numeroSalidasEmergencia + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCilindraje()=" + getCilindraje() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getFoto()=" + getFoto() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + ", getCamaraReversa()=" + getCamaraReversa() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getAbs()=" + getAbs() + "]";
    }
}