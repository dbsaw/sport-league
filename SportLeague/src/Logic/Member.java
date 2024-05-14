package Logic;


import java.awt.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import javax.swing.text.html.ImageView;

public abstract class Member implements Comparable<Member> {
    public static final Comparator<String> NAME_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1 == null && s2 == null) {
                return 0;
            }
            if (s1 == null) {
                return -1;
            }
            if (s2 == null) {
                return 1;
            }
            return s1.compareTo(s2);
        }
    };


    private static int id_increment = 0;
    private final int id;
    private String name;
    private LocalDate dob;
    private String address;
    private String nationality;
    private double yearlySalary;


    public Member(String name, LocalDate dob, String address, String nationality, double yearlySalary) {
        this.id = ++id_increment;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.nationality = nationality;
        this.yearlySalary = yearlySalary;
    }

//    public static int nextId_increment() {
//        return ++id_increment;
//    }

    public static int getId_increment() {
        return id_increment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob.format(DateTimeFormatter.ofPattern("d/M/yyyy"));
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }


    public Label getModify() {
        Label label = new Label();


//        label.setOnMouseClicked(event -> {
//            System.out.println(event.getEventType());
////            event.get
//        });

//
//        label.setContextMenu(new ContextMenu(new CheckMenuItem(id + "")));

        return label;
    }

    public String getClassName() {
        if (this instanceof Player)
            return "Player";

        return "Manager";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int compareTo(Member m) {
        return Integer.compare(this.id, m.getId());
    }
}
