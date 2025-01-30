import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elige una opción:");
            System.out.println("1. Mezclar");
            System.out.println("2. Head");
            System.out.println("3. Pick");
            System.out.println("4. Hand");
            System.out.println("5. Salir");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    List<Card> hand = deck.hand();
                    System.out.println("Mano repartida:");
                    for (Card card : hand) {
                        System.out.println(card);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige nuevamente.");
            }
        }
    }
}

class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        this.initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = new String[]{"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colors = new String[]{"Negro", "Rojo"};
        String[] values = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            for (String value : values) {
                String color = suit.equals("Corazones") || suit.equals("Diamantes") ? colors[1] : colors[0];
                this.cards.add(new Card(suit, color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!this.cards.isEmpty()) {
            Card card = this.cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + this.cards.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void pick() {
        if (!this.cards.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(this.cards.size());
            Card card = this.cards.remove(index);
            System.out.println(card);
            System.out.println("Quedan " + this.cards.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public List<Card> hand() {
        List<Card> hand = new ArrayList<>();
        if (this.cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                hand.add(this.cards.remove(0));
            }
            for (Card card : hand) {
                System.out.println(card);
            }
            System.out.println("Quedan " + this.cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck para repartir una mano.");
        }
        return hand;
    }
}

class Card {
    private final String suit;
    private final String color;
    private final String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " de " + suit + " (" + color + ")";
    }
}
