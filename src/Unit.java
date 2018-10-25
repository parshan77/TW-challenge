import java.util.ArrayList;

public class Unit {

    public ArrayList<Person> persons = new ArrayList();
    public int getScore(){
        int score = 2;
        for (Person person : persons){
            score += person.getScore();
        }
        return score;
    }
    public Unit(){
        for (int i = 0; i < 5; i++) {
            persons.add(new Person());
        }
    }
}
