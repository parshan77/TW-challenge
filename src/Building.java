public abstract class Building {

    protected int blockId;
    protected int level;
    protected int id;
    protected int capacity;
    protected int daysActivated;
    protected int baseScore;
    protected int maxLevel;

    public int getScore(){
        return (int) Math.pow(baseScore, daysActivated);
    }

    public void upgrade(){
        if (level < maxLevel) level++ ;
        else System.out.println("not possible");
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void dayPassed(){
        this.daysActivated ++ ;
    }



}
