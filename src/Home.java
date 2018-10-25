import java.util.ArrayList;

public class Home {
    public ArrayList floors = new ArrayList();
    private int id;
    int blockId ;
    public int getScore(){
        int score = 10;
        for (Floor floor : floors) {
            socore+= floor.getScore();
        }
        return score;
    }
    public floor addFloor(int x){
        for (int i = 0; i < x; i++) {
            floors.add(new Floor());
        }
    }
    public Home(int id,int blockId){
        this.id = id;
        this.blockId = blockId ;
    }

}
