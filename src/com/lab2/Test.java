package com.lab2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        try{
            RSAPublicKey pubKey;
            RSAPrivateKey privKey;

            //generate the RSA key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            //initialise the KeyGenerator with a random number.
            keyGen.initialize(1024, new SecureRandom());
            KeyPair keypair = keyGen.genKeyPair();
            privKey = (RSAPrivateKey)keypair.getPrivate();
            pubKey = (RSAPublicKey)keypair.getPublic();

            String message = "hello";

            byte [] raw = message.getBytes(StandardCharsets.UTF_8);


            BigInteger m = new BigInteger(raw);
            BigInteger e = pubKey.getPublicExponent();
            BigInteger d = privKey.getPrivateExponent();

            SecureRandom random = SecureRandom.getInstance("SHA1PRNG","SUN");
            byte [] randomBytes = new byte[10];
            BigInteger r = null;
            BigInteger n = pubKey.getModulus();
            BigInteger gcd = null;
            BigInteger one = new BigInteger("1");
            //check that gcd(r,n) = 1 && r < n && r > 1
            do {
                random.nextBytes(randomBytes);
                r = new BigInteger(randomBytes);
                gcd = r.gcd(n);
                System.out.println("gcd: " + gcd);
            }
            while(!gcd.equals(one) || r.compareTo(n)>=0 || r.compareTo(one)<=0);

            BigInteger b = ((r.modPow(e,n)).multiply(m)).mod(n);
            System.out.println("\nb = " + b);

            BigInteger recode = r.modPow(d,n).multiply(b).mod(n);
            System.out.println(new String(recode.toByteArray()));
        }
        catch (Exception ex){
            System.out.println("Error: "+ex);
            ex.printStackTrace();
        }
    }
}
