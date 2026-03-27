package march_17.PasswordCracker;
// PasswordCracker.java

public class PasswordCracker {
    private final String target;
    private boolean found;
    private String finder;

    public PasswordCracker(String target){
        this.target = target;
    }

    public boolean isFound(){
        return found;
    }

    public synchronized void setFound(String result){
        if(!found){
            found = true;
            finder = result;
            notifyAll();
        }
    }

    public String getFinder() {
        return finder;
    }

    public synchronized boolean printerChecker(int threadNum, String attempt){
        if(found) return true;
        System.out.printf("Thread %d: %s\n", threadNum, attempt);
        if(attempt.equals(target)){
            setFound(target);
            return true;
        }
        return false;
    }
}

//public class PasswordCracker {
//    protected final String target;
//    private final int length;
//    private volatile boolean found = false;
//    private String finder = null;
//
//    public PasswordCracker(String target) {
//        this.target = target;
//        this.length = target.length();
//    }
//
//    public synchronized boolean isFound() {
//        return found;
//    }
//
//    public synchronized void setFound(String result) {
//        if (!found) {
//            found = true;
//            finder = result;
//            notifyAll(); // wake up any waiting threads
//        }
//    }
//
//    public synchronized void waitForResult(){
//        while (!found) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public String getFinder() {
//        return finder;
//    }
//
//    public synchronized boolean printerChecker(int threadNum, String attempt) {
//        if (isFound()) return true; // don't print, just stop
//
//        System.out.printf("Thread %d: %s\n", threadNum, attempt);
//
//        if (attempt.equals(target)) {
//            setFound(attempt);
//            return true;
//        }
//        return false;
//    }
//
//
//}
