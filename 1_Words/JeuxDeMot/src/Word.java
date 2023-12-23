public class Word
{
    private int ID;
    private String WordString;

    // Constructor
    public Word(int ID, String WordString) {
        this.ID = ID;
        this.WordString = WordString;
    }

    // Getters and setters (optional)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWordString() {
        return WordString;
    }

    public void setWordString(String WordString) {
        this.WordString = WordString;
    }

    // Override toString() method for better printing
    @Override
    public String toString() {
        return "Word{" +
                "ID=" + ID +
                ", WordString='" + WordString + '\'' +
                '}';
    }
}