
select *
from dept d, emp e
where d.deptno = e.deptno
 and d.deptno = 40;

select *
from dept d inner join emp e
on d.deptno = e.deptno
where d.deptno=10;


select *
from dept d left join emp e
on d.deptno = e.deptno
where d.deptno=40;


insert into dept (deptno, dname, loc) values (50, '출구', 'seoul');
insert into dept values (50, 'sd', 'seoul');
insert into dept values (60, 'ss', 'seoul');
insert into dept values (70, 'ds', 'seoul');


delete from dept where deptno > 40;


commit

select * from dept;