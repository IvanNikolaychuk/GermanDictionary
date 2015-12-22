package dictionary.word;

public class WordPair {
    private Word germanWord;
    private Word russianWord;

    public WordPair( Word russianWord, Word germanWord ) {
        this.russianWord = russianWord;
        this.germanWord = germanWord;
    }

    public WordPair( String russianWord, String germanWord ) {
        this( new Word( russianWord ), new Word( germanWord ) );
    }

    public Word getGermanWord() {
        return germanWord;
    }

    public void setGermanWord( Word germanWord ) {
        this.germanWord = germanWord;
    }

    public Word getRussianWord() {
        return russianWord;
    }

    public void setRussianWord( Word russianWord ) {
        this.russianWord = russianWord;
    }

    @Override
    public String toString() {
        return "WordPair{" +
                "germanWord=" + germanWord +
                ", russianWord=" + russianWord +
                '}';
    }
}
