
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
    private ArrayList<Integer> IJ = new ArrayList<Integer>();
    private int NNZ = 0;
    private int Arows = 0;
    private int Acolumns = 0;
    public Matrix(int rows, int columns){
        IA = [rows+1];
        Arows = rows;
        Acolumns = columns;
    }

    public void set(int row, int column, double value){

    }

    public double get(int row, int column){

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
}
