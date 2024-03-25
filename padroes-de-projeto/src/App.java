import facade.Facade;
import strategy.AttackBeahaviour;
import strategy.Beahaviour;
import strategy.DefenseBeahaviour;
import strategy.NormalBeahaviour;
import strategy.Robot;

public class App {
    public static void main(String[] args) {

        /* Strategy 
        Beahaviour normal = new NormalBeahaviour();
        Beahaviour attack = new AttackBeahaviour();
        Beahaviour defense = new DefenseBeahaviour();
        
        Robot robot =  new Robot();

        robot.setBehaaviour(normal);

        robot.move();
        robot.move();

        robot.setBehaaviour(attack);
        robot.move();

        robot.setBehaaviour(defense);
        robot.move();
        */


        /*Facade */
        Facade facade = new Facade();

        facade.migrateClient("Gibran", "98765432");
        

        

    }
}
