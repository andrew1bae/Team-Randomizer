import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Player test = new Player("Chuck", 7.8);
        Team testing = new Team();
        testing.getTeamFromFile();
        for(Player player : testing.getPlayers()) {
            System.out.println(player);
        }
        System.out.println(test.getName() + "\n" + test.getWeight());
    }
}