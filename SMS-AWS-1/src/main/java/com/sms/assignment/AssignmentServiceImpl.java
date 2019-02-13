package com.sms.assignment;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.Assignment;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.Teacher;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.services.FileS3ServiceImpl;

@Service
public class AssignmentServiceImpl {

	@Autowired
	private AssignmentDAO assignmentDAO;

	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;
	
	
	private Section section;
	
	private Subject subject;
	
	private Teacher teacher;

	private String fileName;

	private String fileUrl;

	@Transactional(rollbackFor = Exception.class)
	public void saveAssignment(MultipartFile file, Assignment assignment, int sectionId, int subjectId, int teacherId) throws InvalidFileNameException, IOException {

		if (file != null) {
			fileName = StringUtils.cleanPath(file.getOriginalFilename());
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new InvalidFileNameException();
			}
			section=new Section();
			section.setSectionId(sectionId);
			subject=new Subject();
			subject.setSubjectId(subjectId);
			teacher=new Teacher();
			teacher.setTeacherId(teacherId);
			assignment.setSection(section);
			assignment.setSubject(subject);
			assignment.setTeacher(teacher);
			fileUrl = fileS3ServiceImpl.uploadFile(file);
			assignment.setFileUrl(fileUrl);
		}
		assignmentDAO.save(assignment);
	}

	public Assignment getAssignment(int id) {
		return assignmentDAO.getOne(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteAssignment(int assignmentId) {

		fileUrl = assignmentDAO.getFileUrlById(assignmentId);
		if (fileUrl != null) {
			fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		}
		assignmentDAO.deleteById(assignmentId);
	}

	public List<Assignment> getAssignmentsByTeacherId(int teacherId) {

		return assignmentDAO.getAssignmentsByTeacherId(teacherId);
	}

	public List<Assignment> getAssignmentsBySectionId(int sectionId) {
		// TODO Auto-generated method stub
		return assignmentDAO.getAssignmentsBySectionId(sectionId);
	}

}
