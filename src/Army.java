public class Army extends Building{
    private double attackLevel;
    private int level = 1;
    private int id;
    private int blockId;
    private int daysActivated;
    private int baseScore = 10;

    public Army(int id, int blockId){
        this.id = id;
        this.blockId = blockId;
        this.maxLevel = 5;
    }

    public double getAttackLevel() {
        return attackLevel;
    }
    public void setAttackLevel(double attackLevel) {
        this.attackLevel = attackLevel;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBlockId() {
        return blockId;
    }
    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }


    public int getUpgradeCost() {
        return 20000;
    }


    public int getAddCost() {
        return 15000;
    }


    public int getRemoveCost() {
        return -10000;
    }

}

