package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Camioneta extends VehiculoConfort {
    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermaneciaCarril;
    private Boolean traccion4x4;
    private LinkedList<Camioneta> listaCamionetas = new LinkedList<>();

    public Camioneta (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
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
        return "Camioneta [velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermaneciaCarril=" + asistentePermaneciaCarril + ", traccion4x4=" + traccion4x4 + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getModelo()=" + getModelo() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getCilindraje()=" + getCilindraje() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getFoto()=" + getFoto() + ", getCamaraReversa()=" + getCamaraReversa() + ", getTransmision()=" + getTransmision() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getEstado()=" + getEstado() + ", getAbs()=" + getAbs() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Camioneta nuevaCamioneta) {
        if (buscar(nuevaCamioneta.getIdVehiculo()) != null) {
            return "\nLa Camioneta ya está registrada.";
        }
        listaCamionetas.add(nuevaCamioneta);
        return "\nCamioneta agregada exitosamente.";
    }

    public LinkedList<Camioneta> obtener() {
        return listaCamionetas;
    }

    public Camioneta buscar(String idVehiculo) {
        for (Camioneta camioneta : listaCamionetas) {
            if (camioneta.getIdVehiculo().equals(idVehiculo)) {
                return camioneta;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
        Camioneta camioneta = buscar(idVehiculo);
        if (camioneta != null) {
            camioneta.setMarca(marca);
            camioneta.setModelo(modelo);
            camioneta.setCambios(cambios);
            camioneta.setVelocidadMaxima(velocidadMaxima);
            camioneta.setCilindraje(cilindraje);
            camioneta.setFoto(foto);
            camioneta.setTransmision(transmision);
            camioneta.setEstado(estado);
            camioneta.setCombustible(combustible);
            camioneta.setNumeroPasajeros(numeroPasajeros);
            camioneta.setNumeroPuertas(numeroPuertas);
            camioneta.setCapacidadMaletero(capacidadMaletero);
            camioneta.setAireAcondicionado(aireAcondicionado);
            camioneta.setCamaraReversa(camaraReversa);
            camioneta.setNumeroBolsasAire(numeroBolsasAire);
            camioneta.setAbs(abs);
            camioneta.setVelocidadCrucero(velocidadCrucero);
            camioneta.setSensoresColision(sensoresColision);
            camioneta.setSensorTraficoCruzado(sensorTraficoCruzado);
            camioneta.setAsistentePermaneciaCarril(asistentePermaneciaCarril);
            camioneta.setTraccion4x4(traccion4x4);
            return "\nInformación de la Camioneta actualizada correctamente.";
        }
        return "\nLa Camioneta no se encuentra registrada.";
    }

    public String eliminar(String idVehiculo) {
        Camioneta camioneta = buscar(idVehiculo);
        if (camioneta != null) {
            listaCamionetas.remove(camioneta);
            return "\nLa Camioneta ha sido eliminada correctamente.";
        }
        return "\nLa Camioneta no existe.";
    }
}