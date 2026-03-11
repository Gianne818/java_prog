package march_06;

public class DebitWorker implements Runnable{
    private BankAccount account;
    private String merchant;
    private double amount;

    public DebitWorker(BankAccount account, String merchant, double amount) {
        this.account = account;
        this.merchant = merchant;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
//        System.out.println(merchant);
        System.out.println("UPDATED = " + account.getBalance());
    }
}
