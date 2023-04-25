# jwp-shopping-cart

## 기능 요구사항 목록
- [ ] 상품 목록 페이지 연동
  - [ ] index.html 파일이 / url을 통해 접근되도록 설정
  - [ ] 상품 목록을 담고 있는 Html을 응답한다
    - 상품 기본 정보
      - 상품 ID
      - 상품 이름
      - 상품 이미지
      - 상품 가격
- [ ] 상품 관리 CRUD API 작성
  - [ ] 상품 생성
    - [ ] POST /item 요청과 매핑
    - [ ] db에 저장한다
  - [ ] 상품 목록 조회
    - [ ] GET /item 요청과 매핑
    - [ ] db의 item 목록을 전부 조회한다
  - [ ] 상품 수정
    - [ ] PUT /item 요청과 매핑
    - [ ] 특정 item의 정보를 수정한다
  - [ ] 상품 삭제
    - [ ] DELETE /item 요청과 매핑
    - [ ] 특정 item을 삭제한다
- [ ] 관리자 도구 페이지 연동
  - [ ] /admin 요청
    - [ ] 모든 상품 목록을 담고 있는 html을 응답한다
  - [ ] 상품 추가 버튼 클릭
    - [ ] 추가할 상품 정보를 입력한다
    - [ ] submit 버튼을 클릭해 입력한 상품 정보를 저장한다
  - [ ] 수정 버튼 클릭
    - [ ] 수정할 상품 정보를 입력한다
    - [ ] submit 버튼을 클릭해 해당 행의 상품 정보를 수정한다
  - [ ] 삭제 버튼 클릭
    - [ ] 해당 행의 정보를 삭제한다
