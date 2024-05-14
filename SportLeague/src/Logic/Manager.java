package Logic;

import java.time.LocalDate;

public class Manager extends Member {
    private double bouncePercentage;
    private String qualifications;

    public Manager(String name, LocalDate dob, String address, String nationality, double yearlySalary, double bouncePercentage, String qualifications) {
        super(name, dob, address, nationality, yearlySalary);
        this.bouncePercentage = bouncePercentage;
        this.qualifications = qualifications;
        // add ERROR for each
    }

    public double getBouncePercentage() {
        return bouncePercentage;
    }

    public void setBouncePercentage(double bouncePercentage) {
        this.bouncePercentage = bouncePercentage;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\tManager\t%s\t%s\t%s\t%,g\t%s%n"
                , getId(), getName(), getAddress()
                , getDob(), getNationality()
                , getBouncePercentage(), getQualifications());

//        return String.format("%3d\tManager\t%20S\t%30S\t%9S\t%10S\t%,3g\t%20S%n"
//                , getId(), getName(), getAddress()
//                , getDob(), getNationality()
//                , getBouncePercentage(), getQualifications());

    }
}
