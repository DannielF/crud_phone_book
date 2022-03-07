create schema if not exists phone_book default character set utf8 ;
use phone_book ;

create table if not exists phone_book.contact (
    cnt_id int not null auto_increment,
    cnt_full_name varchar(80) not null,
    cnt_phone varchar(13) not null,
    cnt_email varchar(80) null,
    cnt_dob datetime null,
    create_at datetime default now(),
    update_at datetime null,
    delete_at datetime null,
    primary key (cnt_id),
    unique index cnt_phone_name (cnt_phone asc, cnt_full_name asc) visible
) engine = InnoDB ;

insert into contact (cnt_full_name, cnt_phone, cnt_email, cnt_dob) values ('Delphinia Lochhead', '784-701-4286', 'dlochhead0@columbia.edu', '2014-05-19 22:03:28');
insert into contact (cnt_full_name, cnt_phone, cnt_email, cnt_dob) values ('Virgie Kestian', '299-656-1578', 'vkestian1@wufoo.com', '2020-07-31 15:24:42');
insert into contact (cnt_full_name, cnt_phone, cnt_email, cnt_dob) values ('Darelle Ingamells', '984-596-4225', 'dingamells2@si.edu', '2020-01-15 11:05:53');
insert into contact (cnt_full_name, cnt_phone, cnt_email, cnt_dob) values ('Renault Timeby', '173-301-1541', 'rtimeby3@jiathis.com', '2014-03-17 19:45:11');
insert into contact (cnt_full_name, cnt_phone, cnt_email, cnt_dob) values ('Arnold Proudman', '551-612-3446', 'aproudman4@cargocollective.com', '2013-08-08 01:31:09');