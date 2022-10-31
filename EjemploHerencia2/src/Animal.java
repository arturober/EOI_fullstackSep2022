import java.util.Random;

public class Animal {
    private String nombre;
    private double peso;
    
    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void comer() {
        // El animal cuando come engorda entre 0 y 0,5 kg (aleatorio)
        peso += new Random().nextDouble() * 0.5;
        System.out.printf("Ñam ñam. Ahora peso %.2f kilos\n", peso);
    }
}
