<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Import Leaflet CSS Style Sheet -->
<link rel="stylesheet" href="https://npmcdn.com/leaflet@1.0.0-rc.2/dist/leaflet.css" />
<!-- Import Leaflet JS Library -->
<script type="text/javascript" src="https://npmcdn.com/leaflet@1.0.0-rc.2/dist/leaflet.js"></script>
<script type="text/javascript" src=https://unpkg.com/leaflet.markercluster@1.4.1/dist/></script>
      
<link rel="stylesheet" href="assets/css/markerClusters.css" />
<link rel="stylesheet" href="assets/css/markerClusters.Default.css" />
<style>
#my_osm_widget_map { /* use the same name as <div id=""> */
	width: 100%; /* important! if you need full width display */
	height: 550px;
	margin: 0;
	border-radius: 5px;
	/* ... */
}
</style>

</head>
<body>


	<div id="my_osm_widget_map"></div>
	
<script>


//Nous définissons le dossier qui contiendra les marqueurs
var myIcon = L.icon({
	iconUrl:'assets/images/boVoyageIcon.png',
	iconSize:[30, 30],
	
});
var mymap = L.map('my_osm_widget_map', { /* use the same name as your <div id=""> */
	  center: [44.8209,-0.6731], /* set GPS Coordinates */
	  zoom: 05, /* define the zoom level */
	  zoomControl: true, /* false = no zoom control buttons displayed */
	  scrollWheelZoom: true /* false = scrolling zoom on the map is locked */
	});


var villes = {
		"Paris": { "lat": 48.852969, "lon": 2.349903 },
		"Brest": { "lat": 48.383, "lon": -4.500 },
		"Quimper": { "lat": 48.000, "lon": -4.100 },
		"Bayonne": { "lat": 43.500, "lon": -1.467 },
		
};

	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoiZWxldmVqZWUwMSIsImEiOiJjanRzbnU1YngwbTdmNDNtbXJ5YnQ0OHgwIn0.OoVyfktWZIHkA5-RoC8T7A', { /* set your personal MapBox Access Token */
	  maxZoom: 10, /* zoom limit of the map */
	  attribution: 'Données &copy; Contributeurs <a href="http://openstreetmap.org">OpenStreetMap</a> + ' +
	    '<a href="http://mapbox.com">Mapbox</a> | ' +
	    '<a href="https://creativecommons.org/licenses/by/2.0/">CC-BY</a> ' +
	    'Guillaume Rouan 2016', /* set the map's caption */
	    id: 'mapbox.streets' /* mapbox.light / dark / streets / outdoors / satellite */
	}).addTo(mymap);
	for (ville in villes) {
		
		var marker = L.marker([villes[ville].lat, villes[ville].lon], { icon: myIcon }).addTo(mymap);
		
		marker.bindPopup(ville);
	}
	
	
	

	var markerBordeaux = L.marker([44.8209,-0.6731]).addTo(mymap); /* set your location's GPS Coordinates : [LAT,LON] */
	
</script>
</html>