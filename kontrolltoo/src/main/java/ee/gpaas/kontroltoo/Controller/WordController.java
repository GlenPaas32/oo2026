package ee.gpaas.kontroltoo.Controller;


import ee.gpaas.kontroltoo.entity.LetterCount;
import ee.gpaas.kontroltoo.entity.Word;
import ee.gpaas.kontroltoo.Repository.LetterCountRepository;
import ee.gpaas.kontroltoo.Repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordController {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    LetterCountRepository letterCountRepository;

    @PostMapping("/word")
    public String addWord(@RequestBody Word word) {

        if(word.getWord() == null || word.getWord().isEmpty()){
            return "Sõna ei tohi olla tühi";
        }

        if(word.getWord().length() < 2){
            return "Sõna peab olema vähemalt 2 tähemärki";
        }

        wordRepository.save(word);
        return "Sõna lisatud";
    }

    @GetMapping("/words")
    public List<Word> getWords(){
        return wordRepository.findAll();
    }

    @GetMapping("/count-a")
    public int countA(){

        List<Word> words = wordRepository.findAll();
        int total = 0;

        for(Word w : words){
            String text = w.getWord().toLowerCase();

            for(char c : text.toCharArray()){
                if(c == 'a'){
                    total++;
                }
            }
        }

        LetterCount lc = new LetterCount();
        lc.setCount(total);
        letterCountRepository.save(lc);

        return total;
    }

    @GetMapping("/words-with-a")
    public int wordsWithA(){

        List<Word> words = wordRepository.findAll();
        int count = 0;

        for(Word w : words){
            if(w.getWord().toLowerCase().contains("a")){
                count++;
            }
        }

        return count;
    }

    @GetMapping("/average-a")
    public double averageA(){

        List<Word> words = wordRepository.findAll();

        int totalA = 0;
        int totalLetters = 0;

        for(Word w : words){

            String text = w.getWord().toLowerCase();
            totalLetters += text.length();

            for(char c : text.toCharArray()){
                if(c == 'a'){
                    totalA++;
                }
            }
        }

        if(totalLetters == 0){
            return 0;
        }

        return (double) totalA / totalLetters;
    }

    @PutMapping("/replace/{index}")
    public String replaceLetter(@PathVariable int index){

        List<Word> words = wordRepository.findAll();

        for(Word w : words){

            String text = w.getWord();

            if(text.length() > index){

                char[] chars = text.toCharArray();
                chars[index] = 'a';

                w.setWord(new String(chars));
                wordRepository.save(w);

            }

        }

        return "Tähed muudetud";
    }
}
//word
//words
//count-a
//words-with-a
//average-a
//replace/2