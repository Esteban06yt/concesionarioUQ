package co.edu.uniquindio.poo.model;

public class Electrico implements Combustible {
    private Float autonomia;
    private Float tiempoCarga;

    public Electrico (Float autonomia, Float tiempoCarga) {
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
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

    @Override
    public String getTipo() {
        return "Electrico";
    }
}