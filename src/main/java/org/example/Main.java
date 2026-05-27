package org.example;

import java.util.*;

//The question is : Museum visit<br> There are N students numbered from 1 to N who visited the museum.
// <br>They entered in the order B1, B2,....,BN.<br> If the ith student overtook the jth student,
// then the ith student will be punished. Any student can be punished. any student can be punished atmost once.
// <br>Return the count of punished students.<br><br>Note<br> The number of punished students may be 0.
// <br><br>Function Description<br>in the provided code snippet, imnplement the provided punishedStudents(...)
// method and return the count of punished students. you can write the code in the space below the
// phrase "WRITE YOUR LOGIC HERE".<br>There will be multiple test cases running so the input and output should
// match exactly as provided.<br><br>Input Format<br>The first line contains an integer N, denoting the length of
// the array A.<br>The second line contains N space-separated integers A[i].<br>The third line contains N space-separated
// integers B[i].<br><br>Constraints<br>1 <= N <=10^5.<br> 1 <= A[i] <= N.<br> 1<= b[i] <=N.<br><br>Sample Input<br> 5 -
// denotes N <br> 3 5 2 1 4 -- denotes A<br> 4 3 2 1 -- denotes B<br><br>Output Format<br> The output contains an integer
// denoting the count of punished students.<br><br>Sample Output<br>2<br><br>Explanation<br>N = 5<br>A = [3,5,2,1,4] <br>
// B=[4,3,2,5,1]<br>The students entered a museum in order of A and exited in order of B.<br>Student number 4
// overtook 3, 5, 2, 1 and student number 2 overtook 5.<br>No other overtake happened.<br>Hence,
// students 4 and 2 will be punished.<br>Hence, the count of punished students = 2.

public class Main {
    public static int punishedStudents(int N, int[] A, int[] B) {
        // Map student -> their entry index
        Map<Integer, Integer> entryPos = new HashMap<>();
        for (int i = 0; i < N; i++) {
            entryPos.put(A[i], i);
        }

        // Convert B to entry positions
        int[] Bpos = new int[N];
        for (int i = 0; i < N; i++) {
            Bpos[i] = entryPos.get(B[i]);
        }

        // We’ll track the smallest entry index seen from the right side
        Set<Integer> punished = new HashSet<>();
        int minFromRight = Integer.MAX_VALUE;

        // Traverse from right to left in exit order
        for (int i = N - 1; i >= 0; i--) {
            if (Bpos[i] > minFromRight) {
                // This student entered later but exited earlier => overtook
                punished.add(B[i]);
            }
            minFromRight = Math.min(minFromRight, Bpos[i]);
        }

        return punished.size();
    }

    // Non-editable part
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        int result = punishedStudents(N, A, B);
        System.out.println(result);
    }
}

//with input : 5
// 3 5 2 1 4
// 4 3 2 5 1
// should get output as 2