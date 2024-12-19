package components;

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

    @Override
    public Boolean getIsTeamCaptain() {
        return true;
    }

    public String toString() {
        return super.toString() + " | Team Captain";
    }

}
