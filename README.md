# 연습문제 MyBatis

### 1. View 생성

-   로그인 페이지
-   관리자 회원가입 페이지
-   구매자 회원가입 페이지
-   상품목록 페이지
-   상품등록 페이지
-   판매자 입장 상품 상세보기 페이지
-   구매자 입장 상품 상세보기 페이지
-   구매목록 페이지

### 2. 기능 (ajax 필요 없음) (서비스 만들 필요 없음)

-   구매자, 판매자별 회원가입
-   구매자, 판매자별 로그인
-   상품목록 보기
-   상품상세 보기
-   구매목록 보기
-   주문취소하기

## 3. 고급 기능

-   상품 등록시 동일한 상품명 못들어가게 하기
-   구매 후 상품 재고 수정

### 4. 테이블 생성

```sql
create table users(
    users_id int primary KEY auto_increment,
    username VARCHAR(20) NOT NULL UNIQUE,
    password varchar(20) NOT NULL,
    role VARCHAR(20) NOT NULL,
    createdAt TIMESTAMP
);

create table members(
    members_id int primary KEY auto_increment,
    mebers_name varchar(20) NOT NULL,
    mebers_email varchar(50) NOT NULL,
    users_id int NOT NULL,
    createdAt TIMESTAMP
);

create table admin(
    admin_id int primary KEY auto_increment,
    admin_name varchar(20) NOT NULL,
    admin_email varchar(50) NOT NULL,
    users_id int NOT NULL,
    createdAt TIMESTAMP
);


create table product(
    product_id int primary KEY auto_increment,
    product_name varchar(20) NOT null UNIQUE,
    product_price INT NOT null,
    product_qty INT NOT null,
    created_at TIMESTAMP NOT null
);

create table orders(
    orders_id int primary KEY auto_increment,
    orders_name varchar(20) NOT null,
    orders_price int NOT null,
    orders_count int NOT null,
    product_id int NOT null,
    users_id int NOT null,
    created_at TIMESTAMP
);
```

### 5. 더미데이터

```sql
insert into users(username, password, role, createdAt) values('ssar', '1234' ,'admin',  NOW());
insert into users(username, password, role, createdAt) values('cos', '1234','members',  NOW());

insert into members(mmbers_name, mebers_email, users_id, createdAt) values('홍길동','ssar@nate.com', 1,  NOW());

insert into admin(admin_name, admin_email,  users_id, createdAt) values('장보고','cos@nate.com',2,  NOW());


INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98,1, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100,2, NOW());

INSERT INTO orders(orders_name, orders_price, orders_count,  product_id, users_id,  created_at) VALUES('바나나', 3000, 10, 1, 1,  NOW());
INSERT INTO orders(orders_name, orders_price, orders_count,  product_id, users_id,  created_at) VALUES('딸기', 2000, 20, 2, 2,  NOW());

```

### 6. 페이지

상품관리자 회원가입 페이지
<img src="https://user-images.githubusercontent.com/106166409/202645322-10059a4e-6630-41ba-b037-8edf32f8fad3.png"  width="1000"/>

구매자 회원가입 페이지
<img src="https://user-images.githubusercontent.com/106166409/202645451-eea13492-97ba-419c-bf94-2a70decc2b95.png"  width="1000"/>

로그인 페이지
<img src="https://user-images.githubusercontent.com/106166409/202645213-4d669a6f-92d8-4b58-96c7-33bebef9b7cc.png"  width="1000"/>

상품목록 페이지

<img src="https://user-images.githubusercontent.com/106166409/202645187-50ece4ac-38f6-45c5-9dc0-29fa6ebdd279.png"  width="1000"/>

판매자 입장 상품 상세보기 페이지

<img src="https://user-images.githubusercontent.com/106166409/202645548-61fa708f-31db-40af-ad78-6fff267be6e6.png"  width="1000"/>

구매자 입장 상품 상세보기 페이지

<img src="https://user-images.githubusercontent.com/106166409/202645772-0068acf8-bb1f-48c5-b00c-531bf2069b4c.png"  width="1000"/>

상품등록 페이지

<img src="https://user-images.githubusercontent.com/106166409/202645648-4e5f1317-5c0e-410a-aaa5-b1e557e412f6.png"  width="1000"/>

구매목록 페이지

<img src="https://user-images.githubusercontent.com/106166409/202645870-fa0c8c0b-c888-44a9-a536-3aedd78aade6.png"  width="1000"/>

### 7. 구현기능

-   구매자 ,판매자 입장별 다른 뷰 구현
