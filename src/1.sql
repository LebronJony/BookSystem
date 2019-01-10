CREATE VIEW View_len AS
SELECT `lenbooks`.`leid`,`credate`,`retdate`,
	`member`.`mid`,`name`,`age`,`sex`,`phone`
FROM `lenbooks` JOIN `member` ON `lenbooks`.`mid`=`member`.`mid`

CREATE VIEW View_book AS
SELECT `books`.bid,`credate`,`status`,`books`.`note`,
	`item`.`iid`,`item`.`name`
FROM `books` JOIN `item` ON `books`.`iid`=`item`.`iid`

CREATE VIEW View_all AS
SELECT `books`.bid,`status`,`books`.`note`,
	`item`.`iid`,`item`.`name`,
	`lenbooks`.`leid`,`lenbooks`.`credate`,`retdate`,
	`member`.`mid`,`age`,`sex`,`phone`
FROM `books` JOIN `item` ON `books`.`iid`=`item`.`iid`
	JOIN `lenbooks` ON `books`.`bid`=`lenbooks`.`bid`
	JOIN `member` ON `member`.`mid`=`lenbooks`.`mid`
