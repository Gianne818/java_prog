// implement here

import java.util.*;

public class BigInteger{
    String num;
    
    public BigInteger(String num){
        this.num = num;
    }
    
    public BigInteger(int number){
        StringBuilder sb = new StringBuilder();
        while(number!=0){
            sb.append(number%10);
            number/=10;
        }
        this.num = sb.reverse().toString();
    }
    
    public String add(BigInteger other){
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        int otherLength = other.num.length();
        int thisLength = this.num.length();
        
        while(otherLength < thisLength){
            sb2.append(0);
            otherLength++;
        }
        
        sb2.append(other.num);
        other.num = sb2.toString();
        
        while(otherLength > thisLength){
            sb3.append(0);
            thisLength++;
        }
        
        sb3.append(this.num);
        this.num = sb3.toString();
        
       
        
        // System.out.println("curInd: " + this.num);
        // System.out.println("otherInd: " + other.num);
        
        int curInd = this.num.length()-1;
        int otherInd = other.num.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        //  System.out.println("curInd: " + curInd);
        // System.out.println("otherInd: " + otherInd);
        
        while(curInd>=0 || otherInd>=0 || carry > 0){
             int dig1 = (this.num.charAt(curInd) != '0') ? this.num.charAt(curInd) - '0' : 0;
             int dig2 = (other.num.charAt(otherInd) != '0') ? other.num.charAt(otherInd) - '0' : 0;
            curInd--;
            otherInd--;
            
            int sum = dig1 + dig2 + carry;
            
            carry = sum/10;
            sb.append(sum%10);
        }
        return sb.reverse().toString();
    }
    
    public String multiply(BigInteger other){
        return "";
    }
    
    
    // public String multiply(BigInteger other){
    //     StringBuilder sb2 = new StringBuilder();
    //     StringBuilder sb3 = new StringBuilder();
        
    //     int otherLength = other.num.length();
    //     int thisLength = this.num.length();
        
    //     while(otherLength < thisLength){
    //         sb2.append(0);
    //         otherLength++;
    //     }
        
    //     sb2.append(other.num);
    //     other.num = sb2.toString();
        
    //     while(otherLength > thisLength){
    //         sb3.append(0);
    //         thisLength++;
    //     }
        
    //     sb3.append(this.num);
    //     this.num = sb3.toString();
        
       
        
    //     // System.out.println("curInd: " + this.num);
    //     // System.out.println("otherInd: " + other.num);
        
    //     int curInd = this.num.length()-1;
    //     int otherInd = other.num.length()-1;
    //     int carry = 0;
    //     StringBuilder sb = new StringBuilder();
    //     //  System.out.println("curInd: " + curInd);
    //     // System.out.println("otherInd: " + otherInd);
        
    //     // while(curInd>=0 || otherInd>=0 || carry > 0){
    //     //      int dig1 = (this.num.charAt(curInd) != '0') ? this.num.charAt(curInd) - '0' : 0;
    //     //     // System.out.println("otherInd: " + otherInd);
    //     //      int dig2 = (other.num.charAt(otherInd) != '0') ? other.num.charAt(otherInd) - '0' : 0;
    //     //      //int dig2 = 0;
          
    //     //     curInd--;
    //     //     otherInd--;
            
    //     //     int sum = dig1 + dig2 + carry;
            
    //     //     carry = sum/10;
    //     //     sb.append(sum%10);
    //     // }
        
    //     int ctr = 0;
    //     while(ctr < otherInd){
    //         int dig1 = (this.num.charAt(otherInd)!=0) ? this.num.charAt(curInd) - '0' : 0;
    //     }
        
    //     return "";
    // }
    
}