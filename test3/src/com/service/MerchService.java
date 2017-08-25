package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Merch;
import com.entity.PageBean;


public interface MerchService {
	
	Integer getProductsCount();
	
	 List<Merch> findAll();
	
	 PageBean<Merch> findByPage(int currentPage);

	  Merch	find(String id);
	  
	  void add(Merch merch);
	  
	  void del(String id);
	  

	void update(Merch merch);
	
	
	void excel(HttpServletResponse response,HttpServletRequest request);
	
	void json(HttpServletRequest request,HttpServletResponse response,int currentPage);
}
