public class Main {
    public static void main(String[] args) {
        BigInt bi = new BigInt("111111111111111111119");
        BigInt bi2 = new BigInt("111111111111111111111");

        String res = bi.add(bi2.num).toString();
        System.out.println("res: " + res);
    }
}
