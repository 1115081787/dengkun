insert  into transactions(transactionId,tradeId,version,securityCode,quantity,status,type) values 
(1,'1','1','REL','50','INSERT','Buy'),
(2,'2','1','ITC','40','INSERT','Sell'),
(3,'3','1','INF','70','INSERT','Buy'),
(4,'1','2','REL','60','UPDATE','Buy'),
(5,'2','2','ITC','30','CANCEL','Buy'),
(6,'4','1','INF','20','INSERT','Sell');