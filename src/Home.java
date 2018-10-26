import java.util.ArrayList;

public class Home extends Building {

    public ArrayList<Floor> floors = new ArrayList<>();

    public int getScore() {
        int score = 10;
        for (Floor floor : floors) {
            score += floor.getScore();
            for (Unit unit : floor.units) {
                score += 2 * unit.getScore();
                for (Person person : unit.persons) {
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
        if (numberOfFloorsNow + addingFloors <= 6) {
            for (int i = 0; i < addingFloors; i++) {
                this.floors.add(new Floor(numberOfUnits));  //?
            }
        }
    }

    public void addUnits() {

    }

    public Home(int id, int blockId, int floors, int units) {
        this.id = id;
        this.blockId = blockId;
        for (int i = 0; i < floors; i++) {
            this.floors.add(new Floor(units));
        }
    }

    public static int getAddHomeCost(int floors, int units) {
        return 700 + 300 * floors + 100 * (units * floors);
    }

    //addedFloors, addedUnits = 0 ya 1
    public int getUpgradeHomeCost(boolean addUnits, boolean addFloors) {
        int cost;
        int floorsBefore = this.floors.size();
        int unitsInEachFloorBefore = this.floors.get(0).units.size();
        if (!addFloors) {
            if (addUnits) {
                cost = 1 * floorsBefore;
                return cost;
            }
            if (!addUnits){
                return 0;
            }
        }
        //addFloors = true:
        if (addUnits) {
            cost = 300 + unitsInEachFloorBefore * 50 + (floorsBefore + 1) * 1 * 50;
            return cost;
        }
        return 0;
    }

    //  public boolean isUpgradable(boolean addFloor, boolean addUnit) {}



}
