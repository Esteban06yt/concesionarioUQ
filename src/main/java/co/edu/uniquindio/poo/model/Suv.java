package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Suv extends VehiculoConfort {
    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermaneciaCarril;
    private Boolean traccion4x4;
    private LinkedList<Suv> listaSuvs = new LinkedList<>();

    public Suv (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
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
        return "Suv [velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermaneciaCarril=" + asistentePermaneciaCarril + ", traccion4x4=" + traccion4x4 + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getModelo()=" + getModelo() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getCilindraje()=" + getCilindraje() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getFoto()=" + getFoto() + ", getCamaraReversa()=" + getCamaraReversa() + ", getTransmision()=" + getTransmision() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getEstado()=" + getEstado() + ", getAbs()=" + getAbs() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Suv nuevoSuv) {
        if (buscar(nuevoSuv.getIdVehiculo()) != null) {
            return "\nEl Suv ya está registrado.";
        }
        listaSuvs.add(nuevoSuv);
        return "\nSuv agregado exitosamente.";
    }

    public LinkedList<Suv> obtener() {
        return listaSuvs;
    }

    public Suv buscar(String idVehiculo) {
        for (Suv suv : listaSuvs) {
            if (suv.getIdVehiculo().equals(idVehiculo)) {
                return suv;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermaneciaCarril, Boolean traccion4x4) {
        Suv suv = buscar(idVehiculo);
        if (suv != null) {
            suv.setMarca(marca);
            suv.setModelo(modelo);
            suv.setCambios(cambios);
            suv.setVelocidadMaxima(velocidadMaxima);
            suv.setCilindraje(cilindraje);
            suv.setFoto(foto);
            suv.setTransmision(transmision);
            suv.setEstado(estado);
            suv.setCombustible(combustible);
            suv.setNumeroPasajeros(numeroPasajeros);
            suv.setNumeroPuertas(numeroPuertas);
            suv.setCapacidadMaletero(capacidadMaletero);
            suv.setAireAcondicionado(aireAcondicionado);
            suv.setCamaraReversa(camaraReversa);
            suv.setNumeroBolsasAire(numeroBolsasAire);
            suv.setAbs(abs);
            suv.setVelocidadCrucero(velocidadCrucero);
            suv.setSensoresColision(sensoresColision);
            suv.setSensorTraficoCruzado(sensorTraficoCruzado);
            suv.setAsistentePermaneciaCarril(asistentePermaneciaCarril);
            suv.setTraccion4x4(traccion4x4);
            return "\nInformación del Suv actualizada correctamente.";
        }
        return "\nEl Suv no se encuentra registrado.";
    }

    public String eliminar(String idVehiculo) {
        Suv suv = buscar(idVehiculo);
        if (suv != null) {
            listaSuvs.remove(suv);
            return "\nEl Suv ha sido eliminado correctamente.";
        }
        return "\nEl Suv no existe.";
    }
}