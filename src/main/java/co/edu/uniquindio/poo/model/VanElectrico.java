package co.edu.uniquindio.poo.model;

public class VanElectrico extends VehiculoConfortElectrico {

    public VanElectrico(String idVehiculo, String marca, String modelo, Integer cambios, Float velocidadMaxima,
            Float cilindraje, Transmision transmision, Estado estado, String combustible, Float autonomia,
            Float tiempoCarga, Integer numeroPasajeros, Integer numeroPuertas, Float capacidadMaletero,
            Boolean aireAcondicionado, Boolean camaraReversa, Integer numeroBolsasAire, Boolean abs) {
        super(idVehiculo, marca, modelo, cambios, velocidadMaxima, cilindraje, transmision, estado, combustible,
                autonomia, tiempoCarga, numeroPasajeros, numeroPuertas, capacidadMaletero, aireAcondicionado,
                camaraReversa, numeroBolsasAire, abs);
    }
}