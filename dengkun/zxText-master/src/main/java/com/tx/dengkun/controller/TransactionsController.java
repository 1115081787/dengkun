package com.tx.dengkun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.dengkun.mapper.TransactionsMapper;
import com.tx.dengkun.pojo.Transactions;

@Controller
public class TransactionsController {
    @Resource
    private TransactionsMapper transactionsMapper;

    //添加页面
    @RequestMapping("add")
    public String add() {
        return "add";
    }

    //查找(用于查询)
    @RequestMapping("getTransactions")
    public String getTransactions(String transactionId,Model model) throws Exception {
    	Transactions transactions = transactionsMapper.getTransactions(transactionId);
        model.addAttribute("transactions", transactions);
        return "transactionsShow";
    }

    //添加
    @RequestMapping("addTransactions")
    public String addTransactions(Transactions transactions, BindingResult bindingResult) throws Exception {
    	
    	String status = transactions.getStatus();
    	String findMaxId = transactionsMapper.findMaxByTransactionId();
    	transactions.setTransactionId(String.valueOf(Integer.parseInt(findMaxId)+1));
    	String findMaxByTradeId = transactionsMapper.findMaxByTradeId();
    	transactions.setTradeId(String.valueOf(Integer.parseInt(findMaxByTradeId)+1));
    	transactions.setVersion("1");
        boolean flag = transactionsMapper.add(transactions) > 0;
        return "redirect:listTransactions";
    }


    //查找(用于修改)
    @RequestMapping("findTransactions")
    public String findTransactions(String transactionId, Model model) throws Exception {
    	Transactions transactions = transactionsMapper.getTransactions(transactionId);
        model.addAttribute("transactions", transactions);
        return "modify";
    }

    //遍历
    @RequestMapping({"/","listTransactions"})
    public String listTransactions(@RequestParam(value = "name",defaultValue = "") String name,
    		               Model model, @RequestParam(value = "start", defaultValue = "1") int start,
                           @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        PageHelper.startPage(start, size, "transactionId asc");
        List<Transactions> transactionsList = transactionsMapper.getTransactionsAll();
        PageInfo<Transactions> page = new PageInfo<>(transactionsList);
        model.addAttribute("pages", page);
        model.addAttribute("name", name);
        return "index";
    }
}