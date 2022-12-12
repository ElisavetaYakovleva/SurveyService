package Survey.controllers;


import Survey.models.Answer;
import Survey.models.Question;
import Survey.models.SurveyAll;
import Survey.models.User;
import Survey.repositories.AnswerRepository;
import Survey.repositories.QuestionRepository;
import Survey.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SurveyController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/surveyList")
    public String surveysList(Model model){
        Iterable<SurveyAll> survey = surveyRepository.findAll();


/*        List<SurveyAll> survey1 = surveyRepository.findAll();
        List<Long> id1 = new ArrayList<>();

        for (int i = 0; i < survey1.size(); i++) {
            SurveyAll surveyAll = survey1.get(i);
            id1.add(surveyAll.getId());
            //id1.addAll()
        }*/
        model.addAttribute("survey", survey);

        return "surveyList";
    }


    @GetMapping("/newSurvey/{id}")
    public String getSurveyAdd(@PathVariable (value = "id") long id, Model model) {
        if (!surveyRepository.existsById(id)) {
            return "redirect:/surveyList";
        }
        long id1 = id;
        model.addAttribute("id", id1);
        return "surveyAdd";
    }

    @GetMapping("/newSurvey")
    public String getNewSurvey(Model model) {
        return "newSurvey";
    }

    @GetMapping("/surveyList/{id}")
    public String getSurvey(
            @PathVariable (value = "id") long id,
            ModelMap modelMap, Model model) {
        SurveyAll survey = surveyRepository.getById(id);
        modelMap.put("survey", survey);
        List<Question> question = questionRepository.findBySurveyId(id);
        Question question1 = question.get(0);
        Long quest = question1.getId();
        model.addAttribute("quest", quest);
        return "surveyFirst";
    }

    @PostMapping("/surveyList/{id}")
    public String postSurvey(
            @PathVariable (value = "id") long id,
            Model model) {
        List<Question> question = questionRepository.findBySurveyId(id);
        Question question1 = question.get(0);
        Long quest = question1.getId();
        model.addAttribute("quest", quest);


        return "redirect:/surveyList/{id}/" + quest;
    }

    @GetMapping("/surveyList/{id}/{quest}")
    public String getSurveyQuest(
            @PathVariable (value = "id") long id,
            @PathVariable (value = "quest") long id1,
            ModelMap modelMap, Model model) {
        model.addAttribute("surveyId", id);
        model.addAttribute("quest", id1);
        SurveyAll surveyAll = surveyRepository.getById(id);
        model.addAttribute("nameSurvey", surveyAll.getNameSurvey());
        List<Question> question = questionRepository.findBySurveyId(id);
       // Question question2 = new Question();
        Question question2 = question.get(0);

        Long questionID = question2.getId();
        int i = 1;
        while (questionID != id1 && i < question.size()){
            question2 = question.get(i);
            questionID = question2.getId();
            i++;

        }
        model.addAttribute("question", question2);


        List<Answer> answerList = answerRepository.findByQuestionId(question2.getId());
        modelMap.put("answers", answerList);

        /*boolean containsElement = question.contains(((int)id1)+1);
        if (containsElement == false){
            return "redirect:/surveyList";
        }*/

        return "surveyAnswer";
    }

    @PostMapping("/surveyList/{id}/{quest}")
    public String postSurveyQuest(
            @PathVariable (value = "id") long id,
            @PathVariable (value = "quest") long id1,
            @RequestParam ("aID") long aID,
            ModelMap modelMap, Model model) {
        model.addAttribute("surveyId", id);
        model.addAttribute("quest", id1);
        SurveyAll surveyAll = surveyRepository.getById(id);
        model.addAttribute("nameSurvey", surveyAll.getNameSurvey());
        List<Question> question = questionRepository.findBySurveyId(id);
        Question question2 = question.get(0);
        Long questionID = question2.getId();

        int i = 1;
        while (questionID != id1 && i < question.size()){
            question2 = question.get(i);
            questionID = question2.getId();
            i++;

        }
        model.addAttribute("question", question2);
        List<Answer> answerList = answerRepository.findByQuestionId(question2.getId());
        modelMap.put("answers", answerList);
        Answer answer = answerRepository.getById(aID);
        int a = answer.getChoiceNumber();
        a+=1;
        answer.setChoiceNumber(a);
        answerRepository.save(answer);
        boolean containsElement = question.contains(((int)id1));
        if (containsElement == false){
            return "redirect:/surveyList";
        }

        Long r = id1 + 1;
        return "redirect:/surveyList/{id}/" + r;
    }


    @PostMapping("/newSurvey/{id}")
    public String surveyAdd(
            @PathVariable (value = "id") long id, @RequestParam String questions, @RequestParam/*(required = false)*/ List<String> answer, Map<String, Object> model){
        if (!surveyRepository.existsById(id)) {
            return "redirect:/surveyList";
        }
        SurveyAll surveyAll = surveyRepository.getById(id);
        long idSurvey = surveyAll.getId();
        Question question = new Question(idSurvey, questions);
        questionRepository.save(question);
        long idQuestion = question.getId();

        for (int i = 0; i < answer.size(); i++) {
            Answer answer1 = new Answer(idQuestion, answer.get(i), 0);
            answerRepository.save(answer1);
        }

        return "surveyAdd";
    }

    @PostMapping("/newSurvey")
    public String newSurvey(@AuthenticationPrincipal User user,
                            @RequestParam String nameSurvey,
                            @RequestParam int answerTime,
                            Model model){
        long id1 = user.getId();
        SurveyAll survey = new SurveyAll(id1, nameSurvey, answerTime, user.getUsername());
        surveyRepository.save(survey);
        model.addAttribute("id", survey.getId());


        return "newSurvey";
    }
}
