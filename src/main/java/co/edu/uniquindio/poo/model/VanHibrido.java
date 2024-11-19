package co.edu.uniquindio.poo.model;

public class VanHibrido extends VehiculoConfortHibrido {

    public VanHibrido(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima, Float cilindraje, Transmision transmision, Estado estado, Boolean enchufable,
            Boolean hibridoLigero, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero, Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, enchufable, hibridoLigero, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado,
                camaraReversa, numeroBolsasAire, abs);
    }

    @Override
    public String toString() {
        return "VanHibrido{idVehiculo='" + getIdVehiculo() + "', marca='" + getMarca() + "', modelo='" + getModelo() + "', cambios=" + getCambios() + ", velocidadMaxima=" + getVelocidadMaxima() + ", cilindraje=" + getCilindraje() + ", transmision=" + getTransmision() + ", estado=" + getEstado() + ", enchufable=" + getEnchufable() + ", hibridoLigero=" + getHibridoLigero() + ", numeroPasajeros=" + getNumeroPasajeros() + ", numeroPuertas=" + getNumeroPuertas() + ", capacidadMaletero=" + getCapacidadMaletero() + ", aireAcondicionado=" + getAireAcondicionado() + ", camaraReversa=" + getCamaraReversa() + ", numeroBolsasAire=" + getNumeroBolsasAire() + ", abs=" + getAbs() + "}";
    }
}