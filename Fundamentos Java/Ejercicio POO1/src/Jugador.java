public class Jugador {
    private String nombre;
    private int edad;
    private double salario;

    public Jugador(String nombre, int edad, double salario) {
        this.nombre = nombre;
        setEdad(edad);
        setSalario(salario);
    }

    public Jugador(Jugador j) {
        this.nombre = j.nombre;
        this.edad = j.edad;
        this.salario = j.salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad >= 0) {
            this.edad = edad;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
    }  
}
