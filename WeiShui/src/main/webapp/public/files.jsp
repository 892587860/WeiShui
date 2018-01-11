<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">  
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<!-- <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
 --><!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
 <!-- TABLE STYLES-->
<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>

<script src="assets/js/BaiduMap/index-drawMap.js"  charset="UTF-8"></script>
<!-- <script src="assets/js/BaiduMap/points-sample-data.js"   charset="UTF-8"></script>
 --><script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Sj4GdvLlELGHB70KMMd5FNZbSLl1qpHg"></script>