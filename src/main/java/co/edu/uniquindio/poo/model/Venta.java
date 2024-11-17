package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Venta extends Transaccion {

    private String metodopago;
    private Boolean garantia;

    public Venta(String idtransaccion, LocalDate fecha, Float preciototal, Cliente cliente, Empleado empleado, Vehiculo vehiculo, String metodopago, Boolean garantia) {
        super(idtransaccion, fecha, preciototal, cliente, empleado, vehiculo);
        this.metodopago = metodopago;
        this.garantia = garantia;
    }

    public String getMetodopago() {
        return metodopago;
    }
    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public Boolean getGarantia() {
        return garantia;
    }
    public void setGarantia(Boolean garantia) {
        this.garantia = garantia;
    }
}