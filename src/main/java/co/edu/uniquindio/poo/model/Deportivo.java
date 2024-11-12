package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Deportivo extends Vehiculo {
    private Integer numeroPasajeros;
    private Integer numeroPuertas;
    private Integer numeroBolsasAire;
    private Integer caballosFuerza;
    private Float tiempoCienKmh;
    private LinkedList<Deportivo> listaDeportivos = new LinkedList<>();

    public Deportivo (String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Integer numeroBolsasAire, Integer caballosFuerza, Float tiempoCienKmh) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, foto, transmision, estado, combustible);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.numeroBolsasAire = numeroBolsasAire;
        this.caballosFuerza = caballosFuerza;
        this.tiempoCienKmh = tiempoCienKmh;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }
    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Integer getNumeroPuertas() {
        return numeroPuertas;
    }
    public void setNumeroPuertas(Integer numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public Integer getNumeroBolsasAire() {
        return numeroBolsasAire;
    }
    public void setNumeroBolsasAire(Integer numeroBolsasAire) {
        this.numeroBolsasAire = numeroBolsasAire;
    }

    public Integer getCaballosFuerza() {
        return caballosFuerza;
    }
    public void setCaballosFuerza(Integer caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    public Float getTiempoCienKmh() {
        return tiempoCienKmh;
    }
    public void setTiempoCienKmh(Float tiempoCienKmh) {
        this.tiempoCienKmh = tiempoCienKmh;
    }

    @Override
    public String toString() {
        return "Deportivo [numeroPasajeros=" + numeroPasajeros + ", numeroPuertas=" + numeroPuertas + ", numeroBolsasAire=" + numeroBolsasAire + ", caballosFuerza=" + caballosFuerza + ", tiempoCienKmh=" + tiempoCienKmh + ", getIdVehiculo()=" + getIdVehiculo() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCambios()=" + getCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getFoto()=" + getFoto() + ", getTransmision()=" + getTransmision() + ", getEstado()=" + getEstado() + ", getCombustible()=" + getCombustible() + "]";
    }

    public String crear(Deportivo nuevoDeportivo) {
        if (buscar(nuevoDeportivo.getIdVehiculo()) != null) {
            return "\nEl Deportivo ya está registrado.";
        }
        listaDeportivos.add(nuevoDeportivo);
        return "\nDeportivo agregado exitosamente.";
    }

    public LinkedList<Deportivo> obtener() {
        return listaDeportivos;
    }

    public Deportivo buscar(String idVehiculo) {
        for (Deportivo deportivo : listaDeportivos) {
            if (deportivo.getIdVehiculo().equals(idVehiculo)) {
                return deportivo;
            }
        }
        return null;
    }

    public String actualizar(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Image foto, Transmision transmision, Estado estado, Combustible combustible, Integer numeroPasajeros, Integer numeroPuertas, Integer numeroBolsasAire, Integer caballosFuerza, Float tiempoCienKmh) {
        Deportivo deportivo = buscar(idVehiculo);
        if (deportivo != null) {
            deportivo.setMarca(marca);
            deportivo.setModelo(modelo);
            deportivo.setCambios(cambios);
            deportivo.setVelocidadMaxima(velocidadMaxima);
            deportivo.setCilindraje(cilindraje);
            deportivo.setFoto(foto);
            deportivo.setTransmision(transmision);
            deportivo.setEstado(estado);
            deportivo.setCombustible(combustible);
            deportivo.setNumeroPasajeros(numeroPasajeros);
            deportivo.setNumeroPuertas(numeroPuertas);
            deportivo.setNumeroBolsasAire(numeroBolsasAire);
            deportivo.setCaballosFuerza(caballosFuerza);
            deportivo.setTiempoCienKmh(tiempoCienKmh);
            return "\nInformación del Deportivo actualizada correctamente.";
        }
        return "\nEl Deportivo no se encuentra registrado.";
    }

    public String eliminar(String idVehiculo) {
        Deportivo deportivo = buscar(idVehiculo);
        if (deportivo != null) {
            listaDeportivos.remove(deportivo);
            return "\nEl Deportivo ha sido eliminado correctamente.";
        }
        return "\nEl Deportivo no existe.";
    }
}