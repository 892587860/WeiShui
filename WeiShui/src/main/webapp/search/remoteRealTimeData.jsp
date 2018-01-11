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
	               	链路维持报<small>欢迎管理员</small>
	            </h1>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">链路维持报</a></li>
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
	                             	定时报数据
	                        </div>
	                        <div class="panel-body">
	                            <div >
	                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
	                                    <thead>
	                                        <tr>
	                                            <th>遥测站地址</th>
	                                            <th>时间</th>
	                                            <th>地下水瞬时埋深</th>
	                                            <th>瞬时水温</th>
	                                            <th>电源电压</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <tr class="odd gradeX">
	                                            <td>Trident</td>
	                                            <td>Internet Explorer 4.0</td>
	                                            <td>Win 95+</td>
	                                            <td class="center">4</td>
	                                            <td class="center">X</td>
	                                        </tr>
	                                        <tr class="even gradeC">
	                                            <td>Trident</td>
	                                            <td>Internet Explorer 5.0</td>
	                                            <td>Win 95+</td>
	                                            <td class="center">5</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="odd gradeA">
	                                            <td>Trident</td>
	                                            <td>Internet Explorer 5.5</td>
	                                            <td>Win 95+</td>
	                                            <td class="center">5.5</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="even gradeA">
	                                            <td>Trident</td>
	                                            <td>Internet Explorer 6</td>
	                                            <td>Win 98+</td>
	                                            <td class="center">6</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="odd gradeA">
	                                            <td>Trident</td>
	                                            <td>Internet Explorer 7</td>
	                                            <td>Win XP SP2+</td>
	                                            <td class="center">7</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="even gradeA">
	                                            <td>Trident</td>
	                                            <td>AOL browser (AOL desktop)</td>
	                                            <td>Win XP</td>
	                                            <td class="center">6</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Firefox 1.0</td>
	                                            <td>Win 98+ / OSX.2+</td>
	                                            <td class="center">1.7</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Firefox 1.5</td>
	                                            <td>Win 98+ / OSX.2+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Firefox 2.0</td>
	                                            <td>Win 98+ / OSX.2+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Firefox 3.0</td>
	                                            <td>Win 2k+ / OSX.3+</td>
	                                            <td class="center">1.9</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Camino 1.0</td>
	                                            <td>OSX.2+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Camino 1.5</td>
	                                            <td>OSX.3+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Netscape 7.2</td>
	                                            <td>Win 95+ / Mac OS 8.6-9.2</td>
	                                            <td class="center">1.7</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Netscape Browser 8</td>
	                                            <td>Win 98SE+</td>
	                                            <td class="center">1.7</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Netscape Navigator 9</td>
	                                            <td>Win 98+ / OSX.2+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.0</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.1</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.1</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.2</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.2</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.3</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.3</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.4</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.4</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.5</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.5</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.6</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">1.6</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.7</td>
	                                            <td>Win 98+ / OSX.1+</td>
	                                            <td class="center">1.7</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Mozilla 1.8</td>
	                                            <td>Win 98+ / OSX.1+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Seamonkey 1.1</td>
	                                            <td>Win 98+ / OSX.2+</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Gecko</td>
	                                            <td>Epiphany 2.20</td>
	                                            <td>Gnome</td>
	                                            <td class="center">1.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>Safari 1.2</td>
	                                            <td>OSX.3</td>
	                                            <td class="center">125.5</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>Safari 1.3</td>
	                                            <td>OSX.3</td>
	                                            <td class="center">312.8</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>Safari 2.0</td>
	                                            <td>OSX.4+</td>
	                                            <td class="center">419.3</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>Safari 3.0</td>
	                                            <td>OSX.4+</td>
	                                            <td class="center">522.1</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>OmniWeb 5.5</td>
	                                            <td>OSX.4+</td>
	                                            <td class="center">420</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>iPod Touch / iPhone</td>
	                                            <td>iPod</td>
	                                            <td class="center">420.1</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Webkit</td>
	                                            <td>S60</td>
	                                            <td>S60</td>
	                                            <td class="center">413</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 7.0</td>
	                                            <td>Win 95+ / OSX.1+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 7.5</td>
	                                            <td>Win 95+ / OSX.2+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 8.0</td>
	                                            <td>Win 95+ / OSX.2+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 8.5</td>
	                                            <td>Win 95+ / OSX.2+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 9.0</td>
	                                            <td>Win 95+ / OSX.3+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 9.2</td>
	                                            <td>Win 88+ / OSX.3+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera 9.5</td>
	                                            <td>Win 88+ / OSX.3+</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Opera for Wii</td>
	                                            <td>Wii</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Nokia N800</td>
	                                            <td>N800</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Presto</td>
	                                            <td>Nintendo DS browser</td>
	                                            <td>Nintendo DS</td>
	                                            <td class="center">8.5</td>
	                                            <td class="center">C/A<sup>1</sup>
	                                            </td>
	                                        </tr>
	                                        <tr class="gradeC">
	                                            <td>KHTML</td>
	                                            <td>Konqureror 3.1</td>
	                                            <td>KDE 3.1</td>
	                                            <td class="center">3.1</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>KHTML</td>
	                                            <td>Konqureror 3.3</td>
	                                            <td>KDE 3.3</td>
	                                            <td class="center">3.3</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>KHTML</td>
	                                            <td>Konqureror 3.5</td>
	                                            <td>KDE 3.5</td>
	                                            <td class="center">3.5</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeX">
	                                            <td>Tasman</td>
	                                            <td>Internet Explorer 4.5</td>
	                                            <td>Mac OS 8-9</td>
	                                            <td class="center">-</td>
	                                            <td class="center">X</td>
	                                        </tr>
	                                        <tr class="gradeC">
	                                            <td>Tasman</td>
	                                            <td>Internet Explorer 5.1</td>
	                                            <td>Mac OS 7.6-9</td>
	                                            <td class="center">1</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeC">
	                                            <td>Tasman</td>
	                                            <td>Internet Explorer 5.2</td>
	                                            <td>Mac OS 8-X</td>
	                                            <td class="center">1</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Misc</td>
	                                            <td>NetFront 3.1</td>
	                                            <td>Embedded devices</td>
	                                            <td class="center">-</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeA">
	                                            <td>Misc</td>
	                                            <td>NetFront 3.4</td>
	                                            <td>Embedded devices</td>
	                                            <td class="center">-</td>
	                                            <td class="center">A</td>
	                                        </tr>
	                                        <tr class="gradeX">
	                                            <td>Misc</td>
	                                            <td>Dillo 0.8</td>
	                                            <td>Embedded devices</td>
	                                            <td class="center">-</td>
	                                            <td class="center">X</td>
	                                        </tr>
	                                        <tr class="gradeX">
	                                            <td>Misc</td>
	                                            <td>Links</td>
	                                            <td>Text only</td>
	                                            <td class="center">-</td>
	                                            <td class="center">X</td>
	                                        </tr>
	                                        <tr class="gradeX">
	                                            <td>Misc</td>
	                                            <td>Lynx</td>
	                                            <td>Text only</td>
	                                            <td class="center">-</td>
	                                            <td class="center">X</td>
	                                        </tr>
	                                        <tr class="gradeC">
	                                            <td>Misc</td>
	                                            <td>IE Mobile</td>
	                                            <td>Windows Mobile 6</td>
	                                            <td class="center">-</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeC">
	                                            <td>Misc</td>
	                                            <td>PSP browser</td>
	                                            <td>PSP</td>
	                                            <td class="center">-</td>
	                                            <td class="center">C</td>
	                                        </tr>
	                                        <tr class="gradeU">
	                                            <td>Other browsers</td>
	                                            <td>All others</td>
	                                            <td>-</td>
	                                            <td class="center">-</td>
	                                            <td class="center">U</td>
	                                        </tr>
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
				"scrollX": false
			});
		});
    </script>
    <%@include file="../public/scripts.jsp" %>
</body>

</html>