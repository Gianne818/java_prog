package Sept5.num1;

public class Ebook extends Book {
    private double fileSizeMB;

    public Ebook(String title, String author, int pages, double fileSizeMB){
        super(title, author, pages);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public String toString(){
        return super.toString() + ", File size(MB): " + String.format("%.2f", fileSizeMB);
    }
}
