package co.edu.uniquindio.poo.model;

public abstract class VehiculoGasolina extends Vehiculo {

    private String combustible;

    public VehiculoGasolina(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado);
        this.combustible = "Gasolina";
    }

    public String getCombustible() {
        return combustible;
    }
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}