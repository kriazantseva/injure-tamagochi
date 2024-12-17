package project.service.toy_play;

import java.util.Random;

//many small if-methods for more clear results
//big method with many if-statements in it produce sometimes wrong false-value
public final class TreatToySolvingCalc {
    public static int solvedTimes = 0;
    public static int tries = 0;
    public static boolean inProcess = true;
    public static boolean succeed = false;
    public static boolean notSucceed = false;

    private static final int MAX_TRIES = 5;
    private static final int MAX_SOLVED_TIMES = 5;
    private static final int MAX_FAILED_TIMES = 3;
    private static final int RANDOM_INDEX = 1;
    private static final int MAX_INDEX = 3;

    public static boolean chanceOfSolving() {
        if(inProcess) {
            if(isSolved()) {
                return handleSolved();
            } else {
                return handleNotSolved();
            }
        }
        return handleFinalStates();
    }

    private static boolean handleSolved() {
        if(solvedTimes < MAX_SOLVED_TIMES) {
            solvedTimes++;
            System.out.println("Solved");
            return true;
        } else {
            inProcess = false;
            succeed = true;
        }
        return true;
    }

    private static boolean handleNotSolved() {
        if(tries >= MAX_TRIES && solvedTimes <= MAX_FAILED_TIMES) {
            inProcess = false;
            notSucceed = true;
            return false;
        }
        tries++;
        System.out.println("Failed!");
        return false;
    }

    private static boolean handleFinalStates() {
        if(succeed) {
            System.out.println("Yappie!!");
            return true;
        }
        if(notSucceed) {
            System.out.println("Oh...");
            return false;
        }
        System.out.println("It not supposed to be here");
        return false;
    }

    private static boolean isSolved() {
        Random random = new Random();
        return random.nextInt(MAX_INDEX) == RANDOM_INDEX;
    }
}
