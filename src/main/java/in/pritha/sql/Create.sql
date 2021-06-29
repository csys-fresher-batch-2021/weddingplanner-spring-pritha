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
  
  
  
  create table bookings(
booking_id serial primary key,
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



//procedure cancel booking //
BEGIN

UPDATE bookings SET status='CANCELLED' , 
	cancellation_reason = i_cancellation_reason,
	cancelled_date = CURRENT_TIMESTAMP
	WHERE username = i_username AND booking_id = i_booking_id;
	
	UPDATE discounts SET earned_coins =0  
	where username=i_username AND booking_id = i_booking_id;


END;

