-- 사원(customers) 테이블 생성
CREATE TABLE customers(
	customer_id			 	 		NUMBER(5)			 								NOT NULL,
	customer_name    			VARCHAR2(10)	 								NOT NULL,
  customer_address   		VARCHAR2(20)	 								NOT NULL,
  customer_phone_number VARCHAR2(15),
  customer_post_number	VARCHAR2(15)   								NOT NULL,
  customer_location			VARCHAR2(15)   								NOT NULL,
  credit_rating	 				VARCHAR2(10)	DEFAULT 'POOR'	NOT NULL,
  customer_info					VARCHAR2(30),
  CONSTRAINT customer_id_pk PRIMARY KEY(customer_id)
);

-- 사원(customers) 테이블 비활성화/활성화
ALTER TABLE customers
	DISABLE CONSTRAINT customer_id_pk CASCADE;

ALTER TABLE customers
	ENABLE CONSTRAINT customer_id_pk CASCADE;

/* -------------------------------------------------------------- */

-- 주문 항목(order_items) 테이블 생성
CREATE TABLE order_items(
	item_id 			NUMBER(5)								NOT NULL,
  customer_id 	NUMBER(5) 							NOT NULL,
  order_id 			NUMBER(5) 							NOT NULL,
  product_name 	VARCHAR2(30) 						NOT NULL,
  product_price NUMBER(10) 		DEFAULT 0 NOT NULL,
  order_amount 	NUMBER(8) 		DEFAULT 0 NOT NULL,
  CONSTRAINT item_id_pk PRIMARY KEY(item_id)
);
-- 주문 항목(order_items) 테이블 FK 제약사항 추가
ALTER TABLE order_items ADD CONSTRAINT customer_id_fk FOREIGN KEY(customer_id) REFERENCES customers(customer_id);

-- 주문 항목(order_items) 활성화/비활성화
ALTER TABLE order_items
	DISABLE CONSTRAINT item_id_pk CASCADE
  DISABLE CONSTRAINT customer_id_fk CASCADE
  ;

/* -------------------------------------------------------------- */
-- 주문(orders) 테이블 생성
CREATE TABLE orders(
	order_id 							 NUMBER(5) 		 									NOT NULL,
  customer_name 				 VARCHAR2(10)  									NOT NULL,
  order_date 						 DATE  				 DEFAULT SYSDATE 	NOT NULL,
  business_employee_name VARCHAR2(10),
  order_price 					 NUMBER(10)  	 DEFAULT 0 				NOT NULL,
  payment 							 VARCHAR2(8) 	 DEFAULT 'CASH' 	NOT NULL,
  CONSTRAINT order_id_pk PRIMARY KEY(order_id)
);

ALTER TABLE orders
	DISABLE CONSTRAINT order_id_pk CASCADE;

/* -------------------------------------------------------------- */

-- 제품(products) 테이블 생성
CREATE TABLE products(
	product_id NUMBER(5) 		 						NOT NULL,
  order_id NUMBER(5) 		 							NOT NULL,
  product_name VARCHAR2(30)						NOT NULL,
  product_price NUMBER(10)	DEFAULT 0 NOT NULL,
  sale_unit VARCHAR2(10)							NOT NULL,
  product_description VARCHAR2(100),
  CONSTRAINT product_id_pk PRIMARY KEY(product_id)
	-- CONSTRAINT order_id_fk FOREIGN KEY(order_id) REFERENCES orders(order_id),
);
ALTER TABLE products ADD CONSTRAINT order_id_fk FOREIGN KEY(order_id) REFERENCES orders(order_id);

ALTER TABLE products
	DISABLE CONSTRAINT product_id_pk CASCADE;


/* -------------------------------------------------------------- */

-- 운송 (transportations) 테이블 생성
CREATE TABLE transportations(
  transportation_id        NUMBER(5)     					  					NOT NULL,
  employee_id							 NUMBER(5)													NOT NULL,
  shipment_date						 DATE 					DEFAULT SYSDATE     NOT NULL,
  shipment_yn							 VARCHAR2(2) 		DEFAULT 'N'					NOT NULL,
  shipment_amount					 NUMBER(8)		  DEFAULT 0						NOT NULL,
   CONSTRAINT   transportation_id_pk  PRIMARY KEY(transportation_id)
   --CONSTRAINT	  employee_id_fk				FOREIGN KEY(employee_id)    REFERENCES employee(employee_id)
);

-- 운송 (transportations) 테이블 fk 추가
ALTER TABLE transportations ADD CONSTRAINT employee_id_fk FOREIGN KEY(employee_id)    REFERENCES employees(employee_id);

/* -------------------------------------------------------------- */

-- 부서 (departments) 테이블 생성
CREATE TABLE departments(
  department_id						NUMBER(5)														NOT NULL,
  department_name					VARCHAR2(15)												NOT NULL,
  departments_location	  VARCHAR2(15)												NOT NULL,
  CONSTRAINT  department_id_pk	PRIMARY KEY(department_id)
);

-- 부서 (departments) 테이블 비활성화/활성화

ALTER TABLE departments
	DISABLE CONSTRAINT department_id_pk CASCADE;

ALTER TABLE departments
	ENABLE CONSTRAINT department_id_pk;

/* -------------------------------------------------------------- */

-- 사원 (employees) 테이블 생성
CREATE TABLE employees(
  employee_id						 NUMBER(5)														NOT NULL,
  storehouse_id					 NUMBER(5)														NOT NULL,
  department_id					 NUMBER(5),
  first_name						 VARCHAR2(10)													NOT NULL,
  last_name							 VARCHAR2(10)													NOT NULL,
  user_id								 VARCHAR2(15),
  hire_date							 DATE 				    DEFAULT SYSDATE     NOT NULL,
  position							 VARCHAR2(10)													NOT NULL,
  salary								 NUMBER(8)														NOT NULL,
  commision_pct					 NUMBER(8),
  CONSTRAINT	employee_id_pk	PRIMARY KEY(employee_id)
--CONSTRAINT	storehouse_id_fk		FOREIGN KEY(storehouse_id)		REFERENCES storehouse(storehouse_id)
--CONSTRAINT	department_id_fk		FOREIGN KEY(department_id)		REFERENCES departments(department_id)
);

-- 사원 (employees)테이블 fk 추가
ALTER TABLE employees ADD CONSTRAINT storehouse_id_fk 	FOREIGN KEY(storehouse_id)		REFERENCES storehouses(storehouse_id);
ALTER TABLE employees ADD CONSTRAINT	department_id_fk	FOREIGN KEY(department_id)		REFERENCES departments(department_id);

-- 사원 (employees) 테이블 비활성화/활성화
ALTER TABLE employees
	DISABLE CONSTRAINT employee_id_pk CASCADE
	DISABLE CONSTRAINT department_id_fk CASCADE;

ALTER TABLE employees
	ENABLE CONSTRAINT employee_id_pk
	ENABLE CONSTRAINT department_id_fk;
/* -------------------------------------------------------------- */

-- 재고(stocks) 테이블 생성
CREATE TABLE stocks(
  	product_stock_code  NUMBER(5)                NOT NULL,
    product_id          NUMBER(5)             	 NOT NULL,
    storehouse_id       NUMBER(5)           		 NOT NULL,
    stock_amount        NUMBER(8)  		DEFAULT 0  NOT NULL,
    stock_info          VARCHAR2(50)             NOT NULL,

    CONSTRAINT product_stock_code_pk PRIMARY KEY(product_stock_code)
   -- CONSTRAINT product_id_fk       FOREIGN KEY(product_id)     REFERENCES products(product_id),
   -- CONSTRAINT storehouse_id_fk    FOREIGN KEY(storehouse_id)   REFERENCES storehouses(storehouse_id)
  );

ALTER TABLE stocks ADD CONSTRAINT product_id_fk FOREIGN KEY(product_id)		REFERENCES products(product_id);

-- 재고(stocks) 테이블 비활성화/활성화
ALTER TABLE STOCKS
	DISABLE CONSTRAINT PRODUCT_STOCK_CODE_PK CASCADE
	DISABLE CONSTRAINT PRODUCT_ID_fk CASCADE
	DISABLE CONSTRAINT STOREHOUSE_ID_fk CASCADE;

/* -------------------------------------------------------------- */

-- 창고(storehouses) 테이블 생성
CREATE TABLE storehouses(
		storehouse_id								NUMBER(5)				NOT NULL,
    location_id									NUMBER(5)				NOT NULL,
    storehouse_name							VARCHAR2(15) 		NOT NULL,
    storehouse_tell_number			VARCHAR2(15),
    storehoust_post_number			VARCHAR2(15) 		NOT NULL,
    storehouse_address					VARCHAR2(20)		NOT NULL,
    CONSTRAINT storehouse_id_pk PRIMARY KEY(storehouse_id),
    CONSTRAINT location_id_fk   FOREIGN KEY(location_id)  REFERENCES  locations(location_id)
);

-- 창고(storehouses) 테이블 비활성화/활성화
ALTER TABLE storehouses
	DISABLE CONSTRAINT storehouse_id_pk CASCADE
	DISABLE CONSTRAINT location_id_fk CASCADE;

ALTER TABLE storehouses
	ENABLE CONSTRAINT storehouse_id_pk CASCADE
	ENABLE CONSTRAINT location_id_fk CASCADE

/* -------------------------------------------------------------- */

-- 지역(locations) 테이블 생성
CREATE TABLE locations(
		location_id				NUMBER(5)			NOT NULL,
    location_name			VARCHAR2(15)	NOT NULL,
    CONSTRAINT location_id_pk  PRIMARY KEY(location_id)
);

-- 지역(locations) 테이블 비활성화/활성화
ALTER TABLE locations
	DISABLE CONSTRAINT location_id_pk CASCADE;

ALTER TABLE locations
	ENABLE CONSTRAINT location_id_pk CASCADE;

SELECT *
FROM user_constraints;