class CompositeThread extends Thread {
    private int limit;

    public CompositeThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        System.out.println("Composite Numbers up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (isComposite(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nComposite Thread finished.");
    }

    private boolean isComposite(int n) {
        if (n <= 3) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return true;
        }
        return false;
    }
}