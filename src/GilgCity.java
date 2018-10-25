import java.util.ArrayList;

public class GilgCity {

    public ArrayList<Block> blocks = new ArrayList();
    private int score;
    private int gills;

    public GilgCity(){
        gills = 30000;
        score = 0;
    }

    public int seeScore(){
        return score;
    }

    public int seeGills(){
        return gills;
    }

    public void addBlock(){
        int maxId = 0;
        for (Block block : blocks){
            int thisBlockId = block.getId();
            if (thisBlockId > maxId)
                maxId = thisBlockId;
        }
        if (gills >= 1000) {
            blocks.add(new Block(maxId + 1));
            System.out.println(maxId + 1);        //id sh ro chap mikonim
        }
        else System.out.println("not possible");
    }

    public void removeBlock(int blockId){
        for (int i = 0; i < blocks.size(); i++){
            //int thisBlockId = block.getId();
            //agar id e in block hamun id E bud ke bayad hazf beshe hazfesh mikonim

        }
    }

    public void upgradeBlock(int BlockId){

    }

}