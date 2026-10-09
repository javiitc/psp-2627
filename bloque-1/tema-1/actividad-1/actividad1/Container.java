package actividad1;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private String containerName;
    public enum Status {EMPTY, IN_PROGRESS, COMPLETED};
    private Status status;
    private ArrayList <Ingredient> ingredients;

    public Container(String containerName) {
        this.containerName = containerName;
        this.status = Status.EMPTY;
        this.ingredients = new ArrayList<>();
    }

    public String getContainerName() { return containerName; }
    public void setContainerName(String containerName) { this.containerName = containerName; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<Ingredient> getIngredients() { return new ArrayList<>(ingredients); }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void empty() {
        ingredients.clear();
    }
}
