package org.kangwooju.skeletoncode_socket.domain.User.DTO.Request;

import lombok.Builder;
import lombok.Data;

@Data
public class SigninRequest {

    public Long id;
    public String username;
    public String nickname;
    public String password;

    @Builder
    public SigninRequest(String username,String nickname,String password){
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

}
