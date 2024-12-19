public class TeamCaptain extends Player{
    private final Boolean isTeamCaptain = true;
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
        return isTeamCaptain;
    }

    public String toString() {
        return super.toString() + " | Team Captain";
    }

}
