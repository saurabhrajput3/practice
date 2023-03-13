package com.chatapplication.chat.application.controller;

import com.chatapplication.chat.application.dao.StatusRepository;
import com.chatapplication.chat.application.dao.UserRepository;
import com.chatapplication.chat.application.model.ChatHistory;
import com.chatapplication.chat.application.model.Status;
import com.chatapplication.chat.application.model.Users;
import com.chatapplication.chat.application.service.ChatHistoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/api/v1/chat")
public class ChatHistoryController {
    @Autowired
    ChatHistoryService chatHistoryService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatusRepository statusRepository;

    @PostMapping(value = "/send-message")
    public ResponseEntity<String> saveMessage(@RequestBody String requestData){
        JSONObject requestObj=new JSONObject(requestData);
        JSONObject errorList= validateRequest(requestObj);
        if(errorList.isEmpty()){
            ChatHistory chat= setChatHistory(requestObj);
            int chatId = chatHistoryService.saveMessage(chat);
            return new ResponseEntity<>("message sent-"+chatId, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<String>(errorList.toString(),HttpStatus.BAD_REQUEST);
        }
    }
        @GetMapping(value = "/get-chat")
        public ResponseEntity<String> getChatByUserId(@RequestParam int senderId){
            JSONObject response=chatHistoryService.getChatsByUserId(senderId);
            return new ResponseEntity<String>(response.toString(),HttpStatus.OK);
        }


        @GetMapping(value = "/get-conversation")
        public ResponseEntity<String> getConversationBetweenTwoUsers(@RequestParam int user1,@RequestParam int user2){
            JSONObject response=chatHistoryService.getConversation(user1,user2);
            return new ResponseEntity<String>(response.toString(),HttpStatus.OK);
        }







    private ChatHistory setChatHistory(JSONObject requestObj){
        ChatHistory chat=new ChatHistory();

        String message= requestObj.getString("message");
        int senderId=requestObj.getInt("sender");
        int receiverId=requestObj.getInt("receiver");
        Users senderUserObj=userRepository.findById(senderId).get();
        Users receiverUserObj=userRepository.findById(receiverId).get();

        chat.setSender(senderUserObj);
        chat.setReceiver(receiverUserObj);
        chat.setMessage(message);
        Status status=statusRepository.findById(1).get();
        chat.setStatusId(status);

        Timestamp createdTime=new Timestamp(System.currentTimeMillis());
        chat.setCreatedDate(createdTime);

        return chat;
    }

    private JSONObject validateRequest(JSONObject requestObj){
        JSONObject errorObj=new JSONObject();
        if(!requestObj.has("sender")){
            errorObj.put("sender","Missing Parameter");
        }
        if(!requestObj.has("receiver")){
            errorObj.put("receiver","Missing Parameter");
        }
        if(requestObj.has("message")){
            String message=requestObj.getString("message");
            if(message.isEmpty()||message.isBlank()){
                errorObj.put("message","message body can't be empty");
            }
        }
        else{
            errorObj.put("message","missing parameter");
        }
        return errorObj;
    }


}
