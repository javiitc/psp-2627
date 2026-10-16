package actividad1;

import java.util.List;
import java.util.Random;

public class Main {

    private static final Random random = new Random();

    private static long randomDuration(int minSeconds, int maxSeconds) {
        int seconds = minSeconds + random.nextInt(maxSeconds - minSeconds + 1);
        return seconds * 1000L;
    }

    public static void main(String[] args) {

        Ingredient pasta = new Ingredient("Pasta", 500, "g");
        Ingredient carnePicada = new Ingredient("Carne Picada", 500, "g");
        Ingredient tomate = new Ingredient("Salsa de Tomate", 200, "ml");
        Ingredient aceite = new Ingredient("Aceite", 20, "ml");
        Ingredient agua = new Ingredient("Agua", 2, "L");
        Ingredient cebolla = new Ingredient("Cebolla", 200, "g");
        Ingredient ajo = new Ingredient("Ajo", 15, "g");
        Ingredient sal = new Ingredient("Sal", 30, "g");

        Container pot = new Container("Olla");
        Container pan = new Container("Sartén");
        Container colander = new Container("Escurridor");
        Container plate = new Container("Plato");

        Chef chef = new Chef("KokaLoka");

        Receipt receipt = new Receipt("Espaguetis a la boloñesa");

        receipt.addStep(new ReceiptStep("Poner agua a hervir", pot, List.of(agua, sal), randomDuration(3, 6)));
        receipt.addStep(new ReceiptStep("Cocer los espaguetis", pot, List.of(pasta), randomDuration(4, 7)));
        receipt.addStep(new ReceiptStep("Sofreír la cebolla y el ajo", pan, List.of(aceite, cebolla, ajo), randomDuration(2, 4)));
        receipt.addStep(new ReceiptStep("Añadir la carne picada y dorarla", pan, List.of(carnePicada), randomDuration(3, 5)));
        receipt.addStep(new ReceiptStep("Añadir el tomate y reducir la salsa", pan, List.of(tomate), randomDuration(3, 5)));
        receipt.addStep(new ReceiptStep("Escurrir la pasta", colander, pot, List.of(pasta), randomDuration(1, 2)));
        receipt.addStep(new ReceiptStep("Mezclar la pasta con la salsa", pan, colander, List.of(pasta), randomDuration(1, 3)));
        receipt.addStep(new ReceiptStep("Emplatar", plate, pan, List.of(pasta, aceite, cebolla, ajo, carnePicada, tomate), randomDuration(1, 2)));

        receipt.executeReceipt(chef);
    }
}
