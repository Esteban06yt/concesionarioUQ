package co.edu.uniquindio.poo.model;

public abstract class VehiculoDiesel extends Vehiculo {
    private String combustible;

    public VehiculoDiesel(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima,
            Float cilindraje, Transmision transmision, Estado estado) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado);
        combustible = "Diesel";
    }

    public String getCombustible() {
        return combustible;
    }

}