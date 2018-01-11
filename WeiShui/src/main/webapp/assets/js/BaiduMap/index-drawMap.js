var map;
var fusionLayerInfoWindow;
function drawMap_Baidu() {

	if (document.createElement('canvas').getContext) { // 判断当前浏览器是否支持绘制海量点
		var points = []; // 添加海量点数据
		var result;
		$.ajax({
	        type: "post",
	        dataType: "json",
	        url: 'remote/selectRemotePackets',
	        async : false,
	        success: function (data) {
	            if (data != "") {
	            	result=data.data;
	            }
	        }
	    });
		map = new BMap.Map("map_canvas", {}); // 创建Map实例
//		map.centerAndZoom(new BMap.Point(-76.609, 39.395), 9); // 初始化地图,设置中心点坐标和地图级别
		map.centerAndZoom(new BMap.Point(result[0].lng, result[0].lat), 12); // 初始化地图,设置中心点坐标和地图级别
		map.enableScrollWheelZoom(); // 启用滚轮放大缩小
		for ( var i = 0; i < result.length; i++) {
			var p = new BMap.Point(result[i].lng, result[i].lat);
			p.id = result[i].id;
			p.siteName = result[i].station;
			p.traffic = result[i].traffic;
			p.voltage = result[i].voltage;
			p.sendTime = result[i].sendTime;
			p.remoteAddress = result[i].remoteAddress;
			points.push(p);
		}
		console.log(points)
		var options = {
			size : BMAP_POINT_SIZE_BIG,
			shape : BMAP_POINT_SHAPE_STAR,
			color : '#ff0000'
		}
		var pointCollection = new BMap.PointCollection(points, options); // 初始化PointCollection
		pointCollection.addEventListener('click', function(e) {

			// 从event中获取所点击站点的信息
			var sId = String(e.point.sId);
			var siteName = e.point.siteName;
			var traffic = e.point.traffic;
			var voltage = e.point.voltage;
			var sendTime = e.point.sendTime;

		
			fusionLayerInfoWindow = new BMap.InfoWindow("<div class='googft-info-window'>" +
                    "<b>遥测站名称:</b><a href='search/remoteInfo.html'>" + siteName + "</a></b><br>" +
                    "<b>蓄水口瞬时流量: </b>" + traffic + "<br>" +
                    "<b>电源电压: </b>" + voltage + "<br>" +
                    "<b>观测时间: </b>" + sendTime + "<br>" +
                    "</div>"); // 创建信息窗口对象
			
			map.openInfoWindow(fusionLayerInfoWindow, e.point); // 开启信息窗口


		});
		map.addOverlay(pointCollection); // 添加Overlay
		
	} else {
		alert('请在chrome、safari、IE8+以上浏览器查看本示例');
	}
}