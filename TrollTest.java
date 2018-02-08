
/**
 * Write a description of class TrollTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrollTest
{
   public static void main(String [] args){
       TrollToll test = new TrollToll();
       test.collect(5);
       System.out.println(test.myMoney());
       System.out.println(test.treasury());
       TrollToll test2 = new TrollToll();
       test2.collect(5);
       System.out.println(test.treasury());
       test.emptyTreasury();
       System.out.println(test.treasury());
       System.out.println(test.myMoney());
       System.out.println(test2.myMoney());
    }
    
}
