# DailyTracker : 하루 일과 정리 REST API Server.

REST API를 공부하고 예제를 만들어 본 저장소입니다. (Java11, Spring boot 2.1.7, JPA, Gradle)

프로젝트에서 집중한 부분은 다음과 같습니다.

&nbsp;&nbsp;&nbsp;&nbsp; - 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

&nbsp;&nbsp;&nbsp;&nbsp; - 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

&nbsp;&nbsp;&nbsp;&nbsp; - API 가이드 방법 고민

&nbsp;&nbsp;&nbsp;&nbsp; - [소트웍스 앤솔러지](http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788992939249)의 객체지향
생활 체조 9규칙

</br>

### 기능에 맞는 HTTP 메소드 선택과 가독성있는 URL 네이밍을 위한 규칙

1. 소문자를 사용하고, _(under bar)가 아닌 -(dash)를 사용한다.

2. HTTP 메소드와 중복된 동작을 URL에 포함하지 않는다.

3. 경로의 끝에 /(slash) 또는 파일의 확장자를 포함하지 않는다.

</br>

### 적절한 HTTP 상태 코드와 헤더, 응답 방법에 대한 고민

1. 응답의 header(content-type), body(message, data), status를 상황에 맞도록 정의한다.

2. @ResponseBody, @RestController, ResponseEntity

</br>

### 참고 자료

참고한 API 가이드

1. [카카오 지도 web api 가이드](https://apis.map.kakao.com/web/guide/)

2. [NHN TOAST 사용자 가이드](https://docs.toast.com/ko/Dev%20Tool/Deploy/ko/api-guide/)

3. [공공데이터포털_오픈 API 상세 / 보건복지부 코로나19 감염 현황](https://docs.toast.com/ko/Dev%20Tool/Deploy/ko/api-guide/)

URL 컨벤션과 RESTful API

1. [TOAST Meetup - REST API 제대로 알고 사용하기](https://meetup.toast.com/posts/92)

2. [이상학의 개발 블로그 - RESTful API 설계 가이드](https://sanghaklee.tistory.com/57)


</br> </br>
# API 가이드

## Host와 Port

host ip :

port :

</br>

## 항목별 Request

|목적|HTTP-method|URL-Pattern|Paramter-Value|
|---|---|---|---|
|서버 확인|GET|/hello||
|사용자 등록|GET|/user/register/{name}||
|사용자 목록|GET|/user/list||
|일정 등록|POST|/schedule/{user}/{date}|content|
|일정 검색|GET|/schedule/{user}/{date}||
|사용자 전체 일정 검색|GET|/schedule/{user}
|단일 일정 삭제|DELETE|/schedule/{user}/{date}/{index}||
|하루 일정 삭제|DELETE|/schedule/{user}/{date}||

</br>
<details markdown="1">
<summary> <b> 보다 자세한 가이드 </b> </summary>

## 서버 확인

### Request

`GET : /hello`

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "hello",
        "data": null
     }
    }

</br>

## 사용자 등록

### Request

`POST : /user/register/{name}`

    /user/register/ecsimsw

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data": null
     }
    }

</br>

## 사용자 목록
### Request

`GET : /user/list`

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data": "[ecsimsw, kim, jin, hwan]"
     }
    }

</br>

## 일정 등록

### Request

`POST : /schedule/{user}/{date}?content=운동하기 `

    url : /schedule/ecsimsw/2021.01.28
    body : {content=운동하기}

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data" : null
     }
    }

</br>


## 일정 검색

### Request

`GET : /schedule/{user}/{date}`

    /schedule/ecsimsw/2021.01.28

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data" : "[
            "{user:ecsimsw, content:운동하기, localDate:2021-01-28}",
            "{user:ecsimsw, content:커밋하기, localDate:2021-01-28}",
            "{user:ecsimsw, content:요리하기, localDate:2021-01-28}"
         ]"   
     }
    }

</br>

## 사용자 전체 일정 검색
### Request

`GET : /schedule/{user}`

    /schedule/ecsimsw/2021.01.28

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data" : "[
            "{user:ecsimsw, content:운동하기, localDate:2021-01-23}",
            "{user:ecsimsw, content:커밋하기, localDate:2021-01-24}",
            "{user:ecsimsw, content:요리하기, localDate:2021-01-26}
         ]"   
     }
    }
</br>

## 단일 일정 삭제
### Request

`DELETE : /schedule/{user}/{date}/{index}`

    /schedule/ecsimsw/2021.01.28/1

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data" : null  
     }
    }

</br>

## 하루 일정 삭제

### Request

`DELETE : /schedule/{user}/{date}`

    /schedule/ecsimsw/2021.01.28

### Response

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 200 
     },
     "body" : {
        "message": "success",
        "data" : null  
     }
    }

</details>   

</br>

## 에러 코드

|HTTP-status|Message|
|---|---|
|406|ALREADY_REGISTERED_USER|
|404|INVALID_SCHEDULE_INDEX|
|400|INVALID_DATE_FORMAT|
|404|NOT_FOUND_USER|
|404|UNDEFINED_ERROR|


</br>
<details markdown="1">
<summary> <b> 보다 자세한 가이드 </b> </summary>

### 1. 유저 등록 : 이미 존재하는 이름으로 유저를 등록하는 경우

MESSAGE : ALREADY_REGISTERED_USER
</br>HTTP STATUS : 406

<b>Response</b>

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 406 
     },
     "body" : {
        "message": "ALREADY_REGISTERED_USER",
        "data": null
     }
    }

</br>

### 2. 사용자 일정 제거 : 잘못된 제거 요청 인덱스

MESSAGE : INVALID_SCHEDULE_INDEX
<br>HTTP STATUS : 404

<b>Response</b>

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 404 
     },
     "body" : {
        "message": "INVALID_SCHEDULE_INDEX",
        "data": null
     }
    }
    
</br>    

### 3. 사용자 일정 관리 (조회, 등록, 제거) : 잘못된 날짜 포맷 (올바른 표기는 yyyy.MM.dd)

MESSAGE : INVALID_DATE_FORMAT
</br>HTTP STATUS : 400

<b> Response </b>

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 400 
     },
     "body" : {
        "message": "INVALID_DATE_FORMAT",
        "data": null
     }
    }

</br>

### 4. 사용자 일정 관리 (조회, 등록, 제거) : 존재하지 않는 사용자의 일정 관리 요청

MESSAGE : NOT_FOUND_USER
</br>HTTP STATUS : 404

<b> Response </b>

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 404 
     },
     "body" : {
        "message": "NOT_FOUND_USER",
        "data": null
     }
    }

</br>

### 5. 정의되지 않은 오류

MESSAGE : UNDEFINED_ERROR
</br>HTTP STATUS : 404

<b> Response </b>

    {
     "header" : {
        HTTP/1.1
        Content-Type: application/json
        Status Code: 404 
     },
     "body" : {
        "message": "UNDEFINED_ERROR",
        "data": null
     }
    }

</details>   
