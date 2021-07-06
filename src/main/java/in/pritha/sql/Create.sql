create table users(
user_id serial primary key,
username varchar(100) not null,
role varchar(25) default 'USER',
password varchar(100) not null,
mobile_number bigint not null,
user_status varchar(25) default 'ACTIVE',
registered_date timestamp default CURRENT_TIMESTAMP);

alter table users
	add column logout_time timestamp default null;

 create table discounts(
  username varchar not null,
  booking_id int unique ,
  earned_coins int not null,
  status varchar not null);
  
  
  //trigger after insert on users
  create 
  Trigger tr_give_welcome_coins AFTER INSERT 
  ON users
  FOR EACH ROW BEGIN
  IF old.user_status ='ACTIVE' THEN
  INSERT INTO discounts(username,earned_coins,status)
  VALUES (old.username,'1000','UNUSED');
  END
  
  //after insert on bookings
  BEGIN
    IF new.status ='BOOKED' THEN
 		UPDATE discounts
		SET booking_id = new.booking_id,
		earned_coins = earned_coins + 100,
		status = 'UNUSED'
		WHERE username = new.username;
		
	END IF;
END
  //to update foreign key of bookings that is the primary key of payments(ONE_TO_ONE)
  BEGIN
	If new.status='PAID' THEN
	INSERT INTO bookings (payment_id) VALUES
    ( (SELECT payment_id from payments WHERE transactioncode=new.transactioncode) );
	END IF;
	RETURN NULL;
END;

  
//create table bookings  
create table bookings(
booking_id INT GENERATED ALWAYS AS IDENTITY,
username varchar(100) not null,
status varchar(25) default 'BOOKED',
wedding_date date not null,
wedding_time time not null,
wedding_location varchar(100) not null,
wedding_style varchar(100) not null,
wedding_style_location varchar(100) not null,
wedding_food_type varchar(100) not null,
wedding_guest_count varchar(100) not null,
wedding_decor_type varchar(100) not null,
booked_date timestamp not null default CURRENT_TIMESTAMP,
cancelled_date timestamp default null,
cancellation_reason varchar(100) default null
	
);

//add foreign key to bookings
ALTER TABLE bookings 
ADD COLUMN payment_id INT,
ADD FOREIGN KEY (payment_id) REFERENCES payments(payment_id)
ON DELETE CASCADE;


//procedure cancel booking //
BEGIN

UPDATE bookings SET status='CANCELLED' , 
	cancellation_reason = i_cancellation_reason,
	cancelled_date = CURRENT_TIMESTAMP
	WHERE username = i_username AND booking_id = i_booking_id;
	
	UPDATE discounts SET earned_coins =0  
	where username=i_username AND booking_id = i_booking_id;


END;

//view for leaderboard

CREATE VIEW user_earned_coins_vw As 
SELECT user_id,username,mobile_number,coalesce(
	(SELECT SUM(earned_coins) FROM discounts
	WHERE username = u.username),0)
	As earned_coins FROM users u
	ORDER BY  earned_coins DESC;
	
	
//function to get earned_coins for particular user
DECLARE v_no_of_earned_coins INT;

BEGIN
		                  
		SELECT SUM(earned_coins) INTO v_no_of_earned_coins FROM discounts 
		WHERE username IN (
			SELECT username FROM users where username = i_username);
			RETURN v_no_of_earned_coins;
END;

//payments table
create table payments(
payment_id INT GENERATED ALWAYS AS IDENTITY,
bank varchar(100) not null,
card varchar(100) not null,
card_user_name varchar(100) not null,
amount int not null,
status varchar(100) default 'PAID',
payment_date timestamp not null default CURRENT_TIMESTAMP,
transactioncode varchar(100) unique,
purpose varchar(100),
PRIMARY KEY(payment_id)
);


//ONE_TO_MANY[ONe ROLE To Many Users]
create table roles(
id int primary key,
name varchar(25) not null ,
description varchar(100) not null);

ALTER TABLE users
ADD COLUMN role_id INT,
ADD FOREIGN KEY (role_id) REFERENCES roles(id)
ON DELETE CASCADE;