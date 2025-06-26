package org.scoula.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
}
