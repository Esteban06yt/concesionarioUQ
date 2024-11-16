package co.edu.uniquindio.poo.model;

public class MotoHibrido extends VehiculoHibrido {

    public MotoHibrido(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima,
            Float cilindraje, Transmision transmision, Estado estado, String combustible, Boolean enchufable,
            Boolean hibridoLigero) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, combustible,
                enchufable, hibridoLigero);
    }
}