import javax.lang.model.type.UnionType;
import java.util.ArrayList;

public class Floor {

    public ArrayList<Unit> units = new ArrayList();

    public Floor(int numberOfUnits){
        for (int i = 0; i < numberOfUnits; i++) {
            units.add(new Unit());
        }
    }

    public int getScore(){
        int score = 3 ;
        for (Unit unit : units){
            score += unit.getScore();
            for (Person person : unit.persons){
                score += 2 * person.getScore();
            }
        }
        return score;
    }

    public void upgrade(boolean addToUnits ){
        units.add(new Unit());
    }
}
