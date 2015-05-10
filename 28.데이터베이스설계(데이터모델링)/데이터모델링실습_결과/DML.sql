-- 고객(customers) insert 문

INSERT INTO customers(customer_id, customer_name, customer_address, customer_phone_number, customer_post_number, customer_location, credit_rating, customer_info)
VALUES(1, '이재하', '양평', '01077889957', '133-754', 'Asia', 'B', '우수고객');

INSERT INTO customers(customer_id, customer_name, customer_address, customer_phone_number, customer_post_number, customer_location, credit_rating, customer_info)
VALUES(2, '홍태순', '화성시', '01051314863', '788-745', 'Asia', 'A', '우수고객');

-- 부서(departments) insert 문

INSERT INTO departments(department_id, department_name, departments_location)
VALUES(100, '영업부', 'Asia');

-- 사원 (employees) insert 문

INSERT INTO employees(employee_id, storehouse_id, department_id, first_name, last_name, user_id, hire_date, position, salary, commision_pct)
VALUES(105, 1000, 100, '이', '재하', '50', SYSDATE, '과장', 5000, 1.0 );

-- 운송(transportations) insert 문

INSERT INTO transportations(transportation_id, employee_id, shipment_date, shipment_yn, shipment_amount)
VALUES(9921, 105, SYSDATE, 'Y', 100);

-- 재고(stocks) insert 문

INSERT INTO STOCKS(PRODUCT_STOCK_CODE ,PRODUCT_ID, STOREHOUSE_ID, STOCK_AMOUNT, STOCK_INFO )
	VALUES(1, 100, 100 , 100, '우후' ); -- 묵시적 null 입력

-- 창고(storehouses) insert 문

INSERT INTO storehouses(STOREHOUSE_ID, LOCATION_ID, storehouse_name, storehouse_tell_number, STOREHOUST_POST_NUMBER, STOREHOUSE_ADDRESS)
VALUES(29251, 031, '재하창고','031-123-4567','411-360', '경기도');

-- 주문 항목(order_items) insert 문

INSERT INTO order_items(item_id, customer_id, order_id, product_name, product_price,order_amount)
VALUES(00001, 12345, 75865, '입던스타킹', 100000, 5);

-- 주문(orders) insert 문

INSERT INTO orders(order_id, customer_name, order_date, business_employee_name, order_price, payment)
VALUES(7586, '박광석2' , SYSDATE, '박퇴페', 10000, 'CASH');

-- 지역 (locations) insert 문

INSERT INTO locations(LOCATION_ID, LOCATION_NAME)
VALUES(31, '경기도');

-- 제품 (products) insert 문

INSERT INTO products(PRODUCT_ID, ORDER_ID, PRODUCT_NAME, PRODUCT_PRICE, SALE_UNIT, PRODUCT_DESCRIPTION)
VALUES(100, 100, '재고찡', 100, '퇴폐', '피씨방6개월 정액권');

