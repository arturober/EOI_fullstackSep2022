import java.rmi.server.ObjID;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void ejemplo1() {
        // Este ejemplo ya no funciona al ser la clase Animal abstracta (abstract)
        // Lo que impide crear objetos de dicha clase
        // Animal a = new Animal("Cosa", 5);
        // a.comer();
    }

    public static void ejemplo2() {
        Ave ave = new Ave("loro", 1.2, true);
        ave.comer();
        ave.ponerHuevos();

        Mamifero m = new Mamifero("Leon", 300, true);
        m.comer();
    }

    // toString
    public static void ejemplo3() {
        Mamifero m = new Mamifero("Leon", 300, true);
        System.out.println(m);
    }

    // equals
    public static void ejemplo4() {
        Mamifero m = new Mamifero("Leon", 300, true);
        Mamifero m2 = new Mamifero(m);

        System.out.println(m);
        System.out.println(m2);

        if(m == m2) { // Mismo objeto
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son objetos diferentes");
        }

        if(m.equals(m2)) {
            System.out.println("Son equivalentes");
        } else {
            System.out.println("Tienen diferentes propiedades");
        }
    }

    public static void ejemplo5() {
        Mamifero m = new Mamifero("Leon", 300, true);
        m.hablar();

        Persona p = new Persona("Pepe");
        p.hablar();
    }

    // Polimorfismo
    public static void ejemplo6() {
        Object o = "Hola";
        Object o2 = LocalDate.now();
        Object o3 = new Ave("Pájaro", 1, true);
        Object o4 = new Persona("Juan");

        System.out.println(o2.toString()); 
        System.out.println(o3.toString());

        // o3.comer(); // Error. No puedo acceder al método comer

        List<Object> lista = new ArrayList<>();
        lista.add(34);
        lista.add("Hola");
        lista.add(LocalDate.now());
        lista.add(new Mamifero("Leon", 300, true));

        for(Object item: lista) {
            System.out.println(item.toString());
        }
    }

    public static void ejemplo7() {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Mamifero("Gacela", 80, false));
        animales.add(new Ave("Loro", 1, true));
        animales.add(new Mamifero("Leon", 300, true));
        animales.add(new Ave("Avestruz", 50, false));

        for (Animal animal : animales) {
            System.out.println("-------------- " + animal.tipoAnimal() + " --------------");
            System.out.println(animal.toString());
            animal.comer();
            if(animal instanceof Ave) { // Objeto de la clase Ave o derivada
                Ave ave = (Ave)animal;
                ave.ponerHuevos();
                // ((Ave)animal).ponerHuevos(); // También se puede hacer en una línea
            }
        }
    }

    public static void ejemplo8() {
        List<IHablador> habladores = new ArrayList<>();
        habladores.add(new Ave("Loro", 1, true));
        habladores.add(new Persona("Pepe"));

        for (IHablador hablador : habladores) {
            hablador.hablar();
        }
    }

    public static void main(String[] args) throws Exception {
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
