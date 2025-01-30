import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Carta> cartas;

    // Constructor de la clase Deck
    public Deck() {
        cartas = new ArrayList<>();
        inicializarDeck();
    }


    private void inicializarDeck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? colores[1] : colores[0];
                cartas.add(new Carta(palo, color, valor));
            }
        }
    }


    public void mezclar() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }


    public void head() {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(0);
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }


    public void pick() {
        if (!cartas.isEmpty()) {
            Random random = new Random();
            int indice = random.nextInt(cartas.size());
            Carta carta = cartas.remove(indice);
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }


    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Carta carta = cartas.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck para repartir una mano.");
        }
    }
}