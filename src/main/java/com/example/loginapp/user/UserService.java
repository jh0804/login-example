package com.example.loginapp.user;

import com.example.loginapp._core.util.SHA256Util;
import org.mindrot.jbcrypt.BCrypt;
import com.example.loginapp._core.error.ex.Exception400;
import com.example.loginapp._core.error.ex.Exception401;
import com.example.loginapp._core.error.ex.Exception404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
// 책임 : 트랜잭션 처리, 비지니스 로직, DTO 완료
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.JoinDTO joinDTO) {
        try {
            String encPassword = SHA256Util.encrypt(joinDTO.getPassword());
            joinDTO.setPassword(encPassword);

            userRepository.save(joinDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("이미 존재하는 아이디로 회원가입 하지 마세요. postman도 쓰지 마세요.");
        }
    }

    public User login(UserRequest.LoginDTO loginDTO) {
        // 1. username 일치 검사
        User user = userRepository.findByUsername(loginDTO.getUsername());
        // 2. username 불일치 -> Exception
        if (user == null) throw new Exception401("username 혹은 password가 틀렸습니다.");
        // 3. password 불일치 -> Exception
        String encPassword = SHA256Util.encrypt(loginDTO.getPassword());
        if (!encPassword.equals(user.getPassword())) {
            throw new Exception401("username 혹은 password가 틀렸습니다.");
        }
        // 4. username & password 전부 일치
        return user;
    }

    public Map<String, Object> 유저네임중복체크(String username) {
        User user = userRepository.findByUsername(username);
        Map<String, Object> dto = new HashMap<>();

        if (user == null) {
            dto.put("available", true);
        } else {
            dto.put("available", false);
        }
        return dto;
    }

    @Transactional
    public User 회원정보수정(UserRequest.UpdateDTO updateDTO, Integer id) {
        User user = userRepository.findById(id);
        if (user == null) throw new Exception404("회원을 찾을 수 없습니다.");
        user.update(updateDTO.getPassword(), updateDTO.getEmail());
        return user;
    }
}
