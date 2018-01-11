<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 上边导航栏开始 -->
<nav class="navbar navbar-default top-navbar" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
             <span class="sr-only">切换导航栏</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="index.html"><strong><i class="icon fa fa-plane"></i>HydroCloud</strong></a>
         <div id="sideNav" href="">
         	<i class="fa fa-bars icon"></i>
         </div>
	</div>
		<!-- 右上方提示 -->
    <ul class="nav navbar-top-links navbar-right">
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li>
                	<a href="javascript:void(0)"><i class="fa fa-user fa-fw"></i>用户资料</a>
                </li>
                <li>
                	<a href="javascript:void(0)"><i class="fa fa-gear fa-fw"></i>设置</a>
                </li>
                <li class="divider"></li>
                <li>
                	<a href="login.html"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
</nav>
<!--/. 上边导航栏结束 -->
<!-- 左边导航开始 -->
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li>
            	<a  href="index.html"><i class="fa fa-dashboard"></i>站点地图</a>
            </li>
            <li>
            	<a href="linkMainPacket.html"><i class="fa fa-desktop"></i>链路维持报</a>
            </li> 
			<li>
				<a href="testPacket.html"><i class="fa fa-sitemap"></i>测试报</a>
			</li>
			<li>
				<a href="infoPacket.html"><i class="fa fa-qrcode"></i>均匀时段水文信息报</a>
			</li>
			<li>
				<a href="timingPacketTable.html"><i class="fa fa-table"></i>定时报</a>
              </li>
			<li>
				<a href="timingPacketChart.html"><i class="fa fa-table"></i>定时报图表</a>
              </li>
              <li>
                  <a href="addedPacket.html"><i class="fa fa-edit"></i>遥测站加报报</a>
              </li>


              <li>
                  <a href="javacript:void(0)"><i class="fa fa-sitemap"></i>查询<span class="fa arrow"></span></a>
                  <ul class="nav nav-second-level">
                      <li>
                          <a href="search/remoteInfo.html">遥测站信息</a>
                      </li>
                      <li>
                          <a href="search/remoteRealTimeData.html">查询遥测站实时数据</a>
                      </li>
                      <li>
                          <a href="search/remoteTimeData.html">查询遥测站时段数据</a>
                      </li>
                      <li>
                          <a href="search/remoteManualNumber.html">查询遥测站人工置数</a>
                      </li>
                      <li>
                          <a href="search/remoteFactorData.html">查询遥测站指定要素数据</a>
                      </li>
                  </ul>
              </li>
              <li>
                  <a href="javacript:void(0)"><i class="fa fa-fw fa-file"></i>设置<span class="fa arrow"></span></a>
                  <ul class="nav nav-second-level">
                      <li>
                          <a href="settings/updateRemoteBasicConfig.html">修改遥测站基本配置表</a>
                      </li>
                      <li>
                          <a href="settings/getRemoteBasicConfig.html">读取遥测站基本配置表</a>
                      </li>
                      <li>
                          <a href="settings/updateRemoteRunParam.html">修改遥测站运行参数配置表</a>
                      </li>
                  </ul>
              </li>
          </ul>

      </div>

</nav>
<!-- /. NAV SIDE  -->
<!-- 左边导航结束 -->
<script  type="text/javascript">
	var path = window.location.pathname;
	var index = path .lastIndexOf("\/");  
	path  = path .substring(index + 1, path.length);
	$("#main-menu li a").removeClass("active-menu");
	$("#main-menu li a").each(function(){
		var str=$(this).attr("href").split("/");
		if(str.length==2){
			if(str[1]==path){
				$(this).parent().parent().parent().addClass("active");
				$(this).addClass("active-menu");
			}
		}else{
			if($(this).attr("href")==path){
				$(this).addClass("active-menu");
			}
		}
	});
</script>