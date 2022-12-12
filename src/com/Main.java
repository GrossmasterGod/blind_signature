package com;

import com.lab2.RSAKeyPairGenerator;
import com.lab2.Voter;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<int[]> keys = RSAKeyPairGenerator.keyGenerator();
        Voter voter1 = new Voter(1,keys,0);
        Voter voter2 = new Voter(2,keys,1);
        voter1.getPublicKeys().forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println(voter1.getR());
        System.out.println("-------------");
        voter2.getPublicKeys().forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println(voter2.getR());
    }
}
