
-- queriesUS 0,5
select book_categories.name, count(*)
from book_categories
         inner join books on book_categories.id = books.book_category_id
         inner join book_borrow on books.id = book_borrow.book_id
group by book_categories.name
order by 2 desc;

select bc.name, count(*)
from book_borrow bb
         inner join books b on bb.book_id = b.id
         inner join book_categories bc on b.book_category_id = bc.id
group by name
order by 2 desc;

select distinct id from users;

select count(distinct id) from users;

-- queries for US 1 Scenario: verify users table columns
select * from users;








