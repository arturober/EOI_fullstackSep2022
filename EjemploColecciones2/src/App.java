import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class App {
    /**
     * Map cuya clave sea un nombre y el valor asociado la edad
     */
    public static void ejemplo1() {
        Map<String, Integer> personas = new HashMap<>();
        personas.put("Pepe", 34);
        personas.put("Ana", 24);
        personas.put("Alejandro", 26);
        personas.put("Marta", 55);

        personas.put("Ana", 79); // Reemplaza el valor
        personas.putIfAbsent("Ana", 100); // Añade solo si no existe previamente

        System.out.println(personas);

        System.out.println("Edad de Alejandro: " + personas.get("Alejandro"));
        System.out.println("Edad de alguien que no existe: " + personas.getOrDefault("Nadie", 0));

        personas.remove("Ana");

        // for(Entry<String, Integer> pair: personas.entrySet()) {
        // System.out.println("Nombre: " + pair.getKey() + ", edad: " +  pair.getValue());
        // }

        // for (String nombre : personas.keySet()) {
        //     System.out.println("Nombre: " + nombre + ", edad: " + personas.get(nombre));
        // }

        personas.forEach((nombre, edad) -> System.out.println("Nombre: " + nombre + ", edad: " + edad));
    }

    // Diferencia HashMap y TreeMap
    public static void ejemplo2() {
        Map<String, Integer> personas = new HashMap<>();
        personas.put("Pepe", 34);
        personas.put("Ana", 24);
        personas.put("Alejandro", 26);
        personas.put("Marta", 55);

        Map<String, Integer> personas2 = new TreeMap<>();
        personas2.put("Pepe", 34);
        personas2.put("Ana", 24);
        personas2.put("Alejandro", 26);
        personas2.put("Marta", 55);
        personas2.put("Berto", 40);

        Map<String, Integer> personas3 = new TreeMap<>(Comparator.comparing(String::length).thenComparing(String::toString));
        personas3.put("Pepe", 34);
        personas3.put("Ana", 24);
        personas3.put("Alejandro", 26);
        personas3.put("Marta", 55);
        personas3.put("Berto", 40);

        System.out.println(personas);
        System.out.println(personas2);
        System.out.println(personas3);
    }

    /**
     * Ejemplo SET
     */
    public static void ejemplo3() {
        Set<String> frutas = new HashSet<>();
        frutas.add("Plátano");
        frutas.add("Manzana");
        frutas.add("Mandarina");
        frutas.add("Sandía");

        frutas.add("Manzana");
        frutas.add("Manzana");
        frutas.add("Manzana");

        System.out.println(frutas);

        System.out.println(frutas.contains("Plátano"));
        System.out.println(frutas.contains("Aguacate"));

        frutas.remove("Plátano");
        frutas.forEach(f -> System.out.println(f));

        // Transformar Set a List
        List<String> frutasList = new ArrayList<>(frutas);
        System.out.println(frutasList);
    }

    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2();
        ejemplo3();
    }
}
