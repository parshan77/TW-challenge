public class Defence extends Building{

    public Defence(int blockId, int id) {   //block E ke tushe ro midim behesh
        this.id = id;
        level = 1;
        this.blockId = blockId;         //id e block E ke tushe
        capacity = 30;
        daysActivated = 1;
        this.maxLevel = 5;
    }

    public void upgrade(){
        this.level ++;
    }

    public int getLevel(){
        return this.level;
    }

    public int getScore(){
        return (int) Math.pow(15, daysActivated);
    }

    @Override
    public int getUpgradeCost() {
        return 5000;
    }
}