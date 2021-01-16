package Concurrency;

public class Bank {
    private int id;
    private double amount;

    public Bank(int id, double amount) {
        this.id  = id;
        this.amount = amount;
    }

    public void transfer(int from, int to, double amount) {
        return;
    }
}
