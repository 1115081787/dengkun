package com.tx.dengkun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tx.dengkun.pojo.Transactions;

@Mapper
public interface TransactionsMapper {

    @Select("select * from transactions")
    public List<Transactions> getTransactionsAll();

    @Insert("insert into transactions (transactionId,tradeId,version,securityCode,quantity,status,type) " +
            "values (#{transactionId},#{tradeId},#{version},#{securityCode},#{quantity},#{status},#{type})")
    public int add(Transactions transactions);


    @Select("select * from transactions where transactionId= #{transactionId} ")
    public Transactions getTransactions(String transactionId);

    @Update("update transactions set " +
            "securityCode = #{securityCode}," +
            "quantity = #{quantity}," +
            "type = #{type}," +
            "where transactionId=#{transactionId} ")
    public int update(Transactions transactions);
    
    @Select("select transactionId from TRANSACTIONS where transactionId=(select MAX(transactionId) from TRANSACTIONS ")
    public String findMaxByTransactionId();

    @Select("select tradeId from TRANSACTIONS where tradeId=(select MAX(tradeId) from TRANSACTIONS ")
    public String findMaxByTradeId();
}
