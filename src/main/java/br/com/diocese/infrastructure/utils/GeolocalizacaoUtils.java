package br.com.diocese.infrastructure.utils;

public class GeolocalizacaoUtils {

    private static final double EARTH_RADIUS_KM = 6371.0;

    public static double calcularDistancia(double latMobile, double lonMobile, double latParoquia, double lonParoquia) {
        double dLat = Math.toRadians(latParoquia - latMobile);
        double dLon = Math.toRadians(lonParoquia - lonMobile);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(latMobile)) * Math.cos(Math.toRadians(latParoquia)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS_KM * c;
        return distance * 1000; //Converte para metros
    }

}
