insert into user_tb(username, password, email, created_at)
values ('ssar', '$2a$10$is8Qa2h1BJgnLZh/bp5Qqe74FIoHU15OjgsBPaT5TEMV.1WMt8Ata', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('cos', '$2a$10$is8Qa2h1BJgnLZh/bp5Qqe74FIoHU15OjgsBPaT5TEMV.1WMt8Ata', 'cos@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('love', '$2a$10$is8Qa2h1BJgnLZh/bp5Qqe74FIoHU15OjgsBPaT5TEMV.1WMt8Ata', 'love@nate.com', now());

insert into board_tb(title, content, user_id, created_at)
values ('제목1', '내용1', 1, now());
insert into board_tb(title, content, user_id,  created_at)
values ('제목2', '내용2', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목3', '내용3', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목4', '내용4', 3, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목5', '내용5', 1, now());