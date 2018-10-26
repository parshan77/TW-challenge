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

    public void addBlock() {
        int cost = 1000;
        if (gills < cost) {
            System.out.println("not possible");
            return;
        }
        int id = getLastBlockId() + 1;
        blocks.add(new Block(id));
        System.out.println(id);        //id sh ro chap mikonim
        gills -= cost;
    }

    private int getLastBlockId() {
        int maxId = 0;
        for (Block block : blocks) {
            int thisBlockId = block.getId();
            if (thisBlockId > maxId)
                maxId = thisBlockId;
        }
        return maxId;
    }

    //ba hazfe bolook tamame anasore dakhelesh az bein miran -> benevis
    public void removeBlock(int deletingBlockId) {
        int income = 500;
        int index = getBlockIndex(deletingBlockId);
        if (index == -1) {
            System.out.println("not possible");
            return;
        }
        blocks.remove(index);
        gills += income;
    }

    private int getBlockIndex(int blockId) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getId() == blockId) {
                return i;
            }
        }
        return -1;
    }   //age block E ba in index nadashte bashim -1 midim

    public void upgradeBlock(int upgradingBlockId) {
        int index = getBlockIndex(upgradingBlockId);
        if (index == -1) {
            System.out.println("not possible");
            return;
        }
        if (!blocks.get(index).isUpgradable()){
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

    public void addHome(int blockId, int floors, int units) {
        int index = getBlockIndex(blockId);
        if (index == -1){
            System.out.println("not possible");
            return;
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
        int index = getBlockIndex(blockId);
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
        int blockIndex = getBlockIndex(blockId);
        if (blockIndex == -1) {
            System.out.println("not possible");
            return;
        }
        int buildingIndex = blocks.get(blockId).getThisBuildingIndex(buildingId);
        if (buildingIndex == -1) {
            System.out.println("not possible");
            return;
        }
        if (!(blocks.get(blockId).buildings.get(buildingId) instanceof Army)) {
            System.out.println("not possible");
            return;
        }
        blocks.get(blockId).buildings.get(buildingId).upgrade();
        gills -= upgradeCost;
    }

    public void addBazar(int BlockId) {
        for (Block block : blocks) {
            if (BlockId == block.getId()) {
                this.gills -= 6000;
            }
        }
    }

    public void removeBazar(int BlockId, int UnitId) {
        for (Block block : blocks) {
            if (BlockId == block.getId()) {
                for (int i = 0; i < block.buildings.size(); i++) {
                    if (block.buildings.get(i).id == UnitId)
                        this.gills -= 500;
                }
            }
        }
    }

    public void upgradeBazar(int BlockId, int UnitId) {
        for (Block block : blocks) {
            if (BlockId == block.getId()) {
                for (int i = 0; i < block.buildings.size(); i++) {
                    if (block.buildings.get(i).id == UnitId)
                        this.gills -= 5000 * (1 + block.buildings.get(i).level);

                }
            }
        }
    }

    public void upgradeDefence(int blockId, int buildingId) {
        int upgradeCost = 5000;
        if (gills < upgradeCost) {
            System.out.println("not possible");
            return;
        }
        int blockIndex = getBlockIndex(blockId);
        if (blockIndex == -1) {
            System.out.println("not possible");
            return;
        }
        int buildingIndex = blocks.get(blockId).getThisBuildingIndex(buildingId);
        if (buildingIndex == -1) {
            System.out.println("not possible");
            return;
        }
        if (!(blocks.get(blockId).buildings.get(buildingId) instanceof Defence)) {
            System.out.println("not possible");
            return;
        }
        blocks.get(blockId).buildings.get(buildingId).upgrade();
        gills -= upgradeCost;
    }

}