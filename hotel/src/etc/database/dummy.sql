INSERT INTO `hotel`.`client` (`id`, `name`, `mobile`, `email`, `password`, `isLoggedIn`) VALUES ('71e4ec12-3ef7-460c-938b-e4f878e404c7', 'test1', '65432185', 'test1@gmail.com', 'test1', '0');
INSERT INTO `hotel`.`client` (`id`, `name`, `mobile`, `email`, `password`, `isLoggedIn`) VALUES ('712fec12-3eh7-460c-938b-e4f878e40j28', 'test2', '24562514', 'test2@gmail.com', 'test2', '0');
INSERT INTO `hotel`.`client` (`id`, `name`, `mobile`, `email`, `password`, `isLoggedIn`) VALUES ('71e4ec12-3ef7-460c-938b-e4f878e742c7', 'test3', '23242176', 'test3@gmail.com', 'test3', '0');
INSERT INTO `hotel`.`client` (`id`, `name`, `mobile`, `email`, `password`, `isLoggedIn`) VALUES ('71e4ec12-3ef7-460c-938b-e4f8klo385mc7', 'test4', '97645685', 'test4@gmail.com', 'test4', '0');

INSERT INTO `hotel`.`reservation` (`reservationid`, `clientid`, `start_date`, `end_date`) VALUES ('dc44724b-4929-4f11-81c3-3246547dfgd4', '71e4ec12-3ef7-460c-938b-e4f878e404c7', '2000-11-11', '2000-12-01');
INSERT INTO `hotel`.`reservation` (`reservationid`, `clientid`, `start_date`, `end_date`) VALUES ('dc44724b-4929-4f11-81c3-2290e15284rh', '71e4ec12-3ef7-460c-938b-e4f878e404c7', '2004-08-26', '2004-09-05');
INSERT INTO `hotel`.`reservation` (`reservationid`, `clientid`, `start_date`, `end_date`) VALUES ('dc44724b-4929-4f11-81c3-2290e1653234', '71e4ec12-3ef7-460c-938b-e4f878e404c7', '2008-10-10', '2008-10-18');

INSERT INTO `hotel`.`room` (`id`, `size`, `max_ppl`, `price`) VALUES ('1', '35', '4', '9400');
INSERT INTO `hotel`.`room` (`id`, `size`, `max_ppl`, `price`) VALUES ('2', '35', '4', '9400');
INSERT INTO `hotel`.`room` (`id`, `size`, `max_ppl`, `price`) VALUES ('3', '35', '4', '9400');
INSERT INTO `hotel`.`room` (`id`, `size`, `max_ppl`, `price`) VALUES ('4', '40', '4', '10000');
INSERT INTO `hotel`.`room` (`id`, `size`, `max_ppl`, `price`) VALUES ('5', '40', '4', '10000');
