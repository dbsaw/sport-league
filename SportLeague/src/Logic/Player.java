package Logic;

import java.time.LocalDate;

public class Player extends Member {
    private String position;
    private boolean isCaptain;


    public Player(String name, LocalDate dob, String address, String nationality
            , double yearlySalary, String position, boolean isCaptain) {
        super(name, dob, address, nationality, yearlySalary);
//        this.weeklySalary = weeklySalary;
        this.position = position;
        this.isCaptain = isCaptain;
        // add ERROR for each
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }


    // for tables
    public String getIsCaptain() {
        return isCaptain ? "Yes" : "No";
    }

    @Override
    public String toString() {
        return String.format("%3d\tPlayer\t%20s\t%30s\t%9s\t%10s\t%15s\t%,10g\t%s%n"
                , getId(), getName(), getAddress()
                , getDob(), getNationality()
                , getPosition(), getYearlySalary()
                , (isCaptain() ? "Captain" : "Not Captain"));
    }


}

