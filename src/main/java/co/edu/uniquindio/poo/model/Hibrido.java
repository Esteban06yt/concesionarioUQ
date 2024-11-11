package co.edu.uniquindio.poo.model;

public class Hibrido implements Combustible {
    private Boolean enchufable;
    private Boolean hibridoLigero;

    public Hibrido(Boolean enchufable, Boolean hibridoLigero) {
        this.enchufable = enchufable;
        this.hibridoLigero = hibridoLigero;
    }

    public Boolean getEnchufable() {
        return enchufable;
    }

    public void setEnchufable(Boolean enchufable) {
        this.enchufable = enchufable;
    }

    public Boolean getHibridoLigero() {
        return hibridoLigero;
    }

    public void setHibridoLigero(Boolean hibridoLigero) {
        this.hibridoLigero = hibridoLigero;
    }

    @Override
    public String getTipo() {
        return "Hibrido";
    }
}