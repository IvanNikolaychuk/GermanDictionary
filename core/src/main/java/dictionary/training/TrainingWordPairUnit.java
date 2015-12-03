package dictionary.training;

import dictionary.word.WordPair;

/**
 * Contains word and it's translation
 * with current learning status
 */
public class TrainingWordPairUnit {
    private WordPair wordPair;
    private boolean isLearned;

    public TrainingWordPairUnit( WordPair wordPair ) {
        this.wordPair = wordPair;
        isLearned = false;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned( boolean learned ) {
        isLearned = learned;
    }

    public WordPair getWordPair() {
        return wordPair;
    }

    public void setWordPair( WordPair wordPair ) {
        this.wordPair = wordPair;
    }
}
