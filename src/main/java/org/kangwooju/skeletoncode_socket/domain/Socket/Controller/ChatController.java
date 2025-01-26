package org.kangwooju.skeletoncode_socket.domain.Socket.Controller;

import org.kangwooju.skeletoncode_socket.domain.User.Entity.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import javax.naming.AuthenticationException;

@Controller
public class ChatController {

    @MessageMapping("info")
    @SendToUser("/queue/info")
    public String info(String message,SimpMessageHeaderAccessor messageHeaderAccessor){

        User talker = messageHeaderAccessor.getSessionAttributes().get(SESSION).get(USER_SESSION_KEY);
        return message;
    }

    @MessageMapping("chat")
    @SendTo("/topic/message")
    public String chat(String message,SimpMessageHeaderAccessor messageHeaderAccessor){
        User talker = messageHeaderAccessor.getSessionAttributes().get(SESSION).get(USER_SESSION_KEY);

        if(talker == null) throw new UnAuthenticationException("로그인한 사용자만 채팅에 참여할 수 있습니다.");
        return message;

    }
}
