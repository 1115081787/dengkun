CREATE TABLE transactions (
   transactionId varchar(11) NOT NULL AUTO_INCREMENT COMMENT 'transactionId',
   tradeId varchar(5) ,
  version varchar(5) ,
  securityCode varchar(10) ,
  quantity varchar(10) ,
  status varchar(10),
  type varchar(10) ,
  PRIMARY KEY (transactionId)
) 