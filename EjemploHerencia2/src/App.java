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

    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        ejemplo4();
    }
}
