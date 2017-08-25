package com.dao;

import java.util.HashMap;
import java.util.List;

import com.entity.Merch;

public interface MerchDao {
	
  Integer getProductsCount();	
	
  List<Merch> findAll ();	
  List<Merch> list (HashMap<String,Object> map);

  Merch	find(String id);
  
  void add(Merch merch);
  
  void del(String id);
  
  void update (Merch merch);
  
  
}
