package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Alquiler extends Transaccion {

    private LocalDate fechaDevolucion;
    private Integer duracionalquiler;

    public Alquiler(String idtransaccion, LocalDate fecha, Float preciototal, Cliente cliente, Empleado empleado, Vehiculo vehiculo, LocalDate fechaDevolucion, Integer duracionalquiler) {
        super(idtransaccion, fecha, preciototal, cliente, empleado, vehiculo);
        this.fechaDevolucion = fechaDevolucion;
        this.duracionalquiler = duracionalquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getDuracionalquiler() {
        return duracionalquiler;
    }
    public void setDuracionalquiler(Integer duracionalquiler) {
        this.duracionalquiler = duracionalquiler;
    }
}