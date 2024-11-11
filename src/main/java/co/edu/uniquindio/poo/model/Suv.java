package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Suv extends VehiculoConfort {
    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermaneciaCarril;
    private Boolean traccion4x4;

    public Suv (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
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
        return "Suv [velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermaneciaCarril=" + asistentePermaneciaCarril + ", traccion4x4=" + traccion4x4 + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCilindraje()=" + getCilindraje() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getFoto()=" + getFoto() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + ", getCamaraReversa()=" + getCamaraReversa() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getAbs()=" + getAbs() + "]";
    }
}