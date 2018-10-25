public class Bazaar extends Building {

    public Bazaar(int blockId){
        this.level = 1;
        this.blockId = blockId;
        this.baseScore = 5;
        this.capacity = 50;


    }

    @Override
    public int getUpgradeCost() {
        return (level + 1) * 5000;
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.capacity += 20;
    }
}
