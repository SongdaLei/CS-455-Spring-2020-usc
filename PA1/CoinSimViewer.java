//Name: Songda Lei
//USC NetId:8374371181
//CSCI 455 PA1
//Spring 2020
import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer
{

    public static void main(String[] args)
    {
        while (true) {

            JFrame frame = new JFrame();

            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of trials: ");
            int numTrials = in.nextInt();
            while (numTrials <= 0) {
                System.out.println("Error: Number Entered must be greater than 0.");
                System.out.println("Enter number of trials: ");
                numTrials = in.nextInt();
            }
            ;

            frame.setSize(800, 500);
            frame.setTitle("CoinSim");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CoinSimComponent component = new CoinSimComponent(numTrials);
            frame.add(component);

            frame.setVisible(true);
        }
    }
}
