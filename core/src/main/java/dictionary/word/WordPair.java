package dictionary.word;

public class WordPair {
    private final Word germanWord;
    private final Word russianWord;

    public WordPair( Word russianWord, Word germanWord ) {
        if (russianWord == null || germanWord == null) {
            throw new IllegalArgumentException( "Words cannot be null" );
        }

        if (russianWord.getValue().length() < 3) {
            throw new IllegalArgumentException(russianWord.getValue() + " is too short.");
        }

        if (germanWord.getValue().length() < 3) {
            throw new IllegalArgumentException(germanWord.getValue() + " is too short.");
        }

        this.russianWord = russianWord;
        this.germanWord = germanWord;
    }

    public WordPair( String russianWord, String germanWord ) {
        this( new Word( russianWord ), new Word( germanWord ) );
    }

    public Word getGermanWord() {
        return new Word( germanWord.getValue() );
    }

    public Word getRussianWord() {
        return new Word( russianWord.getValue() );
    }

    public WordPair copy() {
        return new WordPair( germanWord.getValue(), russianWord.getValue() );
    }

    @Override
    public String toString() {
        return "WordPair{" +
                "germanWord=" + germanWord +
                ", russianWord=" + russianWord +
                '}';
    }
}
