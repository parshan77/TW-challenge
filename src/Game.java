import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GilgCity gilgCity1 = new GilgCity();
        GilgCity gilgCity2 = new GilgCity();
        Scanner scanner = new Scanner(System.in);
        String place = new String();
        String cmd = scanner.next();
        cmd = cmd.toLowerCase();
        while (!cmd.equals("yield") && !cmd.equals("done")){
            if (cmd.equals("add")){
                place = scanner.next();
                place = place.toLowerCase();
                if (place.equals("block")){
                    gilgCity1.addBlock();
                }
                else if (place.equals("home")){
                    int blockId = scanner.nextInt();
                    int numberOfFloors = scanner.nextInt();
                    int numberOfUnits = scanner.nextInt();
                    gilgCity1.addHome(blockId, numberOfFloors, numberOfUnits);
                }
                else if (place.equals("army")){
                    int blockId = scanner.nextInt();
                    gilgCity1.addArmy(blockId);
                }
                else if (place.equals("bazaar")){
                    int blockId = scanner.nextInt();
                    gilgCity1.addBazar(blockId);
                }
                else if (place.equals("defense")){
                    int blockId = scanner.nextInt();
                    //TODO : gilgCity1.addDefence(blockId);
                }
            }
            else if (cmd.equals("remove")){

            }
        }
    }
}
