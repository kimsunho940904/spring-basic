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