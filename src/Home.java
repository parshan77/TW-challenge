import java.util.ArrayList;

public class Home extends Building{
    public ArrayList floors = new ArrayList();

    public int getScore(){
        int score = 10;
        for (Floor floor : floors) {
            score+= floor.getScore();
            for (Unit unit : floor.units){
                score += 2 * unit.getScore();
                for (Person person : unit.persons){
                    score += 3 * person.getScore();
                }
            }
        }
        return score;
    }

    public void addFloor(int addingFloors) {
        int numberOfFloorsNow = this.floors.size();
        if (numberOfFloorsNow + addingFloors <= 6){
            for (int i = 0; i < addingFloors; i++) {
                this.floors.add(new Floor());
            }
        }
    }

    public Home(int id,int blockId){
        this.id = id;
        this.blockId = blockId ;
    }

}
