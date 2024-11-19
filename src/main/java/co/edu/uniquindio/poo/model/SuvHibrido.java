package co.edu.uniquindio.poo.model;

public class SuvHibrido extends VehiculoConfortHibrido {

    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermaneciaCarril;
    private Boolean traccion4x4;

    public SuvHibrido(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Boolean enchufable,
            Boolean hibridoLigero, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs,
            Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, enchufable, hibridoLigero, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado,
                camaraReversa, numeroBolsasAire, abs);
        this.velocidadCrucero = velocidadCrucero;
        this.sensoresColision = sensoresColision;
        this.sensorTraficoCruzado = sensorTraficoCruzado;
        this.asistentePermaneciaCarril = asistentePermaneciaCarril;
        this.traccion4x4 = traccion4x4;
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

    public Boolean getAsistentePermaneciaCarril() {
        return asistentePermaneciaCarril;
    }
    public void setAsistentePermaneciaCarril(Boolean asistentePermaneciaCarril) {
        this.asistentePermaneciaCarril = asistentePermaneciaCarril;
    }

    public Boolean getTraccion4x4() {
        return traccion4x4;
    }
    public void setTraccion4x4(Boolean traccion4x4) {
        this.traccion4x4 = traccion4x4;
    }

    @Override
    public String toString() {
        return "SuvHibrido{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", enchufable=" + getEnchufable() + ", hibridoLigero=" + getHibridoLigero() + ", numeroPasajeros=" + getNumeroPasajeros() + ", numeroPuertas=" + getNumeroPuertas() + ", capacidadMaletero=" + getCapacidadMaletero() + ", aireAcondicionado=" + getAireAcondicionado() + ", camaraReversa=" + getCamaraReversa() + ", numeroBolsasAire=" + getNumeroBolsasAire() + ", abs=" + getAbs() + ", velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermaneciaCarril=" + asistentePermaneciaCarril + ", traccion4x4=" + traccion4x4 + "}";
    }
}