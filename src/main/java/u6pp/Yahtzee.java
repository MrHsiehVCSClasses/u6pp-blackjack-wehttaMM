package u6pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yahtzee {

    public Yahtzee() {
    }

    public static boolean beenUsed(int[] scores, int scoreIndex) {
        return scores[scoreIndex] != 0;
    }

    public static void play(){

    }

    public static int getScore(int[] scores) {
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        return sum;
    }

    public static int getLargestMatchType(Dice[] dice) {
        int[] counts = new int[7];
        for (Dice die : dice) {
            counts[die.getSide()]++;
        }
        int maxCount = 0;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }

        if (maxCount == 5) {
            return 5; // Yahtzee
        } else if (maxCount == 4) {
            return 4; // 4 of a Kind
        } else if (maxCount == 3 && Arrays.stream(counts).filter(c -> c == 2).count() >= 1) {
            return 3; // Full House
        } else if (maxCount == 3) {
            return 3; // 3 of a Kind
        } else if (maxCount == 2 && Arrays.stream(counts).filter(c -> c == 2).count() >= 2) {
            return 2; // Two Pair
        } else if (maxCount == 2) {
            return 2; // Pair
        } else {
            return 1; // Unique
        }
    }

    public static Dice[] rollDice(Dice[] dice, boolean[] toRoll) {
        Dice[] newDiceArray = new Dice[dice.length];
        for (int i = 0; i < dice.length; i++) {
            Dice die = dice[i];
            boolean isToRoll = toRoll[i];
            if (isToRoll) {
                die.roll();
            }
            newDiceArray[i] = die;
        }
        return newDiceArray;
    }

}
