package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Moto extends Vehiculo {

    public Moto (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible){
        super (marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
    }

    @Override
    public String toString() {
        return "Moto [getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }
}