package com.example.loginapp.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String list(HttpServletRequest request) {
        request.setAttribute("models", boardService.글목록보기());
        return "board/list";
    }
}
