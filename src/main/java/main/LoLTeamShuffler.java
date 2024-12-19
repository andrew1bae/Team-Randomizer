package main;

import components.*;

import java.io.IOException;

public class LoLTeamShuffler {
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