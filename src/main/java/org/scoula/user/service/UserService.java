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
//    public UserDTO signup(UserDTO dto) {
//        UserVO user = new UserVO();
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword()); //  평문 저장
//        user.setName(dto.getName());
//        user.setNickname(dto.getNickname());
//
//        userMapper.insertUser(user);
//        return new UserDTO(user.getId(), user.getPassword(), user.getEmail(), user.getName(), user.getNickname());
//    }
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
//        return new UserDTO(
//                user.getId(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getName(),
//                user.getNickname()
//        );
//        UserVO vo = dto.toVO();
//                userMapper.addToUser(vo);
//        return UserDTO.fromVO(userVO);
        return UserDTO.fromVO(user);
    }
}
