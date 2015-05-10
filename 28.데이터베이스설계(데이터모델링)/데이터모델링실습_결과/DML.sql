-- ��(customers) insert ��

INSERT INTO customers(customer_id, customer_name, customer_address, customer_phone_number, customer_post_number, customer_location, credit_rating, customer_info)
VALUES(1, '������', '����', '01077889957', '133-754', 'Asia', 'B', '�����');

INSERT INTO customers(customer_id, customer_name, customer_address, customer_phone_number, customer_post_number, customer_location, credit_rating, customer_info)
VALUES(2, 'ȫ�¼�', 'ȭ����', '01051314863', '788-745', 'Asia', 'A', '�����');

-- �μ�(departments) insert ��

INSERT INTO departments(department_id, department_name, departments_location)
VALUES(100, '������', 'Asia');

-- ��� (employees) insert ��

INSERT INTO employees(employee_id, storehouse_id, department_id, first_name, last_name, user_id, hire_date, position, salary, commision_pct)
VALUES(105, 1000, 100, '��', '����', '50', SYSDATE, '����', 5000, 1.0 );

-- ���(transportations) insert ��

INSERT INTO transportations(transportation_id, employee_id, shipment_date, shipment_yn, shipment_amount)
VALUES(9921, 105, SYSDATE, 'Y', 100);

-- ���(stocks) insert ��

INSERT INTO STOCKS(PRODUCT_STOCK_CODE ,PRODUCT_ID, STOREHOUSE_ID, STOCK_AMOUNT, STOCK_INFO )
	VALUES(1, 100, 100 , 100, '����' ); -- ������ null �Է�

-- â��(storehouses) insert ��

INSERT INTO storehouses(STOREHOUSE_ID, LOCATION_ID, storehouse_name, storehouse_tell_number, STOREHOUST_POST_NUMBER, STOREHOUSE_ADDRESS)
VALUES(29251, 031, '����â��','031-123-4567','411-360', '��⵵');

-- �ֹ� �׸�(order_items) insert ��

INSERT INTO order_items(item_id, customer_id, order_id, product_name, product_price,order_amount)
VALUES(00001, 12345, 75865, '�Դ���Ÿŷ', 100000, 5);

-- �ֹ�(orders) insert ��

INSERT INTO orders(order_id, customer_name, order_date, business_employee_name, order_price, payment)
VALUES(7586, '�ڱ���2' , SYSDATE, '������', 10000, 'CASH');

-- ���� (locations) insert ��

INSERT INTO locations(LOCATION_ID, LOCATION_NAME)
VALUES(31, '��⵵');

-- ��ǰ (products) insert ��

INSERT INTO products(PRODUCT_ID, ORDER_ID, PRODUCT_NAME, PRODUCT_PRICE, SALE_UNIT, PRODUCT_DESCRIPTION)
VALUES(100, 100, '�����', 100, '����', '�Ǿ���6���� ���ױ�');

