//Name: Songda Lei
//USC NetId:8374371181
//CSCI 455 PA1
//Spring 2020
import javax.swing.*;
import java.awt.*;


public class CoinSimComponent extends JComponent {
    double twoheads;
    double twotails;
    double totaltrials;
    double oneheadonetail;
    double hpercent;
    double tpercent;
    double htpercent;


    public CoinSimComponent(int numTrials){


        CoinTossSimulator real = new CoinTossSimulator();
        real.run(numTrials);

        twoheads = real.getTwoHeads();
        //System.out.println(twoheads);
        twotails = real.getTwoTails();
        //System.out.println(twotails);
        oneheadonetail = real.getHeadTails();
        //System.out.println(oneheadonetail);
        totaltrials = real.getNumTrials();
        //System.out.println(totaltrials);
        hpercent = (twoheads/totaltrials)*100.0;
        //System.out.println(hpercent);
        tpercent = (twotails/totaltrials)*100.0;
        //System.out.println(tpercent);
        htpercent = (oneheadonetail/totaltrials)*100.0;
        //System.out.println(htpercent);

    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int x = getWidth();
        int y = getHeight();
        int barwidth = (int) ( x*0.1);
        int barheight = (int) (y*0.8);
        int bottom = (int) (y*0.9);

        int firstbarleft = (int) (x*0.2);
        int secondbarleft = (int) (x*0.45);
        int thirdbarleft = (int) (x*0.7);

        //define scale
        double hscale = 0;
        double tscale = 0;
        double htscale = 0;
        if (hpercent>=tpercent){
            if (hpercent>=htpercent)
            {
                hscale = 1.0;
                tscale = tpercent/hpercent;
                htscale = htpercent/hpercent;
            }
            else if (htpercent>=hpercent){
                htscale = 1.0;
                tscale = tpercent/htpercent;
                hscale = hpercent/htpercent;
            }

        }else if (tpercent>=hpercent)
        {
            if (tpercent>=htpercent)
            {
                tscale = 1.0;
                hscale = hpercent/tpercent;
                htscale = htpercent/tpercent;
            }
            else if (htpercent>=tpercent){
                htscale = 1.0;
                tscale = tpercent/htpercent;
                hscale = hpercent/htpercent;
            }
        }

        //System.out.println(htscale);
        String headstring = "Two Heads: " + (int)twoheads + "(" + Math.round(hpercent ) + "%)";
        String headtailstring = "A Head and a Tail: " + (int)oneheadonetail + "(" + Math.round(htpercent) + "%)";
        String tailsstring = "Two Tails: " + (int)twotails + "(" + Math.round(tpercent) + "%)";

        Bar heads = new Bar ( bottom,  firstbarleft,  barwidth,  barheight, hscale, Color.RED, headstring);
//        int bottom, int left, int width, int barHeight, double scale, Color color, String label
        Bar headtail = new Bar ( bottom,  secondbarleft,  barwidth,  barheight, htscale, Color.GREEN, headtailstring);
        Bar tails = new Bar ( bottom,  thirdbarleft,  barwidth,  barheight, tscale, Color.BLUE, tailsstring);

        heads.draw(g2);
        headtail.draw(g2);
        tails.draw(g2);


    }

}
