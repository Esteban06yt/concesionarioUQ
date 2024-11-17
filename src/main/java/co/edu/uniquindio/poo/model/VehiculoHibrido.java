package co.edu.uniquindio.poo.model;

public abstract class VehiculoHibrido extends Vehiculo {

    private String combustible;
    private Boolean enchufable;
    private Boolean hibridoLigero;

    public VehiculoHibrido(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Boolean enchufable, Boolean hibridoLigero) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado);
        this.combustible = "Hibrido";
        this.enchufable = enchufable;
        this.hibridoLigero = hibridoLigero;
    }

    public String getCombustible() {
        return combustible;
    }
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Boolean getEnchufable() {
        return enchufable;
    }
    public void setEnchufable(Boolean enchufable) {
        this.enchufable = enchufable;
    }

    public Boolean getHibridoLigero() {
        return hibridoLigero;
    }
    public void setHibridoLigero(Boolean hibridoLigero) {
        this.hibridoLigero = hibridoLigero;
    }
}