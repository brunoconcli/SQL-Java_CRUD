create schema Launch

create table Launch.Rocket (
	idRocket int primary key,
	rocketName varchar(30) not null
)

create table Launch.Member (
	idMember int primary key,
	idRocket int foreign key references Launch.Rocket(idRocket),
	memberName varchar(50) not null
)

drop table Launch.Rocket
drop table Launch.Member 

delete from Launch.Rocket
delete from Launch.Member

INSERT INTO Launch.Rocket (idRocket, rocketName) values(1, 'David Bart')
INSERT INTO Launch.Rocket (idRocket, rocketName) values(2, 'StarCast')

INSERT INTO Launch.Member (idMember, idRocket, memberName) values(1, 1, 'Josh Cassada')
INSERT INTO Launch.Member (idMember, idRocket, memberName) values(2, 1, 'Anna Kikina')
INSERT INTO Launch.Member (idMember, idRocket, memberName) values(3, 1, 'Koichi Wakata')

update Launch.Member set memberName = 'Nicole Mann'  where memberName = 'Koichi Wakata'
UPDATE LAUNCH.MEMBER 
                  SET IDROCKET=1, 
                  MEMBERNAME='Koichi Wakata' 
                  WHERE IDMEMBER = 3

UPDATE LAUNCH.ROCKET 
                  SET ROCKETNAME= 'Dragon'
                  WHERE IDROCKET = 1

select count(*) from Launch.Member
select * from Launch.Rocket
select * from Launch.Member

SELECT * FROM LAUNCH.MEMBER
SELECT * FROM LAUNCH.ROCKET WHERE IDROCKET = 3