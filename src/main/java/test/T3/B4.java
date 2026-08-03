package test.T3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class B4 {
    static int MAX = 1_000_000;
    static boolean[] prime = initPrime();

    static boolean[] initPrime(){
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++){
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }


    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        ObjectInputStream input1 = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("DAYSO.DAT")
                )
        );

        ArrayList<Integer> list1 =
                (ArrayList<Integer>) input1.readObject();

        input1.close();

        Set<Integer> res = new TreeSet<>(list1);

        for (int x : res) {
            if (x >= 100 && prime[x]) System.out.println(x);
        }
    }
}
