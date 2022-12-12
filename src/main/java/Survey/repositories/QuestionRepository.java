package Survey.repositories;

import Survey.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question getBySurveyId(long id);

    List<Question> findBySurveyId(Long surveyId);
}