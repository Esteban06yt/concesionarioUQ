package co.edu.uniquindio.poo.model;

public abstract class VehiculoElectrico extends Vehiculo {
    private String combustible = "Electrico";
    private Float autonomia;
    private Float tiempoCarga;

    public VehiculoElectrico (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, String combustible, Float autonomia, Float tiempoCarga) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado);
        this.combustible = combustible;
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public String getCombustible() {
        return combustible;
    }
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Float getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(Float autonomia) {
        this.autonomia = autonomia;
    }

    public Float getTiempoCarga() {
        return tiempoCarga;
    }
    public void setTiempoCarga(Float tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
}