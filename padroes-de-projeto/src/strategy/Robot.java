package strategy;

public class Robot {

    private Beahaviour beahaviour;

    public void setBehaaviour(Beahaviour beahaviour) {
        this.beahaviour = beahaviour;
    }

    public void move() {
        beahaviour.move();
    }


}
