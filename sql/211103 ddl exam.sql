create table phoneInfo_basic (
    idx number(6) constraint phoneInfo_basic_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
);


create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default '1' not null,
    fr_ref number(7) not null,
    constraint phoneInfo_univ_fr_u_year_ck check(fr_u_year between 1 and 4),
    constraint phoneInfo_univ_idx_pk primary key (idx),
    constraint phoneInfo_univ_fr_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx)
);

create table phoneInfo_com (
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null,
    constraint phoneInfo_com_idx_pk primary key (idx),
    constraint phoneInfo_com_fr_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx)
);




