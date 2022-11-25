/**
 * Implementación del apartado 6 de los ejercicios de herencia
 */
public class App {
    public static void main(String[] args) throws Exception {
        Circulo ci = new Circulo(6);
        Cuadrado cu = new Cuadrado(6);

        System.out.println("------- Círculo (radio: " + ci.getRadio() + ") -------");
        System.out.printf("Área: %.2f\n", ci.getArea());
        System.out.printf("Perímetro: %.2f\n", ci.getPerimetro());

        System.out.println("------- Cuadrado (lado: " + cu.getLado() + ") -------");
        System.out.printf("Área: %.2f\n", cu.getArea());
        System.out.printf("Perímetro: %.2f\n", cu.getPerimetro());
    }
}
