package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.SendRequestDto;
import com.example.demo.dto.WithdrawRequestDto;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountservice;

	@GetMapping("/account")
	public @ResponseBody List<Account> findAll(){
		return accountservice.계좌정보보기();
	}
	
	@PutMapping("/send")
	public @ResponseBody String send(SendRequestDto dto) {
		accountservice.송금(dto);
		return "<h1> 송금이 완료되었습니다.</h1>";
	}

	@PutMapping("/withdraw")
	public @ResponseBody String withdraw(WithdrawRequestDto dto) {
		accountservice.인출(dto);
		return "<h1>인출이 완료되었습니다.</h1>";
	}
}
