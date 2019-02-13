package com.sms.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Parent;

@Service
public class ParentServiceImpl {

	@Autowired
	ParentDAO parentDAO;

	Parent parent2;

	public Parent saveParent(Parent parent) {

		return parentDAO.save(parent);

	}

	public Parent getParentById(int parentId) {

		return parentDAO.getOne(parentId);
	}

	public Parent editParent(Parent parent) {
		parent2 = parentDAO.getOne(parent.getParentId());
		parent2.setFathersName(parent.getFathersName());
		parent2.setMothersName(parent.getMothersName());
		return parentDAO.save(parent2);
	}

	public void deleteParent(int parentId) {
		parentDAO.deleteById(parentId);

	}

}
