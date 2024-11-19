package co.edu.uniquindio.poo.model;

public class MotoElectrico extends VehiculoElectrico {

    public MotoElectrico(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Float autonomia, Float tiempoCarga) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, autonomia, tiempoCarga);
    }

    @Override
    public String toString() {
        return "MotoElectrico{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", autonomia=" + getAutonomia() + ", tiempoCarga=" + getTiempoCarga() + "}";
    }
}