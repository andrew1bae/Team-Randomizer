import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Player test = new Player("Chuck", 7.8);
        Player test2 = new TeamCaptain(test);
        Team testing = new Team();
        testing.getTeamFromFile();
        testing.writeTeamToFile();
        System.out.println(testing);
        //System.out.println(test.getName());
//        System.out.println(test2.getName());
//        System.out.println(test2);

    }
}