import java.util.ArrayList;

public class Block {
    private int id;
    private int maxBuildings = 15;
    ArrayList buildings = new ArrayList();
    public Block(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public int getMaxBuildings() {
        return maxBuildings;
    }
    public void addMaxBuildings() {
        this.maxBuildings += 5;
    }

}
