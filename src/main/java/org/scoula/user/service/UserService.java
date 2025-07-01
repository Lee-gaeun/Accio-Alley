package org.scoula.user.service;

import lombok.RequiredArgsConstructor;
import org.scoula.user.domain.UserVO;
import org.scoula.user.dto.*;
import org.scoula.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    // 회원가입
    public UserDTO signup(UserDTO dto) {
        UserVO user = dto.toVO();
        userMapper.insertUser(user); // user.id는 DB에서 자동 생성됨
        return UserDTO.fromVO(user);
    }
    // 로그인
    public UserDTO login(UserDTO dto) {
        UserVO user = userMapper.findByEmail(dto.getEmail());
        if (user == null || !user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }
        return UserDTO.fromVO(user);
    }
    // 사용자 조회
    public UserDTO findById(Long id) {
        UserVO user = userMapper.findById(id);
        if (user == null) {
            throw new RuntimeException("해당 사용자를 찾을 수 없습니다.");
        }
        return UserDTO.fromVO(user);
    }

}
