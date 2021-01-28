# DailyTracker : 하루 일과 정리 REST API Server.

REST API를 공부하고 예제를 만들어 본 저장소입니다.

프로젝트에서 집중한 부분은 다음과 같습니다.

&nbsp;&nbsp;&nbsp;&nbsp; - 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

&nbsp;&nbsp;&nbsp;&nbsp; - 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

&nbsp;&nbsp;&nbsp;&nbsp; - API 가이드 방법 고민

&nbsp;&nbsp;&nbsp;&nbsp; - [소트웍스 앤솔러지](http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788992939249)의 객체지향
생활 체조 9규칙

(Java11, Spring boot 2.1.7, JPA, Gradle)

### 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

1. 소문자를 사용하고, _(under bar)가 아닌 -(dash)를 사용한다.

2. HTTP 메소드와 중복된 동작을 URL에 포함하지 않는다.

3. 경로의 끝에 /(slash) 또는 파일의 확장자를 포함하지 않는다.

### 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

1. 응답의 header(content-type), body(message, data), status를 상황에 맞도록 정의

2. ResponseEntity 사용과 ResponseEntityFactory 정의

### 참고 자료

참고한 API 가이드

1. [카카오 지도 web api 가이드](https://apis.map.kakao.com/web/guide/)

2. [NHN TOAST 사용자 가이드](https://docs.toast.com/ko/Dev%20Tool/Deploy/ko/api-guide/)

3. [공공데이터포털_오픈 API 상세 / 보건복지부 코로나19 감염 현황](https://docs.toast.com/ko/Dev%20Tool/Deploy/ko/api-guide/)

URL 컨벤션과 RESTful

1. [TOAST Meetup - REST API 제대로 알고 사용하기](https://meetup.toast.com/posts/92)

2. [이상학의 개발 블로그 - RESTful API 설계 가이드](https://sanghaklee.tistory.com/57)



