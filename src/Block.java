import java.util.ArrayList;

public class Block {
    private int id;
    private int maxBuildings = 15;
    ArrayList<Building> buildings = new ArrayList<>();
    private int level;

    public Block(int id){
        this.id = id;
        level = 1;
    }

    public int getId() {
        return id;
    }

    public void upgradeBlock() {
        this.maxBuildings += 5;
    }

    public int getUnemployedPeople(){
        int unemployedPeople = 0;
        for (Building building : buildings) {
            if (building instanceof Home){
                for (Floor floor : ((Home) building).floors){
                    for ( Unit unit : floor.units){
                        for ( Person person : unit.persons){
                            if (!person.getIsEmployed()){
                                unemployedPeople++;
                            }
                        }
                    }
                }
            }
        }
        return unemployedPeople;
    }

    public int getUpgradeCost(){
        return (int) Math.pow(500, level);
    }

    public int getMaxBuildings() {
        return maxBuildings;
    }

    public int getThisBuildingIndex(int buildingId){
        for (int i = 0; i < buildings.size(); i++){
            if (buildings.get(i).getId() == id){
                return id;
            }
        }
        return -1;
    }

    public int getLastUsedId(){
        int lastId = 0;
        for (Building building : buildings) {
            if (building.id > lastId){
                lastId = building.id;
            }
        }
        return lastId;
    }

    public boolean isUpgradable(){
        if (level < 3)
            return true;
        return false;
    }

}
