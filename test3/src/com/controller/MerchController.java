package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Merch;
import com.service.MerchService;
import com.util.ExcelDemo;
@Controller
@RequestMapping(value="/merch")
public class MerchController {
	
	
	
	@Autowired
	private MerchService service;
	
	

	@RequestMapping("/main")
	 public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			 Model model,HttpServletRequest resquest,HttpServletResponse response){
        model.addAttribute("pagemsg", service.findByPage(currentPage));//回显分页数据
        service.json(resquest, response,currentPage);
		return "main";
		
	}
	
	@RequestMapping("/merchAdd")
	public String add(HttpServletRequest request,Merch merch,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		 String name = request.getParameter("name");
		 String cade = request.getParameter("cade");
		
		String factory = request.getParameter("factory");
		String packages = request.getParameter("packages");
		Double price =Double.valueOf(request.getParameter("price")) ;
		
		
		merch.setName(name);
		merch.setCade(cade);
		merch.setFactory(factory);
		
		merch.setPackages(packages);
		merch.setPrice(price);
	   
		System.out.println(merch.toString());
		service.add(merch);
		
		return "index";
		
	}
	
	@RequestMapping("/del")
	public String del(HttpServletRequest request, Model model){
		 
		 String id = request.getParameter("id");
		 
		 service.del(id);
		 
		 return "redirect:main";
		 
		 
		 
	 }
	
	@RequestMapping("/merchShow")
	public String show(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		 Merch merch = service.find(id);
		 model.addAttribute("merch", merch);
		
		return "show";
	}
	
@RequestMapping("/findAll")
public String up(Model model){
		
		List<Merch>  list = service.findAll();
		
		model.addAttribute("list", list);
		
		
		return "update";
		
	}

@RequestMapping("/manyDel")
public String manyDel(Model model){
		
		List<Merch>  list = service.findAll();
		
		model.addAttribute("list", list);
		
		
		return "manyDel";
		
	}

@RequestMapping("delmany")
public String delmany(HttpServletRequest request){
	
	String[] ids=  request.getParameterValues("id");
	for (String string : ids) {
		service.del(string);
	}
	
	
	
	return "redirect:main";
	
	
	
}

 @RequestMapping("find")
  public String up1(HttpServletRequest request, Model model){
	String id = request.getParameter("id");
	System.out.println(id);
	 Merch merch = service.find(id);
	 model.addAttribute("merch", merch);
	
	return "upMerch";
}
	
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,Merch merch){
		
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		 String name = request.getParameter("name");
		 String cade = request.getParameter("cade");
		 
		String factory = request.getParameter("factory");
		String packages = request.getParameter("packages");
		Double price =Double.valueOf(request.getParameter("price")) ;
		
		merch.setId(id);
		merch.setName(name);
		merch.setCade(cade);
		merch.setFactory(factory);
		
		merch.setPackages(packages);
		merch.setPrice(price);
		
		service.update(merch);
		
		return "redirect:main";
		
	}	
		
	
	@RequestMapping("excel")
	public String excel(HttpServletRequest request,HttpServletResponse response){
		
		service.excel(response, request);
		
		
		return "redirect:main";
		
		
		
	}
	
	@RequestMapping("upload")
	public String addList( @RequestParam("myfile") MultipartFile myfile, HttpServletRequest request) throws IOException{
		
			
		
		
		InputStream fis = myfile.getInputStream();
		
		
		
		List<Merch> merchList = ExcelDemo.importEmployeeByPoi(fis);
		
		for (Merch merch : merchList) {
			
			service.add(merch);
			
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		 	
		return "redirect:main";
		
		
		
		
	}
	

	
}

