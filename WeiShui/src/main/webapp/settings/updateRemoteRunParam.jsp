<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>水文检测系统</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <%@include file="../public/files.jsp" %>
</head>

<body>
    <div id="wrapper">
         <%@include file="../public/navigation.jsp"%>
		<div id="page-wrapper">
			<div class="header"> 
	            <h1 class="page-header">
	               	遥测站运行参数配置表<small>欢迎管理员</small>
	            </h1>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">修改遥测站运行参数配置表</a></li>
					<li class="active">数据列表</li>
				</ol> 
			</div>
            <div id="page-inner">
                <!-- /. ROW  -->
                <div class="row" >
                    <div class="col-md-12">
	                    <!-- Advanced Tables -->
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                             	遥测站运行参数配置表
	                        </div>
	                        <div class="panel-body">
	                          <div class="sub-title">配置1</div>
	                           <div>
	                               <input type="text" class="form-control" placeholder="Text input">
	                           </div>
	                           <div class="sub-title">配置2</div>
	                           <div>
	                               <textarea class="form-control" rows="3"></textarea>
	                           </div>
	                           <div class="sub-title">配置3</div>
	                           <div>
	                               <div class="checkbox3 checkbox-round">
	                                 <input type="checkbox" id="checkbox-2">
	                                 <label for="checkbox-2">
	                                   Option one is this and that&mdash;be sure to include why it's great
	                                 </label>
	                               </div>
	                               <div class="checkbox3 checkbox-round">
	                                 <input type="checkbox" id="checkbox-3" disabled="">
	                                 <label for="checkbox-3">
	                                   Option two is disabled
	                                 </label>
	                               </div>
	                               <div class="radio3">
	                                 <input type="radio" id="radio1" name="radio1" value="option1">
	                                 <label for="radio1">
	                                   Option one is this and that&mdash;be sure to include why it's great
	                                 </label>
	                               </div>
	                               <div class="radio3">
	                                 <input type="radio" id="radio2" name="radio1" value="option2">
	                                 <label for="radio2">
	                                   Option two can be something else and selecting it will deselect option one
	                                 </label>
	                               </div>
	                               <div class="sub-title">配置4</div>
	                               <div>
	                                 <div class="checkbox3 checkbox-inline checkbox-check checkbox-light">
	                                   <input type="checkbox" id="checkbox-fa-light-1" checked="">
	                                   <label for="checkbox-fa-light-1">
	                                     Option1
	                                   </label>
	                                 </div>
	                                 <div class="checkbox3 checkbox-success checkbox-inline checkbox-check checkbox-round  checkbox-light">
	                                   <input type="checkbox" id="checkbox-fa-light-2" checked="">
	                                   <label for="checkbox-fa-light-2">
	                                     Option Round
	                                   </label>
	                                 </div>
	                                 <div class="checkbox3 checkbox-danger checkbox-inline checkbox-check  checkbox-circle checkbox-light">
	                                   <input type="checkbox" id="checkbox-fa-light-3" checked="">
	                                   <label for="checkbox-fa-light-3">
	                                     Option Circle
	                                   </label>
	                                 </div>
	                               </div>
	                               <div>
	                                 <div class="radio3 radio-check radio-inline">
	                                   <input type="radio" id="radio4" name="radio2" value="option1" checked="">
	                                   <label for="radio4">
	                                     Option 1
	                                   </label>
	                                 </div>
	                                 <div class="radio3 radio-check radio-success radio-inline">
	                                   <input type="radio" id="radio5" name="radio2" value="option2">
	                                   <label for="radio5">
	                                     Option 2
	                                   </label>
	                                 </div>
	                                 <div class="radio3 radio-check radio-warning radio-inline">
	                                   <input type="radio" id="radio6" name="radio2" value="option3">
	                                   <label for="radio6">
	                                     Option 3
	                                   </label>
	                                 </div>
	                               </div>
	                           </div> 
	                           <div>
	                               <input type="checkbox" class="toggle-checkbox" name="my-checkbox" checked>
	                           </div>
	                           <button type="submit" class="btn btn-default">提交</button>
	                        </div>
	                    </div>
	                    <!--End Advanced Tables -->
                	</div>
				   
             	</div>
		
				<footer>
					<p>Copyright &copy; 2017.Company name All rights reserved.</p>
				</footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <script type="text/javascript">
     	$(document).ready(function () {
			$('#dataTables-example').dataTable({
				"scrollX": false
			});
		});
    </script>
    <%@include file="../public/scripts.jsp" %>
</body>

</html>