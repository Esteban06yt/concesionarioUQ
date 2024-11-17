package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Transaccion {

    private String idtransaccion;
    private LocalDate fecha;
    private Float preciototal;
    private Cliente cliente;
    private Empleado empleado;
    private Vehiculo vehiculo;

    public Transaccion(String idtransaccion, LocalDate fecha, Float preciototal, Cliente cliente, Empleado empleado, Vehiculo vehiculo) {
        this.idtransaccion = idtransaccion;
        this.fecha = fecha;
        this.preciototal = preciototal;
        this.cliente = cliente;
        this.empleado = empleado;
        this.vehiculo = vehiculo;
        cliente.AgregarTransaccion(this);
        empleado.AgregarTransaccion(this);
        vehiculo.AgregarTransaccion(this);
    }

    public String getIdtransaccion() {
        return idtransaccion;
    }
    public void setIdtransaccion(String idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Float getPreciototal() {
        return preciototal;
    }
    public void setPreciototal(Float preciototal) {
        this.preciototal = preciototal;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idtransaccion == null) ? 0 : idtransaccion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaccion other = (Transaccion) obj;
        if (idtransaccion == null) {
            if (other.idtransaccion != null)
                return false;
        } else if (!idtransaccion.equals(other.idtransaccion))
            return false;
        return true;
    }
}