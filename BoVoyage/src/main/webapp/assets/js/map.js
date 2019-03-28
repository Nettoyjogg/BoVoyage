var mymap = L.map('map', { /*
							 * use the same name as your <div id="">
							 */
	center : [ 44.8209, -0.6731 ], /*
									 * set GPS Coordinates
									 */
	zoom : 17, /* define the zoom level */
	zoomControl : false, /* false = no zoom control buttons displayed */
	scrollWheelZoom : false
/* false = scrolling zoom on the map is locked */
});

L
		.tileLayer(
				'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=mapBoVoyage',
				{ /* set your personal MapBox Access Token */
					maxZoom : 20, /* zoom limit of the map */
					attribution : 'Données &copy; Contributeurs <a href="http://openstreetmap.org">OpenStreetMap</a> + '
							+ '<a href="http://mapbox.com">Mapbox</a> | '
							+ '<a href="https://creativecommons.org/licenses/by/2.0/">CC-BY</a> '
							+ 'Guillaume Rouan 2016', /* set the map's caption */
					id : 'mapbox.streets' /*
											 * mapbox.light / dark / streets /
											 * outdoors / satellite
											 */
				}).addTo(mymap);

L.marker([ 44.8209, -0.6731 ]).addTo(mymap); /*
												 * set your location's GPS
												 * Coordinates : [LAT,LON]
												 */