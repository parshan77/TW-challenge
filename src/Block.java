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
        for (Building building : buildings){
            for (Floor floor : building.)
        }
    }

    public int getUpgradeCost(){
        return (int) Math.pow(500, level);
    }

    public boolean isThisBuildingIdExists(int id){
        for (Building building : buildings){
            if (building.getId() == id){
                return true;
            }
        }
        return false;
    }

}
