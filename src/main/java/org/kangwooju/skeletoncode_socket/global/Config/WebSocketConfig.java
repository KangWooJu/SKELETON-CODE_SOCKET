package org.kangwooju.skeletoncode_socket.global.Config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@Data
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){

        // 해당 파라미터의 접두사가 붙은 목적지 ( 구독자 ) 에 메시지를 보낸다.
        registry.enableSimpleBroker("/topic");

        // 도착 경로에 대한 prefix를 설정하는 메소드
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // WebSocket을 사용할 수 없는 경우 대체 전송을 사용할 수 있도록 SockJS 풀백옵션 활성화
        registry.addEndpoint("/websocket-talk")
                .addInterceptors()
                // fallback - client가 sockJS로 개발되었을 때 필요 ( 앱 통신시 제거 )
                .withSockJS();
    }


}
