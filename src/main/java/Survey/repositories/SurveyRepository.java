package Survey.repositories;

import Survey.models.Answer;
import Survey.models.SurveyAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<SurveyAll,Long> {
    //Optional<SurveyAll> findByQuestionsNotNull();

   // @Query("select s from SurveyAll s inner join s.questions questions inner join s.questions.answer answer where s.id = ?1 and s.company.username = ?2 and questions.question = ?3 and s.nameSurvey = ?4 and s.answerTime = ?5 and answer.answer = ?6")
    //List<SurveyAll> findForList(Long id, String username, String question, String nameSurvey, int answerTime, String answer);

    //List<SurveyAll> findAll();



   // SurveyAll findByCompany_UsernameAndNameSurveyAndAnswerTimeAndQuestions_QuestionAndQuestions_Answer_AnswerAndQuestions_Answer_ChoiceNumber(String username, String nameSurvey, int answerTime, String question, String answer, int choiceNumber);







}
