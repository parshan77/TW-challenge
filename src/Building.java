public abstract class Building {

    int blockId;
    int level;
    int id;
    int capacity;
    int daysActivated;
    int baseScore;
    int maxLevel;

    public int getScore(){
        return (int) Math.pow(baseScore, daysActivated);
    }

    public void upgrade(){
        if (level < maxLevel) level++ ;
        else System.out.println("not possible");
    }

    public void dayPassed(){
        this.daysActivated ++ ;
    }

    public abstract int getUpgradeCost();

}
