import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Player test = new Player("Chuck", 7.8);
        Team testing = new Team("Johns");
//        testing.getTeamFromTXT();
//        testing.exportTeamToJSON();
        testing.importTeamFromJSON("Johns");
//        testing.getTeamFromTXT();
//        testing.writeTeamToTXT();
//        System.out.println(testing);
//        testing.exportTeamToJSON();
        System.out.println(testing);
    }
}