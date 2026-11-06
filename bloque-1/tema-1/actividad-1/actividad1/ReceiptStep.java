package actividad1;

import java.util.ArrayList;
import java.util.List;

public class ReceiptStep {

    private Container container;
    private String description;
    private Container source;
    private ArrayList<Ingredient> ingredients;
    private long stepDuration;

    public ReceiptStep(String description, Container container, List<Ingredient> ingredients, long durationMillis) {
        this(description, container, null, ingredients, durationMillis);
    }

    public ReceiptStep(String description, Container container, Container source, List<Ingredient> ingredients, long stepDuration) {
        this.description = description;
        this.container = container;
        this.source = source;
        this.ingredients = new ArrayList<>(ingredients);
        this.stepDuration = stepDuration;
    }

    public Container getContainer() {
        return container;
    }

    public String getDescription() {
        return description;
    }

    public Container getSource() {
        return source;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public long getStepDuration() {
        return stepDuration;
    }

    public void stepInProgress () {
        container.setStatus (Container.Status.IN_PROGRESS);

        for (Ingredient ingredient : ingredients) {
            container.addIngredient(ingredient);
        }

        if (source != null) {
            source.empty();
        }

        try {
            Thread.sleep(stepDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        container.setStatus(Container.Status.COMPLETED);
    }
}
