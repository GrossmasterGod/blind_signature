package com.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Voter {
    private final int id;
    private boolean isVoted;
    private final List<int[]> publicKeys;
    private final List<int[]> privateKeys;
    private final List<Integer> r;

    public Voter(int id, ArrayList<int[]> keys,int skip){
        this.id = id;
        this.isVoted = false;
        skip = skip*10;
        this.publicKeys = keys.stream().skip(skip).limit(10).map(t->t=new int[]{t[0],t[2]}).collect(Collectors.toList());
        this.privateKeys = keys.stream().skip(skip).limit(10).map(t->t=new int[]{t[1],t[2]}).collect(Collectors.toList());
        this.r = keys.stream().skip(skip).limit(10).map(t->t[3]).collect(Collectors.toList());
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }

    public int getId() {
        return id;
    }

    public List<int[]> getPublicKeys() {
        return publicKeys;
    }

    public List<int[]> getPrivateKeys() {
        return privateKeys;
    }

    public List<Integer> getR() {
        return r;
    }


}
