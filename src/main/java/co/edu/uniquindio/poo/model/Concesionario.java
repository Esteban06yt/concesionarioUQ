package co.edu.uniquindio.poo.model;

public class Concesionario {
    private String nombre;

    public Concesionario (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Concesionario [nombre=" + nombre + "]";
    }
}