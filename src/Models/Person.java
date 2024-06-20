package Models;

public class Person {
    private String nameAndSurname;
    private Integer age;
    private String neighborhood;
    private Integer dni;
    private String occupation;
    private Integer kitNumber;

    public Person() {
    }

    public Person(String nameAndSurname, Integer age, String neighborhood, Integer dni, String occupation) {
        this.nameAndSurname = nameAndSurname;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.occupation = occupation;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Integer kitNumber) {
        this.kitNumber = kitNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameAndSurname='" + nameAndSurname + '\'' +
                ", age=" + age +
                ", neighborhood='" + neighborhood + '\'' +
                ", dni=" + dni +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
