import java.util.ArrayList;

public class Army extends Building{

    private double attackLevel;
    public ArrayList<Person> employees = new ArrayList<>();

    public Army(int id, int blockId){
        this.id = id;
        level = 1;
        this.blockId = blockId;
        maxLevel = 5;
        baseScore = 10;
        attackLevel = 0.2;
    }

    public void upgradeArmy(){
        level++;
        attackLevel += 0.2;
    }

    public double getAttackLevel() {
        return attackLevel;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    public int getBlockId() {
        return blockId;
    }

    public int getRemoveCost() {
        return -10000;
    }

}

