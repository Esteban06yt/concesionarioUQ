package co.edu.uniquindio.poo.model;

public class MotoElectrico extends VehiculoElectrico {

    public MotoElectrico(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Float autonomia, Float tiempoCarga) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, autonomia, tiempoCarga);
    }
}