package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 연습. 이건 쓸 일 없음
    @GetMapping("hello-string")
    @ResponseBody // 응답 body부에 data를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // name에 spring 을 넣으면 hello spring이 나온다.
    }

    // 여기부터 API 진짜
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON으로 반환.
    }
    static class Hello {
        private String name; // 커맨드 n으로 게터세터
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        } }

}
