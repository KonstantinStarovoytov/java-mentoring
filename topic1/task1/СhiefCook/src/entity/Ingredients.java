package entity;

public enum Ingredients {
    BEET("Beet", 43), CARROT("Carrot", 32), EGGS("Eggs", 53), PARSLEY("Parsley", 34), POTATO("Potato", 77), TOMATO("Tomato", 50);

    private String productName;

    private int calIn100g;

    Ingredients (String productName, int calIn100g) {
        this.productName = productName;
        this.calIn100g = calIn100g;
    }

    @Override
    public String toString () {
        return productName;
    }

    public int getCalIn100g () {
        return calIn100g;
    }
}
