# DailyTracker : 하루 일과 정리 REST API Server.

1. REST API를 공부하고 적용해보고자 간단히 만들어본 예제입니다.

2. 프로젝트에서 집중한 부분은 다음과 같습니다.

&nbsp;&nbsp;&nbsp;&nbsp; - 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

&nbsp;&nbsp;&nbsp;&nbsp; - 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

&nbsp;&nbsp;&nbsp;&nbsp; - API 가이드 방법 고민

&nbsp;&nbsp;&nbsp;&nbsp; - [소트웍스 앤솔러지](http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788992939249)의 객체지향
생활 체조 9규칙

3. Java11, Spring boot 2.1.7, JPA, Gradle

### 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

1. 소문자를 사용하고, _(under bar)가 아닌 -(dash)를 사용한다.

2. HTTP 메소드와 중복된 동작을 URL에 포함하지 않는다.

3. 경로의 끝에 /(slash) 또는 파일의 확장자를 포함하지 않는다.

### 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

&nbsp;&nbsp;&nbsp;&nbsp; 1. 응답의 header(content-type), body(message, data), status를 상황에 맞도록 정의

&nbsp;&nbsp;&nbsp;&nbsp; 2. ResponseEntity 사용과 ResponseEntityFactory 정의


