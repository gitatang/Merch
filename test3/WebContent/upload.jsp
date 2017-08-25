<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- <form name="fileupload" enctype="multipart/form-data" action="" method="post">
<p style="font-size:16px;">请选择正确的excel文件上传</p>
<input id="txt" class="input" type="text"  value="文件域" name="txt">
<input id="file1" class="files" type="file" hidefocus="" size="1" style="height:26px;" name="file" onchange="txt.value= this.value">
<br/><input type="button" onclick="checkSuffix();" value="提交上传" style="height:26px;width:100px">
 <p style="color:red;">支持的excel格式为：xls、xlsx、xlsb、xlsm、xlst！</p>
</form>
 -->
<form action="http://localhost:8080/test3/merch/upload" method="post" enctype="multipart/form-data">
<input type="file" id="myfile" name="myfile"/>&nbsp;&nbsp;   
<input type="submit"  value="导入Excel" onclick="importEmp()"/>   
</form>

</body>

<script type="text/javascript">

//Excel文件导入到数据库中   
function importEmp(){   
    //检验导入的文件是否为Excel文件   
    var excelPath = document.getElementById("excelPath").value;   
    if(excelPath == null || excelPath == ''){   
        alert("请选择要上传的Excel文件");   
        return;   
    }else{   
        var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();    
        if(fileExtend == '.xls'){   
        }else{   
            alert("文件格式需为'.xls'格式");   
            return;   
        }   
    }   
   
    
}  

</script>

</html>