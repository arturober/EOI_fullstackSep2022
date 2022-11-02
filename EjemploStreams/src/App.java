import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static List<Persona> personas;
    
    public static void ejemplo1() {
        personas.stream()
        .filter(p -> p.getEdad() >= 18)
        .forEach(p -> System.out.println(p));
    }

    /**
     * Imprime los nombres de las personas mayores de edad
     */
    public static void ejemplo2() {
        personas.stream()
        .filter(p -> p.getEdad() >= 18)
        .map(p -> p.getNombre())
        .distinct() // Elimina los nombres repetidos
        .forEach(n -> System.out.println(n));
    }

    public static void ejemplo3() {
        System.out.println(personas.stream().allMatch(p -> p.getEdad() >= 18));
        System.out.println(personas.stream().anyMatch(p -> p.getEdad() >= 18));
    }

    /**
     * Imprimir la primera persona cuyo nombre empiece por "P"
     */
    public static void ejemplo4() {
        Optional<Persona> persona = personas.stream()
        .filter(p -> p.getNombre().startsWith("P"))
        .findFirst();

        if(persona.isPresent()) {
            System.out.println(persona.get());
        } else {
            System.out.println("No hay personas cuyo nombre empiece por P");
        }

        // Otra forma de hacerlo con un resultado por defecto
        Persona persona2 = personas.stream()
        .filter(p -> p.getNombre().startsWith("P"))
        .findFirst().orElse(null);

        System.out.println(persona2);
    }

    // Obtener nombre de la tercera persona más joven
    public static void ejemplo5() {
        String nombre = personas.stream()
        .sorted(Comparator.comparing(Persona::getEdad))
        .map(Persona::getNombre)
        .skip(2) // Me salto a los 2 primeros (más jóvenes)
        .findFirst().orElse(null);

        System.out.println(nombre);
    }

    // Imprimir las 3 personas más mayores
    public static void ejemplo6() {
        personas.stream()
        .sorted(Comparator.comparing(Persona::getEdad).reversed()) // Ordenamos de mayor a menor
        .limit(3) // Me quedo con los 3 primeros (más mayores)
        .forEach(System.out::println);
    }

    /**
     * Devuelve la suma de las edades
     */
    public static void ejemplo7() {
        int totalEdades = personas.stream()
        .map(Persona::getEdad)
        .reduce(0, (total, edad) -> total + edad);

        System.out.println(totalEdades);

        int totalEdades2 = personas.stream()
        .mapToInt(Persona::getEdad)
        .sum();

        System.out.println(totalEdades2);

        // Media de las edades
        double media = personas.stream()
        .mapToInt(Persona::getEdad)
        .average().orElse(0);

        System.out.println(media);
    }

    /**
     * Lista de las personas mayores de edad ordenadas por nombre
     */
    public static void ejemplo8() {
        List<Persona> mayores = personas.stream()
        .filter(p -> p.getEdad() >= 18)
        .sorted(Comparator.comparing(Persona::getNombre))
        .collect(Collectors.toList());

        System.out.println(mayores);
    }

    public static void main(String[] args) throws Exception {
        personas = new ArrayList<>();
        personas.add(new Persona("Juan", 24));
        personas.add(new Persona("Alba", 53));
        personas.add(new Persona("Jose", 35));
        personas.add(new Persona("Paco", 15));
        personas.add(new Persona("Natalia", 28));
        personas.add(new Persona("Andrea", 17));
        personas.add(new Persona("Juan", 70));
        personas.add(new Persona("Patricia", 36));

        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        // ejemplo4();
        // ejemplo5();
        // ejemplo6();
        // ejemplo7();
        ejemplo8();
    }
}
