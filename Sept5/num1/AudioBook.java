package Sept5.num1;

public class AudioBook extends Book{
    private int durationMinutes;
    public AudioBook(String title, String author, int pages, int durationMinutes){
        super(title, author, pages);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString(){
        return super.toString() +  ", Duration(minutes): " + durationMinutes;
    }
}
