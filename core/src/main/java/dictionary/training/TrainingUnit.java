package dictionary.training;

import dictionary.word.WordPair;

/**
 * Contains unique id, word, it's translation
 * with current learning status
 */
public class TrainingUnit {
    private int id;
    private WordPair wordPair;
    private int correctAnswers;

    public TrainingUnit( WordPair wordPair ) {
        this.wordPair = wordPair;
        correctAnswers = 0;
    }

    public TrainingUnit( int id, WordPair wordPair, int correctAnswers ) {
        this.id = id;
        this.wordPair = wordPair;
        this.correctAnswers = correctAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public WordPair getWordPair() {
        return wordPair;
    }

    public int getId() {
        return id;
    }

}
