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
        if (!blocks.get(index).isUpgradable()) {
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
        if (index == -1) {              //blocky ba in id darim?
            System.out.println("not possible");
            return;
        }
        if (blocks.get(index).buildings.size() >= blocks.get(index).getMaxBuildings()) {    //blockemun ja dare?
            System.out.println("not possible");
            return;
        }
        if (!((floors >= 3) && (floors <= 6))) {
            System.out.println("not possible");
            return;
        }
        if (!((units >= 1) && (units <= 4))) {
            System.out.println("not possible");
            return;
        }
        int cost = Home.getAddHomeCost(floors, units);
        if (gills < cost) {
            System.out.println("not possible");
            return;
        }
        int id = blocks.get(index).getLastUsedId() + 1;
        blocks.get(index).buildings.add(new Home(id, blockId, floors, units));
        System.out.println(id);
        gills -= cost;
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
        if (blocks.get(index).getUnemployedPeople() < 100) {     //afrade kafi
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

    public void addBazar(int blockId) {
        for (Block block : blocks) {
            if (blockId == block.getId()) {
                if (block.getUnemployedPeople() >= 50) {
                    if (gills >= 6000) {
                        this.gills -= 6000;
                        new Bazaar(blockId);
                        for (int i = 0; i < block.buildings.size(); i++) {
                            if (block.buildings.get(i) instanceof Home) {
                                for (int j = 0; j < ((Home) block.buildings.get(i)).floors.size(); j++) {
                                    for (int k = 0; k < ((Home) block.buildings.get(i)).floors.get(j).units.size(); k++) {
                                        //TODO : add people to Bazaar
                                    }
                                }
                            }
                        }
                    }
                }
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