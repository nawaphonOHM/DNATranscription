import java.io.Console;
import java.util.HashMap;

public class DNATrans{
    public static void main(String[] args){
        Console terminal = System.console();
        HashMap<Integer, String> proteinTable = new HashMap<Integer, String>();
        String input;
        char[] inputchars;
        int[] ABC = new int[3];
        boolean foundStartPoint = false;
        int counter = 0;
        int[][][] proteinTableNum = {
            {
                {0, 0, 1, 1}, 
                {5, 5, 5, 5}, 
                {9, 9, 10, 10}, 
                {17, 17, 10, 18}
            }, 
            {
                {1, 1, 1, 1}, 
                {6, 6, 6, 6}, 
                {11, 11, 12, 12}, 
                {19, 19, 19, 19}
            }, 
            {
                {2, 2, 2, 3}, 
                {7, 7, 7, 7}, 
                {13, 13, 14, 14}, 
                {5, 5, 19, 19}
            }, 
            {
                {4, 4, 4, 4}, 
                {8, 8, 8, 8}, 
                {15, 15, 16, 16}, 
                {20, 20, 20, 20}
            }, 
        };

        proteinTable.put(0, "Phe");
        proteinTable.put(1, "Leu");
        proteinTable.put(2, "Ile");
        proteinTable.put(3, "Met");
        proteinTable.put(4, "Val");
        proteinTable.put(5, "Ser");
        proteinTable.put(6, "Pro");
        proteinTable.put(7, "Thr");
        proteinTable.put(8, "Ala");
        proteinTable.put(9, "Tyr");
        proteinTable.put(10, "stop");
        proteinTable.put(11, "Hls");
        proteinTable.put(12, "Gln");
        proteinTable.put(13, "Asn");
        proteinTable.put(14, "Lys");
        proteinTable.put(15, "Asp");
        proteinTable.put(16, "Glu");
        proteinTable.put(17, "Cys");
        proteinTable.put(18, "Trp");
        proteinTable.put(19, "Arg");
        proteinTable.put(20, "Gly");

        input = terminal.readLine("Input your DNA: ");
        input = input.toUpperCase();
        inputchars = input.toCharArray();
        int tempINT = 0;
        String tempSTR;

        if(input.length() < 3 || input.length() % 3 != 0){
            System.err.println("length must be >= 3 or is mutiple of 3.");
        } else {
            for(char c : inputchars){
                ABC[counter] = convertedBaseToNum(c);

                if(ABC[counter] == -1){
                    System.exit(-1);
                }

                if(counter % 3 == 2){
                    tempINT = proteinTableNum[ABC[counter - 2]][ABC[counter - 1]][ABC[counter]];
                    if(tempINT == 3) foundStartPoint = foundStartPoint | true;
                    if(tempINT == 10) System.exit(0);
                    if(foundStartPoint){
                        System.out.print(proteinTable.get(tempINT) + "|");
                    }
                }
                
                counter = (counter + 1) % 3;
            }
        }
    }

    public static int convertedBaseToNum(char c){
        if(c == 'T' || c == 'U') return 0;
        else if(c == 'C') return 1;
        else if(c == 'A') return 2;
        else if(c == 'G') return 3;
        else return -1;
    }

}
