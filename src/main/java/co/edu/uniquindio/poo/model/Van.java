package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Van extends VehiculoConfort {
    private LinkedList<Van> listaVans = new LinkedList<>();

    public Van (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
    }

    @Override
    public String toString() {
        return "Van [getIdVehiculo()=" + getIdVehiculo() + "getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCilindraje()=" + getCilindraje() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getFoto()=" + getFoto() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + ", getCamaraReversa()=" + getCamaraReversa() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getAbs()=" + getAbs() + "]";
    }

    public String crear(Van nuevaVan) {
        if (buscar(nuevaVan.getIdVehiculo()) != null) {
            return "\nLa van ya está registrada.";
        }
        listaVans.add(nuevaVan);
        return "\nVan agregada exitosamente.";
    }

    public LinkedList<Van> obtener() {
        return listaVans;
    }

    public Van buscar(String idVehiculo) {
        for (Van van : listaVans) {
            if (van.getIdVehiculo().equals(idVehiculo)) {
                return van;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        Van van = buscar(idVehiculo);
        if (van != null) {
            van.setMarca(marca);
            van.setModelo(modelo);
            van.setCambios(cambios);
            van.setVelocidadMaxima(velocidadMaxima);
            van.setCilindraje(cilindraje);
            van.setTransmision(transmision);
            van.setEstado(estado);
            van.setCombustible(combustible);
            van.setNumeroPasajeros(numeroPasajeros);
            van.setNumeroPuertas(numeroPuertas);
            van.setCapacidadMaletero(capacidadMaletero);
            van.setAireAcondicionado(aireAcondicionado);
            van.setCamaraReversa(camaraReversa);
            van.setNumeroBolsasAire(numeroBolsasAire);
            van.setAbs(abs);
            return "\nInformación de la van actualizada correctamente.";
        }
        return "\nLa van no se encuentra registrada.";
    }

    public String eliminar(String idVehiculo) {
        Van van = buscar(idVehiculo);
        if (van != null) {
            listaVans.remove(van);
            return "\nLa van ha sido eliminada correctamente.";
        }
        return "\nLa van no existe.";
    }
}