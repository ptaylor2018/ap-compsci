
/**
 * Write a description of class MatrixTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixTest
{
   public static void main (String[] args){
       Matrix test = new Matrix(3,4);
       test.set(0,0,1);
       test.set(0,1,2);
       test.set(0,0,0);
       test.set(0,1,6);
       //test.get(0,1);
       test.printMatrix();
       //System.out.println(test.get(0,0));
       //System.out.println(test.get(0,1));
    }
}
