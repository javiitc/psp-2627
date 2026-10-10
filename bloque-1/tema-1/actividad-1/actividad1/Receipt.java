package actividad1;

import java.util.ArrayList;

public class Receipt {

    private String receiptName;
    private ArrayList<ReceiptStep> steps;

    public Receipt(String receiptName) {
        this.receiptName = receiptName;
        this.steps = new ArrayList<>();
    }

    public String getReceiptName() { return receiptName; }

    public ArrayList<ReceiptStep> getSteps() { return steps; }

    public void addStep(ReceiptStep step) {
        steps.add(step);
    }

    public void executeReceipt (Chef chef) {
        System.out.println("===== " + receiptName + " =====");
        System.out.println("Cocinero: " + chef.getName());
        System.out.println();

        long startMillis = System.currentTimeMillis();

        for (ReceiptStep step : steps) {
            chef.executeStep(step);
        }

        long totalMillis = System.currentTimeMillis() - startMillis;

        System.out.println("===== Receta terminada =====");
        System.out.println("Tiempo total: " + totalMillis / 1000.0 + " s");
    }
}
