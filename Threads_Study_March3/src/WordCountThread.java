//import java.io.BufferedReader;
//import java.io.FileReader;
//
//class WordCountThread extends Thread {
//    private String filePath;
//    int start;
//    int end;
//    int localCount = 0;
//
//    public WordCountThread(String filePath, int start, int end) {
//        this.filePath = filePath;
//        this.start = start;
//        this.end = end;
//    }
//
//    @Override
//    public void run() {
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            int curr = 0;
//            while ((line = br.readLine()) != null) {
//                if(curr>=start && curr < end ){
//                    String trimmed = line.trim();
//                    if (!trimmed.isEmpty()) { // Check the TRIMMED version
//                        String[] words = trimmed.split("\\s+");
//                        localCount += words.length;
//                    }
//                }
//                curr++;
//                if(curr==end) break;
//            }
//
//        } catch (Exception e) {
//            System.out.println("File Error: " + e.getMessage());
//        }
//    }
//}
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountThread extends Thread{
    String fileName;
    int start;
    int end;
    int localCount = 0;

    public WordCountThread(String fileName, int start, int end) {
        this.fileName = fileName;
        this.start = start;
        this.end = end;
    }

    public void run(){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            int cur = 0;
            String line;
            while((line = br.readLine())!=null){
                if(cur >= start && cur<end){
                    String temp = line.trim();
                    if(!temp.isEmpty()){
                        String[] words = temp.split("\\s+");
                        localCount+= words.length;
                    }

                }
                cur++;
                if(cur == end) break;
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}