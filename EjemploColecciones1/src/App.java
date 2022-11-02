import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class App {
    /**
     * Transformar array a lista
     */
    public static void ejemplo1() {
        Integer[] numeros = { 3, 4, 5, 6, 2 };
        Arrays.sort(numeros);
        Arrays.toString(numeros);
        List<Integer> list = new ArrayList<>(List.of(numeros));
        list.add(4);
        System.out.println(list);
    }

    public static void ejemplo2() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 5, 7, 3, 8));
        System.out.println(numeros.size());
        System.out.println(numeros);
        numeros.add(0, 99);
        System.out.println(numeros);

        numeros.addAll(List.of(10, 11, 12, 13));
        System.out.println(numeros);
    }

    /**
     * Transformar lista a array
     */
    public static void ejemplo3() {
        List<String> palabras = new ArrayList<>();
        palabras.add("coche");
        palabras.add("casa");
        palabras.add("perro");
        palabras.add("gato");

        palabras.remove("casa");

        String[] palabrasArray = new String[palabras.size()];
        palabras.toArray(palabrasArray);
        System.out.println(Arrays.toString(palabrasArray));
    }

    public static void ejemplo4() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 5, 7, 6, 8));
        System.out.println(numeros.contains(7));
        System.out.println(numeros.indexOf(7));
        System.out.println(numeros.contains(12));
        System.out.println(numeros.indexOf(12));
        System.out.println(numeros.containsAll(List.of(5, 6, 3)));

        // Cuidado con las listas de Integer (por defecto remove cuando recibe un número
        // borra la posición)
        numeros.remove(3); // Borra el índice 3 (valor = 6)
        // Tendremos que crear un objeto Integer para que borre por valor
        numeros.remove(Integer.valueOf(3)); // Borra el valor 3 (índice = 0)
        System.out.println(numeros);
    }

    // Ordenar listas
    public static void ejemplo5() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 1, 7, 6, 8, 2));
        // Método 1 (Collections.sort): Ordenar por defecto listas
        // Collections.sort(numeros);

        // Método 2 (List.sort) (Hay que pasarle un comparador o null por defecto)
        numeros.sort(null);
        System.out.println(numeros);

        // Ordenar al revés (mayor a menor)
        // Collections.sort(numeros, Comparator.reverseOrder());
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);
        Collections.shuffle(numeros); // Desordena lista (random)
        System.out.println(numeros);
    }

    // Métodos que reciben funciones (lambdas)
    public static void ejemplo6() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 2, 1, 7, 6, 8));
        System.out.println(numeros);

        // Borrar números pares
        numeros.removeIf(n -> n % 2 == 0);
        System.out.println(numeros);

        numeros.replaceAll(n -> n * 2);
        System.out.println(numeros);
    }

    /**
     * Ordenar una lista en base a una función de comparación (lambda)
     */
    public static void ejemplo7() {
        List<String> palabras = new ArrayList<>(
            List.of("gato", "perro", "aro", "murciélago", "patata")
        );
        palabras.sort(null);
        System.out.println(palabras);

        // Ordenar las palabras por su longitud
        palabras.sort((p1, p2) -> p1.length() - p2.length());
        System.out.println(palabras); // [aro, gato, perro, patata, murciélago]
        // Al revés
        palabras.sort((p1, p2) -> p2.length() - p1.length());
        System.out.println(palabras); // [murciélago, patata, perro, gato, aro]
        // Otra forma de comparar números
        palabras.sort((p1, p2) -> Integer.compare(p1.length(), p2.length()));
        System.out.println(palabras); // [aro, gato, perro, patata, murciélago]
    }

    // Ordenar objetos
    public static void ejemplo8() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(24, "Juan"));
        personas.add(new Persona(19, "Ana"));
        personas.add(new Persona(43, "Marta"));
        personas.add(new Persona(33, "Zacarías"));
        personas.add(new Persona(17, "Paula"));

        System.out.println(personas);

        // Ordenar por edad
        personas.sort((p1, p2) -> p1.getEdad() - p2.getEdad());
        System.out.println(personas);

        // Ordenar por nombre
        personas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        System.out.println(personas);

        // Ordenar por edad 2 (Comparing)
        personas.sort(Comparator.comparing(p -> p.getEdad()));
        System.out.println(personas);

        // Ordenar por edad 3 (Comparing)
        personas.sort(Comparator.comparing(Persona::getEdad));

        personas.forEach(p -> System.out.println(p));
        // personas.forEach(System.out::println); // Igual que lo anterior
    }

    /**
     * Crear una lista de nombres
       Convertir los nombres a mayúsculas (replaceAll)
       Borrar los nombres que empiezan por "A" (removeIf)
       Recorre la lista con un forEach y muestra los nombres
    */
    public static void ejercicio() {
        List<String> nombres = new ArrayList<>(
            List.of("Antonio", "Luisa", "Arnold", "Martín", "Ana", "Marcos")
        );

        nombres.replaceAll(nombre -> nombre.toUpperCase());
        nombres.removeIf(nombre -> nombre.startsWith("A"));
        nombres.forEach(nombre -> System.out.println(nombre));
    }

    /**
     * Lo mismo que el ejercicio anterior pero con personas
     */
    public static void ejercicio2() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(24, "Juan"));
        personas.add(new Persona(19, "Ana"));
        personas.add(new Persona(43, "Marta"));
        personas.add(new Persona(33, "Arnold"));
        personas.add(new Persona(17, "Paula"));

        // personas.forEach(p -> p.setNombre(p.getNombre().toUpperCase()));
        personas.replaceAll(p -> new Persona(p.getEdad(), p.getNombre().toUpperCase()));
        personas.removeIf(p -> p.getNombre().startsWith("A"));
        personas.forEach(p -> System.out.println(p));
    }

    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        // ejemplo4();
        // ejemplo5();
        // ejemplo6();
        // ejemplo7();
        // ejemplo8();
        // ejercicio();
        ejercicio2();
    }
}
