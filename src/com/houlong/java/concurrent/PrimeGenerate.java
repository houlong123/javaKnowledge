/*
package com.houlong.java.concurrent;

import org.apache.http.annotation.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by houlong on 2017/9/20.
 *//*

public class PrimeGenerate implements Runnable {

    private volatile boolean cancelled;
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    public List<BigInteger> aSecondPrimes() throws InterruptedException {
        PrimeGenerate generate = new PrimeGenerate();
        new Thread(generate).start();

        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
        } finally {
            generate.cancel();
        }
        return generate.get();
    }
}
*/
