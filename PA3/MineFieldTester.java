
public class MineFieldTester {

    private static boolean[][] smallMineField =
            {{false, false, false, false, false, false, false, true, false},
                    {false, false, false, false, false, false, false, false, false},
                    {false, false, true, false, false, true, false, false, false},
                    {false, false, false, false, false, false, false, false, false},
                    {false, false, false, false, false, false, false, true, false},
                    {false, false, false, false, false, false, false, false, false},
                    {false, false, false, false, true, false, false, false, false},
                    {false, false, false, false, false, false, false, false, false},
                    {false, false, false, false, false, false, false, false, false},
                    };

    private static boolean[][] emptyMineField =
            {{false, false, false, false},
                    {false, false, false, false},
                    {false, false, false, false},
                    {false, false, false, false}};

    private static boolean[][] almostEmptyMineField =
            {{false, false, false, false},
                    {false, false, false, false},
                    {false, false, false, false},
                    {false, true, false, false}};

    public static void main(String[] args) {

        System.out.println(" #####  Test Case 1  #####");
        MineField smallMine = new MineField(smallMineField);
        //smallMine.test();

        System.out.println();
        System.out.println(" #####  Test Case 2  #####");
        MineField emptyMine = new MineField(emptyMineField);
        //emptyMine.test();

        System.out.println();
        System.out.println(" #####  Test Case 3  #####");
        MineField almostEmptyMine = new MineField(almostEmptyMineField);
        //almostEmptyMine.test();


        System.out.println();
        System.out.println(" #####  Test Case 4  #####");
        MineField mine1 = new MineField(9, 9, 80);
        mine1.populateMineField(2, 2);
        //mine1.test();

    }


}