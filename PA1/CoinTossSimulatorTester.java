//Name: Songda Lei
//USC NetId:8374371181
//CSCI 455 PA1
//Spring 2020
public class CoinTossSimulatorTester {
    public static void main(String[] args)
    {
        CoinTossSimulator simulator = new CoinTossSimulator();
        boolean correct = (simulator.getTwoHeads() + simulator.getTwoTails()
        + simulator.getHeadTails() == simulator.getNumTrials());

        simulator.run (0);
        System.out.println("After constructor: ");
        System.out.println("Number of trials [exp: 0]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");


        simulator.run(1);
        System.out.println("After run(1) ");
        System.out.println("Number of trials [exp: 1]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");

        simulator.run(10);
        System.out.println("After run(11) ");
        System.out.println("Number of trials [exp: 11]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");

        simulator.run(100);
        System.out.println("After run(111) ");
        System.out.println("Number of trials [exp: 111]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");

        simulator.reset();
        System.out.println("After reset: ");
        System.out.println("Number of trials [exp: 0]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");

        simulator.run(1000);
        System.out.println("After run(1000) ");
        System.out.println("Number of trials [exp: 1000]: " + simulator.getNumTrials());
        System.out.println("Two-head tosses: " + simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + correct + "\n");

    }
}
