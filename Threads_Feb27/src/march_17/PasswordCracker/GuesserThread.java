package march_17.PasswordCracker;


public class GuesserThread implements Runnable{
    private final PasswordCracker cracker;
    private final char vowel;
    private final int vowelPosition;
    private final int wordLength;
    private static int ID = 0;
    private int id;

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public GuesserThread(PasswordCracker cracker, char vowel, int vowelPosition, int wordLength) {
        this.cracker = cracker;
        this.vowel = vowel;
        this.vowelPosition = vowelPosition;
        this.wordLength = wordLength;
        this.id = ++ID;
    }

    public void run(){
        int[] indices = new int[wordLength];
        while(!cracker.isFound()){
            char[] curr = new char[wordLength];
            for(int i = 0; i<wordLength; i++){
                if(i==vowelPosition) curr[i] = vowel;
                else curr[i] = ALPHABET.charAt(indices[i]);
            }

            if(cracker.printerChecker(id, new String(curr))) return;

            for(int i = wordLength-1; i>=0; i--){
                if(i == vowelPosition) continue;
                indices[i]++;
                if(indices[i]<26) break;
                indices[i] = 0;
                if(i == 0 || vowelPosition==0 && i == 1) return;
            }
        }
    }
}

//public class GuesserThread implements Runnable {
//    private final PasswordCracker cracker;
//    private final char vowel;
//    private final int vowelPosition;
//    private final int length;
//    private final int threadNum;
//
//    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
//
//    public GuesserThread(PasswordCracker cracker, char vowel, int vowelPosition, int length, int threadNum) {
//        this.cracker = cracker;
//        this.vowel = vowel;
//        this.vowelPosition = vowelPosition;
//        this.length = length;
//        this.threadNum = threadNum;
//    }
//
//    @Override
//    public void run() {
//        // Generate all combinations with vowel fixed at vowelPosition
//        generateGuesses();
//    }
//
//    private void generateGuesses() {
//        int[] indices = new int[length]; // all start at 0 (letter 'a')
//
//        while (!cracker.isFound()) {
//            // Build the current attempt
//            char[] current = new char[length];
//            for (int i = 0; i < length; i++) {
//                if (i == vowelPosition) {
//                    current[i] = vowel;          // locked position
//                } else {
//                    current[i] = ALPHABET.charAt(indices[i]); // free position
//                }
//            }
//
//            // Check the attempt
//            String attempt = new String(current);
//            if (cracker.printerChecker(threadNum, attempt)) return;
//
//            for (int i = length - 1; i >= 0; i--) {
//                if (i == vowelPosition) continue;
//
//                indices[i]++;
//                if (indices[i] < 26) {
//                    break;
//                }
//                indices[i] = 0;
//                if(i==0 || i==1 && vowelPosition == 0){
//                    return;
//                }
//            }
//        }
//    }
//    /*
//    so like... (_ means vowel)
//    aa_aa initial attempt
//    aa_ab incremented from the for loop, then ind[i]<26 = true, so break, proceed back to the first for loop where it sets the attempt to aa_ab, then
//    aa_ac incremented from the second loop, then ind[i]=2, <26 == true, so break and proceed back again,
//    aa_ad
//    ...
//    aa_az, ind[i] is not less than 26, so we can continue to the prev index and reset the last one to zero, which is a
//    aa_ba increment indices[i], which is now indices[3]
//    aa_bb
//    aa_bc
//    ...
//    aa_bz, ind[i] is not less than 26, so we can continue to the prev index and reset the last one back to a
//    aa_ca
//    aa_cb
//    aa_cc
//    aa_cd
//    ...
//    aa_cz
//    aa_da
//    aa_db
//    aa_dc
//    like this?
//     */
//
//
//}