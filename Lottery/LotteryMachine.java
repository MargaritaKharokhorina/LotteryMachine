package Lottery;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LotteryMachine {
    public static void main(String[] args) { 
        String text = "Teddy_Bear Barbie_Doll Lego_Pirates Set_of_toy_cars Doll_house Hello_Kitty Puzzle_Animal Plasticine Plush_Shark Rubber_ball Badminton Singing_Heart;";
        String[] words = text.split(" "); 
        System.out.println("All toys: " + Arrays.toString(words)); //создан массив
        int min = 1;
        int max = 10;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1); {
            i += min;
            System.out.println("Lottery prize is: " + words[i]); 
        }
        int num =  0;
        try (Scanner myscan = new Scanner (System.in)) {
            System.out.println("Let's start! Enter an integer from 0 to 11: ");
            num = myscan.nextInt();
            // счастливое число - 4, у пользователя одна попытка
            if (num < 0 || num > 11) {
                System.out.println ("You entered a number outside the given limits");
                System.out.println("Enter an integer from 0 to 10 again: ");
                num = myscan.nextInt();
                if (num == 4) {
                    System.out.println("Congratulations! You won the " + words[i]);
                }
                else {
                    System.out.println("Don't worry, good luck next time");
                }
               
            } else if (num == 4) {
                System.out.println("Congratulations! You won the " + words[i]);
            } else {
                System.out.println("Don't worry, good luck next time");  
                
            }
        }
    }
}
