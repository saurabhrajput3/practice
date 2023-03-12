package com.chatapplication.chat.application.service;

import com.chatapplication.chat.application.dao.StatusRepository;
import com.chatapplication.chat.application.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;
    public int saveStatus(Status status){
        Status statusObj=statusRepository.save(status);
        return statusObj.getStatusId();
    }

}
