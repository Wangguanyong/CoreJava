package Concurrency;


import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) {
        reentrantLock.lock();
        try{
         if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d\n", amount, from, to);
        accounts[to] += amount;

        System.out.printf("Total balance: %10.2f\n ", getTotalBalance());

        }
        finally {
            reentrantLock.unlock();
        }
   }

    public double getTotalBalance() {
        double sum = 0;
        for (double e : accounts) {
            sum += e;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
