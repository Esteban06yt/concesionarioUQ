package co.edu.uniquindio.poo.model;

public class MotoGasolina extends VehiculoGasolina {

    public MotoGasolina(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima,
            Float cilindraje, Transmision transmision, Estado estado, String combustible) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, combustible);
    }
}