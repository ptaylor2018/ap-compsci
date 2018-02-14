
/**
 * Write a description of class TrollToll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrollToll implements Noiseable
{
    static int allTrollSum = 0;
    int trollSum = 0;
    
    public string Noise(){
        return "You have to pay the troll toll!";
    }
    public void collect(double income){
        trollSum += income;
        allTrollSum+= income;
    } // collect money

    public double myMoney(){
        return trollSum;
    } // returns this troll's money

    public static double treasury(){
        return allTrollSum;
    } // returns total money collected by all trolls

    public static void emptyTreasury(){
       allTrollSum = 0;
       
    } // sets the total money collected by all trolls to 0
}
