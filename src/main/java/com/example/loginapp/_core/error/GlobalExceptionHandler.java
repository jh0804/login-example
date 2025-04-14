package com.example.loginapp._core.error;

import com.example.loginapp._core.error.ex.*;
import com.example.loginapp._core.util.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 401 : 인증 안 됨
    @ExceptionHandler(Exception401.class)
    public String ex401(Exception401 e) {

        String html = """
                <script>
                    alert('${msg}');
                    location.href = "/login-form";
                </script>
                """.replace("${msg}", e.getMessage());

        return html;
    }

    @ExceptionHandler(ExceptionApi401.class)
    public Resp<?> exApi401(ExceptionApi401 e) {
        return Resp.fail(401, e.getMessage());
    }

    // 403 : 권한 없음
    @ExceptionHandler(Exception403.class)
    public String ex403(Exception403 e) {

        String html = """
                <script>
                    alert('${msg}');
                </script>
                """.replace("${msg}", e.getMessage());

        return html;
    }

    @ExceptionHandler(ExceptionApi403.class)
    public Resp<?> exApi403(ExceptionApi403 e) {

        return Resp.fail(403, e.getMessage());
    }

    // 404 : 자원 없음
    @ExceptionHandler(Exception404.class)
    public String ex404(Exception404 e) {

        String html = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}", e.getMessage());

        return html;
    }

    @ExceptionHandler(ExceptionApi404.class)
    public Resp<?> exApi404(ExceptionApi404 e) {

        return Resp.fail(404, e.getMessage());
    }

    // 400 : Bad Request
    @ExceptionHandler(Exception400.class)
    public String ex400(Exception400 e) {

        String html = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}", e.getMessage());

        return html;
    }

    // 내가 처리하지 못한 모든 Exception
    @ExceptionHandler(Exception.class)
    public String exUnknown(Exception e) {
        // 중요한 내용이 들어있는 msg일 수도 있으므로
        // history.back = 뒤로가기
        String html = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}", "관리자에게 문의해주세요.");
        System.out.println("관리자님 보세요 : " + e.getMessage()); // 원래는 로그로 남겨야 한다!

        return html;
    }
}
