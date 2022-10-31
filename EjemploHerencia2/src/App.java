public class App {
    public static void main(String[] args) throws Exception {
        Animal a = new Animal("Cosa", 5);
        a.comer();

        Ave ave = new Ave("loro", 1.2, true);
        ave.comer();
        ave.ponerHuevos();

        Mamifero m = new Mamifero("Leon", 300, true);
        m.comer();
    }
}
