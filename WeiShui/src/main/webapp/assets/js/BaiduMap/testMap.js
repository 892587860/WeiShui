var map;
var fusionLayerInfoWindow;
function drawMap_Baidu() {

	// �ٶȵ�ͼAPI����
	var map = new BMap.Map("map_canvas");
	var point = new BMap.Point(116.404, 39.915);
	map.centerAndZoom(point, 15);
	// ��д�Զ��庯��,������ע
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	}
	// ������ͼ���25����ע
	var bounds = map.getBounds();
	var sw = bounds.getSouthWest();
	var ne = bounds.getNorthEast();
	var lngSpan = Math.abs(sw.lng - ne.lng);
	var latSpan = Math.abs(ne.lat - sw.lat);
	for (var i = 0; i < 25; i ++) {
		var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
		addMarker(point);
	}
}