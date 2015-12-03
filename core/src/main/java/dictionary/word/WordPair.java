package dictionary.word;

public class WordPair {
    private GermanWord germanWord;
    private RussianWord russianWord;

    public WordPair( RussianWord russianWord, GermanWord germanWord ) {
        this.russianWord = russianWord;
        this.germanWord = germanWord;
    }

    public GermanWord getGermanWord() {
        return germanWord;
    }

    public void setGermanWord( GermanWord germanWord ) {
        this.germanWord = germanWord;
    }

    public RussianWord getRussianWord() {
        return russianWord;
    }

    public void setRussianWord( RussianWord russianWord ) {
        this.russianWord = russianWord;
    }
}
