package Oct13_FILE;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader("gianne.txt"));
            /* while(br.readLine()!=null){ //br.readLine() already reads the first line
                System.out.println(br.readLine()); //goes to the  next line already
            } */
            bw = new BufferedWriter(new FileWriter("cruz.txt")); //Automatically creates file if it does not exist. by default it overwrites the file contents.
            String s;
            while((s = br.readLine())!=null){
                System.out.println(s);
            }
            for (int i = 1; i<=7; i++){
                bw.write(i + ""); // the numbers are regarded as ascii values, so do + "" so that it regards it as string
                bw.newLine();
                if(i==6){
                    int a  = 6/0; //throws arithmetic exception, so it does not write anything, does not do the bw.close()
                }
            }
            //bw.close(); //won't write unless you close it.
            //br.close();
        } catch (FileNotFoundException e){ //Cannot be interchanged with IOException, since it is a subclass of IOException and becomes unreachable
            System.out.println("No File.");
        } catch (IOException e){
            System.out.println("General error");
        } finally {
            try{
                bw.close(); //bw and br must be declared outside the try block
                br.close();
            } catch (IOException e){
                //do nothing
            }

        }

    }
}
