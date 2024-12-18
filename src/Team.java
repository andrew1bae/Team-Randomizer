import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Team {
    private List<Player> players;

    //constructor
    public Team() {
        players = new ArrayList<Player>();
    }
    public Team(Player[] p) {
        players = Arrays.asList(p);
    }

    //Methods
    public List<Player> getPlayers() {
        return players;
    }

    public void getTeamFromFile() throws FileNotFoundException {
        File file = new File("./import/Players.txt");
        Scanner scanner = new Scanner(file);
        String temp;
        if(!file.exists()) {
            System.out.println("File Does not Exist");
            return;
        }

        while(scanner.hasNextLine()) {
            temp = scanner.nextLine();
            String[] tempPlayer = temp.split("\\|");
            players.add(new Player(tempPlayer[0], Double.parseDouble(tempPlayer[1])));
        }

    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for(Player player : players) {
            out.append(player.toString()).append("\n");
        }
        try {
            out.delete(out.length() - 1, out.length());
        } catch (Exception e) {
        }
        return out.toString();
    }
}
