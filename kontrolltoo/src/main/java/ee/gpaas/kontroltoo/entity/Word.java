package ee.gpaas.kontroltoo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    public Long getId(){

        return id;
    }
    public String getWord(){

        return word;
    }

    public void setWord(String word){
        this.word = word;
    }
}
