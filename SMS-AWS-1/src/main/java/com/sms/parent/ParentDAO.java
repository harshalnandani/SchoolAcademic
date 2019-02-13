package com.sms.parent;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.beans.Parent;

public interface ParentDAO extends JpaRepository<Parent, Integer>{

	

}
