package com.chatapplication.chat.application.dao;

import com.chatapplication.chat.application.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {



}
