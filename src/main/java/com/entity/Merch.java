package com.entity;

import java.util.List;

public class Merch {
	
	
		
		private Integer id;
		
	public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	private String name;
		
		private String cade;
		
		private String factory;
		
		private String packages;
		
		private Double price;
		
		private List<Emp> list;
		

		public List<Emp> getList() {
			return list;
		}

		public void setList(List<Emp> list) {
			this.list = list;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getCade() {
			return cade;
		}

		public void setCade(String cade) {
			this.cade = cade;
		}

		public String getFactory() {
			return factory;
		}

		public void setFactory(String factory) {
			this.factory = factory;
		}

		public String getPackages() {
			return packages;
		}

		public void setPackages(String packages) {
			this.packages = packages;
		}

		

		@Override
		public String toString() {
			return "{\"name\":\"" + name + "\", \"cade\":\" " + cade + "\", \"factory\":\"" + factory + "\", \"packages\":\"" + packages + "\", \"price\":\""
				+ price +"\" , \"id\" :\""+id+ "\" }";
		}
		

	}


