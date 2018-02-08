
/**
 * Write a description of class PatrickButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PatrickButton implements PushButton
{
    double approx = 1;
    int approxTerm = 0;
    public void push(){
        approxTerm++;
        int denominator = factorial(approxTerm);
        approx += (1.0/denominator);
    }
    public String buttonState(){
        return approx+ "";
    }
    public int factorial(int input){
        int result = 1;
        for(int i = 0; i<input; i++){
            result = result * i;
        }
        return result;
    }
}
