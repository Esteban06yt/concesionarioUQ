package co.edu.uniquindio.poo.model;

public class BusElectrico extends VehiculoConfortElectrico {
    private Integer numeroEjes;
    private Integer numeroSalidasEmergencia;

    public BusElectrico(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima,
            Float cilindraje, Transmision transmision, Estado estado, String combustible, Float autonomia,
            Float tiempoCarga, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero,
            Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes,
            Integer numeroSalidasEmergencia) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, combustible,
                autonomia, tiempoCarga, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado,
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
}