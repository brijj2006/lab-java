package org.example;

//Print Numbers in Sequence with Multiple threads.
//
//        Implement a program that uses three separate threads to print numbers in sequence up to a given integer n. The program should initialize three threads and ensures that they print the numbers in sequence without any overlaps. The user provided the value of n, and the program should print/return the numbers in the sequence.
//
//        Function description :
//        In the provided code snippet, complete the implementation of PrintNumbersInSequence constructor to ensure sequential printing of numbers. You can write your code in the space below the phrase "WRITE YOUR LOGIC HERE".
//
//        There will be multiple test cases running so the Imput and Output should match exactly as provided.
//
//        Input Format :
//        The program expects a single integer n as input, denoting the maximum value for the sequence.
//
//        Output Format :
//        The program outputs as single line containing the space-separated numbers from 1 to n printed in sequence.
//
//        Constraints :
//        The input integer n is a positive integer.
//
//        Sample Input :
//        10
//
//        Sample Output :
//        1 2 3 4 5 6 7 8 9 10
//
//        Explanation :
//        The program takes the user input 10 and intializes three threads to print numbers in sequence.
//        Each thread prints a portion of the sequence, ensuring the numbers are printed in the correct prder without overlaps. The program prints in sequence 1 2 3 4 5 6 7 8 9 10.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

public class PrintNumbersInSequence {
    private int n;
    private int current = 1;
    private final Lock lock = new ReentrantLock();

    public PrintNumbersInSequence(int n) {
        this.n = n;

        // Create 3 threads
        Thread t1 = new Thread(this::printNumbers);
        Thread t2 = new Thread(this::printNumbers);
        Thread t3 = new Thread(this::printNumbers);

        // Start them
        t1.start();
        t2.start();
        t3.start();

        // Wait for all to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void printNumbers() {
        while (true) {
            lock.lock();
            try {
                if (current > n) {
                    break;
                }
                System.out.print(current + " ");
                current++;
            } finally {
                lock.unlock();
            }

            // Small sleep to let other threads get CPU time
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Non-editable code
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PrintNumbersInSequence obj = new PrintNumbersInSequence(n);
        scanner.close();
    }
}

