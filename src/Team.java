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
        File file = new File("./Resources/Players.txt");
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
}
