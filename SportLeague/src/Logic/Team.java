package Logic;

import java.util.ArrayList;

public class Team {
    private String name;
    private String stadiumName;
    private int stadiumCapacity;

    private ArrayList<Player> players = new ArrayList<>();
    private Manager manager;

    public Team(String name, String stadiumName, int stadiumCapacity) {
        this.name = name;
        this.stadiumName = stadiumName;
        this.stadiumCapacity = stadiumCapacity;
        this.players = new ArrayList<>();
    }

    public Team(String name, String stadiumName, int stadiumCapacity, ArrayList<Player> players, Manager manager) {
        this.name = name;
        this.stadiumName = stadiumName;
        this.stadiumCapacity = stadiumCapacity;
        this.players = players;
        this.manager = manager;
    }

    public void addPlayer(Player player) {
        if (player.isCaptain()) {
            for (Player p : this.players) {
                if (p.isCaptain()) {
                    p.setCaptain(false);
                    break; // check
                }
            }
        }
        this.players.add(player);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void removePlayer(Member player) {
        this.players.remove(player);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Player getCaptain() {
        Player player = null;
        for (Player p : this.players
        ) {
            if (p.isCaptain()) {
                player = p;
            }
        }
        return player;
    }

    public void setCaptain(Player player) {
        if (!player.isCaptain()) {
            for (Player p : this.players) {
                p.setCaptain(false);
            }
            player.setCaptain(true);
        }

    }

    @Override
    public String toString() {
        return name + "\t" + stadiumName + "\t" + stadiumCapacity;
//                "Team{" +
//                "name='" + name + '\'' +
//                ", stadiumName='" + stadiumName + '\'' +
//                ", stadiumCapacity=" + stadiumCapacity +
//                '}';
    }
}
