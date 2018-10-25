import java.util.ArrayList;

public class GilgCity {

    private ArrayList<Block> blocks = new ArrayList<>();
    private int score;
    private int gills;
    private boolean hasArmy;

    public GilgCity() {
        gills = 30000;
        score = 0;
        hasArmy = false;
    }

    public int seeScore() {
        return score;
    }

    public int seeGills() {
        return gills;
    }

    //age hamichin blocky nadashte bashim -1 midim
    public int getThisBlockIndex(int blockId) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getId() == blockId)
                return i;
        }
        return -1;
    }

    public void addBlock() {
        int maxId = 0;
        if (gills < 1000) {
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
    public void removeBlock(int deletingBlockId) {
        int index = -1;
        for (int i = 0; i < blocks.size(); i++) {
            int thisBlockId = blocks.get(i).getId();
            //agar id e in block hamun id E bud ke bayad hazf beshe hazfesh mikonim
            if (thisBlockId == deletingBlockId) {
                index = thisBlockId;
            }
        }
        if (index == -1) {
            System.out.println("not possible");
        } else {
            blocks.remove(index);
            gills += 500;
        }
    }

    //mashghul kardane afrad ro benevis
    public void upgradeBlock(int deletingBlockId) {
        int index = -1;
        for (int i = 0; i < blocks.size(); i++) {
            int thisId = blocks.get(i).getId();
            if (thisId == deletingBlockId) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("not possible");
            return;
        }
        int cost = blocks.get(index).getUpgradeCost();
        if (gills < cost) {
            System.out.println("not possible");
            return;
        }
        gills -= cost;
        blocks.get(index).upgradeBlock();
    }


    public void addHome(int blockId, int floors, int units){
        int maxId = 0;
        int index = 0;
        for (int i = 0; i < blocks.size(); i++){
            if (blocks.get(i).getId() == blockId)
                index = i;
        }
        if (blocks.get(index).buildings.size() < blocks.get(index).getMaxBuildings()) {
            if (gills > Home.getAddHomeCost(units, floors)) {
                maxId = blocks.get(index).buildings.size() - 1;
                if (maxId < blocks.get(index).getMaxBuildings())
                    new Home(maxId + 1, blockId, floors, units);
            }
        }
    }
    //check kon niruye kafi darim ya na
    //niruhaye artesh az hamun block bayad tamin beshan
    //ino nazadam
    public void addArmy(int blockId) {
        if (hasArmy) {
            System.out.println("not possible");
            return;
        }
        int index = getThisBlockIndex(blockId);
        if (index == -1) {      //blocki nadarim ke index esh in bashe
            System.out.println("not possible");
            return;
        }
        if (gills < 15000) {        //poole kafi baraye sakhte army nadarim
            System.out.println("not possible");
            return;
        }
        int lastUsedId = blocks.get(index).getLastUsedId();
        blocks.get(index).buildings.add(new Army(lastUsedId + 1, blocks.get(index).getId()));
    }

    public void upgradeArmy(int blockId, int buildingId) {
        int upgradeCost = 20000;
        if (gills < upgradeCost) {
            System.out.println("not possible");
            return;
        }
        int blockIndex = getThisBlockIndex(blockId);
        if (blockIndex == -1){
            System.out.println("not possible");
            return;
        }
        int buildingIndex = blocks.get(blockId).getThisBuildingIndex(buildingId);
        if (buildingIndex == -1){
            System.out.println("not possible");
            return;
        }
        if (!(blocks.get(blockId).buildings.get(buildingId) instanceof Army)){
            System.out.println("not possible");
            return;
        }
        blocks.get(blockId).buildings.get(buildingId).upgrade();
        gills -= upgradeCost;
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
                    if (block.buildings.get(i).id == UnitId)
                        this.gills -= 500;
                }
            }
        }
    }
    public void upgradeBazar(int BlockId,int UnitId){
        for (Block block : blocks){
            if(BlockId ==block.getId()){
                for (int i = 0; i < block.buildings.size(); i++){
                    if (block.buildings.get(i).id == UnitId)
                        this.gills -= 5000 * (1 + block.buildings.get(i).level);

                }
            }
        }
    }


    public void upgradeDefence(int blockId, int buildingId){
        int upgradeCost = 5000;
        if (gills < upgradeCost) {
            System.out.println("not possible");
            return;
        }
        int blockIndex = getThisBlockIndex(blockId);
        if (blockIndex == -1){
            System.out.println("not possible");
            return;
        }
        int buildingIndex = blocks.get(blockId).getThisBuildingIndex(buildingId);
        if (buildingIndex == -1){
            System.out.println("not possible");
            return;
        }
        if (!(blocks.get(blockId).buildings.get(buildingId) instanceof Defence)){
            System.out.println("not possible");
            return;
        }
        blocks.get(blockId).buildings.get(buildingId).upgrade();
        gills -= upgradeCost;
    }
}