package Nov18_FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IO;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        class1();
        class2();
        class3();
        System.out.print("Enter student ID to search: ");
        String ID = sc.nextLine();
        System.out.print("Enter class to search (1, 2, 3, all): ");
        String classSearch = sc.nextLine();
        findStudent(ID, classSearch);

        
    }

    public static void findStudent(String ID, String classSearch){
        switch(classSearch){
            case "1":
                try(BufferedReader br = new BufferedReader(new FileReader("class1Info.csv"))){
                    String s;
                    while((s=br.readLine())!=null){
                        String[] parts = s.split(",");
                        if(parts[0].equals(ID)){
                            System.out.println("Student " + parts[0] + ": ");
                            System.out.println("Name: " + parts[1]);
                            System.out.println("Grade " + parts[2]);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Student not found\n");
                } catch (IOException e){

                }
            break;

            case "2":
                try(BufferedReader br = new BufferedReader(new FileReader("class2Info.csv"))){
                    String s;
                    while((s=br.readLine())!=null){
                        String[] parts = s.split(",");
                        if(parts[0].equals(ID)){
                            System.out.println("Student " + parts[0] + ": ");
                            System.out.println("Name: " + parts[1]);
                            System.out.println("Grade " + parts[2]);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Student not found\n");
                } catch (IOException e){

                }
            break;

            case "3":
                try(BufferedReader br = new BufferedReader(new FileReader("class3Info.csv"))){
                    String s;
                    while((s=br.readLine())!=null){
                        String[] parts = s.split(",");
                        if(parts[0].equals(ID)){
                            System.out.println("Student " + parts[0] + ": ");
                            System.out.println("Name: " + parts[1]);
                            System.out.println("Grade " + parts[2]);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Student not found\n");
                } catch (IOException e){

                }
            break;

            case "all":
                combineFiles("class1Info.csv","class2Info.csv", "class3Info.csv", "classCombinedInfo.csv");
                try(BufferedReader br = new BufferedReader(new FileReader("classCombinedInfo.csv"))){
                    String s;
                    while((s=br.readLine())!=null){
                        String[] parts = s.split(",");
                        if(parts[0].equals(ID)){
                            System.out.println("Student " + parts[0] + ": ");
                            System.out.println("Name: " + parts[1]);
                            System.out.println("Grade " + parts[2]);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Student not found\n");
                } catch (IOException e){

                }
            break;
        }
        
    }

    public static void class1(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("class1Info.csv"))){
            bw.write("1001,Alice,97\n");
            bw.write("1002,Bob,92\n");
            bw.write("1003,Charlie,89\n");
            bw.write("1004,Darren,92\n");
            bw.write("1005,Ethan,90\n");
            bw.close();
        } catch(IOException e){

        }
    }

    public static void class2(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("class2Info.csv"))){
            bw.write("1006,Francis,94\n");
            bw.write("1007,Gordon,92\n");
            bw.write("1008,Haley,85\n");
            bw.write("1009,Ian,92\n");
            bw.write("10010,John,90\n");
            bw.close();
        } catch(IOException e){

        }
    }

    public static void class3(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("class3Info.csv"))){
            bw.write("10011,Key,91\n");
            bw.write("10012,Lemuel,92\n");
            bw.write("10013,Mary,89\n");
            bw.write("10014,Nina,92\n");
            bw.write("10015,Owen,90\n");
            bw.close();
        } catch(IOException e){

        }
    }

    public static void combineFiles(String f1, String f2, String f3, String outputFile){
        try(
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            BufferedReader br3 = new BufferedReader(new FileReader(f3));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        ) {
            String s;
            while((s=br1.readLine())!=null){
                bw.write(s + "\n");
            }

            while((s=br2.readLine())!=null){
                bw.write(s + "\n");
            }

            while((s=br3.readLine())!=null){
                bw.write(s + "\n");
            }
        } catch (IOException e){

        }
    }

    
}

