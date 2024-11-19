package co.edu.uniquindio.poo.model;

public class SedanGasolina extends VehiculoConfortGasolina {

    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermanenciaCarril;

    public SedanGasolina(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Integer numeroPasajeros,
            Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision,
            Boolean sensorTraficoCruzado, Boolean asistentePermanenciaCarril) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
        this.velocidadCrucero = velocidadCrucero;
        this.sensoresColision = sensoresColision;
        this.sensorTraficoCruzado = sensorTraficoCruzado;
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
    }

    public Boolean getVelocidadCrucero() {
        return velocidadCrucero;
    }
    public void setVelocidadCrucero(Boolean velocidadCrucero) {
        this.velocidadCrucero = velocidadCrucero;
    }

    public Boolean getSensoresColision() {
        return sensoresColision;
    }
    public void setSensoresColision(Boolean sensoresColision) {
        this.sensoresColision = sensoresColision;
    }

    public Boolean getSensorTraficoCruzado() {
        return sensorTraficoCruzado;
    }
    public void setSensorTraficoCruzado(Boolean sensorTraficoCruzado) {
        this.sensorTraficoCruzado = sensorTraficoCruzado;
    }

    public Boolean getAsistentePermanenciaCarril() {
        return asistentePermanenciaCarril;
    }
    public void setAsistentePermanenciaCarril(Boolean asistentePermanenciaCarril) {
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
    }

    @Override
    public String toString() {
        return "SedanGasolina{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", numeroPasajeros=" + getNumeroPasajeros() + ", numeroPuertas=" + getNumeroPuertas() + ", capacidadMaletero=" + getCapacidadMaletero() + ", aireAcondicionado=" + getAireAcondicionado() + ", camaraReversa=" + getCamaraReversa() + ", numeroBolsasAire=" + getNumeroBolsasAire() + ", abs=" + getAbs() + ", velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermanenciaCarril=" + asistentePermanenciaCarril + "}";
    }
}