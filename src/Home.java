import java.util.ArrayList;

public class Home extends Building{

    public ArrayList<Floor> floors = new ArrayList<>();

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
     private int numberOfUnits = floors.get(0).units.size();
    //ye tabaghe jadid misazim ke tedade vahedash andazeye tabgaghe payinias




    public void addFloor(int addingFloors) {
        numberOfUnits = floors.get(0).units.size();
        int numberOfFloorsNow = this.floors.size();
        if (numberOfFloorsNow + addingFloors <= 6){
            for (int i = 0; i < addingFloors; i++) {
                this.floors.add(new Floor(numberOfUnits));  //?
            }
        }
    }
    public void addUnits(){

    }

    public Home(int id, int blockId, int floors, int units) {
        this.id = id;
        this.blockId = blockId ;
        for (int i = 0; i < floors; i++){
            this.floors.add(new Floor(units));
        }

    }

    public static int getAddHomeCost(int floors, int units) {
        return floors * 300 + (units * floors) * 100 + 700;
    }


    public static int getUpgradeHomeCost(int unit, int floor) {
        return (unit * floor) * 50 + floor * 300;
    }
}
