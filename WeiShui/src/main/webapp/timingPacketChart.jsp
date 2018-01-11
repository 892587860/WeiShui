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
    <%@include file="public/files.jsp" %>
</head>

<body>
    <div id="wrapper">
         <%@include file="public/navigation.jsp"%>
		<div id="page-wrapper">
			<div class="header"> 
	            <h1 class="page-header">
	               	定时报<small>欢迎管理员</small>
	            </h1>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">定时报</a></li>
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
	                             	瞬时流量
	                        </div>
	                        <div class="panel-body">
	                            <div >
	                                 <div id="traffic_bar" style="height:500px;"></div>
	                            </div>
	                            
	                        </div>
	                    </div>
	                    <!--End Advanced Tables -->
                	</div>
               </div>
              <div class="row" >
				    <div class="col-md-12">
	                    <!-- Advanced Tables -->
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                             	电源电压
	                        </div>
	                        <div class="panel-body">
	                            <div >
	                                 <div >
	                                 <div id="voltage_line" style="height:500px;"></div>
	                            </div>
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
    
    <%@include file="public/scripts.jsp"%>
    <script type="text/javascript">
    	$.ajax({
				url : 'hyHistory/getTrafficMonth',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					sendTime : '2017-11',
					station : '1361610090'
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				beforeSend : function(xhr) {
					console.log('---发送前---')
					console.log(xhr)
				},
				success : function(data, textStatus, jqXHR) {
					console.log(data)
					console.log(textStatus)
					console.log(jqXHR)
					var xData = data.xData;
					var yData = data.yData;
					 // 基于准备好的dom，初始化echarts实例
			        var myChart = echarts.init(document.getElementById('traffic_bar'));
			
			        // 指定图表的配置项和数据
			        var option = {
					    tooltip : {
					        trigger: 'axis'
					    },
					    legend: {
					        data:['瞬时流量']
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    xAxis : [
					        {
					            type : 'category',
					            boundaryGap : false,
					            data : xData
					        }
					    ],
					    yAxis : [
					        {
					        	name :'瞬时流量',
					            type : 'value'
					        }
					    ],
					    series : [
					        {
					            name:'瞬时流量',
					            type:'line',
					            stack: '总量',
					            data:yData
					        }
					    ]
					};
			
			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
				},
				error : function(xhr, textStatus) {
					console.log('----错误------')
					console.log(xhr)
					console.log(textStatus)
				},
				complete : function() {
					console.log('-----结束------');
				}
			});
       
    </script>
    <script>
    $.ajax({
		url : 'hyHistory/getVoltageMonth',
		type : 'POST', //GET
		async : true, //或false,是否异步
		data : {
			sendTime : '2017-11',
			station : '1361610090'
		},
		timeout : 5000, //超时时间
		dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		beforeSend : function(xhr) {
			console.log('---发送前---')
			console.log(xhr)
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			console.log(textStatus)
			console.log(jqXHR)
			var xData = data.xData;
			var yData = data.yData;
			// 基于准备好的dom，初始化echarts实例
	        var myChart1 = echarts.init(document.getElementById('voltage_line'));
	    	var option1 = {
			    title: {
			        text: '电源电压'
			    },
			    tooltip : {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'cross',
			            label: {
			                backgroundColor: '#6a7985'
			            }
			        }
			    },
			    legend: {
			        data:['电源电压']
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : xData
			        }
			    ],
			    yAxis : [
			        {
			        	name :'电源电压(v)',
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'电源电压',
			            type:'line',
			            stack: '总量',
			            areaStyle: {normal: {}},
			            data:yData
			        }
			    ]
			};
	    	// 使用刚指定的配置项和数据显示图表。
	        myChart1.setOption(option1);
		},
		error : function(xhr, textStatus) {
			console.log('----错误------')
			console.log(xhr)
			console.log(textStatus)
		},
		complete : function() {
			console.log('-----结束------');
		}
	});
    	 
    </script>
</body>

</html>