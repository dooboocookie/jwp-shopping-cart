# 장바구니

장바구니 미션 저장소

## 1단계 기능 구현 목록

- [x] 회원 가입
    - [x] 이메일, 패스워드, 프로필 이미지 주소, 이름, 성별, 생년월일, 연락처, 주소지, 약관 동의 여부를 전달받아 회원을 생성한다.
    - [x] (예외) 이메일, 패스워드, 이름, 연락처, 주소지 (주소, 우편번호), 약관동의 여부 중 하나라도 누락 시 예외가 발생한다.
    - [x] (예외) 각 필드의 검증 규칙을 지키지 않으면 예외가 발생한다.
        - [x] 이메일은 정규식으로 검사한다.
        - [x] 비밀번호는 8글자 이상, 영문, 특수문자, 숫자 최소 1개씩 포함
        - [x] 프로필 이미지는 URL 형태여야 한다.
        - [x] 이름은 2글자 이상, 5글자 이하, 한글만
        - [x] 성별은 “male” or “female” or “undefined” 중 하나여야 한다.
        - [x] 생년월일은 `YYYY-MM-DD` 형식이어야 한다.
        - [x] 연락처는 8자리 이상 11자리 이하, 하이픈(-)이 없는 숫자로만 구성된 문자열이어야 한다.
        - [x] 주소는 공백이어서는 안된다. (단, 상세주소는 공백 가능)
        - [x] 우편번호는 숫자 5자리여야 한다.
        - [x] 약관 동의 여부는 참/거짓으로 전달받는다.
- [x] 로그인
    - [x] 이메일과 패스워드를 전달받아 데이터베이스에서 유효한 회원인지 검증후 액세스 토큰을 반환한다.
    - [x] (예외) 각 필드의 검증 규칙을 지키지 않으면 예외가 발생한다.
        - [x] 이메일은 정규식으로 검사한다.
        - [x] 비밀번호는 8글자 이상, 영문, 특수문자, 숫자 최소 1개씩 포함
- [x] 로그아웃
    - [x] 토큰을 전달받아 유효성 검증 결과를 반환한다.
    - [x] (예외) 토큰의 유효성이 검증되지 않을 경우(토큰의 customer id 와 전달받은 customer id가 불일치할 경우) 예외가 발생한다.
- [x] 회원 정보 조회
    - [x] 토큰을 전달받아 유효성이 검증되면, 전달받은 customer id 에 해당되는 유저 정보를 반환한다.
    - [x] (예외) 토큰의 유효성이 검증되지 않을 경우(토큰의 customer id 와 전달받은 customer id가 불일치할 경우) 예외가 발생한다.
- [x] 회원 정보 수정
    - [x] 토큰을 전달받아 유효성이 검증되면, 전달받은 customer id 에 해당되는 유저 정보를 수정한다.
    - [x] (예외) 토큰의 유효성이 검증되지 않을 경우(토큰의 customer id 와 전달받은 customer id가 불일치할 경우) 예외가 발생한다.
- [x] 회원 정보 제거 (회원 탈퇴)
    - [x] 토큰을 전달받아 유효성이 검증되면, 전달받은 customer id 에 해당되는 유저 정보를 제거한다.
    - [x] (예외) 토큰의 유효성이 검증되지 않을 경우(토큰의 customer id 와 전달받은 customer id가 불일치할 경우) 예외가 발생한다.

## 2단계 기능 구현 목록

- [x] 등록된 제품 전체 조회 기능
    - [x] 전체 제품의 이름, 가격, 이미지 주소, 설명, 재고, ID를 반환한다.

- [x] 등록된 제품 단건 조회 기능
    - [x] 제품의 이름, 가격, 이미지 주소, 설명, 재고, ID를 반환한다.
    - [x] (예외) 존재하지 않는 제품이라면 404 에러가 발생한다.

- [x] 개인 장바구니에 제품 추가 기능 구현
    - [x] 제품 ID와 수량을 전달받아 개인의 장바구니에 제품을 추가한다.
    - [x] (예외) 존재하지 않는 제품이라면 404 에러가 발생한다.
    - [x] (예외) 잘못된 Body 를 전달하면 400 에러가 발생한다.
    - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
    - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
    - [x] (예외) 이미 장바구니에 담은 제품을 또 다시 담으려고 하면 400 에러가 발생한다.

- [x] 개인 장바구니에 특정 제품이 이미 담겨있는지 확인하는 기능 구현
    - [x] 제품 ID를 전달받아 개인의 장바구니에 해당 제품이 존재하는지 반환한다.
    - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
    - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.

- [x] 개인 장바구니의 제품 수정 기능 구현
    - [x] 제품 ID와 수량을 전달받아 개인의 장바구니의 특정 제품을 수정한다.
    - [x] (예외) 존재하지 않는 Cart Item 이라면 404 에러가 발생한다.
    - [x] (예외) 잘못된 Body 를 전달하면 400 에러가 발생한다.
    - [x] (예외) 요청한 Cart Item 의 productId 와, Body 의 productId 가 다를 경우 400 에러가 발생한다.
    - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
    - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
    - [x] (예외) 장바구니의 Customer Id와 액세스 토큰의 Customer Id가 불일치할 경우 403에러가 발생한다.

- [x] 개인 장바구니에 제품 삭제 기능 구현
    - [x] 장바구니 ID를 전달받아 개인 장바구니 물품을 제거한다.
    - [x] (예외) 존재하지 않는 Cart Item 이라면 404 에러가 발생한다.
    - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
    - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
    - [x] (예외) 장바구니의 Customer Id와 액세스 토큰의 Customer Id가 불일치할 경우 403에러가 발생한다.

- [x] 개인 장바구니에 담긴 전체 제품 조회 기능 구현
    - [x] 개인 장바구니에 담긴 모든 제품을 조회한다. 이때, 제품의 이름, 가격, 이미지 URL, 설명, 재고, ID도 함께 조회한다.
    - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
    - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.

- [x] 제품 주문 기능에 인가 기능 추가
    - [x] 주문 추가 API
        - [x] 변경된 구조 적용
        - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
        - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
    - [x] 전체 주문 조회 API
        - [x] 변경된 구조 적용
        - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
        - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
    - [x] 주문 단건 조회 API
        - [x] 변경된 구조 적용
        - [x] (예외) 유효하지 않은 토큰이 전달되면 401 에러가 발생한다.
        - [x] (예외) 만료된 토큰이 전달되면 403 에러가 발생한다.
