import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

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
            if(tempPlayer.length == 3 && tempPlayer[2].equals("*")) {
                players.add(new TeamCaptain(tempPlayer[0], Double.parseDouble(tempPlayer[1])));
            } else {
                players.add(new Player(tempPlayer[0], Double.parseDouble(tempPlayer[1])));
            }
        }
        scanner.close();
    }

    public void writeTeamToFile() {
        try {
            FileWriter writer = new FileWriter("./export/Players.txt");
            for(Player player : players) {
                if(player instanceof TeamCaptain) {
                    writer.write(player.getName() + "|" + player.getWeight() + "|*\n");
                } else {
                    writer.write(player.getName() + "|" + player.getWeight() + "\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error Has Occured");
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
