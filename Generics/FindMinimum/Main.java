package FindMinimum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // DO NOT MODIFY the main function
    public static void main(String[] args) {
        List<Integer> integerList;
        List<Double> doubleList;
        List<Long> longList;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter test case: ");
        int tc = sc.nextInt();
        switch (tc) {
            case 1:
                integerList = new ArrayList<>();
                integerList.add(13);
                integerList.add(2006);
                integerList.add(4);
                integerList.add(10);
                integerList.add(15);
                integerList.add(68);
                System.out.println("Min: " + findMinimum(integerList));
                break;
            case 2:
                integerList = new ArrayList<>();
                integerList.add(-3);
                integerList.add(4);
                integerList.add(13);
                integerList.add(2006);
                System.out.println("Min: " + findMinimum(integerList));
                integerList.add(-14);
                System.out.println("Min: " + findMinimum(integerList));
                break;
            case 3:
                doubleList = new ArrayList<>();
                doubleList.add(4.0);
                doubleList.add(13.542);
                doubleList.add(2006.1534);
                doubleList.add(15.0);
                doubleList.add(68.153);
                doubleList.add(-3.2);
                System.out.println("Min: " + findMinimum(doubleList));
                break;
            case 4:
                doubleList = new ArrayList<>();
                doubleList.add(4.452);
                doubleList.add(-3.4524);
                doubleList.add(13.4);
                doubleList.add(2006.45);
                System.out.println("Min: " + findMinimum(doubleList));
                doubleList.add(-14.4684);
                System.out.println("Min: " + findMinimum(doubleList));
                break;
            case 5:
                longList = new ArrayList<>();
                longList.add(4L);
                longList.add(13L);
                longList.add(2006L);
                longList.add(15L);
                longList.add(68L);
                longList.add(0L);
                System.out.println("Min: " + findMinimum(longList));
                break;
            case 6:
                longList = new ArrayList<>();
                longList.add(4L);
                longList.add(-3L);
                longList.add(13L);
                longList.add(200L);
                System.out.println("Min: " + findMinimum(longList));
                longList.add(-140L);
                System.out.println("Min: " + findMinimum(longList));
                break;
        }
    }

    // TODO implement findMinimum here
    
    private static <T extends Number> T findMinimum(List<T> list){
        T min = list.get(0);
        
        for(T elem : list){
            if(elem.doubleValue() < min.doubleValue()){
                min = elem;
            }
        }
        return min;
    }
}
