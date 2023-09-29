package atl.wordle.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * I have written this class for an organisationnal purpose. this one deals with
 * all about the dictionary
 *
 * @author Nasse
 */
public class Words {

    // this is simply the dictionary but the specificity is that we 
    // filtered the words with 5 letter at the beginning
    private ArrayList<String> words;
    //this is a set of char to select the words in the dictionary
    private char[] letterFound;

    /**
     *
     * @throws IOException it throws an eceptions if it doesn't find the
     * dictionary
     */
    public Words() throws IOException {
        words = new ArrayList<String>();
        letterFound = new char[5];

        String fileName = "src/resources/Dictionary.txt";

        try ( InputStream fis = new FileInputStream(fileName);  InputStreamReader isr = new InputStreamReader(fis,
                StandardCharsets.UTF_8);  BufferedReader br = new BufferedReader(isr)) {
            String mot = br.readLine();
            while (mot != null) {
                if (mot.length() == 5) {
                    words.add(mot);
                    mot = br.readLine();
                } else {
                    mot = br.readLine();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.firstCleaningOfTheList();
    }
/**
 * This methode has the responsibility to filter all of the words that we don't need for the first use of 
 * the game.
 * I mean the words below 5 letter and the words that have more than 5
 */
    private void firstCleaningOfTheList() {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).toString().length() != 5) {
                words.remove(i);
                i = 0;
            }
        }
    }


    public ArrayList<String> getListWords() {
        return words;
    }

    public int getSize() {
        return getListWords().size();
    }
    /**
     * looking after the availables words which answer to the criteria of
     * the right letter
     * @param letters set of letter correct
     */
    public void availableWords(char[] letters) {
        for (int i = 0; i < this.getListWords().size(); i++) {
            if (!this.words.get(i).contains(letters.toString())) {
                this.words.remove(i);
            }
        }
    }
}
