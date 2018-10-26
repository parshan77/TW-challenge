import java.util.ArrayList;

public class Bazaar extends Building {

    public ArrayList<Person> employees = new ArrayList<>();

    public Bazaar(int blockId) {
        this.level = 1;
        this.blockId = blockId;
        this.baseScore = 5;
        this.capacity = 50;


    }

    public int getUpgradeCost() {
        return (level + 1) * 5000;
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.capacity += 20;
    }
}
