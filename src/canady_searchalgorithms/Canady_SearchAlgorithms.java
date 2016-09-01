package canady_searchalgorithms;

import java.util.*;

public class Canady_SearchAlgorithms {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randNum = new Random();
        final int arrLength = 1000;
        boolean looping = true;
        int inputNum;
        String answer;
        int[] array = new int[arrLength];
        boolean found;
        int foundNum = 2000000000;
        int min;
        int max;
        int currentGuess;

        for (int i = 0; i < array.length; i++) {
            array[i] = randNum.nextInt(1000) + 1;
        }

        Arrays.sort(array);

        do {
            System.out.print("Please enter the number you wish to look for: ");
            System.out.println("");

            found = false;
            inputNum = input.nextInt();

            System.out.println("Linear Search algorithm:");
            System.out.println("");

            for (int i = 0; i < array.length; i++) {
                if (array[i] == inputNum) {
                    foundNum = i;
                    /* foundNum is intended to be the index of the target, 
                                    and since i runs through the indices, it will be the index*/
                    found = true; //the code below just checks for found
                }
            }

            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at index " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Binary Search algorithm:");
            System.out.println("");

            found = false;

            //binary start
            min = 0;
            max = array.length;
            int range = max - min;
            while (found == false) {
                range = max - min;
                currentGuess = range / 2 + min;
                //currentGuess = (min + max) / 2;
                if (currentGuess % 2 != 0) {
                    currentGuess++;
                }
                if (inputNum == array[currentGuess]) {
                    found = true;
                    foundNum = array[max - (range / 2)];
                } else if (range == 1) {
                    System.out.println("Sorry, didn't find " + inputNum);
                } else if (currentGuess < inputNum) {
                    min = currentGuess + 1;
                } else if (currentGuess > inputNum) {
                    max = currentGuess;
                }
            }

            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Would you like to continue?");
            Scanner replay = new Scanner(System.in);
            answer = replay.next();

            System.out.println("");

            if (answer.equals("no")) {
                looping = false;
            }
        } while (looping);
    }

}
