import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> jugadores;

    public Equipo() {
        jugadores = new ArrayList<>();
    }

    public void addJugador(Jugador j) {
        if(j != null) {
            jugadores.add(j);
        }
    }

    public int getNumJugadores() {
        return jugadores.size();
    }

    public Jugador getJugador(int pos) {
        if(pos >= 0 && pos < jugadores.size()) {
            return jugadores.get(pos);
        } else {
            return null;
        }
    }

    public void deleteJugador(int pos) {
        if(pos >= 0 && pos < jugadores.size()) {
            jugadores.remove(pos);
        }
    }

    public double totalSueldos() {
        double total = 0;

        for (Jugador jugador : jugadores) {
            total += jugador.getSalario();
        }

        return total;

        // Modo PRO
        // return jugadores.stream().mapToDouble(Jugador::getSalario).sum();
    }
}
