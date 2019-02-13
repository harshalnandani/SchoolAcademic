package com.sms.questionpaper;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.Class;
import com.sms.beans.QuestionPaper;
import com.sms.beans.Subject;
import com.sms.class1.ClassServiceImpl;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.services.FileS3ServiceImpl;
import com.sms.subject.SubjectServiceImpl;

@Service
public class QuestionPaperServiceImpl {

	@Autowired
	private QuestionPaperDAO questionPaperDAO;

	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;

	@Autowired
	private ClassServiceImpl ClassSectionSubjectServiceImpl;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	private Class class1;

	private Subject subject;

	private String fileName;

	private String fileUrl;

	@Transactional(rollbackFor = Exception.class)
	public void saveQuestionPaper(MultipartFile file, QuestionPaper questionPaper, int classId, int subjectId)
			throws InvalidFileNameException, IOException {

		fileName = StringUtils.cleanPath(file.getOriginalFilename());
		// Check if the file's name contains invalid characters
		if (fileName.contains("..")) {
			throw new InvalidFileNameException();
		}
		fileUrl = fileS3ServiceImpl.uploadFile(file);
		questionPaper.setFileUrl(fileUrl);
		class1 = ClassSectionSubjectServiceImpl.getClassById(classId);
		subject = subjectServiceImpl.getSubjectById(subjectId);
		questionPaper.setClass1(class1);
		questionPaper.setSubject(subject);
		questionPaperDAO.save(questionPaper);

	}

	public QuestionPaper getQuestionPaper(int id) {
		return questionPaperDAO.getOne(id);

	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteQuestionPaper(int questionPaperId) {
		fileUrl = questionPaperDAO.getFileUrlById(questionPaperId);
		fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		questionPaperDAO.deleteById(questionPaperId);

	}

	public List<QuestionPaper> getQuestionPaperByClassId(int classId) {
		// TODO Auto-generated method stub
		return questionPaperDAO.getQuestionPaperByClassId(classId);
	}

}
