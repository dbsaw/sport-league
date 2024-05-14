package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class League {

    private static final Scanner scanner;

    static {

        scanner = new Scanner(System.in);

    }

    private String name = "League";
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Player> unAssignedPlayers = new ArrayList<>();


    public League() {
    }

    public League(String name, ArrayList<Team> teams, ArrayList<Player> unAssignedPlayers) {
        // for reading info from file
        this.name = name;
        this.teams = teams;
        this.unAssignedPlayers = unAssignedPlayers;
    }

    public League(String name) {
        this.name = name;
    }

    public ArrayList<Member> listAllMembers() { // of luge
        ArrayList<Member> members = new ArrayList<>();
        teams.forEach(team -> {
            members.add(team.getManager());
            members.addAll(team.getPlayers());
        });
        members.addAll(unAssignedPlayers);
//        for (Team t : this.teams) {
//            System.out.println(t.getName() + "\t" + t.getManager());
//            for (Player p : t.getPlayers()) {
//                System.out.println("\t" + p);
//            }
//            System.out.println();
//        }
        return members;
    }

    public ArrayList<Member> listAllPlayers() { // of luge
        ArrayList<Member> players = new ArrayList<>();
        teams.forEach(team -> {
            players.addAll(team.getPlayers());
        });
        players.addAll(unAssignedPlayers);

        return players;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Player> getUnAssignedPlayers() {
        return new ArrayList<>(unAssignedPlayers);
    }

    public void setUnAssignedPlayers(ArrayList<Player> unAssignedPlayers) {
        this.unAssignedPlayers = unAssignedPlayers;
    }

    public void addUnAssignedPlayer(Player player) {
        if (!this.unAssignedPlayers.contains(player)) {
            this.unAssignedPlayers.add(player);
        }

    }

    public Member searchId(int id) {
        Manager manager;
        boolean found = false;

        for (Team t : this.teams
        ) {
            manager = t.getManager();
            if (manager.getId() == id) {
                return manager;
            }
            for (Player p : t.getPlayers()
            ) {
                if (p.getId() == (id)) {
                    return p;
                }
            }
        }

        for (Player p : this.unAssignedPlayers
        ) {

            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public int getPlayersCount() {
        return this.listAllPlayers().size();
    }

    public double getAvgSalary() {
        int count = 0;
        double sal = 0;
        for (Member m : this.listAllMembers()
        ) {
            sal += m.getYearlySalary();
            count++;
        }
        return sal / count;
    }

}
