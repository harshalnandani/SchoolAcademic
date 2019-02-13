package com.sms.news;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.News;

public interface NewsDAO extends JpaRepository<News,Integer>{

	@Query(value = "SELECT * from news  where school_id=?1", nativeQuery = true)
	List<News> getViewNewsBySchoolId(int schoolId);
}
