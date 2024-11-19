package co.edu.uniquindio.poo.model;

public class BusGasolina extends VehiculoConfortGasolina {

    private Integer numeroEjes;
    private Integer numeroSalidasEmergencia;

    public BusGasolina(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Integer numeroPasajeros,
            Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes, Integer numeroSalidasEmergencia) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
        this.numeroEjes = numeroEjes;
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
    }

    public Integer getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(Integer numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public Integer getNumeroSalidasEmergencia() {
        return numeroSalidasEmergencia;
    }
    public void setNumeroSalidasEmergencia(Integer numeroSalidasEmergencia) {
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
    }

    @Override
    public String toString() {
        return "BusGasolina{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", numeroPasajeros=" + getNumeroPasajeros() + ", numeroPuertas=" + getNumeroPuertas() + ", capacidadMaletero=" + getCapacidadMaletero() + ", aireAcondicionado=" + getAireAcondicionado() + ", camaraReversa=" + getCamaraReversa() + ", numeroBolsasAire=" + getNumeroBolsasAire() + ", abs=" + getAbs() + ", numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia=" + numeroSalidasEmergencia + "}";
    }
}