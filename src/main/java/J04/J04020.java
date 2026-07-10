package J04;

import java.util.Scanner;

public class J04020 {
    static boolean[] prime = new boolean[1000001];

    static {
        sieve();
    }

    static void sieve() {
        for (int i = 0; i <= 1000000; i++) {
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= 1000000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    static class Pair<T,U>{
        T a;
        U b;

        public Pair(T a, U b) {
            this.a = a;
            this.b = b;
        }

        public boolean isPrime() {
            int a = (Integer) this.a;
            int b = (Integer) this.b;

            return prime[a] && prime[b];
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
