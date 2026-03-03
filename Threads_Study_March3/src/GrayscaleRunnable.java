import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class GrayscaleRunnable implements Runnable{
    BufferedImage input;
    String outputPath;
    int start, end;

    public GrayscaleRunnable(BufferedImage input, String outputPath, int start, int end) {
        this.input = input;
        this.outputPath = outputPath;
        this.start = start;
        this.end = end;
    }

    public void run(){
        int height = input.getHeight();
        int width = input.getWidth();

        for(int y = start; y<end; y++){
            for(int x = 0; x<width; x++){
                int temp = input.getRGB(x, y);
                Color c = new Color(temp);

                double r =  c.getRed()*0.3;
                double g = c.getGreen()*0.59;
                double b = c.getBlue()*0.11;

                int sum =(int) (r+g+b);
                Color newColor = new Color(sum, sum, sum);
                input.setRGB(x, y, newColor.getRGB());
            }
        }
//            ImageIO.write(input, "jpg", new File(outputPath));

    }
}