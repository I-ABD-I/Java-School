package dataStructs.linkedlist.modelUnion;

public class Model {
    private String name;
    private String id;
    private String birthYear;
    private String expertise;

    public Model(String name, String id, String birthYear, String expertise) {
        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

}
