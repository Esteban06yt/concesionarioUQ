package co.edu.uniquindio.poo.model;

public abstract class VehiculoGasolina extends Vehiculo {
    private String combustible = "Gasolina";

    public VehiculoGasolina(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, String combustible) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado);
        this.combustible = combustible;
    }

    public String getCombustible() {
        return combustible;
    }
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}