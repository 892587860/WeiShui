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
	               	遥测站详细信息<small>欢迎管理员</small>
	            </h1>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">查询遥测站要素数据</a></li>
					<li class="active">数据列表</li>
				</ol> 
			</div>
            <div id="page-inner">
            	<div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>44,023</h3>
								<small>蓄水口瞬时流量</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-eye fa-5x red"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>32,850</h3>
								<small>电源电压</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-shopping-cart fa-5x blue"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>56,150</h3>
								<small>遥测站地址</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-comments fa-5x green"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div class="board">
	                        <div class="panel panel-primary">
							<div class="number">
								<h3>
									<h5>2017-11-03 10:01:02</h5>
									<small>观测时间</small>
								</h3> 
							</div>
							<div class="icon">
							   <i class="fa fa-user fa-5x yellow"></i>
							</div>
			 
	                        </div>
						</div>
                    </div>
				   
                </div>
                <!-- /. ROW  -->
                <div class="row" >
                    <div class="col-md-12">
	                    <!-- Advanced Tables -->
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                             	遥测站历史数据
	                        </div>
	                        <div class="panel-body">
	                            <div >
	                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
	                                    <thead>
	                                        <tr>
	                                            <th>遥测站地址</th>
	                                            <th>蓄水口瞬时流量</th>
	                                            <th>电源电压</th>
	                                            <th>时间</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                       
	                                    </tbody>
	                                </table>
	                            </div>
	                            
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
				'serverSide': true,  
		        'ajax': {  
		            'url': 'hyHistory/getDataByPage',  
		            'dataType': 'json',  
		            'type': 'get' ,
		            dataSrc : function(data){
		            	return data.data;
		            }
		        },  
		        'columns': [  
		            {'data': 'telemetryStation'},  
		            {'data': 'd27'},  
		            {'data': 'd38'},  
		            {'data': 'sendTime'},  
		        ],  
		        // 默认排序字段  
		        'aaSorting': [['3', 'desc']],  
		        /* // 禁用列排序  
		        "aoColumnDefs": [  
		            {"bSortable": false, "aTargets": [ 6 , 7]}  
		        ],   */
		        // 查询表单定义  
		      //  'searchForm': '#search-form',  
		        // 批量表单开关  
		        'batchEnalble': false 
			});
		});
    </script>
    <%@include file="../public/scripts.jsp" %>
</body>

</html>