--users

--insert
insert into users
values( user_seq.nextval, '김용준', 'guwj@naver.com', '1234', 'male');

delete from users;

commit;

select * from users;

--select (login)

select no, name 
from users
where email = 'guwj'
and password = '1234';

