import java.util.ArrayList;

/**
 * Write a description of class PatrickMatrix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matrix
{
    private ArrayList<Double> A = new ArrayList<Double>();
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

        double exist = get(row, column);
        if (exist !=0){
            if (value != 0){
                //replace value in A
                int placeToSet = getPlace(row,column);
                A.set(placeToSet, value);
            } else{
                //remove value in A
                int placeToRemove = getPlace(row, column);
                A.remove(placeToRemove);
                JA.remove(placeToRemove);
                NNZ--;
                for(int i = row+1; i < IA.length; i++){
                    IA[i]--;
                }
            }
        } else {
            if (value != 0){
                //insert value into A
                int lowerBound = IA[row]; 
                //System.out.println(lowerBound);
                int upperBound = IA[row + 1]; 
                //System.out.println(upperBound);
                if(JA.size() != 0){
                    for(int i = lowerBound; i < upperBound; i++){
                        //System.out.println("something happened");
                        if(JA.get(i) > column){
                            A.add(i,value);
                            JA.add(i, column);
                            return;
                        }
                    } 
                    A.add(upperBound, value);
                    JA.add(upperBound, column);
                }else{
                    A.add(value);
                    JA.add(column);

                }
                NNZ++;
                for(int i = row+1; i < IA.length; i++){
                    IA[i]++;
                }
                
            }

        }
    }

    public double get(int row, int column){ //3,4
        ArrayList<Integer> IAchecks = new ArrayList<Integer>(); //will contain all indices in A that contain values in row (row)
        int endA = IA[row+1] - 1; //IA[4] - 1, 8 - 1, 7(furthest index to check in A)
        int diffA = (endA - IA[row]) + 1; //7 - IA[3] + 1 , 7 - 7 + 1,  1(number of elements in row (row))
        int indexOfReturn = 0;
        for (int i = 0; i < diffA; i++){ //for number of elements in row (row) (diffA)
            IAchecks.add(endA - i); //add to an ArrayList the relevant indices of A (7)
        }
        if(IAchecks.isEmpty()){return 0;}
        for(int item: IAchecks){
            if(item < JA.size()){
                if(JA.get(item) == column){
                    indexOfReturn = item;
                    return A.get(indexOfReturn);
                }
            } else {return 0;}
        }
        return 0;
    }

    public int getPlace(int row, int column){
        ArrayList<Integer> IAchecks = new ArrayList<Integer>();
        int endA = IA[row+1] - 1; //IA[4] - 1, 8 - 1, 7(furthest index to check in A)
        int diffA = endA - IA[row] + 1; //7 - IA[3] + 1 , 7 - 7 + 1,  (number of elements in row 2)
        int indexOfReturn = 0;
        for (int i = 0; i < diffA; i++){ //for number of elements in row 2 (diffA)
            IAchecks.add(endA - i); //add to an ArrayList the relevant indices of A (7)
        }
        for(int item: IAchecks){
            if(item < JA.size()){
                if(JA.get(item) == column){
                    indexOfReturn = item;
                }
            } else {return 0;}
        }
        return indexOfReturn;
    }

    /*
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
     */
    public void printMatrix(){
        System.out.print("A: ");
        for (double item : A){
            System.out.print(item + " ");
        }
        System.out.println("");
        System.out.print("IA: ");
        for (int item : IA){
            System.out.print(item + " ");
        }
        System.out.println("");
        System.out.print("JA: ");
        for (int item : JA){
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    //A  = [ 10 20 30 40 50 60 70 80 ]
    //IA = [  0  2  4  7  8 ]
    //JA = [  0  1  1  3  2  3  4  5 ]  
}
