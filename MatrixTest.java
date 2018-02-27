
/**
 * Write a description of class MatrixTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixTest
{
   public static void main (String[] args){
       Matrix test = new Matrix(2,2);
       Matrix test2 = new Matrix(2,2);
       try{
       test.set(0,0,1);
       test.set(0,1,2);
       test.set(1,0,3);
       test.set(1,1,4);
       test2.set(0,0,1);
       test2.set(0,1,2);
       test2.set(1,0,3);
       test2.set(1,1,4);
       //Matrix mult = test.mult(test,7);
       //mult.printMatrix();
       Matrix transposed = test.transpose(test);
       transposed.printMatrix();
    }catch(MatrixException e){}
    }
}
