package com.sms.examtimetable;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.Class;
import com.sms.beans.ExamTimeTable;
import com.sms.class1.ClassServiceImpl;
import com.sms.examresult.ExamResultServiceImpl;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.services.FileS3ServiceImpl;

@Service
public class ExamTimeTableServiceImpl {
	
	@Autowired
	private ExamTimeTableDAO examTimeTableDAO;
	
	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;
	
	@Autowired
	private ClassServiceImpl ClassSectionSubjectServiceImpl;
	
	@Autowired
	private ExamResultServiceImpl examResultServiceImpl;
	
	private Class class1;
	
	private String fileName;
	
	private String fileUrl;
	
	

	@Transactional(rollbackFor = Exception.class)
	public void saveExamTimeTable(MultipartFile file,ExamTimeTable examTimeTable, int classId, int examId) throws InvalidFileNameException, IOException {
			fileName = StringUtils.cleanPath(file.getOriginalFilename());
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new InvalidFileNameException();
			}
			fileUrl=fileS3ServiceImpl.uploadFile(file);
			examTimeTable.setFileUrl(fileUrl);
			class1=ClassSectionSubjectServiceImpl.getClassById(classId);
			examTimeTable.setClass1(class1);
			examTimeTable.setExam(examResultServiceImpl.getExamById(examId));
			examTimeTableDAO.save(examTimeTable);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deleteExamTimeTable(int examTimeTableId) {
		fileUrl=examTimeTableDAO.getExamTimeTableFileUrlById(examTimeTableId);
		fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		examTimeTableDAO.deleteById(examTimeTableId);
	}


}
