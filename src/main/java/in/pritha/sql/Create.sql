create table users(
user_id serial primary key,
username varchar(100) not null,
role varchar(25) default 'USER',
password varchar(100) not null,
mobile_number bigint not null,
user_status varchar(25) default 'ACTIVE',
registered_date timestamp default CURRENT_TIMESTAMP);

 create table discounts(
  username varchar not null,
  earned_coins int not null,
  status varchar not null);
  
  create 
  Trigger tr_give_welcome_coins AFTER INSERT 
  ON users
  FOR EACH ROW BEGIN
  IF old.user_status ='ACTIVE' THEN
  INSERT INTO discounts(username,earned_coins,status)
  VALUES (old.username,'1000','UNUSED');
  END