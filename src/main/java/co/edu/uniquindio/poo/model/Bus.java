package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Bus extends VehiculoConfort {
    private Integer numeroEjes;
    private Integer numeroSalidasEmergencia;
    private LinkedList<Bus> listaBuses = new LinkedList<>();

    public Bus (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes, Integer numeroSalidasEmergencia) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs);
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
        return "Bus [numeroEjes=" + numeroEjes + ", numeroSalidasEmergencia=" + numeroSalidasEmergencia + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", getModelo()=" + getModelo() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCapacidadMaletero()=" + getCapacidadMaletero() + ", getCilindraje()=" + getCilindraje() + ", getAireAcondicionado()=" + getAireAcondicionado() + ", getFoto()=" + getFoto() + ", getCamaraReversa()=" + getCamaraReversa() + ", getTransmision()=" + getTransmision() + ", getNumeroBolsasAire()=" + getNumeroBolsasAire() + ", getEstado()=" + getEstado() + ", getAbs()=" + getAbs() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Bus nuevoBus) {
        if (buscar(nuevoBus.getIdVehiculo()) != null) {
            return "\nEl Bus ya está registrado.";
        }
        listaBuses.add(nuevoBus);
        return "\nBus agregado exitosamente.";
    }

    public LinkedList<Bus> obtener() {
        return listaBuses;
    }

    public Bus buscar(String idVehiculo) {
        for (Bus bus : listaBuses) {
            if (bus.getIdVehiculo().equals(idVehiculo)) {
                return bus;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs, Integer numeroEjes, Integer numeroSalidasEmergencia) {
        Bus bus = buscar(idVehiculo);
        if (bus != null) {
            bus.setMarca(marca);
            bus.setModelo(modelo);
            bus.setCambios(cambios);
            bus.setVelocidadMaxima(velocidadMaxima);
            bus.setCilindraje(cilindraje);
            bus.setFoto(foto);
            bus.setTransmision(transmision);
            bus.setEstado(estado);
            bus.setCombustible(combustible);
            bus.setNumeroPasajeros(numeroPasajeros);
            bus.setNumeroPuertas(numeroPuertas);
            bus.setCapacidadMaletero(capacidadMaletero);
            bus.setAireAcondicionado(aireAcondicionado);
            bus.setCamaraReversa(camaraReversa);
            bus.setNumeroBolsasAire(numeroBolsasAire);
            bus.setAbs(abs);
            bus.setNumeroEjes(numeroEjes);
            bus.setNumeroSalidasEmergencia(numeroSalidasEmergencia);
            return "\nInformación del Bus actualizada correctamente.";
        }
        return "\nEl Bus no se encuentra registrado.";
    }

    public String eliminar(String idVehiculo) {
        Bus bus = buscar(idVehiculo);
        if (bus != null) {
            listaBuses.remove(bus);
            return "\nEl Bus ha sido eliminado correctamente.";
        }
        return "\nEl Bus no existe.";
    }
}