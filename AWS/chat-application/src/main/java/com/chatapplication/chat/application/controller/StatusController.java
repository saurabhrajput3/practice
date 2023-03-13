package com.chatapplication.chat.application.controller;

import com.chatapplication.chat.application.model.Status;
import com.chatapplication.chat.application.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    @Autowired
    StatusService service;

    @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData){
        Status status=setStatus(statusData);
        int statusId = service.saveStatus(status);
        return new ResponseEntity<>("status saved- " + statusId, HttpStatus.CREATED);
    }

    public Status setStatus(String statusData){
        Status status=new Status();

        JSONObject json=new JSONObject(statusData);

        status.setStatusName(json.getString("statusName"));
        status.setStatusDescription(json.getString("statusDescription"));
        return status;
    }


}
