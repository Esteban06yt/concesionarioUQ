package co.edu.uniquindio.poo.model;

public class BusHibrido extends VehiculoConfortHibrido {

    private Integer numeroEjes;
    private Integer numeroSalidasEmergencia;

    public BusHibrido(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Boolean enchufable,
            Boolean hibridoLigero, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes,
            Integer numeroSalidasEmergencia) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, enchufable, hibridoLigero, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado,
                camaraReversa, numeroBolsasAire, abs);
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
        return "BusHibrido{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", enchufable=" + getEnchufable() + ", hibridoLigero=" + getHibridoLigero() + ", numeroPasajeros=" + getNumeroPasajeros() + ", numeroPuertas=" + getNumeroPuertas() + ", capacidadMaletero=" + getCapacidadMaletero() + ", aireAcondicionado=" + getAireAcondicionado() + ", camaraReversa=" + getCamaraReversa() + ", numeroBolsasAire=" + getNumeroBolsasAire() + ", abs=" + getAbs() + ", numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia=" + numeroSalidasEmergencia + "}";
    }
}