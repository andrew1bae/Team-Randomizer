package components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.FileWriter;

/**
 * A collection of players that has a name
 */
public class Team {
    private final List<Player> players;
    private String teamName;

    //constructors
    public Team() {
        this.players = new ArrayList<Player>();
        this.teamName = "";
    }
    public Team(String teamName) {
        this.players = new ArrayList<Player>();
        this.teamName = teamName;
    }
    public Team(List<Player> players) {
        this.players = players;
        this.teamName = "";
    }
    public Team(Player[] p) {
        this.players = Arrays.asList(p);
        this.teamName = "";
    }
    public Team(String teamName, List<Player> players) {
        this.teamName = teamName;
        this.players = players;
    }
    public Team(String teamName, Player[] p) {
        this.teamName = teamName;
        this.players = Arrays.asList(p);
    }

    //Methods

    /**
     * Returns a String of the name of the team
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the team
     * @param name - name that you want the team to be
     */
    public void setTeamName(String name) {
        teamName = name;
    }

    /**
     * Returns an ArrayList of Players
     * @return List of Players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Adds a player to the players List
     * @param player - player you want to add
     */
    public void addPlayer(Player player) {
        if(getNames().contains(player.getName())) {
            System.out.println("Insertion Failed: Player Exists");
            return;
        }
        players.add(player);
    }

    /**
     * Removes a player from the List using a String of the name that you want to remove
     * @param name - name of the player you want to remove
     */
    public void removePlayer(String name) {
        for(Player player: players) {
            if(player.getName().equals(name)) {
                players.remove(player);
                return;
            }
        }
    }

    /**
     * Returns an ArrayList of the Names of the Players
     * @return player names
     */
    public List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for(Player player : players) {
            names.add(player.getName());
        }
        return names;
    }

    /**
     * Looks for Players.txt file in the import folder and adds the players to the players ArrayList
     * @throws FileNotFoundException
     */
    public void getTeamFromTXT() throws FileNotFoundException {
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
                addPlayer(new TeamCaptain(tempPlayer[0], Double.parseDouble(tempPlayer[1])));
            } else {
                addPlayer(new Player(tempPlayer[0], Double.parseDouble(tempPlayer[1])));
            }
        }
        scanner.close();
    }

    /**
     * Exports the ArrayList players to a txt file
     */
    public void writeTeamToTXT() {
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

    /**
     * Converts the attributes of the Team to a JSON File and stores it in the exports folder
     * @throws IOException
     */
    public void exportTeamToJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        ArrayNode teamNode = mapper.createArrayNode();
        ObjectNode mainNode = mapper.createObjectNode();
        for(Player player : players) {
            ObjectNode playerNode = mapper.createObjectNode();
            playerNode.put("name", player.getName());
            playerNode.put("weight", player.getWeight());
            playerNode.put("isTeamCaptain", player.getIsTeamCaptain());
            teamNode.add(playerNode);
        }
        mainNode.put("teamName", teamName);
        mainNode.set("players", teamNode);
        mapper.writeValue(new File("./export/" + teamName +".json"), mainNode);
    }

    /**
     * Reads a JSON file and stores information as a Team
     * @param teamNameJSON - name of the file
     * @throws IOException
     */
    public void importTeamFromJSON(String teamNameJSON) throws IOException {
        File file = new File("./import/" + teamNameJSON + ".json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(file);
        setTeamName(rootNode.get("teamName").asText());
        ArrayNode teamNode = (ArrayNode) rootNode.get("players");
        for(JsonNode playerNode : teamNode){
            Player player = new Player(playerNode.get("name").asText(), playerNode.get("weight").asDouble());
            boolean isTeamCaptain = playerNode.get("isTeamCaptain").asBoolean();
            if(isTeamCaptain) {
                player = new TeamCaptain(player);
            }
            addPlayer(player);
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for(Player player : players) {
            out.append(player.toString()).append("\n");
        }
        try {
            out.delete(out.length() - 1, out.length());
        } catch (Exception _) {
        }
        return out.toString();
    }
}
