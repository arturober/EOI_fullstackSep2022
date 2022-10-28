import java.util.ArrayList;
import java.util.List;

public class App {
    public static void apartado1() {
        Jugador j1 = new Jugador("Juanito", 34, 40000);
        Jugador j2 = new Jugador("Pepito", 26, 32000);

        System.out.println(j1);
        System.out.println(j2);
    }

    public static void apartado2() {
        List<Jugador> jugadores = new ArrayList<Jugador>();

        Jugador a = new Jugador("Víctor", 25, 400);
        Jugador b = new Jugador("Javi", -26, -500);
        Jugador c = new Jugador("Alejandro", 34, 800);
        Jugador d = new Jugador("Diego", 31, 950);

        jugadores.add(a);
        jugadores.add(b);
        jugadores.add(null);
        jugadores.add(c);
        jugadores.add(null);
        jugadores.add(d);

        for(Jugador jugador : jugadores) { 
            if (jugador!=null) {
                System.out.println(jugador.toString()); 
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // apartado1();
        apartado2();
    }
}