public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        // Mezclar el deck
        deck.mezclar();

        // Mostrar la primera carta
        deck.head();

        // Seleccionar una carta al azar
        deck.pick();

        // Repartir una mano de cinco cartas
        deck.hand();
    }
}