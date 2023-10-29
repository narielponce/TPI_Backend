package tpiBack.com.tp.services;

public class DistanciaEntrePuntos {

    public static double calcularDistanciaHaversine(double lat1, double lon1, double lat2, double lon2) {
        double radioTierra = 6371; // Radio de la Tierra en kilómetros

        // Convierte las latitudes y longitudes de grados a radianes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Fórmula de Haversine
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calcula la distancia en kilómetros
        double distancia = radioTierra * c;

        return distancia;
    }
}
