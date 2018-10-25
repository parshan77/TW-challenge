import java.util.ArrayList;

public class GilgCity {

    private ArrayList<Block> blocks = new ArrayList<>();
    private int score;
    private int gills;
    private boolean hasArmy;

    public GilgCity(){
        gills = 30000;
        score = 0;
        hasArmy = false;
    }

    public int seeScore(){
        return score;
    }

    public int seeGills(){
        return gills;
    }

    public boolean isThisBlockIdExists(int blockId){
        for (Block block : blocks){
            if (block.getId() == blockId){
                return true;
            }
        }
        return false;
    }

    public void addBlock(){
        int maxId = 0;
        if (gills < 1000){
            System.out.println("not possible");
        } else {
            for (Block block : blocks) {
                int thisBlockId = block.getId();
                if (thisBlockId > maxId)
                    maxId = thisBlockId;
            }
            blocks.add(new Block(maxId + 1));
            System.out.println(maxId + 1);        //id sh ro chap mikonim
        }
    }

    //bikar kardane afrad ro naneveshtim
    public void removeBlock(int deletingBlockId){
        int index = -1;
        for (int i = 0; i < blocks.size(); i++){
            int thisBlockId = blocks.get(i).getId();
            //agar id e in block hamun id E bud ke bayad hazf beshe hazfesh mikonim
            if (thisBlockId == deletingBlockId){
                index = thisBlockId;
            }
        }
        if (index == -1){
            System.out.println("not possible");
        } else {
            blocks.remove(index);
            gills += 500;
        }
    }

    //mashghul kardane afrad ro benevis
    public void upgradeBlock(int deletingBlockId){
        int index = -1 ;
        for (int i = 0; i < blocks.size(); i++){
            int thisId = blocks.get(i).getId();
            if (thisId == deletingBlockId){
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("not possible");
        } else {
            int cost = blocks.get(index).getUpgradeCost();
            if (gills < cost){
                System.out.println("not possible");
            } else {
                gills -= cost;
                blocks.get(index).upgradeBlock();
            }
        }
    }

    //check kon niruye kafi darim ya na
    //niruhaye artesh az hamun block bayad tamin beshan
    public void addArmy(int blockId){
        if (hasArmy){
            System.out.println("not possible");
        } else {
        }
    }
    public void addBazar(int BlockId){
        for (Block block : blocks){
            if(BlockId == block.getId()){
                this.gills -= 6000;
            }
        }
    }
    public void removeBazar(int BlockId ,int UnitId){
        for (Block block : blocks){
            if(BlockId ==block.getId()){
                for (int i = 0; i < block.buildings.size(); i++){
                    if (block.buildings.get(i).)
                }
            }
        }
    }
    public void upgradeBazar(int BlockId,int UnitId){
        for (Block block : blocks){
            if(UnitId ==block.getId() ){

            }
        }
    }

}