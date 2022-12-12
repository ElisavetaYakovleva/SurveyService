package Survey.models;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_id")
    private Long questionId;

    private String answer;
    private int choiceNumber;

    public Answer() {

    }

    public Answer(Long questionId, String answer, int choiceNumber) {
        this.questionId = questionId;
        this.answer = answer;
        this.choiceNumber = choiceNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestion() {
        return questionId;
    }

    public void setQuestion(Long question) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }
}
