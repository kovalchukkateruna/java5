// Клас для представлення літери
class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}


class Word {
    private Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter);
        }
        return word.toString();
    }
}


class Sentence {
    private Word[] words;
    private char punctuation;

    public Sentence(String sentence) {
        String[] splitWords = sentence.split(" ");
        words = new Word[splitWords.length - 1]; 

        for (int i = 0; i < splitWords.length - 1; i++) {
            words[i] = new Word(splitWords[i]);
        }

        punctuation = splitWords[splitWords.length - 1].charAt(0);
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            sentence.append(word).append(" ");
        }
        sentence.append(punctuation);
        return sentence.toString();
    }
}


class Text {
    private Sentence[] sentences;

    public Text(String text) {
        String[] splitSentences = text.split("(?<=[.!?]) "); 
        sentences = new Sentence[splitSentences.length];

        for (int i = 0; i < splitSentences.length; i++) {
            sentences[i] = new Sentence(splitSentences[i]);
        }
    }

    public void replaceMultipleSpacesWithSingle() {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = new Sentence(sentences[i].toString().replaceAll("\\s+", " "));
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence).append(" ");
        }
        return text.toString().trim();
    }
}


public class Main {
    public static void main(String[] args) {
        
        String inputText = "This  is   a    test.  Another    sentence!   Yet   another   one?";

        
        Text text = new Text(inputText);
        System.out.println("Original text:");
        System.out.println(text);

        
        text.replaceMultipleSpacesWithSingle();
        System.out.println("\nText after replacing multiple spaces with a single space:");
        System.out.println(text);
    }
}
