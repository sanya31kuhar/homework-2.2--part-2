package Human;

public class Human {

    private int yearOfBirth;
    public String name;
    private String town;
    public String job;

    public Human(String name, String town, int yearOfBirth, String job) {
        if (yearOfBirth < 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
        if (name == null) {
            this.name = " Информация не указана";
        } else {
            this.name = name;
        }
        if (town == null) {
            this.town = " Информация не указана";
        } else {
            this.town = town;
        }
        if (job == null) {
            this.job = " Информация не указана";
        } else {
            this.job = job;
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth < 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town == null) {
            this.town = "Информация не указана";
        } else {
            this.town = town;
        }
    }
}
