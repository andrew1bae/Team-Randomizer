package components;

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
    public Player(String name, Double weight, Boolean isTeamCaptain) {
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
    public Boolean getIsTeamCaptain() {
        return false;
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
