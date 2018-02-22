
/**
 * Write a description of class PatrickMatrix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matrix
{
    private ArrayList<Double> I = new ArrayList<Double>();
    private int [] IA;
    private ArrayList<Integer> JA = new ArrayList<Integer>();
    private int NNZ = 0;
    private int Arows = 0;
    private int Acolumns = 0;
    public Matrix(int rows, int columns){
        IA = new int[rows+1];
        IA[0] = 0;
        Arows = rows;
        Acolumns = columns;
    }

    public void set(int row, int column, double value){

        if (value != 0){
            NNZ++;
            for(int i = row+1; i < IA.length; i++){
                IA[i]++;
            }
            
        }
    }

    public double get(int row, int column){ //3,4
        ArrayList<Integer> IAchecks = new ArrayList<Integer>();
        int endA = IA[row+1] - 1; //IA[4] - 1, 8 - 1, 7(furthest index to check in A)
        int diffA = endA - IA[row] - 1; //7 - IA[3] - 1 , 7 - 7 - 1, 3 (number of elements in row 2)
        for (int i = 0; i < diffA; i++){ //for number of elements in row 2 (diffA)
            IAchecks.add(endA - i); //add to an ArrayList the relevant indices of A (7, 6, 5)
        }
        for(int item: IAchecks){
            if(JA[item] == column){
                indexOfReturn = item;
            }
        }
        return A[indexOfReturn];
    }

    public static Matrix add(Matrix first, Matrix second){

    }

    public static Matrix sub(Matrix first, Matrix second){

    }

    public static Matrix mult(Matrix first, Matrix second){

    }

    public static Matrix mult(Matrix matrix, double scalar){

    }

    public static Matrix transpose(Matrix matrix){

    }

    private void insert(double value, int row, int column){

    }
   
   A  = [ 10 20 30 40 50 60 70 80 ]
   IA = [  0  2  4  7  8 ]
   JA = [  0  1  1  3  2  3  4  5 ]  
}
