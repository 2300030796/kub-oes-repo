package com.klef.sdp.service;

import com.klef.sdp.model.Result;
import java.util.List;

public interface ResultService {
    Result getResultById(Long id);
    List<Result> getResultsByStudent(Long studentId);
    List<Result> getResultsByExam(Long examId);
}
