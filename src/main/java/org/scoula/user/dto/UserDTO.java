package org.scoula.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.user.domain.UserVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String name;
    private String nickname;

    public UserVO toVO() {
        return UserVO.builder()
                .id(this.id)
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .nickname(this.nickname)
                .build();
    }

    public static UserDTO fromVO(UserVO vo) {
        return UserDTO.builder()
                .id(vo.getId())
                .email(vo.getEmail())
                .password(vo.getPassword())
                .name(vo.getName())
                .nickname(vo.getNickname())
                .build();
    }
}
