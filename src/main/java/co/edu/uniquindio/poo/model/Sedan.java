package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Sedan extends VehiculoConfort {
    private Boolean velocidadCrucero;
    private Boolean sensoresColision;
    private Boolean sensorTraficoCruzado;
    private Boolean asistentePermanenciaCarril;
    private LinkedList<Sedan> listaSedans = new LinkedList<>();

    public Sedan (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermanenciaCarril) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
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
        return "Sedan [velocidadCrucero=" + velocidadCrucero + ", sensoresColision=" + sensoresColision + ", sensorTraficoCruzado=" + sensorTraficoCruzado + ", asistentePermanenciaCarril=" + asistentePermanenciaCarril + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getModelo()=" + getModelo() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getCilindraje()=" + getCilindraje() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getFoto()=" + getFoto() + ", getCamaraReversa()=" + getCamaraReversa() + ", getTransmision()=" + getTransmision() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getEstado()=" + getEstado() + ", getAbs()=" + getAbs() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Sedan nuevoSedan) {
        if (buscar(nuevoSedan.getIdVehiculo()) != null) {
            return "\nEl Sedan ya está registrado.";
        }
        listaSedans.add(nuevoSedan);
        return "\nSedan agregado exitosamente.";
    }

    public LinkedList<Sedan> obtener() {
        return listaSedans;
    }

    public Sedan buscar(String idVehiculo) {
        for (Sedan sedan : listaSedans) {
            if (sedan.getIdVehiculo().equals(idVehiculo)) {
                return sedan;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Boolean velocidadCrucero, Boolean sensoresColision, Boolean sensorTraficoCruzado, Boolean asistentePermanenciaCarril) {
        Sedan sedan = buscar(idVehiculo);
        if (sedan != null) {
            sedan.setMarca(marca);
            sedan.setModelo(modelo);
            sedan.setCambios(cambios);
            sedan.setVelocidadMaxima(velocidadMaxima);
            sedan.setCilindraje(cilindraje);
            sedan.setFoto(foto);
            sedan.setTransmision(transmision);
            sedan.setEstado(estado);
            sedan.setCombustible(combustible);
            sedan.setNumeroPasajeros(numeroPasajeros);
            sedan.setNumeroPuertas(numeroPuertas);
            sedan.setCapacidadMaletero(capacidadMaletero);
            sedan.setAireAcondicionado(aireAcondicionado);
            sedan.setCamaraReversa(camaraReversa);
            sedan.setNumeroBolsasAire(numeroBolsasAire);
            sedan.setAbs(abs);
            sedan.setVelocidadCrucero(velocidadCrucero);
            sedan.setSensoresColision(sensoresColision);
            sedan.setSensorTraficoCruzado(sensorTraficoCruzado);
            sedan.setAsistentePermanenciaCarril(asistentePermanenciaCarril);
            return "\nInformación del Sedan actualizada correctamente.";
        }
        return "\nEl Sedan no se encuentra registrado.";
    }

    public String eliminar(String idVehiculo) {
        Sedan sedan = buscar(idVehiculo);
        if (sedan != null) {
            listaSedans.remove(sedan);
            return "\nEl Sedan ha sido eliminado correctamente.";
        }
        return "\nEl Sedan no existe.";
    }
}