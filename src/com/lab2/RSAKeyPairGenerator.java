package com.lab2;

import java.util.*;

public class RSAKeyPairGenerator {

    public static int p = 13;
    public static int q = 17;
    public static int n = p * q;
    public static int f = (p - 1) * (q - 1);
    public static int e = 5;
    public static int d = reciprocalModNumber(e,f);


    public static boolean isNumbersMutuallyPrime(int a, int b) {
        return iteractiveGCD(a, b) == 1;
    }

    public static boolean isReciprocalModNumber(int d,int e,int f){
        return (d * e) % f == 1;
    }

    public static int reciprocalModNumber(int e, int f) {
        int d = 1;
        while ((d * e) % f != 1) {
            d++;
        }
        return d;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int iteractiveGCD(int a, int b) {
        int tmp;
        while (b != 0) {
            if (a < b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static int[] generatePublicKey() {
        return new int[]{e, n};
    }

    public static int[] generatePrivateKey() {
//        System.out.println("n:" + n);
//        System.out.println("f:" + f);
//         System.out.println("e:" + e);
        int d = reciprocalModNumber(e, f);
//        System.out.println("d:" + d);
        return new int[]{d, n};
    }


    public static int mutuallyPrimeNumber(int a) {
        for (int i = 2; i < a; i++) {
            if (isPrime(i)) {
                if (iteractiveGCD(a, i) == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static ArrayList<int[]> keyGenerator(){
        ArrayList<Integer> pNumbers = new ArrayList<>(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                        53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101, 103, 107, 109, 113,
                        127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
                        193, 197, 199,211, 223, 227, 229, 233, 239, 241, 251, 257, 263,
                        269, 271, 277, 281, 283, 293,307, 311, 313, 317, 331, 337, 347,
                        349, 353, 359, 367, 373, 379, 383, 389, 397,401, 409, 419, 421,
                        431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                        503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
                        599,601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                        673, 677, 683, 691,701, 709, 719, 727, 733, 739, 743, 751, 757,
                        761, 769, 773, 787, 797,809, 811, 821, 823, 827, 829, 839, 853,
                        857, 859, 863, 877, 881, 883, 887,907, 911, 919, 929, 937, 941,
                        947, 953, 967, 971, 977, 983, 991, 997)
        );
        ArrayList<Integer> qNumbers = (ArrayList<Integer>)pNumbers.clone();
        ArrayList<int[]> keys = new ArrayList<>();
        Collections.shuffle(pNumbers);
        Collections.shuffle(qNumbers);
        Random random = new Random();
        for (int i=0;i<qNumbers.size();i++){
            int p = pNumbers.get(i);
            int q = qNumbers.get(i);
            int n = p * q;
            int f = (p - 1) * (q - 1);
            int e = mutuallyPrimeNumber(f);
            int d = reciprocalModNumber(e,f);
            int r = 2;
            do {
                r = random.nextInt(1000)+1;
            }
            while (isNumbersMutuallyPrime(r,n));
            keys.add(new int[]{e,d,n,r});
        }

        return keys;
    }

    public static void main(String[] args) {
        System.out.println("e: "+e);
        System.out.println("n: "+ n);
        System.out.println("d: "+ d);
        System.out.println(isNumbersMutuallyPrime(n,e));

    }


}
