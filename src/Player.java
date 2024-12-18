public class Player {
    //Vars
    private String name;
    private Double weight;

    //Constructors
    public Player() {
        name = "";
        weight = 0.0;
    }
    public Player(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    //Methods
    public String getName() {
        return name;
    }
    public Double getWeight() {
        return weight;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String toString() {
        return name + " | " + weight;
    }
}
