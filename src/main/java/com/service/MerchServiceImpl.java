package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.MerchDao;
import com.entity.Merch;

@Service
public class MerchServiceImpl implements MerchService{
	
	@Resource
	private MerchDao dao;

	public Merch get(Integer eid) {
		Merch m =  dao.get(eid);
		return m;
		
	}

}
