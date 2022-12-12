package com.lab2;

import java.math.BigInteger;


public class DecryptionEncryption {
    public static String RSAEncryption(String text, int[] pb){
        return getString(text, pb);
    }

    public static String RSADecryption(String text, int[]pr){
        return getString(text, pr);
    }

    private static String getString(String text, int[] key) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<text.length();i++){
            int textPos = TextUtil.findPosition(text.charAt(i));
            BigInteger intPow = BigInteger.valueOf(textPos).pow(key[0]);
            BigInteger tmp = intPow.mod(BigInteger.valueOf(key[1]));
            result.append(TextUtil.getLetterFromPosition(tmp.intValue()));
        }
        return result.toString();
    }

    public static int blindEncryption(int m, int[] key, int r){
        BigInteger R = BigInteger.valueOf(r).pow(key[0]);
        BigInteger first = R.multiply(BigInteger.valueOf(m));
        BigInteger second = first.mod(BigInteger.valueOf(key[1]));
        return second.intValue();
    }
    public static int blindDecryptionByR(int i,int[] key,int[] userKey,int r){
        return (BigInteger.valueOf(i).multiply(BigInteger.valueOf(r).modInverse(BigInteger.valueOf(key[1])))).mod(BigInteger.valueOf(key[1])).intValue();
    }

    public static int blindDecryption(int i,int[] key,int r){
        return (BigInteger.valueOf(i).pow(key[0]).mod(BigInteger.valueOf(key[1]))).intValue();
    }

    public static void main(String[] args) {

        int e = 5;
        int d = 141;
        int n = 391;
        int m = 89;
        int r = 5;
        int blindEncrypt = blindEncryption(m,new int[]{43,713},r);
        System.out.println(blindEncrypt);
//        int sPrime = BigInteger.valueOf(blindEncrypt).modPow(BigInteger.valueOf(307),BigInteger.valueOf(713)).intValue();
//        System.out.println(sPrime);
//        int blindDecrypted = blindDecryptionByR(sPrime,new int[]{5,391},new int[]{},r);
//        System.out.println(blindDecrypted);
//        int decrypted = BigInteger.valueOf(blindDecrypted).modPow(BigInteger.valueOf(43),BigInteger.valueOf(713)).intValue();
//        System.out.println(decrypted);
        int blindDecrypt = blindEncryption(blindEncrypt,new int[]{307,713},r);
        System.out.println(blindDecrypt);

    }
}
