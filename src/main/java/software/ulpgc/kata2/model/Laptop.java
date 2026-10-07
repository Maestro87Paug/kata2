package software.ulpgc.kata2.model;

public record Laptop(String manufacturer, String modelName, String category) {
    @Override
    public String toString(){
        return manufacturer + " " + modelName + " - " + category;
    }
}
