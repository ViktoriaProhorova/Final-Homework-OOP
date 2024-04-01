public class Human {
    private String name;
    private String surname;
    private String weight;
    private String height;
    private String gender;

    public Human(String name, String surname, String weight, String height, String gender) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.gender = "N/A";
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public String setSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getWeight() {
        return weight;
    }

    public String setWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public String setHeight() {
        return height;
    }

    public void setHeight(String weight) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public String setGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void presentYourself() {
        System.out.println("I'm a human! I was going to present myself, but I don't want.");
    }

    public void describeYourself() {
        System.out.printf("So I'm not sure how can I describe myself, I haven't decided yet what gender I am...");
    }
}
