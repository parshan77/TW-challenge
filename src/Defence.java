public class Defence extends Building{

    double defenceLevel;

    public Defence(int blockId, int id) {   //block E ke tushe ro midim behesh
        this.id = id;
        level = 1;
        this.blockId = blockId;         //id e block E ke tushe
        capacity = 30;
        daysActivated = 1;
        maxLevel = 5;
        defenceLevel = 0.2;
    }

    public void upgrade(){
        this.level ++;
        this.defenceLevel += 0.2;
    }

    public int getLevel(){
        return this.level;
    }

    public int getScore(){
        return (int) Math.pow(15, daysActivated);
    }


}
