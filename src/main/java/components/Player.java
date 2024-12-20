package components;

/**
 *  A blueprint for player structure
 */
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

    /**
     * Returns a string of the player name
     * @return name of the player
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the weight of the player
     * @return weight of the player
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Returns a boolean of whether the player is the Team Captain
     * @return returns true if the player is team captain
     */
    public Boolean getIsTeamCaptain() {
        return false;
    }

    /**
     * Sets the name of the player
     * @param name - new name you want
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the weight of the player
     * @param weight - the new weight you want
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String toString() {
        return name + " | " + weight;
    }
}
