package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Moto extends Vehiculo {
    private LinkedList<Moto> listaMotos = new LinkedList<>();

    public Moto (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible){
        super (idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
    }

    @Override
    public String toString() {
        return "Moto [getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Moto nuevaMoto) {
        if (buscar(nuevaMoto.getIdVehiculo()) != null) {
            return "\nLa Moto ya está registrada.";
        }
        listaMotos.add(nuevaMoto);
        return "\nMoto agregada exitosamente.";
    }

    public LinkedList<Moto> obtener() {
        return listaMotos;
    }

    public Moto buscar(String idVehiculo) {
        for (Moto moto : listaMotos) {
            if (moto.getIdVehiculo().equals(idVehiculo)) {
                return moto;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible) {
        Moto moto = buscar(idVehiculo);
        if (moto != null) {
            moto.setMarca(marca);
            moto.setModelo(modelo);
            moto.setCambios(cambios);
            moto.setVelocidadMaxima(velocidadMaxima);
            moto.setCilindraje(cilindraje);
            moto.setFoto(foto);
            moto.setTransmision(transmision);
            moto.setEstado(estado);
            moto.setCombustible(combustible);
            return "\nInformación de la Moto actualizada correctamente.";
        }
        return "\nLa Moto no se encuentra registrada.";
    }

    public String eliminar(String idVehiculo) {
        Moto moto = buscar(idVehiculo);
        if (moto != null) {
            listaMotos.remove(moto);
            return "\nLa Moto ha sido eliminada correctamente.";
        }
        return "\nLa Moto no existe.";
    }
}