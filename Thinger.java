import java.util.*;
/**
 * Takes a single input string and then counts the number of times that the word "thingy" 
 * occurs and the number of times that the word "thing" occurs. 
 * Note that "thingy" takes precedence over "thing". If a thingy is counted, 
 * then it should NOT be counted as a "thing". After that, print out the counts. 
 * After that, output the same string with every instance of the word "thingy" 
 * replaced with "wat" and every instance of "thing" replaced with "wut". 
 * NOTHING IS CASE SENSITIVE. It should work with "tHiNg" or "THIngY" or any case combination.
 * 
 * @Patrick Taylor 
 * @1.0
 */
public class Thinger
{
    static int thingyCount = 0;
    static int thingCount = 0;
    public static void main(String [] args){
        String input = "The thing is thingything. We thingy the thingythingything. Thing ything.";
        String output = doTask(input);
        System.out.println("Thingys :" + thingyCount);
        System.out.println("Things :" + thingCount);
        System.out.println(output);
    }

    /**
     * does all of the important stuff for the project
     * @param input the string to be worked with
     * @return the mutated String
     */
    public static String doTask(String input){

        String lcinput = input.toLowerCase();
        for(int i = 0; i < lcinput.length(); i++){
            if(i+6 < lcinput.length()){
                if(lcinput.substring(i, i+6).equals("thingy")){
                    thingyCount++;
                }

                if(lcinput.substring(i, i+5).equals("thing") &&
                (lcinput.substring(i+6, i+6).equals("y") == false)){
                    thingCount++;
                }
            }
        }
        ArrayList<String> whatable = new ArrayList<String>();
        for(int i = 0; i < lcinput.length(); i++){
            whatable.add(lcinput.substring(i,i+1));
        }
        /*
        for(int i = 0; i< whatable.size(); i++){
        System.out.print(whatable.get(i));
        }
         */
        System.out.println("");
        for(int i = 0; i < thingyCount; i++){
            for(int j = 0; j < whatable.size(); j++){
                if(whatable.get(j).equals("t")){
                    if(whatable.get(j+1).equals("h")){
                        if(whatable.get(j+2).equals("i")){
                            if(whatable.get(j+3).equals("n")){
                                if(whatable.get(j+4).equals("g")){
                                    if(whatable.get(j+5).equals("y")){
                                        whatable.set(j, "w");
                                        whatable.set(j+1, "a");
                                        whatable.set(j+2, "t");
                                        whatable.remove(j+3);
                                        whatable.remove(j+3);
                                        whatable.remove(j+3);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*
        for(int i = 0; i< whatable.size(); i++){
        System.out.print(whatable.get(i));
        }
        System.out.println("");
         */
        for(int i = 0; i < thingCount; i++){
            for(int j = 0; j < whatable.size(); j++){
                if(whatable.get(j).equals("t")){

                    if(whatable.get(j+1).equals("h")){
                        if(whatable.get(j+2).equals("i")){
                            if(whatable.get(j+3).equals("n")){
                                if(whatable.get(j+4).equals("g")){

                                    whatable.set(j, "w");
                                    whatable.set(j+1, "u");
                                    whatable.set(j+2, "t");
                                    whatable.remove(j+3);
                                    whatable.remove(j+3);

                                    break;

                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i< whatable.size(); i++){
            System.out.print(whatable.get(i));
        }
        System.out.println("");
        String endString = String.join("", whatable);
        return endString;
    }
}
