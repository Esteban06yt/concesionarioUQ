package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Van extends VehiculoConfort {

    public Van (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
    }

    @Override
    public String toString() {
        return "Van [getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCilindraje()=" + getCilindraje() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getFoto()=" + getFoto() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + ", getCamaraReversa()=" + getCamaraReversa() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getAbs()=" + getAbs() + "]";
    }
}