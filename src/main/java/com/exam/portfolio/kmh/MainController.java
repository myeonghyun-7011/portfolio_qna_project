package com.exam.portfolio.kmh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
  @RequestMapping("/sss")
  // 아래 함수의 리턴값을 그대로 브라우저에 표시
  // 아래 함수의 리턴값을 문자열화 해서 브라우저 응답을 바디에 담는다.
  @ResponseBody()
  public String index() {
    return "안녕하세요";
  }

  @GetMapping("/page1")
  @ResponseBody()
  public String showMain() {
    return """
         <form method="POST" action="/page2">
            <input type="number" name="age" placeholder="나이입력"/>
            <input type="submit" value="page2로 POST 방식으로 이동" />
         </form>
         <form method="GET" action="/page3">
            <input type="number" name="age" placeholder="나이입력"/>
            <input type="submit" value="page3로 GET 방식으로 이동" />
         </form>
        """;
  }
  //  주소에 http://localhost:8080/page2 이런방식으로 중요정보 안나옴.
  @PostMapping("/page2")
  @ResponseBody()
  public String showPost(@RequestParam(defaultValue = "0") int age) {
    return """
          <h1>입력된 나이 : %d</h1>
          <h1>안녕하세요. POST 방식으로 오신걸 환영합니다.</h1>
        """.formatted(age);
  }

  //  주소에 http://localhost:8080/page3?age= 이런방식으로 다 나오게됨.
  @GetMapping("/page3")
  @ResponseBody()
  public String showGet(@RequestParam(defaultValue = "0") int age) {
    return """
          <h1>입력된 나이 : %d</h1>
          <h1>안녕하세요. GET 방식으로 오신걸 환영합니다.</h1>
        """.formatted(age);
  }


}
