import java.util.Scanner;

public class Sentences {
    
    public char[] reverse(char[] sentence) {
        char[] revSentence = new char[sentence.length];
        for(int i = 0; i < sentence.length; i++) {
            revSentence[i] = sentence[sentence.length - i - 1];
        }
        return revSentence;
    }

    public char[] reverseWords(char[] sentence) {
        char[] revWords = new char[sentence.length];
        int spaceIndex = sentence.length;
        int revIndex = 0;
        for(int position = sentence.length - 1; position >= 0; position--) {
            if(sentence[position] == ' ') {
                for(int wordIndex = position + 1; wordIndex < spaceIndex; wordIndex++) {
                revWords[revIndex++] = sentence[wordIndex];
                }
                spaceIndex = position;
                revWords[revIndex++] = ' ';
            }

            if(position == 0) {
                for(int wordIndex = position; wordIndex < spaceIndex; wordIndex++) {
                    revWords[revIndex++] = sentence[wordIndex];
                }
            }

        }
        return revWords;
    }

    public char[] uppercase(char[] sentence) {
        char[] newSentence = new char[sentence.length];
        for(int i = 0; i < sentence.length; i++) {
            if(i % 5 == 0 && sentence[i] > 'a' && sentence[i] < 'z') {
                char toUppercase = sentence[i];
                int ascii = (int)toUppercase;
                ascii -= 32;
                newSentence[i] = (char)ascii;
            }
            else {
                newSentence[i] = sentence[i];
            }
        }

        return newSentence;
    }

    public char[][] write(char[][] sentence) {
        String[] line = new String[3];
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("Enter a sentence that does not exceed 60 characters");
            line[i] = keyboard.nextLine();
        }
        for(int i = 0; i < 3; i++) {
            if(line[i].length() > 60) {
                System.out.printf("Sentence %d too long! Terminating program...", i+1);
                System.exit(1);
            }
            for(int j = 0; j < line[i].length(); j++) {
                sentence[i][j] = line[i].charAt(j);
            }
        }
        keyboard.close();
        return sentence;

    }


    public static void main(String[] args) {
        char[][] sentence = new char[3][60];
        Sentences mySentence = new Sentences();
        mySentence.write(sentence);
        System.out.println(mySentence.reverse(sentence[0]));
        System.out.println(mySentence.reverseWords(sentence[1]));
        System.out.println(mySentence.uppercase(sentence[2]));            
    }
}