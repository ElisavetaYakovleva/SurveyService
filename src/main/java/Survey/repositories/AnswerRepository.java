package Survey.repositories;

import Survey.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Override
    List<Answer> findAll();

    List<Answer> findByQuestionId(long id);
}