public class Men extends Human {

    public Men(String name, String surname, String weight, String height, String gender) {
        super(name, surname, weight, height, gender);
        setGender("Man");
    }

    @Override
    public void presentYourself() {
        System.out.println("I'm a man. I'm strong and handsome.");
    }

    @Override
    public void describeYourself() {
        System.out.println
                ("Interesting fact about men: Men tend to " +
                        "have more muscle mass, particularly in the upper body," +
                        " which gives them a more pronounced “V-shape” physique.");
    }
}
