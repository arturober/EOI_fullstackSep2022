import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {

    /**
     * Ejemplo Supplier (no recibe nada y devuelve algo)
     */
    public static void ejemplo1() {
        Supplier<Integer> random = () -> {
            Random r = new Random();
            return r.nextInt(10) + 1;
        };

        System.out.println(random.get());
    }

    /**
     * Ejemplo Consumer (recibe algo y no devuelve nada)
     */
    public static void ejemplo2() {
        Consumer<String> printMayus = cad -> System.out.println(cad.toUpperCase());
        printMayus.accept("hola"); // HOLA
    }

    /**
     * Ejemplo Predicate (recibe algo y devuelve un booleano)
     */
    public static void ejemplo3() {
        Predicate<String> empiezaPorA = cad -> cad.startsWith("a") || cad.startsWith("A");
        System.out.println(empiezaPorA.test("Avión")); // true
        System.out.println(empiezaPorA.test("Perro")); // false
    }

    /**
     * Ejemplo Function (recibe algo y devuelve algo)
     */
    public static void ejemplo4() {
        Function<String, Integer> longitudPalabra = cad -> cad.length();
        System.out.println(longitudPalabra.apply("Murcielago"));
        System.out.println(longitudPalabra.apply("Perros"));
        System.out.println(longitudPalabra.apply("BeT"));
    }

    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2(); 
        // ejemplo3();
        ejemplo4();
    }
}
