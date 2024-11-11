package co.edu.uniquindio.poo.model;

import javafx.scene.image.Image;

public class Sedan extends VehiculoConfort {
    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermanenciaCarril;

    public Sedan (String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermanenciaCarril) {
        super(marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
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
        return "Sedan [velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermanenciaCarril=" + asistentePermanenciaCarril + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCilindraje()=" + getCilindraje() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getFoto()=" + getFoto() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + ", getCamaraReversa()=" + getCamaraReversa() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getAbs()=" + getAbs() + "]";
    }
}