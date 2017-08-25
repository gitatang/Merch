package com.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MerchDao;
import com.entity.Merch;
import com.entity.PageBean;

@Service
@Transactional
public class MerchServiceImpl implements MerchService {
	@Resource
	private MerchDao dao;
	
	

	@Override
	public Merch find(String id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public List<Merch> findAll(){
		
		return dao.findAll();
		
	}
	
	

	@Override
	public void add(Merch merch) {
		dao.add(merch);
	}

	@Override
	public void del(String id) {
		dao.del(id);
		
	}

	@Override
	public void update(Merch merch) {
		dao.update(merch);
		
	}



	


	@Override
	public Integer getProductsCount() {
		// TODO Auto-generated method stub
		return dao.getProductsCount();
	}

    @Override
    public PageBean<Merch> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Merch> pageBean = new PageBean<Merch>();

        //灏佽褰撳墠椤垫暟
        pageBean.setCurrPage(currentPage);

        //姣忛〉鏄剧ず鐨勬暟鎹�
        int pageSize=4;
        pageBean.setPageSize(pageSize);

        //灏佽鎬昏褰曟暟
        int totalCount = dao.getProductsCount();
        pageBean.setTotalCount(totalCount);

        //灏佽鎬婚〉鏁�
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//鍚戜笂鍙栨暣
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //灏佽姣忛〉鏄剧ず鐨勬暟鎹�
       List<Merch> lists= dao.list(map);
        pageBean.setLists(lists);
        return pageBean;
    }
	
    
    @SuppressWarnings("deprecation")
	public void excel(HttpServletResponse response,HttpServletRequest request){
    	List<Merch> list =new ArrayList();
    	list =dao.findAll();
    	
    	 //  第一步，创建一个webbook，对应一个Excel文件 
        HSSFWorkbook wb = new HSSFWorkbook();  
        
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("商品表一");  
        //  第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        HSSFCell cell = row.createCell((short) 0); 
        cell.setCellValue("名字");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("代码");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("厂商");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("材料");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("价格");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 5);  
        cell.setCellValue("序号");  
        cell.setCellStyle(style); 
        
      for (int i = 0; i < list.size(); i++) {
    	  
    	  row = sheet.createRow((int) i + 1);  
          Merch merch = (Merch) list.get(i);  
          //第四步，创建单元格，并设置值
          row.createCell((short) 0).setCellValue( merch.getName());  
          row.createCell((short) 1).setCellValue(merch.getCade());  
          row.createCell((short) 2).setCellValue(merch.getFactory());  
         row.createCell((short) 3).setCellValue(merch.getPackages()); 
         row.createCell((short) 4).setCellValue(merch.getPrice()); 
         row.createCell((short) 5).setCellValue(merch.getId()); 
      }    
      //第六步，将文件存到指定位置  
         try  
         {  
        	 FileOutputStream fout = new FileOutputStream("E:/merc2.xls");  
             wb.write(fout);  
             fout.close();  
         }  
         catch (Exception e)  
         {  
             e.printStackTrace();  
         }  
	}

    
	public void json(HttpServletRequest request,HttpServletResponse response,int currentPage){
		  response.setContentType("text/html;charset=utf-8");
		 
	        //response.setCharacterEncoding("UTF-8");
	        //PrintWriter out = response.getWriter();
	        //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
	       StringBuilder  jsonString = new StringBuilder("   {     \"chart\":{\n" +
	                "            \"caption\":\"Business Results 2005 v 2006\",\n" +
	                "            \"xaxisname\":\"Month\",\n" +
	                "            \"yaxisname\":\"Revenue\",\n" +
	                "            \"showvalues\":\"0\",\n" +
	                "            \"numberprefix\":\"$\"  },\n" +
	                "        \"categories\":[{\n" +
	                "            \"category\":[");
	       
	        PageBean pageBean = findByPage(currentPage);

	        List list = pageBean.getLists();
	        for (int i = 0; i < list.size(); i++) {
	            Merch p = (Merch) list.get(i);
	            System.out.println(p);
	            jsonString.append(" {          \"label\":\"" + p.getName() + "\"        },");
	        }
	        jsonString.append("]\n" +
	                "        }\n" +
	                "        ],\n" +
	                "        \"dataset\":[\n" +
	                "            {\n" +
	                "                \"data\":[\n" +
	                "                              ");
	        for (int i = 0; i < list.size(); i++) {
	            Merch p = (Merch) list.get(i);
	            jsonString.append("{ \"value\": \""+p.getPrice()+"\"        },");
	        }
	        jsonString.append("  ]    }\n" +
	                " ],\n" +
	                "        \"trendlines\":{\n" +
	                "            \"line\":[{        \"startvalue\":\"26000\",\n" +
	                "                \"color\":\"91C728\",\n" +
	                "                \"displayvalue\":\"Target\",\n" +
	                "                \"showontop\":\"1\"\n" +
	                "            }]\n" +
	                "        },\n" +
	                "        \"styles\":[{\n" +
	                "            \"definition\":[{\n" +
	                "                \"style\":[{          \"name\":\"CanvasAnim\",\n" +
	                "                    \"type\":\"animation\",\n" +
	                "                    \"param\":\"_xScale\",\n" +
	                "                    \"start\":\"0\",\n" +
	                "                    \"duration\":\"1\"\n" +
	                "                }]\n" +
	                "            }],\n" +
	                "            \"application\":[{\n" +
	                "                \"apply\":[{         \"toobject\":\"Canvas\",\n" +
	                "                    \"styles\":\"CanvasAnim\"\n" +
	                "                }]\n" +
	                "            }]\n" +
	                "        }]\n" +
	                "    }");
	        
	        request.setAttribute("json",jsonString.toString());
	        System.out.println(jsonString.toString());

		
		
		
		
	}
    
    
    
    	
    }

