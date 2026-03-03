import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> Composites = new ArrayList<>();
        List<Thread> Grayscales = new ArrayList<>();
        List<Thread> Wordcounts = new ArrayList<>();

        int numThreads = 10;

// ========================= WORD COUNTS =========================
        //count number of lines
        int numLines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            while(br.readLine()!=null){
                numLines++;
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        int numLinesPerThread = numLines/numThreads;
        for(int i = 0; i<numThreads; i++){
            int start = i*numLinesPerThread;
            int end = (i == numThreads-1) ? numLines : (i+1)*numLinesPerThread;
            System.out.println("Reading from line " + start + " to " + end);
            if(start < end) Wordcounts.add(new WordCountThread("data.txt", start, end));
        }
        System.out.println("------FROM START------");
        for(Thread w : Wordcounts){
            w.start();
            System.out.println(w.getState());
        }

        System.out.println("------FROM JOIN------");
        for(Thread w: Wordcounts){
            try{
                System.out.println(w.getState());
                w.join();

            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("------FROM COUNTING------");
        int totCount = 0;
        for(Thread t: Wordcounts){
            WordCountThread w = (WordCountThread)t;
            System.out.println(w.getState());
            totCount+=w.localCount;
        }
        System.out.println("Total count: " + totCount);


// ========================= Grayscale =========================
        int height = 0;
        BufferedImage image = null;
        File imagePath = new File("input.jpg");
        try{
            image = ImageIO.read(imagePath);
            height = image.getHeight();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        int numPixelHeightPerThread = height/numThreads;
        for(int i = 0; i<numThreads; i++){
            int start = i*numPixelHeightPerThread;
            int end = (i == numThreads-1) ? height : (i+1)*numPixelHeightPerThread;
            System.out.println("From " + start + " to " + end);
            if(start<end) Grayscales.add(new Thread(new GrayscaleRunnable(image, "output.jpg", start, end)));
        }

        System.out.println("------FROM START------");
        for(Thread g : Grayscales){
            g.start();
            System.out.println(g.getState());
        }

        System.out.println("------FROM JOIN------");
        for(Thread g: Grayscales){
            try{
                System.out.println(g.getState());
                g.join();
                System.out.println("After timed waiting..." + g.getState());

            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        try {
            ImageIO.write(image, "jpg", new File("output.jpg"));
            System.out.println("Image done");
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}