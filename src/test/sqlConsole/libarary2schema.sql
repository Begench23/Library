SELECT * from users;


SELECT * from users inner join book_borrow on users.id = book_borrow.user_id
where user_id = (select id from users where full_name = 'Test Student 23');

select id from users
where full_name = 'Test Student 2';

