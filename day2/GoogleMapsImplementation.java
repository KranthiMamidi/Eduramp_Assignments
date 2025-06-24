package com.day2;

public class GoogleMapsImplementation extends GoogleMapss implements Location {

	@Override
	public void getLatLong(double latitude, double longitude) {
		System.out.println("You are at Latitude:" + latitude + " and Longitude:" + longitude);
	}

	@Override
	public void accuracy(int accuracy) {
		if (accuracy <= 50) {
			System.out.println("The Location Accuracy of your device is Good");

		} else if (accuracy > 50 && accuracy <= 100) {
			System.out.println("The Location Accuracy is Moderate");
		} else {

			System.out.println("The Location Accuracy is low");
		}

	}

	public static void main(String[] args) {
		GoogleMapss latlong = new GoogleMapss();
		latlong.latitude = 76.87656;
		latlong.longitude = 32.87547;

		GoogleMapsImplementation maps = new GoogleMapsImplementation();
		maps.getLatLong(latlong.latitude, latlong.longitude);
		maps.accuracy(29);
	}

}
