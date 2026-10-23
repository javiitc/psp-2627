package actividad1;

public class Ingredient {

    private String ingredientName;
    private int quantity;
    private String unit;

    public Ingredient(String ingredientName, int quantity, String unit) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return quantity + "" + unit + " de " + ingredientName;
    }
}
