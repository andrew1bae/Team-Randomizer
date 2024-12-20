package tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import components.Player;
import components.TeamCaptain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class playerJSON {
    private static List<Player> players;
    public playerJSON() {

    }

    //Methods
    /**
     * Adds a player to the players List
     * @param player - player you want to add
     */
    public static void addPlayer(Player player) {
        if(getNames().contains(player.getName())) {
            System.out.println("Insertion Failed: Player Exists");
            return;
        }
        players.add(player);
    }
    /**
     * Returns an ArrayList of the Names of the Players
     * @return player names
     */
    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for(Player player : players) {
            names.add(player.getName());
        }
        return names;
    }
    /**
     * Reads a JSON file and stores information as a List of Player classes
     * @param teamNameJSON - name of the file
     * @throws IOException
     */
    public static void importTeamFromJSON(String teamNameJSON) throws IOException {
        File file = new File("./import/players.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(file);
        ArrayNode teamNode = (ArrayNode) rootNode.get("players");
        for(JsonNode playerNode : teamNode){
            Player player = new Player(playerNode.get("name").asText(), playerNode.get("weight").asDouble());
            addPlayer(player);
        }
    }
}
