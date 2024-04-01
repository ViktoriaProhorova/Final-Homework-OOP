public class Women extends Human {

    public Women(String name, String surname, String weight, String height, String gender) {
        super(name, surname, weight, height, gender);
        setGender("Woman");
    }

    @Override
    public void presentYourself() {
        System.out.println("I'm a woman. I can speak about myself for hours! I'm soft and cute.");
    }

    @Override
    public void describeYourself() {
        System.out.println
                ("Interesting fact about women: women have a higher percentage of body fat, " +
                        "which gives them a curvier, more rounded appearance (often known as the “hourglass figure");
    }
}
