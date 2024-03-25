package mungtigi.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Controller; // Controller 애노테이션 import 추가
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller 애노테이션 추가
public class MungtigiController {
    @GetMapping("/")
    public String index(Model model) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul")); // LocalDateTime 사용
        System.out.println(now.toString());

        // 원하는 포맷에 맞게 날짜 및 시간을 문자열로 구성
        String serverTime = String.format("%04d-%02d-%02d %02d:%02d",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getHour(), now.getMinute());

        model.addAttribute("serverTime", serverTime); // Model 객체 직접 사용
        return "index"; // 반환되는 문자열은 Thymeleaf 템플릿의 파일명입니다.
    }

    @GetMapping("/history")
    public String history(Model model){
        return "history";
    }
    @GetMapping("/making")
    public String making(Model model){
        return "making";
    }
    @GetMapping("/appendix")
    public String appendix(Model model){
        return "appendix";
    }
}
