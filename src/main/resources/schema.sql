CREATE TABLE epaper_info
(
 id varchar(11) NOT NULL,
 newspaper_name varchar(50) NOT NULL,
 width bigint DEFAULT NULL,
 height  bigint DEFAULT NULL,
 dpi bigint DEFAULT NULL,
 file_name varchar(20) NOT NULL,
 upload_time DATE NOT NULL,
 PRIMARY KEY (id)
);