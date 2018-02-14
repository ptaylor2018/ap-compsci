
/**
 * Write a description of class buttontest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class buttontest
{
   public static void main (String [] args){
        PatrickButton a = new PatrickButton();
        a.push();

        a.push();
        a.push();
        System.out.println(a.buttonState());
    }
}
