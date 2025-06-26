package org.scoula.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.scoula.user.domain.UserVO;

@Mapper
public interface UserMapper {
    void insertUser(UserVO user);
    UserVO findByEmail(@Param("email") String email);
}
