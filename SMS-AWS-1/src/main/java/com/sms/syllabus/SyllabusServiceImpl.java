package com.sms.syllabus;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.Class;
import com.sms.beans.Subject;
import com.sms.beans.Syllabus;
import com.sms.class1.ClassServiceImpl;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.services.FileS3ServiceImpl;
import com.sms.subject.SubjectServiceImpl;

@Service
public class SyllabusServiceImpl {

	@Autowired
	private SyllabusDAO syllabusDAO;

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
	public void saveSyllabus(MultipartFile file, Syllabus syllabus, int classId, int subjectId) throws InvalidFileNameException, IOException {
		fileName = StringUtils.cleanPath(file.getOriginalFilename());
		// Check if the file's name contains invalid characters
		if (fileName.contains("..")) {
			throw new InvalidFileNameException();
		}
		fileUrl = fileS3ServiceImpl.uploadFile(file);
		syllabus.setFileUrl(fileUrl);
		class1=ClassSectionSubjectServiceImpl.getClassById(classId);
		subject=subjectServiceImpl.getSubjectById(subjectId);
		syllabus.setClass1(class1);
		syllabus.setSubject(subject);
		syllabusDAO.save(syllabus);

	}

	public Syllabus getSyllabus(int id) {
		return syllabusDAO.getOne(id);

	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteSyllabus(int syllabusId) {
		fileUrl = syllabusDAO.getFileUrlById(syllabusId);
		fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		syllabusDAO.deleteById(syllabusId);

	}

	public Syllabus getSyllabusByClassId(int classId) {
		// TODO Auto-generated method stub
		return syllabusDAO.getSyllabusByClassId(classId);
	}

}
