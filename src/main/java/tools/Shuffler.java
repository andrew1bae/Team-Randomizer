package tools;


import components.*;

import java.util.ArrayList;
import java.util.List;

public class Shuffler {
    private final List<Player> players;
    private Team team1 = new Team();
    private Team team2 = new Team();

    //Constructors
    public Shuffler() {
        players = new ArrayList<Player>();
    }
    public Shuffler(List<Player> players) {
        this.players = players;
    }

    //Methods
    public Team getTeam1() {return team1;}
    public Team getTeam2() {return team2;}

    /**
     * Agnostic Team Randomization - Randomizes teams without bias
     */
    public void agnRandTeam() {
        List<Player> temp = new ArrayList<Player>(players);
        int teamSize = temp.size() / 2;
        team1 = new Team();
        team2 = new Team();
        while (temp.size() > teamSize) {
            int rand = (int) (temp.size() * Math.random());
            team1.addPlayer(temp.get(rand));
            temp.remove(rand);
        }
        for(Player player : temp) {
            team2.addPlayer(player);
        }
    }
}
