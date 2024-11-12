package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Camion extends Vehiculo {
    private Float capacidadCarga;
    private Boolean aireAcondicionado;
    private Boolean frenosAire;
    private Boolean abs;
    private Integer numeroEjes;
    private String tipoCamion;
    private LinkedList<Camion> listaCamiones = new LinkedList<>();

    public Camion (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Float capacidadCarga, Boolean aireAcondicionado, Boolean frenosAire, Boolean abs, Integer numeroEjes, String tipoCamion) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
        this.capacidadCarga = capacidadCarga;
        this.aireAcondicionado = aireAcondicionado;
        this.frenosAire = frenosAire;
        this.abs = abs;
        this.numeroEjes = numeroEjes;
        this.tipoCamion = tipoCamion;
    }

    public Float getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(Float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }
    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getFrenosAire() {
        return frenosAire;
    }
    public void setFrenosAire(Boolean frenosAire) {
        this.frenosAire = frenosAire;
    }

    public Boolean getAbs() {
        return abs;
    }
    public void setAbs(Boolean abs) {
        this.abs = abs;
    }

    public Integer getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(Integer numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }
    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    @Override
    public String toString() {
        return "Camion [capacidadCarga=" + capacidadCarga + ", aireAcondicionado=" + aireAcondicionado + ", frenosAire=" + frenosAire + ", abs=" + abs + ", numeroEjes=" + numeroEjes + ", tipoCamion=" + tipoCamion + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }


    public String crear(Camion nuevoCamion) {
        if (buscar(nuevoCamion.getIdVehiculo()) != null) {
            return "\nEl Camión ya está registrado.";
        }
        listaCamiones.add(nuevoCamion);
        return "\nCamión agregado exitosamente.";
    }

    public LinkedList<Camion> obtener() {
        return listaCamiones;
    }

    public Camion buscar(String idVehiculo) {
        for (Camion camion : listaCamiones) {
            if (camion.getIdVehiculo().equals(idVehiculo)) {
                return camion;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Float capacidadCarga, Boolean aireAcondicionado, Boolean frenosAire, Boolean abs, Integer numeroEjes, String tipoCamion) {
        Camion camion = buscar(idVehiculo);
        if (camion != null) {
            camion.setMarca(marca);
            camion.setModelo(modelo);
            camion.setCambios(cambios);
            camion.setVelocidadMaxima(velocidadMaxima);
            camion.setCilindraje(cilindraje);
            camion.setFoto(foto);
            camion.setTransmision(transmision);
            camion.setEstado(estado);
            camion.setCombustible(combustible);
            camion.setCapacidadCarga(capacidadCarga);
            camion.setAireAcondicionado(aireAcondicionado);
            camion.setFrenosAire(frenosAire);
            camion.setAbs(abs);
            camion.setNumeroEjes(numeroEjes);
            camion.setTipoCamion(tipoCamion);
            return "\nInformación del Camión actualizada correctamente.";
        }
        return "\nEl Camión no se encuentra registrado.";
    }

    public String eliminar(String idVehiculo) {
        Camion camion = buscar(idVehiculo);
        if (camion != null) {
            listaCamiones.remove(camion);
            return "\nEl Camión ha sido eliminado correctamente.";
        }
        return "\nEl Camión no existe.";
    }
}