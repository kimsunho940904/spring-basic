### @ServletComponentScan
 - 서블릿 자동 등록

### @WebServlet(name = "helloServlet", urlPatterns = "/hello")
  - urlPatterns로 오면 HelloServlet 클래스가 실행 된다.

### request, response
 - request = localhost:8080/username=kim
 - response = response.getWriter().write("hello" + username);

*** 
### 설정 값 셋팅 방법
 - reponse.setContentType("text/plain");
 - response.setCharacterEncoding("utf-8");
 - 로그를 보고 싶을 때 : logging.level.org.apache.coyote.http11=debug

### HttpServletRequest
 - 서블릿은 개발자가 HTTP 요청 메세지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메세지를 파싱한다.
 - 그리고 그 결과를 HttpServletRequest 객체에 담아서 제공한다.
 ![스크린샷 2021-12-04 오후 11 03 06](https://user-images.githubusercontent.com/63573287/144712382-ed3dd162-24f3-46e6-a30a-c61d33933243.png)
 
