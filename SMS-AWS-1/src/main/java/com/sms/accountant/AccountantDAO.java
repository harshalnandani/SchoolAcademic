package com.sms.accountant;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.beans.Accountant;

public interface AccountantDAO extends JpaRepository<Accountant, Integer> {

}
