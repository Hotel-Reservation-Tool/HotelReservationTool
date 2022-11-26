CREATE TABLE `hotel`.`client` (
    `id` VARCHAR(100) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `mobile` VARCHAR(12) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

ALTER TABLE `hotel`.`client`
    ADD COLUMN `password` VARCHAR(45) NULL AFTER `email`;

CREATE TABLE `hotel`.`room` (
    `id` VARCHAR(100) NOT NULL,
    `size` INT NOT NULL,
    `max_ppl` INT NOT NULL,
    `price` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE `hotel`.`reservation` (
    `roomid` VARCHAR(100) NOT NULL,
    `clientid` VARCHAR(100) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL,
    `people` INT NOT NULL,
    INDEX `clientid_idx` (`clientid` ASC) VISIBLE,
    INDEX `roomid_idx` (`roomid` ASC) VISIBLE,
    CONSTRAINT `clientid`
        FOREIGN KEY (`clientid`)
            REFERENCES `hotel`.`client` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `roomid`
        FOREIGN KEY (`roomid`)
            REFERENCES `hotel`.`room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

ALTER TABLE `hotel`.`reservation`
    DROP FOREIGN KEY `roomid`;
ALTER TABLE `hotel`.`reservation`
    DROP COLUMN `people`,
    DROP COLUMN `roomid`,
    ADD COLUMN `reservationid` VARCHAR(100) NOT NULL FIRST,
    ADD PRIMARY KEY (`reservationid`),
    DROP INDEX `roomid_idx` ;
;

CREATE TABLE `hotel`.`reservation_helper` (
    `reservationid` VARCHAR(100) NOT NULL,
    `roomid` VARCHAR(100) NOT NULL,
    INDEX `reservationid_idx` (`reservationid` ASC) VISIBLE,
    CONSTRAINT `reservationid`
        FOREIGN KEY (`reservationid`)
            REFERENCES `hotel`.`reservation` (`reservationid`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
        CONSTRAINT `roomid`
        FOREIGN KEY (`roomid`)
            REFERENCES `hotel`.`room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION);

ALTER TABLE `hotel`.`client`
    ADD COLUMN `isLoggedIn` TINYINT NOT NULL DEFAULT 0 AFTER `password`,
    CHANGE COLUMN `password` `password` VARCHAR(45) NOT NULL ;
