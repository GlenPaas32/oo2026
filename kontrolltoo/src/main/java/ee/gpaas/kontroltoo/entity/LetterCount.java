package ee.gpaas.kontroltoo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LetterCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    public Long getId() {

        return id;
    }
    public int getCount(){

        return count;
    }

    public void setCount(int count){
        this.count = count;
    }
}
