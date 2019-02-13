package com.sms.questionpaper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.QuestionPaper;

public interface QuestionPaperDAO extends JpaRepository<QuestionPaper,Integer> {

	@Query(value = "SELECT file_url from question_paper where id=?1", nativeQuery = true)
	String getFileUrlById(int questionPaperId);

	@Query(value = "SELECT * from question_paper where class_id=?1", nativeQuery = true)
	List<QuestionPaper> getQuestionPaperByClassId(int classId);

	

}
