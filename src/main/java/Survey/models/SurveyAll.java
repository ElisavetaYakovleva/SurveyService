package Survey.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survey_all")
public class SurveyAll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "survey_name")
    private String nameSurvey;
    private int answerTime;
    private String author;

    public SurveyAll() {
    }

    public SurveyAll(Long userId, String nameSurvey, int answerTime, String author) {
        this.userId = userId;
        this.nameSurvey = nameSurvey;
        this.answerTime = answerTime;
        this.author = author;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNameSurvey() {
        return nameSurvey;
    }

    public void setNameSurvey(String nameSurvey) {
        this.nameSurvey = nameSurvey;
    }

    public int getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(int answerTime) {
        this.answerTime = answerTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
