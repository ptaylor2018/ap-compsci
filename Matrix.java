import java.util.ArrayList;

/**
 * Write a description of class PatrickMatrix here.
 * 
 * @author Patrick Taylor 
 * @version 1.0
 */
public class Matrix
{
    private ArrayList<Double> A = new ArrayList<Double>();
    private int [] IA;
    private ArrayList<Integer> JA = new ArrayList<Integer>();
    private int NNZ = 0;
    private int Arows = 0;
    private int Acolumns = 0;
    /**
     * Constructor for Matrix.
     * @param rows  number of rows the Matrix has
     * @param columns   number of columns the Matrix has
     */
    public Matrix(int rows, int columns){
        IA = new int[rows+1];
        IA[0] = 0;
        Arows = rows;
        Acolumns = columns;
    }

    /**
     * returns the number of rows the matrix has. important for other methods.
     * @return the number of rows the matrix has
     */
    public int getRows(){
        return Arows;
    }

    /**
     * returns the number of columnss the matrix has. important for other methods.
     * @return the number of columns the matrix has
     */
    public int getColumns(){
        return Acolumns;
    }

    /**
     * sets a value in the matrix. I can't explain here how it works.It'd take too long. It's really tricky.
     * @param row the row the value goes in
     * @param column the column the value goes in
     * @param value the value to go at (row, column)
     * @throws MatrixException if one tries to accesss values outside the dimensions of the matrix
     */
    public void set(int row, int column, double value)throws MatrixException{
        if(column > Acolumns - 1){throw new MatrixException("You are trying to access a column of the Matrix that doesn't exist!");}
        if(row > Arows - 1){throw new MatrixException("You are trying to access a row of the Matrix that doesn't exist!");}
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

    public double get(int row, int column)throws MatrixException{ //3,4
        if(column > Acolumns - 1){throw new MatrixException("You are trying to access a column of the Matrix that doesn't exist!");}
        if(row > Arows - 1){throw new MatrixException("You are trying to access a row of the Matrix that doesn't exist!");}
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

    public static Matrix add(Matrix first, Matrix second)throws MatrixException{
        if(first == null || second == null){throw new MatrixException("You can't use null matrices in this method!");}
        if(first.getColumns() == second.getColumns() && first.getRows() == second.getRows()) {
            Matrix sum = new Matrix(first.getRows(), second.getColumns());
            for(int i = 0; i<first.getRows(); i++){
                for(int j = 0; j<first.getColumns(); j++){
                    double spotSum = first.get(i,j) + second.get(i,j);
                    sum.set(i, j, spotSum);
                }
            }
            return sum;
        }else{throw new MatrixException("You are trying to add matrices of different dimensions!");}
    }

    public static Matrix sub(Matrix first, Matrix second)throws MatrixException{
        if(first == null || second == null){throw new MatrixException("You can't use null matrices in this method!");}
        if(first.getColumns() == second.getColumns() && first.getRows() == second.getRows()) {
            Matrix diff = new Matrix(first.getRows(), second.getColumns());
            for(int i = 0; i<first.getRows(); i++){
                for(int j = 0; j<first.getColumns(); j++){
                    double spotDiff = first.get(i,j) - second.get(i,j);
                    diff.set(i, j, spotDiff);
                }
            }
            return diff;
        }else{throw new MatrixException("You are trying to subtract matrices of different dimensions!");}
    }

    public static Matrix mult(Matrix first, Matrix second)throws MatrixException{
        if(first == null || second == null){throw new MatrixException("You can't use null matrices in this method!");}
        if(first.getColumns() == second.getRows()){
            Matrix mult = new Matrix(first.getRows(),second.getColumns());
            for(int I = 0; I < mult.getRows(); I++){
                for(int J = 0; J < mult.getColumns(); J++){
                    double dotProduct = 0;
                    for(int i = 0; i < second.getRows(); i++){
                        dotProduct+= first.get(I,i)*second.get(i,J);
                    }
                    mult.set(I,J,dotProduct);
                }
            }
            return mult;
        }else {throw new MatrixException("Your matrices have the wrong dimensions to be multiplied! The number of columns of the first must match the number of rows of the second!");}
    }

    public static Matrix mult(Matrix matrix, double scalar)throws MatrixException{
        if(matrix == null){throw new MatrixException("You can't use null matrices in this method!");}
        Matrix mult = new Matrix(matrix.getRows(),matrix.getColumns());
        for(int i = 0; i < mult.getRows(); i++){
            for(int j = 0; j < mult.getColumns(); j++){
                double setMe = matrix.get(i,j)*scalar;
                mult.set(i,j,setMe);
            }
        }
        return mult;
    }

    public static Matrix transpose(Matrix matrix)throws MatrixException{
        if(matrix == null){throw new MatrixException("You can't use null matrices in this method!");}
        Matrix transpose = new Matrix(matrix.getColumns(), matrix.getRows());
        for(int i = 0; i < transpose.getRows(); i++){
            for(int j = 0; j < transpose.getColumns(); j++){
                double setMe = matrix.get(j,i);
                transpose.set(i,j,setMe);
            }
        }
        return transpose;
    }

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
}
