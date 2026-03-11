package march_06;

public class CostWorker implements Runnable{
    private BankAccount account;
    private String merchant;
    private double amount;

    public CostWorker(BankAccount account, String merchant, double amount) {
        this.account = account;
        this.merchant = merchant;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(merchant + ": " + account.withdraw(amount));
        System.out.println("REMAINING = " + account.getBalance());
    }
}
