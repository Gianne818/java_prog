
public class BigInt {
    public String num;

    public BigInt(String num){
        this.num = num;
    }

    public BigInt add(String other){
        StringBuilder sb = new StringBuilder();
        int thisCur = this.num.length() - 1;
        int otherCur = this.num.length() - 1;
        int carry = 0;

        while(thisCur >= 0 || otherCur >= 0 || carry>0){
            //convert to int
            int dig1 = thisCur >= 0 ? this.num.charAt(thisCur--) - '0' : 0;
            int dig2 = otherCur >= 0 ? this.num.charAt(otherCur--) - '0' : 0;

            int sum = dig1+dig2+carry;
            carry = sum/10;

            sb.append(sum%10);
        }
        return new BigInt(sb.reverse().toString());
    }

    public String toString(){
        return num;
    }
}
