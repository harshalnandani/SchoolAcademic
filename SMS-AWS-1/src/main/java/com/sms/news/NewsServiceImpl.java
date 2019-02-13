package com.sms.news;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.News;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.FileS3ServiceImpl;

@Service
public class NewsServiceImpl {
	
	@Autowired
	private NewsDAO newsDAO;
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;
	
	private News news;
	
	private String fileName;

	private String fileUrl;
	
	@Transactional(rollbackFor = Exception.class)
	public void addNews(News news, MultipartFile file, int schoolId) throws InvalidFileNameException, IOException {
		
		fileName = StringUtils.cleanPath(file.getOriginalFilename());
		// Check if the file's name contains invalid characters
		if (fileName.contains("..")) {
			throw new InvalidFileNameException();
		}
		fileUrl = fileS3ServiceImpl.uploadFile(file);
		news.setPictureUrl(fileUrl);
		news.setSchool(schoolServiceImpl.getSchoolById(schoolId));
		newsDAO.save(news);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteNews(int newsId) {
		// TODO Auto-generated method stub
		newsDAO.deleteById(newsId);
	}

	public News getNewsById(int newsId) {

		return newsDAO.getOne(newsId);
	}

	public void editNews(News news1) {
		news = newsDAO.getOne(news1.getNewsId());
		news.setTitle(news1.getTitle());
		news.setNewsBody(news1.getNewsBody());
		newsDAO.save(news);
	}

	public List<News> getViewNewsBySchoolId(int schoolId) {
		return newsDAO.getViewNewsBySchoolId(schoolId);
	}

}
