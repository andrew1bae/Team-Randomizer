package components;

/**
 * Child of Player class
 */
public class TeamCaptain extends Player{
    public TeamCaptain(){
        super();
    }
    public TeamCaptain(String name, Double weight) {
        super(name, weight);
    }
    public TeamCaptain(Player player) {
        super(player.getName(), player.getWeight());
    }

    /**
     * Returns a boolean if the player is a team captain
     * @return true (TeamCaptain is a child of Player)
     */
    @Override
    public Boolean getIsTeamCaptain() {
        return true;
    }

    public String toString() {
        return super.toString() + " | Team Captain";
    }

}
