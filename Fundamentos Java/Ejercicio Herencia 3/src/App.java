import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de los apartados 7 y 8 de los ejercicios de herencia
 */
public class App {
    public static void main(String[] args) throws Exception {
        List<IFigura> figuras = new ArrayList<>();
        figuras.add(new Circulo(34));
        figuras.add(new Cuadrado(25));
        figuras.add(new Circulo(12.5));
        figuras.add(new Cuadrado(2.6));
        figuras.add(new Circulo(15));
        figuras.add(new Cuadrado(7));

        for (IFigura figura : figuras) {
            if(figura instanceof Circulo) {
                System.out.println("*** Círculo – Radio: " + ((Circulo)figura).getRadio() + " ***");
            } else {
                System.out.println("*** Cuadrado – Lado: " + ((Cuadrado)figura).getLado() + " ***");
            }
            System.out.printf("Area: %.2f. Perímetro: %.2f\n", figura.getArea(), figura.getPerimetro());
        }
    }
}
