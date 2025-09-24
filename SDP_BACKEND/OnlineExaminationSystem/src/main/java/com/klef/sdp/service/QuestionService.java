package com.klef.sdp.service;

import com.klef.sdp.model.Question;
import java.util.List;

public interface QuestionService {
    Question getQuestionById(Long id);
    Question updateQuestion(Question question);
    void deleteQuestion(Long id);
    List<Question> getQuestionsByExam(Long examId);
}
