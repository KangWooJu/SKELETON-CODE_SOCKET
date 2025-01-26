package org.kangwooju.skeletoncode_socket.domain.Socket.Controller;

import org.kangwooju.skeletoncode_socket.domain.Socket.DTO.GreetingRequest;
import org.kangwooju.skeletoncode_socket.domain.Socket.DTO.GreetingResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    // 특정 경로로 들어오는 메시들을 @SendTo에 명시된 경로로 전달
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingResponse greeting(GreetingRequest request) throws InterruptedException{
        Thread.sleep(10000);
        return new GreetingResponse("Hello, " + HtmlUtils.htmlEscape(request.name()) + " !!");

    }
}
