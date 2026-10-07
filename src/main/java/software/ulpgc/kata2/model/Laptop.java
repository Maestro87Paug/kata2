package software.ulpgc.kata2.model;

public record Laptop(String manufacturer, String modelName, double price) {
    @Override
    public String toString(){
        return manufacturer + " " + modelName + " " + price + "€";
    }
}
