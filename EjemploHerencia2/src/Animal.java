import java.util.Random;

public abstract class Animal extends Object {
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

    /**
     * Al tener abstract (sin implementar), obliga a las clases derivadas
     * a implementar el método sí o sí (@Override)
     * @return Devuelve el tipo de animal
     */
    public abstract String tipoAnimal();

    @Override
    public String toString() {
        return String.format("%s (%.2fkg)", nombre, peso);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Animal other = (Animal) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        return true;
    }

    
}
