package com.ipnet.bl.messagebl;

import com.ipnet.blservice.MessageBLService;
import com.ipnet.entity.Message;
import com.ipnet.vo.MessageSetRead;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageBL implements MessageBLService {
    @Override
    public void generateMessage(String receiver, String event) {

    }

    @Override
    public void generateMessage(ArrayList<String> receiver, String event) {

    }

    @Override
    public void setRead(MessageSetRead messageSetRead) {

    }

    @Override
    public ArrayList<Message> getReadMessageList(String username) {
        return null;
    }

    @Override
    public ArrayList<Message> getUnreadMessageList(String username) {
        return null;
    }
}
