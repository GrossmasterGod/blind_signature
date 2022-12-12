package com.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoteProcess {
    public static List<Voter> voters = new ArrayList<>();
    public static void process(){
        Random random = new Random();
        ArrayList<int[]> keys = RSAKeyPairGenerator.keyGenerator();
        for (int i =0;i<8;i++){
            voters.add(new Voter(CentralElectionCommission.votersId[i], keys,i));
        }
//        makeBlanksForCEC(voters.get(0)).forEach(t-> System.out.println(t[0].getVote()));
//        ArrayList<Blank[]> blanks = makeBlanksForCEC(voters.get(0));
//        String vote = blanks.get(0)[0].getVote();
//        System.out.println(vote);
//        String voteWithoutR = DecryptionEncryption.blindDecryptionByR(vote,voters.get(0).getPrivateKeys().get(0),voters.get(0).getR().get(0));
//        System.out.println(voteWithoutR);
//        System.out.println(DecryptionEncryption.RSADecryption(voteWithoutR,voters.get(0).getPrivateKeys().get(0)));
    }
//    private static ArrayList<Blank[]> makeBlanksForCEC(Voter voter){
//        ArrayList<Blank[]> blanks = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            String optionOne = DecryptionEncryption.blindEncryption("dog patron",
//                    voter.getPublicKeys().get(i),
//                    voter.getR().get(i));
//
//            String optionTwo = DecryptionEncryption.blindEncryption("cat kulia",
//                    voter.getPublicKeys().get(i),
//                    voter.getR().get(i));
//            blanks.add(new Blank[]{new Blank(optionOne),new Blank(optionTwo)});
//        }
//        return blanks;
//    }


    public static void main(String[] args) {
        process();
    }

}
